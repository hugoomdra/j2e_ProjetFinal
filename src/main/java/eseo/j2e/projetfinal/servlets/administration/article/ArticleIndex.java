package eseo.j2e.projetfinal.servlets.administration.article;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin_articles")
public class ArticleIndex extends HttpServlet {

    private DAOArticleJPA daoArticle;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoArticle = daoFactory.getDAOArticle();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);
        if (client != null){

            if (middleware.isAdmin(client)){
                List<Article> articles =  daoArticle.getArticles();
                request.setAttribute("articles", articles);
                request.setAttribute("client", client);
                request.setAttribute("content", "admin_articles");
                request.setAttribute("sous_header_title", "Articles");
                request.setAttribute("sous_header_resume", "AJOUTER, MODIFIER, SUPPRIMER");
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

    }
}
