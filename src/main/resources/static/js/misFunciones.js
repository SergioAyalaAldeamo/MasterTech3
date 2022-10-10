function traerInformacion(){
    console.log("si llegue prro");
    $("#resultado").empty();
    $.ajax({
        url:'http://144.22.175.119/api/Doctor/all',
        type:'GET',
        dataType:'JSON',
        success: function(doctor){
            console.log(doctor[0]);
            crearTabla(doctor[0]);

        },
        error: function(xhr,status){
            alert("murio prroa");
        }
    });
}
function crearTabla(items){
    let myTable="<table>";
    //for(i=0;i<items.length;i++){
    myTable+="<tr>";
    myTable+="<td>"+items.id+"</td>";
    myTable+="<td>"+items.specialty.description+"</td>";
    myTable+="<td>"+items.year+"</td>";
    myTable+="<td>"+items.description+"</td>";
    myTable+="<td>"+items.name+"</td>";
    //myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</burron>";
    myTable+="</tr>";
    //}
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarDatos(){
    let myData={
        id:$("#id").val(),
        specialty:$("#specialty").val(),
        graduate_year:$("#graduate_year").val(),
        department_id:$("#department_id").val(),
        name:$("#name").val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:'https://gee994b5a990a9c-hmf9whhymulmhop7.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/doctor/doctor',
        type:'POST',
        data: myData,
        datatype: 'JSON',
        success: function(respuesta){
            alert("Datos guardados con exito");
            $("#resultado").empty();
            $("#id").val(""),
            $("#specialty").val(""),
            $("#graduate_year").val(""),
            $("#department_id").val(""),
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
            url:'https://gee994b5a990a9c-hmf9whhymulmhop7.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/doctor/doctor',
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
    let dataToSend=JSON.stringify(mydata);
    $.ajax({
        url:'https://gee994b5a990a9c-hmf9whhymulmhop7.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/doctor/doctor',
        type:'DELETE',
        data:dataToSend,
        contentType:'application/JSON',
        datatype: 'JSON',
        success:function(respuesta){
            $("#resultado").empty();
            traerInformacion();
            alert("Se elimino con exito");
        }
    });
}
