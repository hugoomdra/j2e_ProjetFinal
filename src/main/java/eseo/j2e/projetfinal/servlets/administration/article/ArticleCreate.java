package eseo.j2e.projetfinal.servlets.administration.article;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.middleware.Middleware;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin_article_create")
public class ArticleCreate extends HttpServlet {

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
                request.setAttribute("client", client);
                request.setAttribute("content", "admin_article_create");
                request.setAttribute("sous_header_title", "Articles");
                request.setAttribute("sous_header_resume", "Création");
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
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String type = request.getParameter("type");
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            String picture = request.getParameter("picture");
            Double price = Double.parseDouble(request.getParameter("price"));

            daoArticle.add(name, description, price, quantity, picture, type);

            response.sendRedirect("admin_articles");

        }else{
            response.sendRedirect("forbidden");
        }
    }
}
