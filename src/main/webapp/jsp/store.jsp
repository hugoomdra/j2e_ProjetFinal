<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

    <!-- title -->
    <title>Shop</title>

    <!-- favicon -->
    <link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
    <!-- fontawesome -->
    <link rel="stylesheet" href="assets/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <!-- owl carousel -->
    <link rel="stylesheet" href="assets/css/owl.carousel.css">
    <!-- magnific popup -->
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <!-- animate css -->
    <link rel="stylesheet" href="assets/css/animate.css">
    <!-- mean menu css -->
    <link rel="stylesheet" href="assets/css/meanmenu.min.css">
    <!-- main style -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- responsive -->
    <link rel="stylesheet" href="assets/css/responsive.css">

</head>
<body>

<!--PreLoader-->
<div class="loader">
    <div class="loader-inner">
        <div class="circle"></div>
    </div>
</div>
<!--PreLoader Ends-->

<!-- header -->
<jsp:include page="header.jsp"/>
<!-- end header -->

<!-- breadcrumb-section -->
<jsp:include page="sous_header.jsp"/>
<!-- end breadcrumb section -->

<!-- products -->
<div class="product-section mt-150 mb-150">
    <div class="container">
        <div class="row product-lists">
            <div class="col-lg-4 col-md-6 text-center strawberry">
                <div class="single-product-item">
                    <div class="product-image">
                        <a href="single-product.html"><img src="assets/img/products/cod_vandguard.png" alt=""></a>
                    </div>
                    <h3>Call of Duty : Vandguard</h3>
                    <p class="product-price"><span>XBox One</span> 85 € </p>
                    <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 text-center berry">
                <div class="single-product-item">
                    <div class="product-image">
                        <a href="single-product.html"><img src="assets/img/products/zelda.png" alt=""></a>
                    </div>
                    <h3>The Legend of Zelda</h3>
                    <p class="product-price"><span>Switch</span> 70 € </p>
                    <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 text-center lemon">
                <div class="single-product-item">
                    <div class="product-image">
                        <a href="single-product.html"><img src="assets/img/products/fifa_22.png" alt=""></a>
                    </div>
                    <h3>Fifa 22</h3>
                    <p class="product-price"><span>PS4</span> 35 €</p>
                    <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 text-center">
                <div class="single-product-item">
                    <div class="product-image">
                        <a href="single-product.html"><img src="assets/img/products/gta_5.png" alt=""></a>
                    </div>
                    <h3>Grand Theft Auto V</h3>
                    <p class="product-price"><span>PS4</span> 50 € </p>
                    <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 text-center">
                <div class="single-product-item">
                    <div class="product-image">
                        <a href="single-product.html"><img src="assets/img/products/mario_kart.png" alt=""></a>
                    </div>
                    <h3>Mario Kart Deluxe 8</h3>
                    <p class="product-price"><span>Switch</span> 45 € </p>
                    <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 text-center strawberry">
                <div class="single-product-item">
                    <div class="product-image">
                        <a href="single-product.html"><img src="assets/img/products/crash.png" alt=""></a>
                    </div>
                    <h3>Crash Team Racing</h3>
                    <p class="product-price"><span>PS4</span> 80 € </p>
                    <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart"></i> Ajouter au panier</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="pagination-wrap">
                    <ul>
                        <li><a href="#">Prev</a></li>
                        <li><a href="#">1</a></li>
                        <li><a class="active" href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- end products -->

<!-- footer -->
<jsp:include page="footer.jsp"/>
<!-- end footer -->



<!-- jquery -->
<script src="assets/js/jquery-1.11.3.min.js"></script>
<!-- bootstrap -->
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<!-- count down -->
<script src="assets/js/jquery.countdown.js"></script>
<!-- isotope -->
<script src="assets/js/jquery.isotope-3.0.6.min.js"></script>
<!-- waypoints -->
<script src="assets/js/waypoints.js"></script>
<!-- owl carousel -->
<script src="assets/js/owl.carousel.min.js"></script>
<!-- magnific popup -->
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<!-- mean menu -->
<script src="assets/js/jquery.meanmenu.min.js"></script>
<!-- sticker js -->
<script src="assets/js/sticker.js"></script>
<!-- main js -->
<script src="assets/js/main.js"></script>

</body>
</html>