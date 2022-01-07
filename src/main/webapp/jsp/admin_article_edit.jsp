<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mb-100 mt-100">
    <div class="row">
        <div class="col-12">
            <div class="billing-address-form">
                <form method="post" >
                    <div class="row">

                        <div class="col-7">
                            <p><input required value="${article.name}" name="name" type="text" placeholder="Nom de l'article"></p>
                        </div>
                        <div class="col-2">
                            <p><input required value="${article.quantity}" name="quantity" type="number" min="0" placeholder="Quantité"></p>
                        </div>

                        <div class="col-3">
                            <select name="type">
                                <option value="">-- Type de jeu --</option>
                                <option ${article.type == "PS4" ? "selected" : ""} value="PS4">PS4</option>
                                <option ${article.type == "XBOX ONE" ? "selected" : ""} value="XBOX ONE">XBOX ONE</option>
                                <option ${article.type == "SWITCH" ? "selected" : ""} value="SWITCH">SWITCH</option>
                            </select>
                        </div>

                        <div class="col-5">
                            <p><input value="${article.price}" required name="price" type="text" placeholder="Prix"></p>
                        </div>

                        <div class="col-7">
                            <p><input value="${article.picture}" required name="picture" type="text" placeholder="Lien de l'image"></p>
                        </div>

                        <div class="col-12 mt-3">
                            <p><textarea required name="description" cols="30" rows="10" maxlength="250" placeholder="Description de l'article">${article.description}</textarea></p>
                        </div>

                        <div class="col-12">
                            <button class="btn btn-dark btn-lg btn-block" type="submit">Modifier</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>