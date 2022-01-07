<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mb-100 mt-100">

    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" style="color: black" aria-current="page" href="admin_articles">Articles</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active text-warning" href="admin_clients">Clients</a>
        </li>
    </ul>

    <div class="row">

        <table class="table">
            <thead>
            <tr>
                <th scope="col">Prénom</th>
                <th scope="col">Nom</th>
                <th></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="client" items="${ clients }">

                <tr>
                    <td class="align-middle">${client.firstName}</td>
                    <td class="align-middle">${client.lastName}</td>
                    <td>
                        <form METHOD="post">
                            <input type="hidden" name="client_id" value="${client.id}">
                            <button type="submit" class="btn ${client.enable == true ? "btn-danger" : "btn-success"}">${client.enable ? "Désactiver" : "Activer"}</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>