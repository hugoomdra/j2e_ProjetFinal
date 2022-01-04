package eseo.j2e.projetfinal.servlets.article;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/articles")
public class ArticleShow extends HttpServlet {

    private DAOArticleJPA daoArticle;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoArticle = daoFactory.getDAOArticle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware middleware = new Middleware();
        Client client = middleware.authentification(request, response);
        request.setAttribute("client", client);


        Article article = daoArticle.getArticle(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("article", article);
        request.setAttribute("content", "article_show");
        request.setAttribute("sous_header_title", article.getName());
        request.setAttribute("sous_header_resume", "Voici un de nos jeux");
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
