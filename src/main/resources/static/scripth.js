function registroh(){
    var elemento={
        name:$("#name").val(),
        description:$("#description").val(),
        price:$("#price").val()
    }


    var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
    $.ajax({

        dataType: 'json',
        data:dataToSend,
        url:"http://localhost:8080/api/Room/save",
        type:'POST',
        contentType:'application/json',
        success:function(response) {
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });

}
function obtenerItemsh(){

    $.ajax({
        dataType: 'json',
        url:"http://localhost:8080/api/Room/all",
        crossOrigin:true,
        type:'GET',
        success:function(response) {
            console.log(response);
            var misItems=response;

            for(i=0;i<misItems.length;i++){

                $("#miResultado").append("<tr>");
                $("#miResultado").append("<td>"+misItems[i].name+"</td>");
                $("#miResultado").append("<td>"+misItems[i].hotel+"</td>");
                $("#miResultado").append("<td>"+misItems[i].description+"</td>");
                $("#miResultado").append("<td>"+misItems[i].stars+"</td>");
                $("#miResultado").append('<td><button onclick="borrar('+misItems[i].id+')">Borrar</button></td>');
                $("#miResultado").append('<td><button onclick="obtenerItemEspecifico('+misItems[i].id+')">Cargar</button></td>');
                $("#miResultado").append("</tr>");

            }

        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });

}


function borrarh(idElemento){
var elemento={
  id:idElemento
};


var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
$.ajax({
      dataType:'json',
      data:dataToSend,
      url:"http://localhost:8080///api/Room/all",
      type:'DELETE',
      contentType:'application/json',
      success:function(response) {
        console.log(response);
      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });
}


function obtenerItemEspecificoh(idItem){
  $.ajax({
      dataType: 'json',
      url:"http://localhost:8080///api/Room/"+idItem,
      type:'GET',
      success:function(response) {
        console.log(response);
        var habitacion=response.items[0];

        $("#miId").val(habitacion.id);
        $("#room").val(habitacion.room);
        $("#stars").val(habitacion.stars);
        $("#category_id").val(habitacion.category_id);
        $("#description").val(habitacion.description);



      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });

}

function actualizarh(){
var elemento={
  id:$("#miId").val(),
  room:$("#room").val(),
  stars:$("#stars").val(),
  category_id:$("#category_id").val(),
  description:$("#description").val()
  }


var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
$.ajax({
      dataType: 'json',
      data:dataToSend,
      contentType:'application/json',
      url:"http://localhost:8080///api/Room/all",
      type:'PUT',
      
      success:function(response) {
        console.log(response);
      },
      
      error: function(jqXHR, textStatus, errorThrown) {
            
      }
  });

}