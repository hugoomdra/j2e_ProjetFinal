<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mb-100 mt-100">


    <div class="row">
        <div class="col-9">
        </div>
        <div class="col-3">
            <a href="admin_article_create" class="btn btn-dark btn-block"><i class="fas fa-plus"></i> Ajouter un article</a>
        </div>
    </div>

    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active text-warning"  aria-current="page" href="admin_articles">Articles</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="color: black" href="admin_clients">Clients</a>
        </li>
    </ul>

    <div class="row">

        <table class="table">
            <thead>
            <tr>
                <th></th>
                <th scope="col">Article</th>
                <th scope="col">Quantité</th>
                <th scope="col">Prix</th>
                <th scope="col"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="article" items="${ articles }">

                <tr>

                    <td><a href="articles?id=${ article.id }"><img src="${ article.picture }" width="60px" alt=""></a></td>
                    <td class="align-middle"><a href="articles?id=${ article.id }">${article.name}</a></td>
                    <td class="align-middle">${article.quantity}</td>
                    <td class="align-middle">${article.price} €</td>
                    <td class="align-middle"><a href="admin_article_update?id=${article.id}" class="btn btn-info"><i class="fas fa-pen"></i></a> <a href="admin_article_delete?id=${article.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>