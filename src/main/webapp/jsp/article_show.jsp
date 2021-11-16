<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="single-product mt-150 mb-150">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <div class="single-product-img">
                    <img src="assets/img/products/${article.picture}.png" alt="">
                </div>
            </div>
            <div class="col-md-7">
                <div class="single-product-content">
                    <h3>${article.name}</h3>
                    <p class="single-product-pricing"><span>${article.type}</span> ${article.price} €</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta sint dignissimos, rem commodi cum voluptatem quae reprehenderit repudiandae ea tempora incidunt ipsa, quisquam animi perferendis eos eum modi! Tempora, earum.</p>
                    <div class="single-product-form">
                        <form action="index.html">
                            <input type="number" placeholder="0">
                        </form>
                    </div>
                    <a href="cart.html" class="cart-btn mt-4"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- end single product -->