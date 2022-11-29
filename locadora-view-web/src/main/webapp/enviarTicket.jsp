<%-- 
    Document   : contato
    Created on : 8 de nov de 2022, 12:33:44
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="locadora.locadora.negocio.servico.ServicoUnidades" %>
<%@ page import="locadora.locadora.negocio.dto.Unidades" %>
<%@ page import="locadora.locadora.negocio.servico.ServicoTicket" %>
<%@ page import="locadora.locadora.negocio.dto.Cliente" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Locacar - Contato</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link href="img/favicon.png" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Rubik&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid bg-dark py-3 px-lg-5 d-none d-lg-block">

    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <!-- Navbar Start -->
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
                            <form action="encerrarSessao" method="post">
                                <button type="submit" class="nav-item btn btn-primary btn-block" style="margin-top: 20px; margin-left: 10px;"><i class="fa fa-sign-out"></i></button>
                            </form>
                            <%}%>
                        </div>
                    </div>
            </nav>
        </div>
    </div>
    <!-- Navbar End -->

    <!-- Search Start -->
    <div class="container-fluid bg-white pt-3 px-lg-5">
        <div class="row mx-n2">
            <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                <select id="unidadeRetirada" class="custom-select px-4 mb-3" style="height: 50px;">
                <option selected>Local de retirada</option>
                <option value="1">Unidade tal</option>
                <option value="2">Unidade tal</option>
                <option value="3">Unidade tal</option>
            </select>
            </div>
            <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                <select id="unidadeEntrega" class="custom-select px-4 mb-3" style="height: 50px;">
                <option selected>Local de retorno</option>
                <option value="1">Unidade tal</option>
                <option value="2">Unidade tal</option>
                <option value="3">Unidade tal</option>
            </select>
            </div>
            <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                <div class="date mb-3" id="date" data-target-input="nearest">
                    <input type="date" id="dataRetirada" name="dataColeta" class="form-control p-4 datetimepicker-input" placeholder="Data de retirada" data-target="#date" data-toggle="datetimepicker" />
                </div>
            </div>
            <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                <div class="time mb-3" id="time" data-target-input="nearest">
                    <input type="date" id="dataEntrega" name="dataEntrega" class="form-control p-4 datetimepicker-input" placeholder="Data de retorno" data-target="#time" data-toggle="datetimepicker" />
                </div>
            </div>
            <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                <select id="tipoVeiculo" class="custom-select px-4 mb-3" style="height: 50px;">
                <option selected>Tipo de veículo</option>
                <option value="1">Tipo A</option>
                <option value="2">Tipo B</option>
                <option value="3">Tipo C</option>
            </select>
            </div>
            <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                <button class="btn btn-primary btn-block mb-3" type="submit" style="height: 50px;">Procurar</button>
            </div>
        </div>
    </div>
    <!-- Search End -->


   
    
    
    <h1 style="text-align: center;  margin-top: 8%;"> MUITO BEM!</h1>
    <h2 style="text-align: center; margin-left: 20%; margin-right: 20%; margin-bottom: 3%;">Você enviou com sucesso um ticket para os serviços da locacar! Enviaremos sua resposta por e-mail quando ela estiver pronta.</h2>
    <button style="display: block; margin-left: auto; margin-right: auto; margin-bottom: 15%;" onclick="window.location.href = 'locadora-view-web/index.jsp'" class="btn btn-primary py-3 px-5" type="submit">Voltar para a Home</button>
   
    <!-- Footer Start -->
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
            <p class="m-0 text-center text-body">Idealizado por <a href="https://htmlcodex.com">HTML Codex</a></p>
        </div>
        <!-- Footer End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
        <script src="https://kit.fontawesome.com/60feab9afa.js" crossorigin="anonymous"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
</body>

</html>
