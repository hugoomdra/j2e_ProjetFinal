package eseo.j2e.projetfinal.beans;

import eseo.j2e.projetfinal.beans.article.DAOArticle;
import eseo.j2e.projetfinal.beans.article.DAOArticleJPA;
import eseo.j2e.projetfinal.beans.client.DAOClientJPA;
import eseo.j2e.projetfinal.beans.commande.DAOCommandeJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {

    private static volatile DAOFactory instance = null;
    private EntityManagerFactory emf;

    public final static DAOFactory getInstance(){
        if (DAOFactory.instance == null){
            synchronized (DAOFactory.class){
                if (DAOFactory.class == null){
                    instance = new DAOFactory();
                }
            }
        }

        return DAOFactory.instance;
    }

    public DAOArticleJPA getDAOArticle(){
        emf = Persistence.createEntityManagerFactory("Database");
        return new DAOArticleJPA(emf);
    }

    public DAOClientJPA getDAOClient(){
        emf = Persistence.createEntityManagerFactory("Database");
        return new DAOClientJPA(emf);
    }

    public DAOCommandeJPA getDAOCommande(){
        emf = Persistence.createEntityManagerFactory("Database");
        return new DAOCommandeJPA(emf);
    }


}
