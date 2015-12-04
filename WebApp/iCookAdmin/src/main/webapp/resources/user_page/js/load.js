// ------------load page--------------
$(window).load(function(){
    $("#check-search").val("on");
    $('.preloader').remove();
});
var slideHeight = $(window).height();
$('#home-slider .item').css('height',slideHeight);

$(window).resize(function(){'use strict',
    slideHeight = $(window).height();
	$('#home-slider .item').css('height',slideHeight);
});
//----------End Load Page-------------

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
