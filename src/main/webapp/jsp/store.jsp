<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="product-section mt-100 mb-150">
    <div class="container">
        <div class="row row-cols-1 row-cols-md-3">
            <c:forEach var="article" items="${ articles }">
                <div class="col mb-4">
                    <a href="articles?id=${ article.id }">
                        <div class="card h-100">
                            <div class="card-body text-center">
                                <img style="width: 300px;" src="${ article.picture }" alt="">
                                <h5 class="card-title mt-2">${ article.name }</h5>
                                <p class="card-text" style="font-size: 18px">${ article.price } €</p>
                                <div class="mt-2">
                                    <c:if test="${article.quantity > 0}">
                                        <a href="articles?id=${ article.id }" class="btn btn-dark"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                                    </c:if>
                                    <c:if test="${article.quantity <= 0}">
                                        <a href="articles?id=${ article.id }" class="btn btn-danger"><i class="fas fa-shopping-cart"></i> Rupture de stock</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
