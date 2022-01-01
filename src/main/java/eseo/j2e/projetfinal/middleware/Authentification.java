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

public class Authentification implements Middleware {

    @Override
    public Client handle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("middleware");

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

}
