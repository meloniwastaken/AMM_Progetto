/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3;

import amm.m3.Classi.User;
import amm.m3.Classi.UserFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marco
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {   /*Se esiste il parametro logout significa che voglio effettuare il logout*/
            session.invalidate();   /*Distruggo la sessione*/
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);   /*E torno al Login*/
            return;
        }

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) { /*Se sono già loggato*/
            request.getRequestDispatcher("Bacheca").forward(request, response); /*Inoltro a Bacheca*/
            return;
        } else {    /*Altrimenti, se non sono loggato*/
            String username = request.getParameter("username"); /*Prendo username (email) e password*/
            String password = request.getParameter("password");
            if (username != null && password != null) { /*Se non sono null, e quindi ho inserito qualcosa*/
                int loggedUserID = UserFactory.getInstance().getIdByEmailAndPassword(username, password);   /*Cerco nella UserFactory l'utente corrispondente ai parametri*/

                if (loggedUserID != -1) {   /*Se l'ho trovato e quindi ha restituito un valore positivo*/
                    User utente = UserFactory.getInstance().getUserById(loggedUserID);  /*Salvo in User utente l'utente che ha loggato*/
                    session.setAttribute("loggedIn", true); /*Setto loggedIn in sessione a true così significa che sono loggato*/
                    session.setAttribute("loggedUserID", loggedUserID); /*Setto loggedUserID in sessione in modo da sapere con chi sono loggato*/
                    session.setAttribute("utente", utente); /*Setto utente in sessione in modo da avere sempre a disposizione i parametri dell'utente loggato*/

                    if (utente.getNome() == "" || utente.getCognome() == "" || utente.getFrase() == "" || utente.getURLimmagine() == "") { /*Se uno dei parametri dell'utente che logga è vuoto*/
                        request.getRequestDispatcher("Profilo").forward(request, response); /*Lo ridirigo a Profilo*/
                        return;
                    }

                    request.getRequestDispatcher("Bacheca").forward(request, response); /*Altrimenti, se tutti i parametri sono giusti, va alla Bacheca*/
                    return;
                } else { /*Altrimenti (se i valori inseriti non corrispondono a nessun utente nella Factory)*/
                    request.setAttribute("invalidData", true);  /*Setto invalidData a true, in modo da far capire che ci sono dati non validi*/
                    request.getRequestDispatcher("loginForm.jsp").forward(request, response);   /*E ridirigo a loginForm.jsp*/
                    return;
                }
            }
        }
        request.getRequestDispatcher("loginForm.jsp").forward(request, response);   /*Altrimenti, se entro per la prima volta in Login, vado a loginForm.jsp*/
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