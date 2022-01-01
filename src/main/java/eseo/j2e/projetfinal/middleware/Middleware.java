package eseo.j2e.projetfinal.middleware;

import eseo.j2e.projetfinal.beans.client.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Middleware {

    Client handle(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
