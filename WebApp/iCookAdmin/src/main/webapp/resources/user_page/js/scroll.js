//---------Animation Scroll-----------
$(document).ready(function(){
    $("#search-button").click(function(){
        if ($("#check-search").val() == "on"){
            $("#search-result-container").slideToggle();
            $("#check-search").val("off");
        }
        $('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 1000);
        return false;
    });
});
$("#btn-plus-search").click(function(){
    $('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 700);
    return false;
});

$('.navbar-collapse ul li a').on('click', function() {  
    $('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 500);
    return false;
});
//-------End Animation Scroll---------
