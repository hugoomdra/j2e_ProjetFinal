package eseo.j2e.projetfinal.servlets.administration.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/articles")
public class ArticleIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("content", "article_index");
        request.setAttribute("sous_header_title", "Articles");
        request.setAttribute("sous_header_resume", "Ajouter, modifier, supprimer");
        request.getRequestDispatcher("/jsp/admin/template.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
