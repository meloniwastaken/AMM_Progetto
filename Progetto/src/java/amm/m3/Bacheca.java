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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marco
 */
public class Bacheca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        if(session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
            String user = request.getParameter("user");
            int userID;
            
            if(user!=null) {
                userID = Integer.parseInt(user);
            }
            else {
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
                
            }
            
            User utente = UserFactory.getInstance().getUserById(userID);
            if(utente != null){
                request.setAttribute("utente", utente);
                request.setAttribute("titolarebacheca",utente);
                ArrayList<Post> posts = new ArrayList<>();
                
                if(request.getParameter("bachecaid") == null) {         /*Cambio i post nel caso sia in una bacheca diversa dalla mia*/
                posts = PostFactory.getInstance().getPostList(utente);
                }
                else {
                    User titolarebacheca = new User();
                    titolarebacheca = UserFactory.getInstance().getUserById(Integer.parseInt(request.getParameter("bachecaid")));
                    posts = PostFactory.getInstance().getPostList(titolarebacheca);
                    request.setAttribute("titolarebacheca",titolarebacheca);
                }
                request.setAttribute("posts", posts);
                ArrayList<User> friends = UserFactory.getInstance().getFriendsByUser(utente);
                request.setAttribute("friends", friends);
                ArrayList<Group> groups = GroupFactory.getInstance().getGroupList(utente);
                request.setAttribute("groups", groups);
                
                if(request.getParameter("revision")!= null)
                {
                    request.setAttribute("revision",true);
                    String nome_destinatario = request.getAttribute("titolarebacheca").toString();
                    User destinatario = UserFactory.getInstance().getUserByName(nome_destinatario);
                    Post post = new Post();
                    post.setCreatorId(userID);
                    post.setId(posts.size());
                    post.setImage(request.getParameter("img"));
                    post.setText(request.getParameter("text"));
                    session.setAttribute("post_r",post); /*Sfrutto la sessione per il doppio passaggio di parametri*/
                    session.setAttribute("dest",destinatario);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    return;
                }
                
                if(request.getParameter("confirm") != null){ /*Non sono sicuro che funzioni*/
                        request.setAttribute("confirm", true);
                        posts.add((Post) session.getAttribute("post_r"));
                        request.setAttribute("dest",session.getAttribute("dest"));
                        request.setAttribute("post_r",session.getAttribute("post_r"));
                        session.removeAttribute("dest");
                        session.removeAttribute("post_r");
                        request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                        return;
                    }
                    
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                return;
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }
    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
        
        
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
