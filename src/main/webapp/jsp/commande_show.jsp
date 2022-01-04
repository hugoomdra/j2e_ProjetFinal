<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="single-product mt-100 mb-150">
    <div class="container">
        <div class="row">

            <div class="col-3 mb-4">
                <p class="font-weight-bold p-0 m-0">Adresse :</p>
                <p class="p-0 m-0">${client.firstName} ${client.lastName}</p>
                <p class="p-0 m-0">${client.rue}</p>
                <p class="p-0 m-0">${client.codepostal} - ${client.ville}</p>
                <p class="p-0 m-0">${client.pays}</p>
            </div>

            <c:if test="${commande != null}">
                <table class="table">
                    <thead>
                    <tr>
                        <th></th>
                        <th scope="col">Article</th>
                        <th scope="col">Quantité</th>
                        <th scope="col">Prix</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ligne" items="${ commande.commandeArticles }">

                        <tr>
                            <td><img src="${ ligne.article.picture }" width="60px" alt=""></td>
                            <td class="align-middle">${ligne.article.name}</td>
                            <td class="align-middle">${ligne.qte}</td>
                            <td class="align-middle">${ligne.total} €</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="col-12 mt-3">

                    <p class="text-right font-weight-bold">Total : ${commande.total} €</p>
                </div>
            </c:if>

        </div>
    </div>
</div>
<!-- end single product -->