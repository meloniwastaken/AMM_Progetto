/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3;

import amm.m3.Classi.Group;
import amm.m3.Classi.GroupFactory;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) { /*Se sono loggato*/
            User utente = UserFactory.getInstance().getUserById((Integer) session.getAttribute("loggedUserID"));    /*E in User utente i dati della persona loggata*/
            
           //if (utente != null) /*Se ho trovato una corrispondenza, e quindi sono effettivamente loggato*/
            //    request.setAttribute("utente", utente); /*Setto l'attributo nella request "utente" con utente*/

            ArrayList < User > friends = UserFactory.getInstance().getFriendsByUser(utente);    /*Prendo la lista degli amici*/
            request.setAttribute("friends", friends);
            ArrayList < Group > groups = GroupFactory.getInstance().getGroupList(utente);   /*e quella dei gruppi dell'utente loggato*/
            request.setAttribute("groups", groups);

            if (request.getParameter("delete") != null) {
                UserFactory.getInstance().deleteUser((Integer) session.getAttribute("loggedUserID"));
                session.invalidate();
                request.getRequestDispatcher("Login").forward(request, response);
            }
            
            if (request.getParameter("update") != null) {   /*Se esiste un parametro update e quindi ho modificato nel form i dati e ho inviato*/
                String nome = request.getParameter("nome");  /*Prendo tutti i parametri e li setto a utente, che è l'oggetto che uso per mostrare i dati nell'applicazione*/
                String cognome = request.getParameter("cognome");
                String email = request.getParameter("email");
                String profile_imm = request.getParameter("profile_imm");
                String frase = request.getParameter("frase");
                String data = request.getParameter("data");
                String password = request.getParameter("password");
                String password_conf = request.getParameter("passwordconf");
                if(!nome.equals("") && 
                   !cognome.equals("") && 
                   !email.equals("") && 
                   !profile_imm.equals("") &&
                   !frase.equals("") && 
                   !data.equals("") &&
                   !password.equals("") && 
                   !password_conf.equals("") && 
                    password.equals(password_conf))
                    {UserFactory.getInstance().updateUser((Integer) session.getAttribute("loggedUserID"),nome,cognome,email,profile_imm,frase,data,password);
                    utente = UserFactory.getInstance().getUserById((Integer) session.getAttribute("loggedUserID")); /*aggiorno i dati*/
                    session.setAttribute("utente",utente);
                    request.setAttribute("update", true);}
                else request.setAttribute("update", false);
            }

        }

        request.getRequestDispatcher("profilo.jsp").forward(request, response); /*Reindirizzo infine a profilo.jsp*/
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
        } // </editor-fold>

}