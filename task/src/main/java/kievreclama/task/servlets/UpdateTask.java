/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kievreclama.task.dao.PostgresqlTaskDao;
import kievreclama.task.entity.Task;


/**
 *
 * @author firsov
 */
public class UpdateTask extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int index =(int) request.getSession().getAttribute("index");
        Task task = ((ArrayList<Task>) request.getSession().getAttribute("UserTask")).get(index);
        task.setPriority(request.getParameter("priority"));
        task.setNumber(request.getParameter("number"));
        task.setInfoTask(request.getParameter("infoTask"));
        if (null==request.getParameter("status")){
            task.setStatys(false);
        }else{
            task.setStatys(true);
        }
        PostgresqlTaskDao pgTaskDao = new PostgresqlTaskDao();
        if (pgTaskDao.updateTask(task)){
            remove(request, "index");
            remove(request, "upadteTask");
            remove(request, "setPriority");
            remove(request, "priority");
            response.sendRedirect("/task/private/ts/index.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void remove(HttpServletRequest request, String name){
        request.getSession().removeAttribute(name);
    }
    
}
