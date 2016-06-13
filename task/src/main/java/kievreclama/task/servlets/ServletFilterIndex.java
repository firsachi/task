/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kievreclama.task.entities.SettingsFilter;

/**
 *
 * @author firsov
 */
public class ServletFilterIndex extends HttpServlet {

    private SettingsFilter settingsFilter;
    private StringBuilder sql;
    
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
        settingsFilter = new SettingsFilter();
        sql = new StringBuilder();
        sql.append("SELECT tasks.id,emplouers.login,task,number,date_create,urgency,state,delete FROM tasks JOIN emplouers ON emplouers.id = tasks.emploue WHERE delete=false");
        settingsFilter.setCustumer(request.getParameter("customer"));
        buildQuery(" AND emploue=", settingsFilter.getCustumer());
        settingsFilter.setPriority(request.getParameter("priority"));
        buildQuery(" AND urgency=", settingsFilter.getPriority());
        if (null == request.getParameter("status")){
           settingsFilter.setStatys(false);
        }else {
            settingsFilter.setStatys(true);
        }
        sql.append(" AND state=");
        sql.append(settingsFilter.isStatys());
        sql.append(" ORDER BY urgency");
        request.getSession().setAttribute("filter", settingsFilter);
        request.getSession().setAttribute("table", sql.toString());
        response.sendRedirect("/task/");
    }
    private void buildQuery(String str, int value){
        if (0!=value){
            sql.append(str);
            sql.append(value);
        }
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
