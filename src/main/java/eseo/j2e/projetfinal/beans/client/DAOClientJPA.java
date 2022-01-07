package eseo.j2e.projetfinal.beans.client;

import eseo.j2e.projetfinal.beans.article.Article;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class DAOClientJPA implements DAOClient{

    private EntityManagerFactory emf;

    public DAOClientJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public void add(String firstName, String lastName, String email, String password, String rue, String ville, String codepostal, String pays) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(new Client(firstName, lastName, email, password, rue, ville, codepostal, pays, true, false));
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Client getClient(int id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Client client = null;
        try {
            client = entityManager.find(Client.class, id);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return client;

    }

    @Override
    public Client getClientWithMail(String email) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Client client = null;

        try {
            client = (Client) entityManager.createQuery("FROM Client c WHERE c.email = ?1").setParameter(1, email).getResultStream().findFirst().orElse(null);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        return client;
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = null;
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            clients = entityManager.createQuery("from Client", Client.class).getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return clients;
    }

    @Override
    public void updateEnable(Client client){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(client);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }

}
