$(window).load(function(){
    $("#check-search").val("on");
    $('.preloader').remove();
});
var slideHeight = $(window).height();
//Page home
$('#home-slider .item').css('height',slideHeight);

$(window).resize(function(){'use strict',
    slideHeight = $(window).height();
	$('#home-slider .item').css('height',slideHeight);
});
//Page Detail
$('#backgroud').css('height',slideHeight);

$(window).resize(function(){'use strict',
    slideHeight = $(window).height();
	$('#backgroud').css('height',slideHeight);
});
