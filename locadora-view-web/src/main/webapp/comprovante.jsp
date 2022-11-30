<%-- 
    Document   : comprovante
    Created on : 28 de nov. de 2022, 07:39:24
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.min.js"></script> 
        <script src="https://cdn.jsdelivr.net/npm/canvas2image@1.0.5/canvas2image.min.js"></script>
    </head>
    <body>
        <button id="btGerarPDF" style="padding: 5px; align-items: center;">Imprimir</button>
        <button id="sair" style="padding: 5px; align-items: center;">Sair</button>
        <div id="containerComprovante" style="border: solid 1px black;color: #605B5B;
             background-color: white;
             padding: 50px;
             margin: 10px;">
            <img src="img/LOCACAR__1_-removebg-preview.png" style="width:200px; height:100px; align-items: center;">
            <h1 style="color: #1d7c42;" class="info">COMPROVANTE DE RESERVA</h1>
            <div class="resultados">
                <h2 class="info">INFORMAÇÕES CLIENTES</h2>
                <ul class="elementos">
                    <li>Nome: ${requestScope.nome}</li>
                    <li>Nascimento: ${requestScope.dataNascimento}</li>
                    <li>CPF: ${requestScope.cpf}</li>
                    <li>RG: ${requestScope.rg}</li>
                    <li>Endereço: ${requestScope.endereco}</li>
                    <li>Telefone: ${requestScope.telefone}</li>
                    <li>Email: ${requestScope.email}</li>
                    <li>Username: ${requestScope.apelido}</li>
                </ul>
            </div>
            <div class="resultados">
                <h2 class="info">INFORMAÇÕES RESERVA</h2>
                <ul class="elementos">
                    <li>Veiculo: ${requestScope.veiculo}</li>
                    <li>Unidade: ${requestScope.localColeta}</li>
                    <li>Unidade Entrega: ${requestScope.localEntrega}</li>
                    <li>Data Início: ${requestScope.dataRetirada}</li>
                    <li>Data Entrega: ${requestScope.dataEntrega}</li>
                    <li>Valor Diária: ${requestScope.valorAluguel}</li>
                    <li>Valor Total: ${requestScope.valorTotal}</li>
                </ul>
            </div>
            <div class="resultados">
                <h2 class="info">ENTRE EM CONTATO </h2>
                <ul class="elementos">
                    <li>Endereço: Av. Amazonas, 7675 - Nova Gameleira, Belo Horizonte</li>
                    <li>Telefone: +55 31 99510-6573</li>
                    <li>Unidade: ${requestScope.localColeta}</li>
                    <li>Email: contato@locacar.com.br</li>
                </ul>
            </div>
        </div>
        <div id="editor"></div>
        <script>
            $('#btGerarPDF').click(function () {
                var doc = new jsPDF('landscape', 'pt', 'a4');
                doc.addHTML($('#containerComprovante'), function () {
                    doc.save("ComrprovanteLocacar.pdf");
                });
            });
            $('#sair').click(function(){
                $(location).prop('href', 'index.jsp');
            });
        </script>
    </body>
</html>

