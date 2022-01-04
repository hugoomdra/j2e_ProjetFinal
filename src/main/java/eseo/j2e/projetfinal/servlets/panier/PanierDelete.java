package eseo.j2e.projetfinal.servlets.panier;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.commande.DAOCommandeJPA;
import eseo.j2e.projetfinal.middleware.Middleware;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/panier/delete")
public class PanierDelete extends HttpServlet {

    private DAOCommandeJPA daoCommande;
    private DAOArticleJPA daoArticle;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoCommande = daoFactory.getDAOCommande();
        daoArticle = daoFactory.getDAOArticle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        int art_id = Integer.parseInt(request.getParameter("art_id"));
        int qte = Integer.parseInt(request.getParameter("qte"));

        Article article = daoArticle.getArticle(art_id);

        daoCommande.deleteCommandLine(id);
        daoArticle.update(article.getId(), article.getName(), article.getDescription(),article.getPrice(), article.getQuantity() + qte, article.getPicture(), article.getType());
        response.sendRedirect("../panier");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
