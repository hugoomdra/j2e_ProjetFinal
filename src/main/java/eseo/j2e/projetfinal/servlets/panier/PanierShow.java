package eseo.j2e.projetfinal.servlets.panier;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.commande.Commande;
import eseo.j2e.projetfinal.beans.commande.DAOCommandeJPA;
import eseo.j2e.projetfinal.middleware.Authentification;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/panier")
public class PanierShow extends HttpServlet {

    private DAOCommandeJPA daoCommande;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoCommande = daoFactory.getDAOCommande();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware auth = new Authentification();
        Client client = auth.handle(request, response);
        Commande commande = daoCommande.getEditCommande(client);

        request.setAttribute("commande", commande);
        request.setAttribute("content", "panier_show");
        request.setAttribute("sous_header_title", "Panier");
        request.setAttribute("sous_header_resume", "Votre panier");
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware auth = new Authentification();
        Client client = auth.handle(request, response);
        Commande commande = daoCommande.getEditCommande(client);

        daoCommande.validateCommand(commande);

    }
}
