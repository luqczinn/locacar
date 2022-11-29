<%-- 
    Document   : logs.jsp
    Created on : 28 de nov. de 2022
    Author     : lucas
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

        <!-- Favicon -->
        <link href="img/favicon.png" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Rubik&display=swap"
              rel="stylesheet">

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
                            <a href="index.html" class="nav-item nav-link active">Home</a>
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
        <!-- Navbar End -->

        <!-- Page Header Start -->
        <div class="container-fluid page-header">
            <h1 class="display-3 text-uppercase text-white mb-3">Geração de Logs de Login</h1>
            <div class="d-inline-flex text-white">
                <h6 class="text-uppercase m-0"><a class="text-white" href="">Home</a></h6>
                <h6 class="text-body m-0 px-3">/</h6>
                <h6 class="text-uppercase text-body m-0">Logs</h6>
            </div>
        </div>
        <!-- Page Header Start -->

        <div class="container-fluid bg-white pt-3 px-lg-5">
            <div class="row mx-n2 tabelasMostra">
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <form action="logsLogin.jsp" method="GET">
                        <h1 class="ls-login-logo ">Escolha a tabela</h1>
                        <select name="tipoTabela" id="tipoTabela" class="custom-select px-4 mb-3" style="height: 50px;">
                            <option value="1">Cliente</option>
                            <option value="2">Funcionário</option>
                        </select>
                </div>
            </div>
            <div class="row mx-n2 tabelasMostra">
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <input type="submit" class="btn btn-primary btn-block mb-3" type="submit" value="Procurar" style="height: 50px; "/>
                    </form>
                </div>
            </div>
        
        <c:set var="tipo" value="${param.tipoTabela}"/>
        <c:choose>
            <c:when test= "${tipo < 2}">    
                <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com/bdlocacar" user= "admin"  password= "NFe8Y6Nh7OPZEfh^sW3hv" />
                <sql:query dataSource="${conexao}" var="result">
                    SELECT * FROM logCliente ORDER BY dataHora desc
                </sql:query>
                <div class="tabelasMostra">
                    <!-- Tabela de Logs -->
                    <div class="tabela">
                        <table id="tabelCliente" class="tabelas">
                            <!--Linha de titulos -->
                            <tr id="titulo">
                                <td>Usuário</td>
                                <td>Hora</td>
                            </tr>      
                            <c:forEach var="row" items="${result.rows}">                        
                                <tr> 
                                    <td>
                                        <c:out value = "${row.cliente}"/> 
                                    </td>
                                    <td>
                                        <c:out value = "${row.dataHora}"/> 
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test= "${tipo > 1}">
                <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com/bdlocacar" user= "admin"  password= "NFe8Y6Nh7OPZEfh^sW3hv" />
                <sql:query dataSource="${conexao}" var="result">
                    SELECT * FROM log ORDER BY horaLogin desc
                </sql:query>
                <!-- Tabela de Logs -->
                <div class="tabelasMostra">
                    <table id="tabelFuncionario" class="tabelas">
                        <!--Linha de titulos -->
                        <tr id="titulo">
                            <td>Usuário</td>
                            <td>Cargo</td>
                            <td>Hora</td>
                        </tr>      
                        <c:forEach var="row" items="${result.rows}">                        
                            <tr> 
                                <td>
                                    <c:out value = "${row.funcionario}"/> 
                                </td>
                                <td>
                                    <c:out value = "${row.cargo}"/> 
                                </td>
                                <td>
                                    <c:out value = "${row.horaLogin}"/> 
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:when>
        </c:choose>
        </div>
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
                <script src="js/ajax.js"></script>
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