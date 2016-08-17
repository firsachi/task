/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kievreclama.task.dao.PostgresqlTaskDao;
import kievreclama.task.entity.Employee;
import kievreclama.task.entity.Task;


/**
 *
 * @author firsov
 */
public class NewTask extends HttpServlet {

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
        Task task = new Task();
        task.setEmploue((Employee) request.getSession().getAttribute("emploue"));
        task.setInfoTask(request.getParameter("infoTask"));
        task.setNumber(request.getParameter("number"));
        task.setPriority(request.getParameter("priority"));
        PostgresqlTaskDao pgTaskDao = new PostgresqlTaskDao();
        pgTaskDao.add(task);
        ((ArrayList)  request.getSession().getAttribute("UserTask")).add(task);
        response.sendRedirect("/task/private/ts/index.jsp");
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

}
