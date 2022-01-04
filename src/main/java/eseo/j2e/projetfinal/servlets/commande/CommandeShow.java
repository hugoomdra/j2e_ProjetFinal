package eseo.j2e.projetfinal.servlets.commande;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.commande.Commande;
import eseo.j2e.projetfinal.beans.commande.DAOCommandeJPA;
import eseo.j2e.projetfinal.middleware.Middleware;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/commande")
public class CommandeShow extends HttpServlet {

    private DAOCommandeJPA daoCommande;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoCommande = daoFactory.getDAOCommande();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);

        Commande commande = daoCommande.getCommande(Integer.parseInt(request.getParameter("id")));

        if (commande != null){

            if (commande.getClient().getEmail().equals(client.getEmail())){

                request.setAttribute("client", client);
                request.setAttribute("commande", commande);
                request.setAttribute("content", "commande_show");
                request.setAttribute("sous_header_title", "#2022CDE00" + commande.getId());
                request.setAttribute("sous_header_resume", "Détails de votre commande");
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
            }else{
                response.sendRedirect("forbidden");
            }

        }else{
            response.sendRedirect("user");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
