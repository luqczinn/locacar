<%-- 
    Document   : cadastro.
    Created on : 24 de nov. de 2022, 20:47:23
    Author     : sufra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object vinda = session.getAttribute("vinda");

%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Cadastro de clientes</title>
  
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
            <a href="about.html" class="nav-item nav-link">Sobre</a>
            <a href="service.html" class="nav-item nav-link">Serviços</a>
            <a href="veiculos.jsp" class="nav-item nav-link">Veículos</a>
            <a href="contact.html" class="nav-item nav-link">Contato</a>
            <a href="Login.jsp" class="nav-item nav-link">Entrar</a>
          </div>
        </div>
      </nav>
    </div>
  </div>


  <div class="formulario">
    <form method="POST" action="ServletCadastro" class="needs-validation" novalidate>
    <div class="titulo">
      <h2>Realize seu cadastro!</h2>
    </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputNome">Nome Completo</label>
        <input type="text" class="form-control" id="inputNome" name="name" placeholder="Nome" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          Preencha o campo corretamente.
        </div>
      </div>
      <div class="form-group col-md-6">
        <label for="inputCpf">CPF</label>
        <input type="text" class="form-control" name="cpf" id="inputCpf" placeholder="CPF" pattern="([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          Preencha o campo corretamente.
        </div>
      </div>
    </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputRg">RG</label>
      <input type="text" class="form-control" name="RG" id="inputRg" pattern="(\d{2}\.\d{3}\.\d{3}-[0-9X])" placeholder="RG" required>
      <div class="valid-feedback">
        Campo correto!
      </div>
      <div class="invalid-feedback">
        Preencha o campo corretamente.
      </div>
    </div>
    <div class="form-group col-md-6">
      <div class="date mb-3" id="date" data-target-input="nearest">
          <label for="dataNasc">Data de Nascimento</label>
          <input type="date" id="dataNasc" name="dataNasc" class="form-control datetimepicker-input" placeholder="Data de Nascimento" data-target="#date" data-toggle="datetimepicker" />
          <div class="valid-feedback">
            Campo correto!
          </div>
          <div class="invalid-feedback">
            Preencha o campo corretamente.
          </div>
        </div>
    </div>
  </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputEndereco">Endereço</label>
        <input type="text" class="form-control" name="endereco" id="inputEndereco" placeholder="Endereço" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          Preencha o campo corretamente.
        </div>
      </div>
      <div class="form-group col-md-6">
        <label for="inputTel">Telefone</label>
        <input type="tel" class="form-control" name="telefone" id="inputTel" placeholder="Telefone" pattern="(\([0-9]{2}\))\s([9]{1})?([0-9]{4})-([0-9]{4})" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          O formato do telefone tem que ser (99) 99999-9999!
        </div>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group col-md-12">
        <label for="inputEmail">E-mail</label>
        <input type="email" class="form-control" name="email" id="inputEmail" placeholder="E-mail" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          Preencha o campo corretamente.
        </div>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputUsuario">Usuário</label>
        <input type="text" class="form-control" name="user" id="inputUsuario" placeholder="Usuário" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          Preencha o campo corretamente.
        </div>
      </div>
      <div class="form-group col-md-6">
        <label for="inputSenha">Senha</label>
        <input type="password" class="form-control" name="senha" id="inputSenha" placeholder="Senha" required>
        <div class="valid-feedback">
          Campo correto!
        </div>
        <div class="invalid-feedback">
          Preencha o campo corretamente.
        </div>
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>

  <div class="container-fluid bg-secondary py-5 px-sm-3 px-md-5" style="margin-top: 90px;">
    <div class="row pt-5">
      <div class="col-lg-3 col-md-6 mb-5">
        <h4 class="text-uppercase text-light mb-4">Entre em contato</h4>
        <p class="mb-2"><i class="fa fa-map-marker-alt text-white mr-3"></i>Av. Amazonas, 7675 - Nova Gameleira, Belo
          Horizonte</p>
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

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js'></script>
    <script>
     $('.input-group.date').datepicker({format: "dd/mm/yyyy"});

    (function() {
      'use strict';
      window.addEventListener('load', function() {
        let forms = document.getElementsByClassName('needs-validation');
        let validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    })();

      function refresh(){
          let forms = document.getElementsByClassName('was-validated');
          let validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
            form.classList.remove('was-validated');
            },false)
          });
      }
      </script>
</body>

</html>