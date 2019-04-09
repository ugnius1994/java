$(function() {

    var skip = 0;
    var rowsPerPage = 5;


    $('#prev').click(function () {
        skip -= rowsPerPage;
        if (skip < 0) skip = 0;
        printRows(skip, rowsPerPage);
    });

    $('#next').click(function () {
        skip += rowsPerPage;
        printRows(skip, rowsPerPage);
    });

    printRows(skip, rowsPerPage);

});




function printRows(skip, rowsPerPage) {

    var token = window.localStorage.token;

    $.ajax('api/product/list', {
        method: 'GET',
        headers: {
            Authorization: "Bearer " + token
        },
        dataType: 'json',
        data: {
            size: rowsPerPage + 1,
            skip: skip
        }

    }).done(function (data) {

        // if (skip === 0) $('#prev').hide();
        // else $('#prev').show();
        //
        // if (data.length <= rowsPerPage) $('#next').hide();
        // else $('#next').show();

        if (skip === 0) $('#prev').addClass('disabled');
        else $('#prev').removeClass('disabled');

        if (data.length <= rowsPerPage) $('#next').addClass('disabled');
        else $('#next').removeClass('disabled');

        var html = '';
        for (i = 0; i < Math.min(data.length, rowsPerPage); i++) {
            html +=
                '<tr>' +
                '<td><img src="' + data[i].image + '" width="100"></td>' +
                '<td>' + data[i].name + '</td>' +
                '<td>' + data[i].description + '</td>' +
                '<td class="text-right">' + data[i].price + '</td>' +
                '</tr>';
        }
        $('#products').html(html);

    }).fail(function(jqXHR) {
        if (jqXHR.status === 401) {
            $('#login').click(function() {
                login($('#username').val(), $('#password').val(), skip, rowsPerPage);
            });
            $('#loginModal').modal('show')
        } else {
            alert("Other error");
        }

    });
}

function login(username, password, skip, rowsPerPage) {
    //$('#login').off();
    $.ajax('api/auth/login', {
        method: 'POST',
        dataType: 'json',
        contentType : 'application/json',
        data: JSON.stringify({
            username: username,
            password: password
        })
    }).done(function(data) {
        $('#loginModal').modal('hide');
        window.localStorage.token = data.token;
        printRows(skip, rowsPerPage);

    }).fail(function() {
        alert('Login fail')
    });




    $('#SmartCart').smartCart({
        onAdded: function(pObj,quantity){ cartAdded(pObj,quantity);},
        onRemoved: function(pObj){ cartRemoved(pObj);},
        onUpdated: function(pObj,quantity){ cartUpdated(pObj,quantity); },
    });

    function cartAdded(obj,qty){
        var product_id = obj.attr("pid");
        var quantity = qty;
// Ajax calls for adding product to cart
        function (pObj,quantity){
            cartAdded(pObj,quantity);}
    }

    function cartRemoved(obj){
        var product_id = obj.attr("pid");
// Ajax call for removing product from cart
    }

    function cartUpdated(obj,qty){
        var product_id = obj.attr("pid");
        var quantity = qty;
// Ajax call for updating product on cart
    }

    function cartAdded(obj,qty){
        var partNum = obj.attr("partNumber");
        var quantity = qty;
        $.ajax({
            type: 'POST',
            url: "json/sessionManager",
            data : "partNum=" + partNum + "&qty=" + quantity,
            dataType: "text/json",
            success: function(msg){
                obj.attr("qty", msg[1]);
            },
            error: function(httpRequest, textStatus, errorThrown) {
                alert("status=" + textStatus + ",error=" + errorThrown);
            }
        });
    }
}