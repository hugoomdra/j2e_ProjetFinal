<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid mb-100 mt-100">
    <div class="row">

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
                <c:forEach var="article" items="${ articles }">

                    <tr>
                        <td><img src="${ article.picture }" style="width: 60px" alt=""></td>
                        <td class="align-middle">${article.name}</td>
                        <td class="align-middle">${article.quantity}</td>
                        <td class="align-middle">${ligne.article.price} €</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</div>