
$(document).ready( function () {
    $('#devices-table').DataTable();
} );

function toggleStatus(token) {
    $.ajax({
        url: '/api/v1/devices/'+token,
        type: 'PATCH',
        success: function(response) {
            if(response === "ATIVO"){
                $("#"+token).html('');
                $("#"+token).html("<button onclick=\"toggleStatus('" + token + "')\" style=\"width: 100%\" class=\"btn btn-success\">ativo</button>");
            }else{
                $("#"+token).html('');
                $("#"+token).html("<button onclick=\"toggleStatus('" + token + "')\" style=\"width: 100%\" class=\"btn btn-primary\">desativado</button>");
            }
        }
    });
}