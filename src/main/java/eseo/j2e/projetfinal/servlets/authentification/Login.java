package eseo.j2e.projetfinal.servlets.authentification;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.client.DAOClientJPA;
import eseo.j2e.projetfinal.middleware.Middleware;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

    private DAOClientJPA daoClient;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoClient = daoFactory.getDAOClient();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        if (middleware.authentification(request, response) == null) {
            request.setAttribute("content", "login");
            request.getRequestDispatcher("/jsp/authentification/template.jsp").forward(request, response);
        }else{
            response.sendRedirect("store");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client client = daoClient.getClientWithMail(email);

        if (client != null){

            if (client.getPassword().equals(password)){

                if (client.getEnable()){
                response.addCookie(new Cookie("email", email));
                response.sendRedirect("store");
                }else{
                    request.setAttribute("error", "Votre compte est bloqué. Veuillez contacter le service client.");
                    request.setAttribute("email", email);
                    request.setAttribute("content", "login");
                    request.getRequestDispatcher("/jsp/authentification/template.jsp").forward(request, response);
                }

            }else{
                request.setAttribute("error", "Le mot de passe est incorrecte.");
                request.setAttribute("email", email);
                request.setAttribute("content", "login");
                request.getRequestDispatcher("/jsp/authentification/template.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "Le mail ne correspond à aucun compte.");
            request.setAttribute("email", email);
            request.setAttribute("content", "login");
            request.getRequestDispatcher("/jsp/authentification/template.jsp").forward(request, response);
        }



    }
}
