package eseo.j2e.projetfinal.beans.commande;

import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.commande_article.CommandeArticle;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="commande")
public class Commande implements Serializable {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name="type")
    private String type;

    @OneToMany( targetEntity= CommandeArticle.class, mappedBy="commande", cascade = CascadeType.ALL)
    private List<CommandeArticle> commandeArticles = new ArrayList<>();

    public Commande(Client client, String type) {
        this.client = client;
        this.type = type;
    }

    public Commande(int id, Client client, String type) {
        this.id = id;
        this.client = client;
        this.type = type;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public String getType() {
        return type;
    }

    public List<CommandeArticle> getCommandeArticles() {
        return commandeArticles;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addCommandeArticle(CommandeArticle commandeArticle){
        this.commandeArticles.add(commandeArticle);
    }

    public String getTotal() {
        double total = commandeArticles.stream().mapToDouble(ligne -> ligne.getArticle().getPrice() * ligne.getQte()).sum();
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(total).replace(",", ".");
    }
}
