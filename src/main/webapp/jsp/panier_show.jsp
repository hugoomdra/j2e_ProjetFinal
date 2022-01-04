<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="single-product mt-100 mb-150">
    <div class="container">
        <div class="row">

            <c:if test="${commande != null}">
                <table class="table">
                    <thead>
                    <tr>
                        <th></th>
                        <th scope="col">Article</th>
                        <th scope="col">Quantité</th>
                        <th scope="col">Prix</th>
                        <th></th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ligne" items="${ commande.commandeArticles }">

                        <tr>
                            <td><img src="${ ligne.article.picture }" width="60px" alt=""></td>
                            <td class="align-middle">${ligne.article.name}</td>
                            <td class="align-middle">${ligne.qte}</td>
                            <td class="align-middle">${ligne.article.price * ligne.qte} €</td>
                            <td class="align-middle"><a href="panier/delete?id=${ligne.id}&qte=${ligne.qte}&art_id=${ligne.article.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="col-12 mt-3">

                    <p class="text-right font-weight-bold">Total : ${commande.total} €</p>
                </div>

                <div class="col-9">

                </div>

                <div class="col-3 mt-3">
                    <form method="POST" class="text-right">
                        <button class="btn btn-dark" type="submit">Commander</button>
                    </form>
                </div>
            </c:if>

            <c:if test="${commande == null}">
                <p>Votre panier est vide. Ajoutez des articles à votre panier.</p>
            </c:if>

        </div>
    </div>
</div>
<!-- end single product -->