package eseo.j2e.projetfinal.beans.commande;


import eseo.j2e.projetfinal.beans.client.Client;

import java.util.List;

public interface DAOCommande {

    public abstract void add(Client client, String type);

    public abstract Commande getCommande(int id);

    public abstract List<Commande> getCommandes();

    public abstract void update(Client client, String type);

    public abstract void delete(int id);

}
