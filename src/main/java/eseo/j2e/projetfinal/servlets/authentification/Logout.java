package eseo.j2e.projetfinal.servlets.authentification;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.client.DAOClientJPA;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logout")
public class Logout extends HttpServlet {

    private DAOClientJPA daoClient;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoClient = daoFactory.getDAOClient();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);

        if (client != null){
            response.addCookie(new Cookie("email", null));
        }
        response.sendRedirect("login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);

        if (client != null){
            response.addCookie(new Cookie("email", null));
        }
        response.sendRedirect("login");

    }
}
