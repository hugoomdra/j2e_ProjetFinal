<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="single-product mt-100 mb-150">
    <div class="container">
        <div class="row">

            <h3>Historique des commandes</h3>

            <c:if test="${client.commandes != null}">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Ref Commande</th>
                        <th scope="col">Total TTC</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ligne" items="${ client.commandes }">
                        <tr>
                            <td class="align-middle">#2022CDE00${ligne.id}</td>
                            <td class="align-middle">${ligne.total} €</td>
                            <td class="align-middle"><a href="commande?id=${ligne.id}">Voir</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${client.commandes == null}">
            <p>Vous n'avez pas encore passé de commande chez nous.</p>
            </c:if>




        </div>
    </div>
</div>
<!-- end single product -->