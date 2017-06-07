package amm.m3;

import amm.m3.Classi.User;
import amm.m3.Classi.UserFactory;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filter extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session!=null && session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true)) /*Se sono loggato*/
        { 
            String command = request.getParameter("q"); /*Chiedo il parametro q della ricerca*/
            if (request.getParameter("q") != null) /*Se è diverso da null*/
            {
                if (command.equals("search")) /*Verifico che command sia uguale a search*/
                {
                    List<User> ret = UserFactory.getInstance().getUserFriends(request.getParameter("cerca"), (Integer)session.getAttribute("loggedUserID"));
                    
                    if(ret == null) { /*Non restituiamo mai null, al massimo restituiamo un utente "vuoto"*/
                        ret = new ArrayList<>();
                        User usr = new User();
                        ret.add(usr);
                    }
                    
                    request.setAttribute("ret", ret);
                    response.setContentType("application/json");
                    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                    request.getRequestDispatcher("filter.jsp").forward(request, response);
                }
            }
        }
        else {
            request.getRequestDispatcher("Login").forward(request, response);
        }
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
