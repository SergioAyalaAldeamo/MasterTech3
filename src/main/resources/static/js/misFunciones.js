function traerInformacion(){
    console.log("si llegue prro");
    $("#resultado").empty();
    $.ajax({
        url:'http://144.22.175.119/api/Doctor/all',
        type:'GET',
        dataType:'JSON',
        success: function(doctor){
            console.log(doctor);
            crearTabla(doctor);

        },
        error: function(xhr,status){
            alert("murio prroa");
        }
    });
    document.getElementById('resultado1').style.display='';
    document.getElementById('botonOcultar').style.display='';
    document.getElementById('display1').style.display='none';
}

function ocultarTabla(){
    document.getElementById('resultado1').style.display='none';
    document.getElementById('botonOcultar').style.display='none';
    document.getElementById('display1').style.display='';
}

function crearTabla(items){
    let myTable="<table class='table table-hover'>";
    myTable+="<thead class='table-dark'>";
    myTable+="<tr>";
    myTable+="<th scope='col'>Id</th>";
    myTable+="<th scope='col'>Año</th>";
    myTable+="<th scope='col'>Descripción</th>";
    myTable+="<th scope='col'>Departamento</th>";
    myTable+="<th scope='col'>Nombre</th>";
    myTable+="<th scope='col'>botón</th>";
    myTable+="</tr>";
    myTable+="</thead>";
    for(i=0;i<items.length;i++){
    myTable+="<tr>";
    myTable+='<th scope="row">'+items[i].id+"</th>";
    myTable+="<td>"+items[i].year+"</td>";
    myTable+="<td>"+items[i].description+"</td>";
    myTable+="<td>"+items[i].department+"</td>";
    myTable+="<td>"+items[i].name+"</td>";
    myTable+="<td><button class='btn btn-secondary' onclick='borrarElemento("+items[i].id+")'>Borrar</burron>";
    myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarDatos(){
    let myData={
        year: parseInt($("#year").val()),
        description:$("#description").val(),
        department:$("#department").val(),
        name:$("#name").val(),
    };
    let dataToSend=JSON.stringify(myData);
    console.log(myData);
    $.ajax({
        url:"http://144.22.175.119/api/Doctor/save",
        type:"POST",
        datatype: "JSON",
        data: myData,
        success: function(respuesta){
            alert("Datos guardados con exito");
            $("#resultado").empty();
            $("#year").val(""),
            $("#description").val(""),
            $("#department").val(""),
            $("#name").val(""),
            traerInformacion();
            console.log(myData);
        },
        error: function(xhr,status){
            alert("murio prro");
            console.log(myData);
        },


    });
}

function actualizar(){
        let myData2={
            id:$("#id").val(),
            specialty:$("#specialty").val(),
            graduate_year:$("#graduate_year").val(),
            department_id:$("#department_id").val(),
            name:$("#name").val(),
        };
        console.log(myData2);
        let dataToSend=JSON.stringify(myData2);
        $.ajax({
            url:'http://144.22.175.119/api/Doctor/update',
            type:'PUT',
            data:dataToSend,
            contentType:'application/JSON',
            datatype: 'JSON',
            success: function(respuesta){
                alert("me vale prro");
                $("#resultado").empty();
                $("#id").val(""),
                $("#specialty").val(""),
                $("#graduate_year").val(""),
                $("#department_id").val(""),
                $("#name").val(""),
                traerInformacion();
                console.log(myData2);
            },
            error: function(xhr,status){
                alert("murio prro");
                console.log(myData2);
            },
    
    
        });
    
}

function borrarElemento(idElemento){
    let mydata={
        id:idElemento
    };
    $.ajax({
        url:'http://144.22.175.119/api/Doctor/'+idElemento,
        type:'DELETE',
        success:function(respuesta){
            $("#resultado").empty();
            traerInformacion();
            alert("Se elimino con exito");
        }
    });
}
