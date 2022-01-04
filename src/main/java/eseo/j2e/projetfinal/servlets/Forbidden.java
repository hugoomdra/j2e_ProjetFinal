package eseo.j2e.projetfinal.servlets;

import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forbidden")
public class Forbidden extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);

        if (client != null){
            request.setAttribute("content", "forbidden");
            request.setAttribute("client", client);
            request.setAttribute("sous_header_title", "INTERDIT");
            request.setAttribute("sous_header_resume", "Vous n'avez pas les droits");
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        }else{
            response.sendRedirect("login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
