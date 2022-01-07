package eseo.j2e.projetfinal.beans.client;

import eseo.j2e.projetfinal.beans.commande.Commande;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="client")
public class Client implements Serializable {


    @Id
    @Column(name="id")
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="rue")
    private String rue;

    @Column(name="ville")
    private String ville;

    @Column(name="codepostal")
    private String codepostal;

    @Column(name="pays")
    private String pays;

    @Column(name="enable")
    private Boolean enable;

    @Column(name="isAdmin")
    private Boolean isAdmin;

    @OneToMany( targetEntity=Commande.class, mappedBy="client" )
    private List<Commande> commandes = new ArrayList<>();


    public Client(String firstName, String lastName, String email, String password, String rue, String ville, String codepostal, String pays, boolean enable, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rue = rue;
        this.ville = ville;
        this.codepostal = codepostal;
        this.pays = pays;
        this.enable = enable;
        this.isAdmin = isAdmin;
    }

    public Client(String firstName, String lastName, String email, String password, String rue, String ville, String codepostal, String pays) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rue = rue;
        this.ville = ville;
        this.codepostal = codepostal;
        this.pays = pays;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public String getPays() {
        return pays;
    }

    public List<Commande> getCommandes() {
        return commandes.stream().filter(commande -> commande.getType().equals("done")).collect(Collectors.toList());
    }

    public Boolean getEnable() {
        return enable;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
