$(function(){
    $('#products').html='<tr><td>OK</td></tr>';

    $.getJSON("api/product/list", function (data) {
        var html = '';
        for (i = 0; i <data.length ; i++) {
            // html += '<tr><td>'+data[i].image+'</td></tr>'
            // html += '<tr><td>'+data[i].image+'</td></tr>'
           html+='<img src="'+data[i].image+'", alt="Smiley face" height="42" width="42">'
        }
        $('#products').html(html);
    });
});
