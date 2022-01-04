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
            entityManager.persist(new Client(firstName, lastName, email, password, rue, ville, codepostal, pays));
            entityManager.getTransaction().commit();
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
            return client;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Client getClientWithMail(String email) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Client client = (Client) entityManager.createQuery("FROM Client c WHERE c.email = ?1").setParameter(1, email).getResultStream().findFirst().orElse(null);
            return client;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients;
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            clients = entityManager.createQuery("from Client", Client.class).getResultList();
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
        }
        finally {
            entityManager.close();
        }
    }

}
