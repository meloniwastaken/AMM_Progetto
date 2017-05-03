/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3;

import amm.m3.Classi.Group;
import amm.m3.Classi.GroupFactory;
import amm.m3.Classi.Post;
import amm.m3.Classi.PostFactory;
import amm.m3.Classi.User;
import amm.m3.Classi.UserFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profilo extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        if(session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
            Integer userID = (Integer) session.getAttribute("loggedUserID");
            User utente = UserFactory.getInstance().getUserById(userID);
            if(utente != null)
                request.setAttribute("utente", utente);
            
            ArrayList<User> friends = UserFactory.getInstance().getFriendsByUser(utente);
            request.setAttribute("friends", friends);
            ArrayList<Group> groups = GroupFactory.getInstance().getGroupList(utente);
            request.setAttribute("groups", groups);
            
            if(request.getParameter("update") != null)
            {
                String aux = request.getParameter("nome");
                utente.setNome(aux);
                aux = request.getParameter("cognome");
                utente.setCognome(aux);
                aux = request.getParameter("profile_imm");
                utente.setURLimmagine(aux);
                aux = request.getParameter("frase");
                utente.setFrase(aux);
                aux = request.getParameter("data");
                utente.setData(aux);
                aux = request.getParameter("password");
                utente.setData(aux);
                aux = request.getParameter("password_conf");
                utente.setData(aux);
                request.setAttribute("update", true);
            }
            
        }
        
        request.getRequestDispatcher("profilo.jsp").forward(request, response);
        return;
            }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
