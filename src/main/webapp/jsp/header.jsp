<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="top-header-area" id="sticker">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 text-center">
                <div class="main-menu-wrap">
                    <!-- logo -->
                    <div class="site-logo">
                        <a href="store">
                            <img src="assets/img/logo.png" alt="">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu">
                        <ul>

                            <li class="${content == 'store' ? "current-list-item" : ""}"><a href="store">Nos jeux</a>
                            </li>
                            <li class="${content == 'about' ? "current-list-item" : ""}"><a href="about">A propos de nous</a></li>

                            <c:if test="${client.admin == true}">
                            <li class="${content.substring(0, 3) == 'adm' ? "current-list-item" : ""}"><a href="admin_articles">Administration</a></li>
                            </c:if>

                            <li>
                                <div class="header-icons">
                                    <a style="${content.substring(0, 3) == 'pan' ? "color:#D7782A;" : ""}" class="shopping-cart" href="panier"><i class="fas fa-shopping-cart"></i></a>
                                    <a style="${content == 'user' || content == 'commande_show' ? "color:#D7782A;" : ""}" href="user"><i class="fas fa-user-circle"></i> ${client.firstName} ${client.lastName}</a>
                                    <a class="" href="logout"><i class="fas fa-sign-out-alt"></i></a>
                                </div>
                            </li>
                        </ul>
                    </nav>
                    <a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                    <div class="mobile-menu"></div>
                    <!-- menu end -->
                </div>
            </div>
        </div>
    </div>
</div>

