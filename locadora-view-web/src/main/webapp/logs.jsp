<%-- 
    Document   : logs.jsp
    Created on : 26 de nov. de 2022, 16:36:45
    Author     : stell
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
        <link href="img/favicon.png" rel="icon">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Rubik&display=swap"
              rel="stylesheet">
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
                    <a href="" class="navbar-brand">
                        <h1 class="text-uppercase text-primary mb-1">Locacar</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                        <div class="navbar-nav ml-auto py-0">
                            <a href="index.jsp" class="nav-item nav-link">Home</a>
                            <a href="logsLogin.jsp" class="nav-item nav-link">Logs Login</a>
                            <a href="logs.jsp" class="nav-item nav-link">Logs gerais</a>
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

        <div class="container-fluid page-header">
            <h1 class="display-3 text-uppercase text-white mb-3">Geração de Logs</h1>
            <div class="d-inline-flex text-white">
                <h6 class="text-uppercase m-0"><a class="text-white" href="">Home</a></h6>
                <h6 class="text-body m-0 px-3">/</h6>
                <h6 class="text-uppercase text-body m-0">Logs</h6>
            </div>
        </div>
        <!-- Page Header Start -->
        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com/bdlocacar" user= "admin"  password= "NFe8Y6Nh7OPZEfh^sW3hv" />
        <sql:query dataSource="${conexao}" var="result">
            SELECT * FROM logs ORDER BY dataHora desc
        </sql:query>
        <!-- Tabela de Logs -->
        <table id="tabelLogs">
            <!--Linha de titulos -->
            <tr id="titulo">
                <td>ID</td>
                <td>Ação</td>
                <td>Descrição</td>
                <td>Usuário</td>
                <td>Hora</td>
            </tr>      
            <c:forEach var="row" items="${result.rows}">                        
                <tr> 
                    <td>
                        <c:out value = "${row.id}"/>
                    </td>
                    <td>
                        <c:out value = "${row.acao}"/> 
                    </td>
                    <td>
                        <c:out value = "${row.descricao}"/> 
                    </td>
                    <td>
                        <c:out value = "${row.usuario}"/> 
                    </td>
                    <td>
                        <c:out value = "${row.dataHora}"/> 
                    </td>
                </tr>
            </c:forEach>
        </table>


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
            </div>
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <script src="js/main.js"></script>
    </body>

</html>
