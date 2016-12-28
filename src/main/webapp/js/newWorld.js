document.getElementById('save').onclick = function () {


    if(document.getElementById('nameWorld').value == ''){

        document.getElementById('error').innerHTML = 'error';
        document.getElementById('error').style.backgroundColor= 'red';

    }else{

        document.getElementById('error').innerHTML = '';

        var world = {

            name : document.getElementById('nameWorld').value

        }

        document.getElementById('nameWorld').value = '';

        $.ajax({


            url : 'saveWorld?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method : 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType : 'json',
            data : JSON.stringify(world),
            success : function (res) {


                var all = '';

                for(var i = 0; i < res.length; i++){

                    all +='<div style="background-color: #30aed6; text-align: center;"> ' +
                        ' '+res[i].name+' <a href="deleteWorld/"+res[i].id>delete</a></div><br>';

                }

                document.getElementById('allWorlds').innerHTML = all;

            }


        })
    }





}

window.onload = function () {

    $.ajax({

        url : 'loadWorlds?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method : 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType : 'json',
        success : function (res) {

            var all = '';

            for(var i = 0; i < res.length; i++){
                var index = res[i].id;
                all +="<div>"+res[i].name+"<a href='deleteWorld/"+index+"'>delete</a></div><br>";
            }
            document.getElementById('allWorlds').innerHTML = all;
        }
    })





}
