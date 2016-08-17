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
import kievreclama.task.entity.SettingsFilter;

/**
 *
 * @author firsov
 */
public class ServletFilterIndex extends HttpServlet {
    
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
        SettingsFilter settingsFilter = (SettingsFilter) request.getSession().getAttribute("filter");
        settingsFilter.setCustumer(request.getParameter("customer"));
        settingsFilter.setPriority(request.getParameter("priority"));
        settingsFilter.setStatys(request.getParameter("status"));
        response.sendRedirect("/task/");
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

    private void createState(StringBuilder sql, boolean state){
            sql.append(" AND state=");
            sql.append(state);
    }
}
