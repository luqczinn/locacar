function getXMLHttpRequest() {
    if (window.XMLHttpRequest) {//Se Chrome, Opera, FireFox...
        return new XMLHttpRequest();  
    }else if (window.ActiveXObject) {//Se Microsoft Explorer
        return new ActiveXObject("Microsoft.XMLHTTP"); 
    }
}
var xmlhttp;
xmlhttp = new XH();
xmlhttp.open("GET","nome_script_servidor",true);
xmlhttp.send();

function XH(){
var xh;
if (window.XMLHttpRequest) // código dos browsers modernos
xh = new XMLHttpRequest();
else // código para o IE5, ou >
xh = new ActiveXObject("Microsoft.XMLHTTP");
return xh;
}