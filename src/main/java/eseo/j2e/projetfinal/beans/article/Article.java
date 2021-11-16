package eseo.j2e.projetfinal.beans.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="article")
public class Article implements Serializable {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="quantity")
    private int quantity;

    @Column(name="picture")
    private String picture;

    @Column(name="type")
    private String type;

    public Article(String name, double price, int quantity, String picture, String type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.picture = picture;
        this.type = type;
    }

    public Article() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPicture() {
        return picture;
    }

    public String getType() {
        return type;
    }

}
