$(document).scroll(function() {
        	var scrollPos = $(window).scrollTop(),
            speed = 0.03;
        	$(".scroll").css("top", (0 + (scrollPos)-(scrollPos*speed)) + 'px');
        	$(".tutorial").css("top", (0 -(scrollPos*0.07)) + 'px');
});