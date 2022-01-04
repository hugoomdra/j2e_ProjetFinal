package eseo.j2e.projetfinal.middleware;

import eseo.j2e.projetfinal.beans.DAOFactory;
import eseo.j2e.projetfinal.beans.client.Client;
import eseo.j2e.projetfinal.beans.client.DAOClientJPA;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class Middleware{

    public Client authentification(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Optional<String> email = Arrays.stream(request.getCookies())
                .filter(c -> "email".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();

        if (!email.isPresent()) {
            return null;

        }else{

            DAOFactory daoFactory = new DAOFactory();
            DAOClientJPA daoClient = daoFactory.getDAOClient();
            Client client = daoClient.getClientWithMail(email.get());
            return client;

        }
    }

    public boolean isAdmin(Client client){

        if (client.getAdmin()){
            return true;
        }else{
            return false;
        }

    }

}
