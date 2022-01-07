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

        String email = null;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("email")) {
                    email = cookies[i].getValue();
                }
            }
        }

        if(email == null){
            return null;
        }else{
            DAOFactory daoFactory = new DAOFactory();
            DAOClientJPA daoClient = daoFactory.getDAOClient();
            Client client = daoClient.getClientWithMail(email);
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
