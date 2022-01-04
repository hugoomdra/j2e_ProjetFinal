<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="product-section mt-150 mb-150">
    <div class="container">
        <div class="row product-lists">
            <c:forEach var="article" items="${ articles }">

                <div class="col-lg-4 col-md-6 text-center strawberry">
                    <div class="single-product-item">
                        <div class="product-image">
                            <a href="articles?id=${ article.id }"><img src="${ article.picture }" alt=""></a>
                        </div>
                        <h3>${ article.name }</h3>
                        <p class="product-price"><span>${ article.type }</span> ${ article.price } € </p>
                        <a href="" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
