<%-- 
    Document   : perfil
    Created on : 28 de nov. de 2022, 21:25:11
    Author     : sufra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Rubik&display=swap" rel="stylesheet"> 
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid position-relative nav-bar p-0">
            <div class="position-relative px-lg-5" style="z-index: 9;">
                <nav class="navbar navbar-expand-lg bg-secondary navbar-dark py-3 py-lg-0 pl-3 pl-lg-5">
                    <a href="" class="navbar-brand">
                        <h1 class="text-uppercase text-primary mb-1">Locacar</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                        <div class="navbar-nav ml-auto py-0">
                            <a href="index.jsp" class="nav-item nav-link">Home</a>
                            <a href="veiculos.jsp" class="nav-item nav-link">Veículos</a>
                            <a href="contato.jsp" class="nav-item nav-link">Contato</a>
                            <%
                    if(session.getAttribute("user") == null){
                            %>
                            <a href="Login.jsp" id="entrarBtn" class="nav-item nav-link">Entrar</a>
                            <%
                }
                else{
                            %>
                            <form action="perfil.jsp" method="post">
                                <input name="apelidoCliente" value="${requestScope.user}" style="display: none;">
                                <input name="nomeCliente" value="${requestScope.nome}" style="display: none;">
                                <input name="emailCliente" value="${requestScope.email}" style="display: none;">
                                <input name="telefoneCliente" value="${requestScope.tel}" style="display: none;">
                                <input name="enderecoCliente" value="${requestScope.endereco}" style="display: none;">
                                <input type="submit" value="Meu perfil" class="nav-item btn btn-primary btn-block" style="margin-top: 20px;">
                            </form>
                            <%}%>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        
        <section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row">
      <div class="col">
        <div class="card mb-4">
          <div class="card-body text-center">
            <h5 class="my-3"><%= session.getAttribute("nome")%></h5>
            <p class="text-muted mb-4"><%= session.getAttribute("endereco")%></p>
          </div>
          <div class="d-flex justify-content-center mb-2">
              <form action="encerrarSessao" method="post">
                <input type="submit" value="Sair da conta" class="btn btn-primary btn-block">
                </form>
          </div>
        </div>
 
      </div>
      <div class="col-lg-8">
        <div class="card mb-4">
          <div class="card-body">
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Usuário</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%= session.getAttribute("user")%></p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Nome</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%= session.getAttribute("nome")%></p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Telefone</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%= session.getAttribute("tel")%></p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Email</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%= session.getAttribute("email")%></p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Endereço</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%= session.getAttribute("endereco")%></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
        
        <div class="container-fluid bg-secondary py-5 px-sm-3 px-md-5" style="margin-top: 90px;">
            <div class="row pt-5">
                <div class="col-lg-3 col-md-6 mb-5">
                    <h4 class="text-uppercase text-light mb-4">Entre em contato</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-white mr-3"></i>Av. Amazonas, 7675 - Nova Gameleira, Belo Horizonte</p>
                    <p class="mb-2"><i class="fa fa-phone-alt text-white mr-3"></i>+55 31 99510-6573</p>
                    <p><i class="fa fa-envelope text-white mr-3"></i>contato@locacar.com.br</p>
                    <h6 class="text-uppercase text-white py-2">Siga-nos</h6>
                    <div class="d-flex justify-content-start">
                        <a class="btn btn-lg btn-dark btn-lg-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-lg btn-dark btn-lg-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-lg btn-dark btn-lg-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                        <a class="btn btn-lg btn-dark btn-lg-square" href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="container-fluid bg-dark py-4 px-sm-3 px-md-5">
                <p class="mb-2 text-center text-body">&copy; <a href="#">Locacar</a>. Todos os direitos reservados</p>
            </div>
            
            <script src="https://kit.fontawesome.com/60feab9afa.js" crossorigin="anonymous"></script>
    </body>
</html>