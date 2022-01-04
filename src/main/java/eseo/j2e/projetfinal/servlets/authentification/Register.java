package eseo.j2e.projetfinal.servlets.authentification;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.client.DAOClientJPA;
import eseo.j2e.projetfinal.middleware.Middleware;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class Register extends HttpServlet {

    private DAOClientJPA daoClient;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoClient = daoFactory.getDAOClient();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        if (middleware.authentification(request, response) == null) {
            request.setAttribute("content", "register");
            request.getRequestDispatcher("/jsp/authentification/template.jsp").forward(request, response);
        }else{
            response.sendRedirect("store");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        String codepostal = request.getParameter("codepostal");
        String pays = request.getParameter("pays");

        Boolean error = false;

        try{
            daoClient.add(firstName, lastName, email, password, rue, ville, codepostal, pays);
        }catch (Exception e){
            error = true;
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("rue", rue);
            request.setAttribute("ville", ville);
            request.setAttribute("codepostal", codepostal);
            request.setAttribute("pays", pays);
            request.setAttribute("error", "Le mail est déjà associé à un compte.");
            request.setAttribute("content", "register");
            request.getRequestDispatcher("/jsp/authentification/template.jsp").forward(request, response);
        }

        // si il n'y a pas d'erreur
        if (!error){
            response.addCookie(new Cookie("email", email));
            response.sendRedirect("store");
        }





    }
}
