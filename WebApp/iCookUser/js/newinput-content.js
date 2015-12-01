var count = 1;
var item = 0;
//-----------Add new input search-------------
$(document).ready(function(){
	$('#btn-plus-search').click(function() {
		var input = '<input type="search" name="" id="input-search'+count+'"class="form-control input-lg" value="" title="" placeholder="Nguyên liệu">';
		$('#btn-plus-search').before(input);
		count++;
		if (count >= 5) {
			$('#btn-plus-search').hide();
		}
	});
});
//---------End Add new input search------------

//--------------Ajax load result---------------
function ajax_loading(item){
	var searchStr="";
        for(var i=0;i<count;i++){
        	searchStr+=$("#input-search"+i).val();
        	if (i!=count-1) {
        		searchStr+="+";
        	};
        }

        
    $.ajax({
        //type: "GET",
        url: "http://54.169.133.254:8080/iCookAPI/search/"+searchStr+"/"+item+"/12",
        //dataType:"jsonp",
        success: function(result) {
        	alert("Success!");
        	/*alert(result);
        	var resultObj = JSON.parse(result);
        	alert(resultObj.length);
            $('#loading').fadeOut('fast');
            var html="";
            $.each (resultObj, function (key, item){
                html +=  '<div class="col-sm-4 col-md-3">';
              		html +=  '<div class="food-item">';
                    	html +=  '<figure>';
                      		html +=  '<img src="images/23.jpg">';
                      		html +=  '<figcaption>';
                        		html +=  '<h4 class="food-name">Cách làm sữa lắc với máy xay sinh tố thơm ngon bổ dưỡng</h4>';
                        		html +=  '<p class="material">';
                          			html +=  'Giò heo, cà chua';
                        		html +=  '</p><!-- /.material -->';
                      		html +=  '</figcaption>';
                    	html +=  '</figure>';
                    	html +=  '<div class="search-detail-container">';
                      		html +=  '<div class="search-detail-btn">';
                        		html +=  '<span class="search-detail-box description-container">';
                          			html +=  '<a href="#" class="">';
                            			html +=  '<h3>Cách làm sữa lắc với máy xay sinh tố thơm ngon bổ dưỡng</h3>';
                            			html +=  '<p><span>12312412412312 31241241231231 241241231212 3213123 123123123</span></p>';
                          			html +=  '</a><!-- /.facebook-btn -->';
                        		html +=  '</span><!-- /.search-detail-box -->';
                      		html +=  '</div><!-- /.search-detail-btn -->';
                    	html +=  '</div><!-- /.search-detail-container -->';
                  	html +=  '</div><!-- /.food-item -->';
                html +=  '</div><!-- /.col-md-3 -->';
            });
            $('#search-result').html(html);*/
        }
    });
}
//-----------End Ajax load result--------------

//---------Ajax load result when click---------
$("#search-button").click(function(){
        item=0;
        ajax_loading(item);
});
//-----------End Ajax load result--------------

//---------Ajax load result when scroll--------
$(document).scroll(function()
{
    if(($(window).scrollTop() == $(document).height() - $(window).height())&& $("#check-search").val() == "off")
    {
        $('#loading').html("<img src='images/loading.gif'/>").fadeIn('fast');
        item=item+13;
        ajax_loading(item);
    }
});
//-----------End Ajax load result--------------
