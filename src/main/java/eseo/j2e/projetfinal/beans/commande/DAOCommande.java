package eseo.j2e.projetfinal.beans.commande;


import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.client.Client;

import java.util.List;

public interface DAOCommande {

    public abstract void add(Client client, String type);

    public abstract Commande getCommande(int id);

    public abstract Commande getEditCommande(Client client);

    public abstract List<Commande> getCommandes();

    public abstract void addCommandLine(Commande commande, Article article, int qte);

    public abstract void deleteCommandLine(int id);

}
