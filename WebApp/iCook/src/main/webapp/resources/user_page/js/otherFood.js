var item = Math.floor($(document).height()/350)-1;
var isLoad = true;
var searchStr = "";
//---------Ajax load result when load---------
$(window).load(function(){
//	item = 0;
//	$('#otherFood').html("");
//	$.ajax({
//		type : "POST",
//		url : "search",
//		async : false,
//		data : {
//			"materials" : searchStr,
//			"start" : 0,
//			"limit" : item
//		},
//		// contentType: "application/json; charset=utf-8",
//		dataType : "json",
//		success : function(result) {
//			if (result.length < 12) {
//				isLoad = false;
//			}
//			// alert("Success!");
//			// alert(result);
//			var resultObj = result;
//			// alert(result.length);
//			$('#loading').fadeOut('fast');
//			var html = "";
//			$.each(resultObj, function(key, item) {
//					html += '<div class="food-item">';
//						html += '<figure>';
//							html += '<img src="' + item.avatarLink + '">';
//							html += '<a href="/iCook/food/'+ item.foodId + '">';
//								html += '<figcaption>';
//									html += '<h4 class="food-name">'+ item.foodName + '</h4>';
//								html += '</figcaption>';
//							html += '</a>';
//						html += '</figure>';
//						html += '<div class="search-detail-container">';
//							html += '<div class="search-detail-btn">';
//								html += '<span class="search-detail-box description-container">';
//									html += '<a href="/iCook/food/'+ item.foodId + '" class="">';
//										html += '<h3>' + item.foodName + '</h3>';
//										html += '<p><span>' + item.description + '</span></p>';
//									html += '</a>';
//								html += '</span><!-- /.search-detail-box -->';
//							html += '</div><!-- /.search-detail-btn -->';
//						html += '</div><!-- /.search-detail-container -->';
//					html += '</div><!-- /.food-item -->';
//			});
//			$('#otherFood').append(html);
//		},
//		error : function(jqXHR, textStatus, ex) {
//			alert("Mất kết nối tới server!");
//			console.log(textStatus + "," + ex + "," + jqXHR.responseText);
//		}
//	});
});
//-----------End Ajax load result--------------
