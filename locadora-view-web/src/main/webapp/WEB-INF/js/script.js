    let calendarioRetirada = document.getElementById("dataRetirada");
    calendarioRetirada.max = new Date().toISOString().split("T")[0];
    
function defineMinimoData (){
    let calendarioEntrega = document.getElementById("dataEntrega");
    calendarioEntrega.min = calendarioRetirada.value;
}
    
function buscarReservasHome() {
    let selectLocalColeta = document.getElementById('unidadeRetirada');
    let localColeta = selectLocalColeta.options[selectLocalColeta.selectedIndex].text;

    let selectLocalEntrega = document.getElementById('unidadeEntrega');
    let localEntrega = selectLocalEntrega.options[selectLocalEntrega.selectedIndex].text;

    let dataRetirada = document.getElementById('dataRetirada').value;
    let dataEntrega = document.getElementById('dataEntrega').value;

    let selectTipoVeiculo = document.getElementById('tipoVeiculo');
    let tipoVeiculo = selectTipoVeiculo.options[selectTipoVeiculo.selectedIndex].text;

    if (localColeta == null || localEntrega == null || dataRetirada == null || dataEntrega == null || tipoVeiculo == null) {

    }
}