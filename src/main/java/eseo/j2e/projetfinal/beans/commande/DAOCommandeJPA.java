package eseo.j2e.projetfinal.beans.commande;

import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.commande_article.CommandeArticle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class DAOCommandeJPA implements DAOCommande{

    private EntityManagerFactory emf;

    public DAOCommandeJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void add(Client client, String type) {

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Commande commande = new Commande(client, type);
        try {
            entityManager.persist(commande);
            entityManager.getTransaction().commit();
        }catch (Exception e){
        }
        finally {
            entityManager.close();
        }
    }

    public Commande getEditCommande(Client client){

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Commande commande = (Commande) entityManager.createQuery("FROM Commande cde WHERE cde.type = ?1 AND cde.client = ?2").
                    setParameter(1, "editing")
                    .setParameter(2, client)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
            return commande;
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public Commande getCommande(int id) {
        return null;
    }

    @Override
    public List<Commande> getCommandes() {
        return null;
    }

    @Override
    public void update(Client client, String type) {

    }

    @Override
    public void delete(int id) {

    }

    public void validateCommand(Commande commande){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            commande.setType("done");
            entityManager.merge(commande);
            entityManager.getTransaction().commit();
        }
        finally {
            entityManager.close();
        }
    }

    public void addCommandLine(Commande commande, Article article, int qte){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(new CommandeArticle(commande, article, qte));
            entityManager.getTransaction().commit();
        }
        finally {
            System.out.println("erreur super");
            entityManager.close();
        }
    }
}