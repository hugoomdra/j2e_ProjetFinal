package eseo.j2e.projetfinal.beans.article;

import java.util.List;

public interface DAOArticle {

    public abstract void add(String name, double price, int quantity, String picture, String type);

    public abstract Article getArticle(int id);

    public abstract List<Article> getArticles();

    public abstract void update(String name, double price, int quantity, String picture, String type);

    public abstract void delete(int id);

}
