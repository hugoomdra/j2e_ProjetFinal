package eseo.j2e.projetfinal.beans.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
}
