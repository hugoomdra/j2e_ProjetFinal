package eseo.j2e.projetfinal.servlets;

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

@WebServlet(value = "/store")
public class Home extends HttpServlet {

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
            List<Article> articles =  daoArticle.getArticles();
            request.setAttribute("articles", articles);
            request.setAttribute("client", client);
            request.setAttribute("content", "store");
            request.setAttribute("sous_header_title", "Nos jeux");
            request.setAttribute("sous_header_resume", "RETROUVEZ LES JEUX DISPONIBLES");
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        }else{
            response.sendRedirect("login");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
