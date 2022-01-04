<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mb-100 mt-100">
    <div class="row">
        <div class="col-12">
            <div class="billing-address-form">
                <form method="post" >
                    <div class="row">

                        <div class="col-7">
                            <p><input required name="name" type="text" placeholder="Nom de l'article"></p>
                        </div>
                        <div class="col-2">
                            <p><input required name="quantity" type="number" min="0" placeholder="Quantité"></p>
                        </div>

                        <div class="col-3">
                            <select name="type">
                                <option value="">-- Type de jeu --</option>
                                <option value="PS4">PS4</option>
                                <option value="XBOX ONE">XBOX ONE</option>
                                <option value="SWITCH">SWITCH</option>
                            </select>
                        </div>

                        <div class="col-5">
                            <p><input required name="price" type="text" placeholder="Prix"></p>
                        </div>

                        <div class="col-7">
                            <p><input required name="picture" type="text" placeholder="Lien de l'image"></p>
                        </div>

                        <div class="col-12 mt-3">
                            <p><textarea required name="description" cols="30" rows="10" placeholder="Description de l'article"></textarea></p>
                        </div>

                        <div class="col-12">
                            <button class="btn btn-dark btn-lg btn-block" type="submit">Ajouter</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>