package eseo.j2e.projetfinal.servlets.panier;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.article.DAOArticle;
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

@WebServlet("/panier/add")
public class PanierAdd extends HttpServlet {

    private DAOCommandeJPA daoCommande;
    private DAOArticleJPA daoArticle;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoCommande = daoFactory.getDAOCommande();
        daoArticle = daoFactory.getDAOArticle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware auth = new Authentification();
        Client client = auth.handle(request, response);
        int qte = Integer.parseInt(request.getParameter("qte"));
        int article_id = Integer.parseInt(request.getParameter("article_id"));

        Commande commande = daoCommande.getEditCommande(client);

        if (commande == null){
            daoCommande.add(client, "editing");
            System.out.println("creation");
            System.out.println(commande);
            commande = daoCommande.getEditCommande(client);
        }

        Article article = daoArticle.getArticle(article_id);

        if (article.getQuantity() < qte){
            response.sendRedirect("../articles?id=" + article_id);
        }else{
            System.out.println(article.getName());
            daoCommande.addCommandLine(commande, article, qte);
            response.sendRedirect("../panier");
        }


    }
}
