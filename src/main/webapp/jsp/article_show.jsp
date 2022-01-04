<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="single-product mt-150 mb-150">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <div class="single-product-img">
                    <img src="${article.picture}" alt="">
                </div>
            </div>
            <div class="col-md-7">
                <div class="single-product-content">
                    <h3>${article.name}</h3>

                    <c:if test="${article.quantity > 1 && article.quantity < 4}">
                        <p class="text-warning">Bientôt en rupture de stock</p>
                    </c:if>

                    <p class="single-product-pricing"><span>${article.type}</span> ${article.price} €</p>
                    <p>${article.description}</p>
                    <div class="single-product-form">
                        <form action="panier/add" method="POST">
                            <c:if test="${article.quantity > 0}">
                                <input type="number" value="1" min="1" name="qte" placeholder="0">
                                <p class="text-danger">${error}</p>
                                <input type="hidden" name="article_id" value="${article.id}">
                                <button type="submit" class="btn btn-dark"><i class="fas fa-shopping-cart"></i> Ajouter au panier</button>
                            </c:if>
                            <c:if test="${article.quantity <= 0}">
                                <button type="button" class="btn btn-danger"><i class="fas fa-shopping-cart"></i> Rupture de stock</button>
                            </c:if>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end single product -->