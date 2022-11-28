<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String erro = (String) request.getAttribute("erro");
    String teste = (String) request.getAttribute("teste");
%>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Login</title>
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
                            <a href="home.html" class="nav-item nav-link">Home</a>
                            <a href="about.html" class="nav-item nav-link">Sobre</a>
                            <a href="service.html" class="nav-item nav-link">Serviços</a>
                            <a href="service.html" class="nav-item nav-link">Veículos</a>
                            <a href="contact.html" class="nav-item nav-link">Contato</a>
                            <a href="Login.jsp" class="nav-item nav-link">Entrar</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <div class="parent-login">
            <div class="parent-inner">
                <div class="box-login">                   
                    <form method="POST" role="form" action="servletLogin">
                        <h1 class="ls-login-logo ">Faça seu login!</h1>
                        <fieldset>
                            <div class="form-group-ls-login-user">
                                <label for="userLogin">Usuário</label>
                                <input class="form-control ls-login-bg-user input-lg" name="user" id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário">
                            </div>

                            <div class="form-group ls-login-password">
                                <label class="userPassword" for="userPassword">Senha</label>
                                <input class="form-control ls-login-bg-password input-lg" name="senha" id="userPassword" type="password" aria-label="Senha" placeholder="Senha">
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="checkbox" value="usuario" id="flexCheckDefault" checked/>
                                <label class="form-check-label" for="flexCheckDefault">Logar como funcionário</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="checkbox" value="cliente" id="flexCheckDefault" />
                                <label class="form-check-label" for="flexCheckDefault">Logar como cliente</label>
                            </div>
                            <div class="submit-button">
                                <input name="ano" value="${param.ano}" style="display: none;">
                                <input name="placaCarro" value="${param.placaCarro}" style="display: none;">
                                <input name="marca" value="${param.marca}" style="display: none;">
                                <input name="tipoMotor" value="${param.tipoMotor}" style="display: none;">
                                <input name="modelo" value="${param.modelo}" style="display: none;"> 
                                <input name="km" value="${param.km}" style="display: none;">
                                <input name="tipoDeCarro" value="${param.tipoDeCarro}" style="display: none;">
                                <input name="cambio" value="${param.cambio}" style="display: none;">
                                <input name="valorDiaria" value="${param.valorDiaria}" style="display: none;">
                                <input name="situacao" value="${param.situacao}" style="display: none;">
                                <input name="imagem" value="${param.imagem}" style="display: none;">
                                <input name="vinda" value="${param.vinda}" style="display: none;">
                                <input type="submit" value="Entrar" class="btn btn-primary btn-lg btn-block">
                            </div>
                            <div class="forgot-password">
                                <p id="senhaIncorreta">
                                    <%
                                        if(erro != null){ 
                                            out.print(erro);
                                        }
                                    %>
                                </p>
                                <p class="txt-center ls-login-signup">Não possui um usuário na Locacar? <a class="ls-login-signup"href="cadastro.jsp">Cadastre-se agora</a></p>
                            </div>
                        </fieldset>
                    </form>
                </div>
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
            </div>

            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>
    </body>
</html>