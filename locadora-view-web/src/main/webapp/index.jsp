<%-- 
    Document   : index.jsp
    Created on : 6 de nov. de 2022, 15:49:19
    Author     : gugup
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <title>Locacar - Locadora de Veículos</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <link href="img/favicon.png" rel="icon">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Rubik&display=swap" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-fluid bg-dark py-3 px-lg-5 d-none d-lg-block">

        </div>
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
                            <a href="home.html" class="nav-item nav-link active">Home</a>
                            <a href="about.html" class="nav-item nav-link">Sobre</a>
                            <a href="service.html" class="nav-item nav-link">Serviços</a>
                            <a href="service.html" class="nav-item nav-link">Veículos</a>
                            <a href="contact.html" class="nav-item nav-link">Contato</a>
                            <a href="contact.html" id="entrarBtn" class="nav-item nav-link">Entrar</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        
        <div class="container-fluid bg-white pt-3 px-lg-5">
            <div class="row mx-n2">
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com/bdlocacar" user= "admin"  password= "NFe8Y6Nh7OPZEfh^sW3hv" />
                    <sql:query dataSource="${conexao}" var="result">
                        SELECT * FROM unidades
                    </sql:query>
                    <select id="unidadeRetirada" class="custom-select px-4 mb-3" style="height: 50px;">
                        <option selected>Local de retirada</option>
                        <c:set var="contador" value="0"/>  
                        <c:forEach var="row" items="${result.rows}">
                            <c:set var="contador" value="contador+1"/>                        
                            <option value="<c:out value="${contador}"/>"><c:out value = "${row.referencia}"/> | <c:out value = "${row.logradouro}"/> | <c:out value = "${row.cidade}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <select id="unidadeEntrega" class="custom-select px-4 mb-3" style="height: 50px;">
                        <option selected>Local de retorno</option>
                        <c:set var="contador" value="0"/>  
                        <c:forEach var="row" items="${result.rows}">
                            <c:set var="contador" value="contador+1"/>                        
                            <option value="<c:out value="${contador}"/>"><c:out value = "${row.referencia}"/> | <c:out value = "${row.logradouro}"/> | <c:out value = "${row.cidade}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <div class="date mb-3" id="date" data-target-input="nearest">
                        <input onkeydown="return false" type="date" id="dataRetirada" name="dataColeta" class="form-control p-4 datetimepicker-input" placeholder="Data de retirada" data-target="#date" data-toggle="datetimepicker" />
                    </div>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <div class="time mb-3" id="time" data-target-input="nearest">
                        <input onclick="defineMinimoData()" onkeydown="return false" type="date" id="dataEntrega" name="dataEntrega" class="form-control p-4 datetimepicker-input" placeholder="Data de retorno" data-target="#time" data-toggle="datetimepicker" />
                    </div>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <select id="tipoVeiculo" class="custom-select px-4 mb-3" style="height: 50px;">
                        <option selected>Tipo de veículo</option>
                        <option value="1">Tipo A</option>
                        <option value="2">Tipo B</option>
                        <option value="3">Tipo C</option>
                        <option value="4">Tipo D</option>
                    </select>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <button class="btn btn-primary btn-block mb-3" type="submit" style="height: 50px;">Procurar</button>
                </div>
            </div>
        </div>

        <div class="container-fluid p-0" style="margin-bottom: 90px;">
            <div id="header-carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="w-100" src="img/carousel-1.png" alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 900px;">
                                <h4 class="text-white text-uppercase mb-md-3">Locacar: Aluguel de veículos</h4>
                                <h1 class="display-1 text-white mb-md-4">A melhor locadora de veículos da América</h1>
                                <a href="" class="btn btn-primary py-md-3 px-md-5 mt-2">Reserve agora!</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="w-100" src="img/carousel-2.jpg" alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 900px;">
                                <h4 class="text-white text-uppercase mb-md-3">Locacar: Aluguel de veículos</h4>
                                <h1 class="display-1 text-white mb-md-4">Veículos de melhores qualidades</h1>
                                <a href="" class="btn btn-primary py-md-3 px-md-5 mt-2">Reserve agora!</a>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
                    <div class="btn btn-dark" style="width: 45px; height: 45px;">
                        <span class="carousel-control-prev-icon mb-n2"></span>
                    </div>
                </a>
                <a class="carousel-control-next" href="#header-carousel" data-slide="next">
                    <div class="btn btn-dark" style="width: 45px; height: 45px;">
                        <span class="carousel-control-next-icon mb-n2"></span>
                    </div>
                </a>
            </div>
        </div>

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

            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>
            <script src="lib/tempusdominus/js/moment.min.js"></script>
            <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
            <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
    </body>

</html>