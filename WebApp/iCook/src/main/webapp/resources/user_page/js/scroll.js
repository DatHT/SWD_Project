//---------Animation Scroll-----------

$("#btn-plus-search").click(function(){
    $('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 700);
    return false;
});

$('.navbar-collapse ul li a').on('click', function() {  
    $('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 500);
    return false;
});
//-------End Animation Scroll---------
