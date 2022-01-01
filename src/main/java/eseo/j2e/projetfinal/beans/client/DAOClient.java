package eseo.j2e.projetfinal.beans.client;


import java.util.List;

public interface DAOClient {

    public abstract void add(String firstName, String lastName, String email, String password, String rue, String ville, String codepostal, String pays);

    public abstract Client getClient(int id);

    public abstract Client getClientWithMail(String email);

    public abstract List<Client> getClients();

    public abstract void update(int id, String firstName, String lastName, String email, String password);

    public abstract void delete(int id);

}
