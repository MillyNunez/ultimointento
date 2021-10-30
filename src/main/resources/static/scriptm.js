function registrom(){
var elemento={
  id:$("#miId").val(),
  messagetext:$("#messagetext").val(),
  }


var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
$.ajax({
      dataType: 'json',
      data:elemento,
      url:"https://g23d7f13080058c-dbreservas.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
      type:'POST',
      
      success:function(response) {
        console.log(response);
      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });

}

function obtenerItemsm(){

  $.ajax({
      dataType: 'json',
      url:"https://g23d7f13080058c-dbreservas.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
      type:'GET',
      
      success:function(response) {
       
        var misItems=response.items;

        for(i=0;i<misItems.length;i++){
         
          $("#miResultado").append("<tr>");
          $("#miResultado").append("<td>"+misItems[i].messagetext+"</td>");
          $("#miResultado").append('<td><button onclick="borrarm('+misItems[i].id+')">Borrar</button></td>');
          $("#miResultado").append('<td><button onclick="obtenerItemEspecificom('+misItems[i].id+')">Cargar</button></td>');
          $("#miResultado").append("</tr>");

        }

      },
      
      error: function(jqXHR, textStatus, errorThrown) {
      
		alert("Fallo la consulta")
      }
  });

}


function borrarm(idElemento){
var elemento={
  id:idElemento
};


var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
$.ajax({
      dataType:'json',
      data:dataToSend,
      url:"https://g23d7f13080058c-dbreservas.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
      type:'DELETE',
      contentType:'application/json',
      success:function(response) {
        console.log(response);
      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });
}


function obtenerItemEspecificom(idItem){
  $.ajax({
      dataType: 'json',
      url:"https://g23d7f13080058c-dbreservas.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message/"+idItem,
      type:'GET',
      success:function(response) {
        console.log(response);
        var mensaje=response.items[0];

        $("#miId").val(mensaje.id);
        $("#messagetext").val(mensaje.messagetext);

      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });

}

function actualizarm(){
var elemento={
  id:$("#miId").val(),
  messagetext:$("#messagetext").val(),
  }


var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
$.ajax({
      dataType: 'json',
      data:dataToSend,
      contentType:'application/json',
      url:"https://g23d7f13080058c-dbreservas.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
      type:'PUT',
      
      success:function(response) {
        console.log(response);
      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });

}