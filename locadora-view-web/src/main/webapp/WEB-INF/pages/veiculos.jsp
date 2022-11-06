<%-- 
    Document   : veiculos
    Created on : 6 de nov. de 2022, 17:01:03
    Author     : gugup
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Locacar - Veículos</title>
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

        <!-- Search Start -->
        <div class="container-fluid bg-white pt-3 px-lg-5">
            <div class="row mx-n2">
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <select id="unidadeRetirada" class="custom-select px-4 mb-3" style="height: 50px;">
                        <%
                                List<Unidades> listaUnidades = listarUnidades();
                                for(Unidades u : listaUnidades){
                                int contador = 0;
                                contador+1;
                        %>
                        <option value="<%=contador%>"><=u.getNumReferencia()%> |<=u.getCidade()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <select id="unidadeEntrega" class="custom-select px-4 mb-3" style="height: 50px;">
                        <%
                                 List<Unidades> listaUnidades = listarUnidades();
                                 for(Unidades u : listaUnidades){
                                 int contador = 0;
                                 contador+1;
                        %>
                        <option value="<%=contador%>"><=u.getNumReferencia()%> |<=u.getCidade()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <div class="date mb-3" id="date" data-target-input="nearest">
                        <input onkeydown="return false" type="date" value="${param.dataRetirada}" id="dataRetirada" name="dataColeta" class="form-control p-4 datetimepicker-input" placeholder="Data de retirada" data-target="#date" data-toggle="datetimepicker" />
                    </div>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <div class="time mb-3" id="time" data-target-input="nearest">
                        <input onkeydown="return false" type="date "value="${param.Entrega}" id="dataEntrega" name="dataEntrega" class="form-control p-4 datetimepicker-input" placeholder="Data de retorno" data-target="#time" data-toggle="datetimepicker" />
                    </div>
                </div>
                <div class="col-xl-2 col-lg-4 col-md-6 px-2">
                    <select id="tipoVeiculo" class="custom-select px-4 mb-3" style="height: 50px;">
                        <option selected>${param.tipoVeiculo}</option>
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
        <!-- Search End -->


        <!-- Page Header Start -->
        <div class="container-fluid page-header">
            <h1 class="display-3 text-uppercase text-white mb-3">Lista de veículos</h1>
            <div class="d-inline-flex text-white">
                <h6 class="text-uppercase m-0"><a class="text-white" href="">Home</a></h6>
                <h6 class="text-body m-0 px-3">/</h6>
                <h6 class="text-uppercase text-body m-0">Veículos</h6>
            </div>
        </div>
        <!-- Page Header Start -->


        <!-- Rent A Car Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <h1 class="display-4 text-uppercase text-center mb-5">ACHE O SEU CARRO</h1>
                <div class="row">
                    <%
                            List<Veiculo> listaVeiculos = listarVeiculos();
                            for(Veiculo v : listaVeiculos){
                            if(v.getStatus().equals("Livre")){                                
                    %>
                    <div class="col-lg-4 col-md-6 mb-2">
                        <div class="rent-item mb-4">
                            <img class="img-fluid mb-4" src="<%=v.getImagem();%>" alt="">
                            <h4 class="text-uppercase mb-4"><%=v.getModeloCarro();%></h4>
                            <div class="d-flex justify-content-center mb-4">
                                <div class="px-2">
                                    <i class="fa fa-car text-primary mr-1"></i>
                                    <span><%=Integer.toString(v.getAno());%></span>
                                </div>
                                <div class="px-2 border-left border-right">
                                    <i class="fa fa-cogs text-primary mr-1"></i>
                                    <span><%=v.getCambio();%></span>
                                </div>
                                <div class="px-2">
                                    <i class="fa fa-road text-primary mr-1"></i>
                                    <span><%=Double.toString(getKmRodados());%> KM</span>
                                </div>
                            </div>
                            <a class="btn btn-primary px-3" href="">R$ <%=Double.toString(getValorAluguel());%>/dia</a>
                        </div>
                    </div>
                    <%}
}%>
                </div>
            </div>
        </div>
        <!-- Rent A Car End -->


        <!-- Banner Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="row mx-0">
                    <div class="col-lg-6 px-0">
                        <div class="px-5 bg-secondary d-flex align-items-center justify-content-between" style="height: 350px;">
                            <img class="img-fluid flex-shrink-0 ml-n5 w-50 mr-4" src="img/banner-left.png" alt="">
                            <div class="text-right">
                                <h3 class="text-uppercase text-light mb-3">Quer ser um cliente?</h3>
                                <p class="mb-4">Clientes Locacar possuem descontos em abastecimentos, lava-jatos e muito mais.</p>
                                <a class="btn btn-primary py-2 px-4" href="">Cadastrar agora</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 px-0">
                        <div class="px-5 bg-dark d-flex align-items-center justify-content-between" style="height: 350px;">
                            <div class="text-left">
                                <h3 class="text-uppercase text-light mb-3">Procurando por um carro?</h3>
                                <p class="mb-4">A Locacar possui veículos especiais para cada tipo de necessidade.</p>
                                <a class="btn btn-primary py-2 px-4" href="">Alugar agora</a>
                            </div>
                            <img class="img-fluid flex-shrink-0 mr-n5 w-50 ml-4" src="img/banner-right.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner End -->




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

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
    </body>

</html>
