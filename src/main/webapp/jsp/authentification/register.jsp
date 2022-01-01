<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="vh-100" style="background-color: #DC782F;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <form method="POST" autocomplete="off">
            <div class="card-body p-4 p-lg-5 text-black">

              <h5 class="fw-normal mb-2 pb-2" style="letter-spacing: 1px;">S'inscrire</h5>

              <p class="text-danger">${error}</p>

              <div class="row g-0">

                <div class="col-sm">

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_mail">Email</label>
                    <input name="email" type="email" id="input_mail" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_firstName">Prénom</label>
                    <input name="firstName" type="text" value="${firstName}" id="input_firstName" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_lastName">Nom</label>
                    <input name="lastName" type="text" value="${lastName}" id="input_lastName" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_password">Mot de passe</label>
                    <input name="password" type="password" id="input_password" class="form-control form-control-lg" />
                  </div>

                </div>
                <div class="col-sm">
                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_rue">Rue</label>
                    <input name="rue" type="text" id="input_rue" value="${rue}" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_ville">Ville</label>
                    <input name="ville" type="text" id="input_ville" value="${ville}" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_codepostal">Code Postal</label>
                    <input name="codepostal" type="text" value="${codepostal}" id="input_codepostal" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="input_pays">Pays</label>
                    <input name="pays" type="text" value="${pays}" id="input_pays" class="form-control form-control-lg" />
                  </div>
                </div>
              </div>
              <div class="pt-1 mb-4">
                <button class="btn btn-dark btn-lg btn-block" type="submit">S'inscrire</button>
              </div>
              <p class="mb-5 pb-lg-2" style="color: #393f81;">Vous avez déjà un compte ? <a href="login" class="text-primary"> Connectez vous ici.</a></p>
            </div>
          </form>
        </div>
      </div>
    </div>
</section>