package eseo.j2e.projetfinal.beans.article;

import eseo.j2e.projetfinal.beans.client.Client;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class DAOArticleJPA implements DAOArticle{

    private EntityManagerFactory emf;

    public DAOArticleJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void add(String name, String description, double price, int quantity, String picture, String type) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try{
            entityManager.persist(new Article(name, description, price, quantity, picture, type));
            entityManager.getTransaction().commit();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Article getArticle(int id) {

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.find(Article.class, id);
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Article> getArticles() {
        List<Article> articles;
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            articles = entityManager.createQuery("from Article where deleted is FALSE", Article.class).getResultList();
        }
        finally {
            entityManager.close();
        }
        return articles;
    }

    @Override
    public void update(int id, String name, String description, double price, int quantity, String picture, String type) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Article article = new Article(id, name, description, price, quantity, picture, type);
            entityManager.merge(article);
            entityManager.getTransaction().commit();
        }
        finally {
            entityManager.close();
        }
    }

    public void delete(int id){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Article article = getArticle(id);
        article.setDeleted(true);
        try {
            entityManager.merge(article);
            entityManager.getTransaction().commit();
        }
        finally {
            entityManager.close();
        }
    }
}
