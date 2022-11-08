<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ page language="java" import="java.util.*" %>
        <%@ page language="java" import="locadora.locadora.negocio*" %>
        <title>Login</title>
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

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
        <style>
            .parent-login{
                border: 1px solid #fff;
                max-width: 900px;
                margin: auto;
                display: grid;
                grid-template-areas: "box-login submit-button forgot-password";
                grid-gap: 20px;

            }
            .box-login{
                grid-area: "box-login";
                grid-row: box-login;
                width: 100%;
                height: 100%;
                margin-top: 15%;
                margin-left: 30%;
                margin-right: 70%;
                text-align: justify;
            }
            .submit-button{
                grid-area: "submit-button";
                width: 100%;
            }
            .btn-block{
                margin-top: 15px;
                margin-bottom: 15px;
                border-radius: 4px;
            }
            .forgot-password{
                grid-area: "forgot-password";
                width: 100%;
            }
            .form-control::placeholder{
                color: #F77D0A;
            }
            .ls-login-logo{
                font-size: 30px;
            }
            .userPassword{
                margin-top: 5%;
            }
            .ls-login-signup{
                margin-top: 3%;
            }
            .senhaIncorreta{
                display:none;
                color: red;
            }
        </style>
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
                            <a href="index.html" class="nav-item nav-link">Home</a>
                            <a href="about.html" class="nav-item nav-link">Sobre</a>
                            <a href="service.html" class="nav-item nav-link">Servi�os</a>
                            <a href="service.html" class="nav-item nav-link">Ve�culos</a>
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
                    <h1 class="ls-login-logo">Faça seu login!</h1>
                    <form role="form" action="http://opensource.locaweb.com.br/locawebstyle-v2/manual/exemplos/login/">
                        <fieldset>
                            <div class="form-group-ls-login-user">
                                <label for="userLogin">Usuário</label>
                                <input class="form-control ls-login-bg-user input-lg" name="usuario "id="userLogin" type="text" aria-label="Usu�rio" placeholder="Usu�rio">
                            </div>

                            <div class="form-group ls-login-password">
                                <label class="userPassword" for="userPassword">Senha</label>
                                <input class="form-control ls-login-bg-password input-lg" name="senha" id="userPassword" type="password" aria-label="Senha" placeholder="Senha">
                            </div>
                            <div class="submit-button">
                                <input type="submit" value="Entrar" class="btn btn-primary btn-lg btn-block">
                            </div>
                            <div class="forgot-password">
                                <p class="senhaIncorreta">Senha ou usuário incorretos!</p>
                                <a href="http://opensource.locaweb.com.br/locawebstyle-v2/manual/exemplos/login/#" class="ls-login-forgot">Esqueci minha senha</a>
                                <p class="txt-center ls-login-signup">Não possui um usuário na Locacar? <a class="ls-login-signup"href="http://opensource.locaweb.com.br/locawebstyle-v2/manual/exemplos/login/#">Cadastre-se agora</a></p>
                            </div>
                        </fieldset>
                    </form>
                    <%
                        String user = request.getParameter("usuario");
                        String senha = request.getParameter("senha");
                    
                        if(user.isEmpty() && senha.isEmpty()){
                            response.sendRedirect("Login.jsp");
                        }
                            session.setAttribute("usuario", user);
                            session.setAttribute("senha", senha);
                        if(ServicosUsuarios.logarUsuario(user, senha) == null){
                            if(ServicosClientes.logarCliente(user, senha) == null)
                                response.sendRedirect("Login.jsp");
                            else
                                Cliente cliente = ServicosClientes.logarCliente(user, senha);
                        }
                        else{
                            Usuario user = ServicoUsuarios.logarUsuario(user, senha);
                            ServicoLog.registrarLogUsuario(user);
                        
                            cargo = user.getCargo()
                        

                            switch (cargo) {
                                    case "Vendedor" -> {
                                        response.sendRedirect("index.html");
                                    }
                                    case "Gerente" -> {
                                        response.sendRedirect("index.html");
                                    }
                                    case "Diretor" -> {
                                        response.sendRedirect("index.html");
                                    }
                                    default -> {
                                    }
                                }
                        }
                    %>
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
                <p class="m-0 text-center text-body">Idealizado por <a href="https://htmlcodex.com">HTML Codex</a></p>
            </div>
    </body>
</html>