package eseo.j2e.projetfinal.beans.article;

import java.util.List;

public interface DAOArticle {

    public abstract void add(String name, String description, double price, int quantity, String picture, String type);

    public abstract Article getArticle(int id);

    public abstract List<Article> getArticles();

    public abstract void update(int id, String name, String description, double price, int quantity, String picture, String type);

    public abstract void delete(int id);

}
