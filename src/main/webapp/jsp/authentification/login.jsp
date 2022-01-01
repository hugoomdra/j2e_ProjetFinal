<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="vh-100" style="background-color: #DC782F;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img
                                    src="assets/img/login/login.png"
                                    alt="login form"
                                    class="img-fluid" style="border-radius: 1rem 0 0 1rem;"
                            />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form method="POST">

                                    <h5 class="fw-normal mb-2 pb-2" style="letter-spacing: 1px;">Connectez vous à votre compte</h5>

                                    <p class="text-danger">${error}</p>
                                    <p class="text-success">${success}</p>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17">Email</label>
                                        <input name="email" value="${email}" type="email" id="form2Example17" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example27">Mot de passe</label>
                                        <input name="password" type="password" id="form2Example27" class="form-control form-control-lg" />
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-dark btn-lg btn-block" type="submit">Se connecter</button>
                                    </div>

                                    <p class="mb-5 pb-lg-2" style="color: #393f81;">Vous n'avez pas de compte ?<a href="register" class="text-primary"> Inscrivez vous ici.</a></p>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>