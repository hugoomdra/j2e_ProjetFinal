package eseo.j2e.projetfinal.servlets.user;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserShow extends HttpServlet {

    private DAOArticleJPA daoArticle;

    public void init() throws ServletException{
        DAOFactory daoFactory = new DAOFactory();
        daoArticle = daoFactory.getDAOArticle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // todo
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
