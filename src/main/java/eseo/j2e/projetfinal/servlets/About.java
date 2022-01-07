package eseo.j2e.projetfinal.servlets;

import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/about")
public class About extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);
        request.setAttribute("client", client);


        request.setAttribute("content", "about");
        request.setAttribute("sous_header_title", "A propos de nous");
        request.setAttribute("sous_header_resume", "Découvrez en plus sur notre équipe de passionés");
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
