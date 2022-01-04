package eseo.j2e.projetfinal.servlets.administration.client;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.client.DAOClientJPA;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin_clients")
public class ClientIndex extends HttpServlet {

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
            if (middleware.isAdmin(client)) {
                List<Client> clients = daoClient.getClients();
                request.setAttribute("clients", clients);
                request.setAttribute("client", client);
                request.setAttribute("content", "admin_clients");
                request.setAttribute("sous_header_title", "Clients");
                request.setAttribute("sous_header_resume", "Activer/Désactiver");
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
            }else{
                response.sendRedirect("forbidden");
            }
        }else{
            response.sendRedirect("login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);
        if (middleware.isAdmin(client)) {
            Client c = daoClient.getClient(Integer.parseInt(request.getParameter("client_id")));

            if (c.getEnable()){
                c.setEnable(false);
            }else{
                c.setEnable(true);
            }

            daoClient.updateEnable(c);
        }else{
            response.sendRedirect("forbidden");
        }
        response.sendRedirect("admin_clients");
    }
}
