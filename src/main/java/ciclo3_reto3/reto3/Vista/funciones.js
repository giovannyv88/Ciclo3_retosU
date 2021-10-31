
function infoCategoria(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirCategoria(respuesta);
        }
    });

}

function imprimirCategoria(respuesta){

    let miTabla = "<table>";
    for(i=0;i<respuesta.length;i++){
            miTabla+="<tr>"
            miTabla+="<td>"+respuesta[i].name+"</td>";
            miTabla+="<td>"+respuesta[i].description+"</td>";
            miTabla+="</tr>";
        }
        miTabla+="</table>";
        $("#impresion").html(miTabla);

}


function infoMoto(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/Motorbike/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirMoto(respuesta);
        }
    });

}


function imprimirMoto(respuesta){

    let miTabla = "<table>";
    for(i=0;i<respuesta.length;i++){
            miTabla+="<tr>"
            miTabla+="<td>"+respuesta[i].name+"</td>";
            miTabla+="<td>"+respuesta[i].brand+"</td>";
            miTabla+="<td>"+respuesta[i].year+"</td>";
            miTabla+="<td>"+respuesta[i].description+"</td>";
            miTabla+="</tr>";
        }
        miTabla+="</table>";
        $("#impresionMoto").html(miTabla);

}

function infoCliente(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/Client/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirCliente(respuesta);
        }
    });

}

function imprimirCliente(respuesta){

    let miTabla = "<table>";
    for(i=0;i<respuesta.length;i++){
            miTabla+="<tr>"
            miTabla+="<td>"+respuesta[i].email+"</td>";
            miTabla+="<td>"+respuesta[i].password+"</td>";
            miTabla+="<td>"+respuesta[i].name+"</td>";
            miTabla+="<td>"+respuesta[i].age+"</td>";
            miTabla+="</tr>";
        }
        miTabla+="</table>";
        $("#impresion").html(miTabla);

}

function infoMensajes(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/Message/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirMensaje(respuesta);
        }
    });

}

function imprimirMensaje(respuesta){

    let miTabla = "<table>";
    for(i=0;i<respuesta.length;i++){
            miTabla+="<tr>"
            miTabla+="<td>"+respuesta[i].messageText+"</td>";
            miTabla+="</tr>";
        }
        miTabla+="</table>";
        $("#impresion").html(miTabla);

}

function infoReserva(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/Reservation/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirReserva(respuesta);
        }
    });

}

function imprimirReserva(respuesta){

    let miTabla = "<table>";
    for(i=0;i<respuesta.length;i++){
            miTabla+="<tr>"
            miTabla+="<td>"+respuesta[i].startDate+"</td>";
            miTabla+="<td>"+respuesta[i].devolutionDate+"</td>";
            miTabla+="</tr>";
        }
        miTabla+="</table>";
        $("#impresion").html(miTabla);

}


function infoEstados(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/Reservation/report-status",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirEstado(respuesta);
        }
    });

}

function imprimirEstado(respuesta){

    let miTabla = "<table>";
    for(i=0;i<respuesta.length;i++){
            miTabla+="<tr>"
            miTabla+="<td>"+respuesta[i]+complete+"</td>";
            miTabla+="<td>"+respuesta[i]+cancelled+"</td>";
            miTabla+="</tr>";
        }
        miTabla+="</table>";
        $("#impresionEstado").html(miTabla);

}






/////// Insertar datos////////////////////////////

function guardarCategoria(){
    let var2 = {
        name:$("#nombreCat").val(),
        description:$("#descripcionCat").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        
        url:"http://168.138.143.61:8080/api/Category/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}


function guardarMoto(){
    let var3 = {
        name:$("#nomMoto").val(),
        brand:$("#marca").val(),
        year:$("#año").val(),
        description:$("#motodescribe").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var3),
        
        url:"http://168.138.143.61:8080/api/Motorbike/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

function guardarCliente(){
    let var4 = {
        email:$("#correo").val(),
        password:$("#contraseña").val(),
        name:$("#nombreCliente").val(),
        age:$("#edad").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var4),
        
        url:"http://168.138.143.61:8080/api/Client/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

function guardarMensaje(){
    let var5 = {
        messageText:$("#texto").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var5),
        
        url:"http://168.138.143.61:8080/api/Message/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

function guardarReserva(){
    let var6 = {
        startDate:$("#fecha").val(),
        devolutionDate:$("#devolucion").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var6),
        
        url:"http://168.138.143.61:8080/api/Reservation/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}











































































