<%-- 
    Document   : contato
    Created on : 8 de nov de 2022, 12:33:44
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="locadora.locadora.negocio.servico.ServicoUnidades" %>
<%@ page import="locadora.locadora.negocio.dto.Unidades" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <title>Locacar - Contato</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <link href="img/favicon.png" rel="icon">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Rubik&display=swap" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-fluid bg-dark py-3 px-lg-5 d-none d-lg-block">

        </div>
        <div class="container-fluid position-relative nav-bar p-0">
            <div class="position-relative px-lg-5" style="z-index: 9;">
                <nav class="navbar navbar-expand-lg bg-secondary navbar-dark py-3 py-lg-0 pl-3 pl-lg-5">
                    <a href="index.jsp" class="navbar-brand">
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
        <div class="container-fluid page-header">
            <h1 class="display-3 text-uppercase text-white mb-3">Contato</h1>
            <div class="d-inline-flex text-white">
                <h6 class="text-uppercase m-0"><a class="text-white" href="">Home</a></h6>
                <h6 class="text-body m-0 px-3">/</h6>
                <h6 class="text-uppercase text-body m-0">Contato</h6>
            </div>
        </div>  

        <h1 class="titleTicket">NOS CONHEÇA</h1>
        <div class="margindiv">
            <label>Seleciona a unidade:</label>
            <select onchange="myFunction()" id="selectUnidade" class="custom-select px-4 mb-3 margindiv" style="height: 50px;">
                <option value="0">Selecione</option>
                <%      
                      List<Unidades> listaUnidades = locadora.locadora.negocio.servico.ServicoUnidades.listarUnidades();
                      int contador = 1;
                      for(Unidades u : listaUnidades){
                %>
                <option value="<%=contador%>"><%=u.getCidade()%> - <%=u.getLogradouro()%></option>
                <% contador = contador + 1;
             }%>
            </select>
        </div>
        <h1 id="coco"></h1>
        <iframe id="map" frameborder="0" style="border:0"
                src="https://www.google.com/maps/embed/v1/place?q=<%=  listaUnidades.get(0).getEndereco() %>&key=AIzaSyAuq-yu9yXNLMuV88VUBDEnI8naScEfxm8">
        </iframe>

        <script>
            function myFunction() {
                var index = document.getElementById("selectUnidade").selectedIndex;
                var valor = document.getElementsByTagName("option")[index].value;
            <%
                    contador = 1;
                    for(Unidades u : listaUnidades){
            %>
                if (valor === "<%=contador%>") {

                    document.getElementById("map").src = "https://www.google.com/maps/embed/v1/place?q=Avenida <%= u.getEndereco() %> &key=AIzaSyAuq-yu9yXNLMuV88VUBDEnI8naScEfxm8";
                }
            <%contador = contador + 1;
               }%>
            }
        </script>

        <h1 class="titleTicket">CONTATE-NOS</h1>
        <h2 class="title2Ticket">Envie seu ticket contendo seu problema, ou algo que quer nos contar. Preencha os campos, nos envie e trabalharemos para lhe responder o mais rápido possivel!</h2>
        <div class="contact-form bg-light mb-4" style="padding: 30px; margin-right:15%; margin-left:15%; margin-top:4%;">
            <form action="TicketServlet" method="post">
                <label>1. Escolha um assunto</label>
                <select name="assuntoSelect" onchange="selectOuString()" id="selectTicket" class="custom-select px-4 mb-3" style="height: 50px;" required>
                    <option selected>-</option>
                    <option value="1">Tenho um poblema com os dados da minha conta</option>
                    <option value="2">Tenho um problema com as opções de pagamento</option>
                    <option value="3">Não consigo alugar um veículo</option>
                    <option value="4">Encontrei um problema no sistema da Locacar</option>
                    <option value="5">Outros</option>
                </select>
                <div id="selectOutro">
                    <label>Escreva o assunto</label>
                    <input id="inputOutro" name="assuntoOutro" type="text" class="form-control p-4" maxlength="90">
                </div>
                <div class="form-group">
                    <label>2. Descreva o assunto</label>
                    <textarea name="descricao" class="form-control py-3 px-4" rows="5"  required="required"></textarea>
                </div>
                <div>
                    <button class="btn btn-primary py-3 px-5" type="submit">Enviar</button>
                </div>
            </form>
        </div>
        <script>
            function selectOuString() {
                var valor = document.getElementById("selectTicket").value;
                if (valor == "5") {
                    document.getElementById('selectOutro').style.display = 'block';
                    document.getElementById('inputOutro').setAttribute("required", "required");
                } else {
                    document.getElementById('selectOutro').style.display = 'none';
                    document.getElementById('inputOutro').removeAttribute("required");
                }
            }
        </script>

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
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <script src="https://kit.fontawesome.com/60feab9afa.js" crossorigin="anonymous"></script>
            <script src="js/main.js"></script>
    </body>

</html>
