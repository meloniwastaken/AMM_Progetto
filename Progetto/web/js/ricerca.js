function createElement(user){
    var nome = $("<li>").html(user.nome+" "+user.cognome);
    var link = $("<a>")
            .attr("href", "Bacheca?bachecaid="+user.id)
            .html(nome);
    return link;
}

function stateSuccess(data){
    var userListPage = $("#research > ul");
    var UserNotFound = "";
    
    $(userListPage).empty();
    if(!data[0].nome) {
        $(userListPage).html(UserNotFound);
    }
    else {
        for(var instance in data){
            $(userListPage).append(createElement(data[instance]));
        }
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#ricerca").on("input", function() {
        
        var wantedUser = $("#ricerca")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                q:"search",
                cerca: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});

$(document).ready(function(){
    $("#ricercaConferma").click(function() {
        
        var wantedUser = $("#ricerca")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                cmd:"search",
                cerca: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});