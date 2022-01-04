package eseo.j2e.projetfinal.beans.commande_article;

import eseo.j2e.projetfinal.beans.article.Article;
import eseo.j2e.projetfinal.beans.commande.Commande;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

@Entity
@Table(name="commande_article")
public class CommandeArticle implements Serializable {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @Column(name="qte")
    private int qte;


    public CommandeArticle(Commande commande, Article article, int qte) {
        this.commande = commande;
        this.article = article;
        this.qte = qte;
    }

    public CommandeArticle() {
    }

    public int getId() {
        return id;
    }

    public Commande getCommande() {
        return commande;
    }

    public Article getArticle() {
        return article;
    }

    public int getQte() {
        return qte;
    }

    public String getTotal(){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(this.qte * this.article.getPrice()).replace(",", ".");
    }
}
