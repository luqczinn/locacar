<%-- 
    Document   : reserva
    Created on : 8 de nov de 2022, 10:33:53
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="utf-8">
        <title>Locacar - Locadora de Veículos</title>
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
        <div class="bg-dark py-3">
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
        <!-- Search End -->

        <!-- Page Header Start -->
        <div class="container-fluid page-header">
            <h1 class="display-3 text-uppercase text-white mb-3">Locação do Veículo</h1>
            <div class="d-inline-flex text-white">
                <h6 class="text-uppercase m-0"><a class="text-white" href="">Home</a></h6>
                <h6 class="text-body m-0 px-3">/</h6>
                <h6 class="text-uppercase text-body m-0">Locação do Veículo</h6>
            </div>
        </div>
        <!-- Page Header Start -->


        <!-- Detail Start -->
        <form action="ComprovanteServlet" method="POST">
            <div class="container-fluid pt-5">
                <div class="container pt-5 pb-3">
                    <h1 class="display-4 text-uppercase mb-5">${requestScope.nomeVeiculo}</h1>
                    <input name="veiculo" value="${requestScope.nomeVeiculo}" style="display: none;">
                    <div class="row align-items-center pb-2">
                        <div class="col-lg-6 mb-4">
                            <img class="img-fluid" src="${requestScope.imagemVeiculo}" alt="">
                        </div>
                        <div class="col-lg-6 mb-4">
                            <h4 class="mb-2">${requestScope.valorAluguel} por dia.</h4>
                            <input name="valorAluguel" value="${requestScope.valorAluguel}" style="display: none;">
                            <div class="d-flex mb-3"></div>
                            <p>Informações do Veículo: Este veículo possui um motor <span>${requestScope.motor}</span>, da marca <span>${requestScope.marca}</span>, do ano <span>${requestScope.ano}</span>, com <span>${requestScope.quilometragem} KM</span> rodados. O seu 
                                tipo é ${requestScope.tipo}.</p>
                            <input name="motor" value="${requestScope.motor}" style="display: none;">
                            <input name="tipo" value="${requestScope.tipo}" style="display: none;">
                            <input name="marca" value="${requestScope.marca}" style="display: none;">
                            <input name="ano" value="${requestScope.ano}" style="display: none;">
                            <input name="quilometragem" value="${requestScope.quilometragem}" style="display: none;">
                            <div class="d-flex pt-1">
                                <h6>Compartilhe em:</h6>
                                <div class="d-inline-flex">
                                    <a class="px-2" href=""><i class="fab fa-facebook-f"></i></a>
                                    <a class="px-2" href=""><i class="fab fa-twitter"></i></a>
                                    <a class="px-2" href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a class="px-2" href=""><i class="fab fa-pinterest"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-n3 mt-lg-0 pb-4">
                        <div class="col-md-3 col-6 mb-2">
                            <i class="fa fa-car text-primary mr-2"></i>
                            <span>Modelo: ${requestScope.modelo}</span>
                            <input name="modelo" value="${requestScope.modelo}" style="display: none;">
                        </div>
                        <div class="col-md-3 col-6 mb-2">
                            <i class="fa fa-cogs text-primary mr-2"></i>
                            <span>Câmbio: ${requestScope.cambio}</span>
                            <input name="cambio" value="${requestScope.cambio}" style="display: none;">
                        </div>
                    </div>
                </div>
            </div>
            <!-- Detail End -->


            <!-- Car Booking Start -->
            <div class="container-fluid pb-5">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8">
                            <h2 class="mb-4">Detalhes Cliente:</h2>
                            <div class="mb-5">
                                <div class="row">
                                    <div class="col-6 form-group">
                                        <input type="text" class="form-control p-4" placeholder="Nome" required="required" disabled value="${requestScope.nomeCliente}">
                                    </div>
                                    <div class="col-6 form-group">
                                        <input type="text" class="form-control p-4" placeholder="Apelido" required="required" disabled value="${requestScope.apelidoCliente}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6 form-group">
                                        <input type="email" name="email" class="form-control p-4" placeholder="Email" required="required" disabled value="${requestScope.emailCliente}">
                                    </div>
                                    <div class="col-6 form-group">
                                        <input type="text" name="telefone" class="form-control p-4" placeholder="Telefone" required="required" disabled value="${requestScope.telefoneCliente}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6 form-group">
                                        <input type="text" name="dataNascimento" class="form-control p-4" placeholder="dataNascimento" required="required" disabled value="${requestScope.nascimentoCliente}">
                                    </div>
                                    <div class="col-6 form-group">
                                        <input type="text" name="endereco" class="form-control p-4" placeholder="Endereco" required="required" disabled value="${requestScope.enderecoCliente}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6 form-group">
                                        <input type="text" name="cpf" class="form-control p-4" placeholder="CPF" required="required" disabled value="${requestScope.cpfCliente}">
                                    </div>
                                    <div class="col-6 form-group">
                                        <input type="text" name="rg" class="form-control p-4" placeholder="RG" required="required" disabled value="${requestScope.rgCliente}">
                                    </div>
                                </div>
                            </div>
                            <h2 class="mb-4">Detalhes da Reserva:</h2>
                            <div class="mb-5">
                                <div class="row">
                                    <div class="col-6 form-group">
                                        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com/bdlocacar" user= "admin"  password= "NFe8Y6Nh7OPZEfh^sW3hv" />
                                        <sql:query dataSource="${conexao}" var="result">
                                            SELECT * FROM unidades
                                        </sql:query>
                                        <select name="localColeta"class="custom-select px-4" style="height: 50px;">
                                            <option selected>Local de coleta</option>
                                            <c:forEach var="row" items="${result.rows}">                        
                                                <option value="<c:out value = "${row.referencia}"/> | <c:out value = "${row.logradouro}"/> | <c:out value = "${row.cidade}"/>"><c:out value = "${row.referencia}"/> | <c:out value = "${row.logradouro}"/> | <c:out value = "${row.cidade}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-6 form-group">
                                        <sql:query dataSource="${conexao}" var="result">
                                            SELECT * FROM unidades
                                        </sql:query>
                                        <select name="localEntrega" class="custom-select px-4" style="height: 50px;">
                                            <option selected>Local de retorno</option>
                                            <c:forEach var="row" items="${result.rows}">                        
                                                <option value="<c:out value = "${row.referencia}"/> | <c:out value = "${row.logradouro}"/> | <c:out value = "${row.cidade}"/>"><c:out value = "${row.referencia}"/> | <c:out value = "${row.logradouro}"/> | <c:out value = "${row.cidade}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6 form-group">
                                        <div class="date" id="date2" data-target-input="nearest">
                                            <input onkeydown="return false" type="date" id="dataRetirada" name="dataRetirada" class="form-control p-4 datetimepicker-input" placeholder="Data de retirada" data-target="#date" data-toggle="datetimepicker" />
                                        </div>
                                    </div>
                                    <div class="col-6 form-group">
                                        <div class="time" id="time2" data-target-input="nearest">
                                            <input onkeydown="return false" type="date" id="dataEntrega" name="dataEntrega" class="form-control p-4 datetimepicker-input" placeholder="Data de retorno" data-target="#time" data-toggle="datetimepicker" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="bg-secondary p-5 mb-5">
                                <h2 class="text-primary mb-4">Pagamento</h2>
                                <select name="pagamento" class="custom-select px-4" style="height: 50px;">
                                    <option selected>Forma de pagamento</option>                     
                                    <option value="pix">Pix</option>
                                    <option value="paypal">Paypal</option>
                                    <option value="cartao">Cartão de crédito</option>
                                    <option value="dinheiro">Dinheiro (na unidade de coleta)</option>
                                </select>
                                <br>

                                <input type="submit" value="Reserve Agora" class="btn btn-block btn-primary py-3">
                                </form>
                            </div>                    
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Car Booking End -->


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

            <script>

            <!-- JavaScript Libraries -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>
            <script src="lib/tempusdominus/js/moment.min.js"></script>
            <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
            <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
            <script src="https://kit.fontawesome.com/60feab9afa.js" crossorigin="anonymous"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
            </body>

<<<<<<< HEAD

=======
            <!-- Template Javascript -->
            <script src="js/main.js"></script>
            </body>

>>>>>>> origin/production
            </html>
