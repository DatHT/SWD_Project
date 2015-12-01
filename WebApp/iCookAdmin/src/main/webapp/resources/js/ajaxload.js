
$(document).ready(function() {
	$(window).load(function() {
		// Animate loader off screen
		$(".se-pre-con").fadeOut("slow");;
	});
	$('.imagelink').focusout(function(){
		$('#imageFood').attr("src",$('#txtImage').val());
	});
	$('.imagelink').keyup(function(e){
	    if(e.keyCode == 13)
	    {
	    	$('#imageFood').attr("src",$('#txtImage').val());
	    }
	});
	$('.imagelink').focus(function() {
		   $(this).select();
		});
	$("#btnNewCatelogue").click(function(){
		$("#myModalCatelogue").modal();
	});
	$('#data-table-1').on('click', '.btn-danger',function(e){ 
		var foodID=$(this).attr('value');
		$.ajax({
			url: "/iCook/deleteFood?txtFoodID="+foodID,
			type: "GET",
			success: function(food) {
				alert(food);
				$(this).closest("tr").remove();
			}
		});
	    $(this).closest("tr").remove();
	});
	$('#data-table-1').on('click', '.btn-warning',function(e){
		
		var foodID=$(this).attr('value');
		$.ajax({
	        url: "/iCook/getFoodID?txtFoodID="+foodID,
	        type: "GET",
	        success: function(category) {
	        	$("#txtID").val(category.foodId);
	        	$("#txtUser").val(category.user);
	        	$("#txtView").val(category.visitNum);
	        	$("#cbbCategory").val(category.categoryId);
	        	$('.imagelink').val(category.linkImage);
	        	$('#imageFood').attr("src",category.linkImage);
	        	$("#myModal .modal-title").html('<b>'+category.foodName+'</b>');
	        	$("#myModal .modal-body .foodName").val(category.foodName);
	        	$("#myModal .modal-body #txtContent").html(category.tutorial);
	        	$("#myModal .modal-body #txtInfo").html(category.materialInfo);
	        	$("#myModal .modal-body #txtDescription").html(category.description);
	        	$("#myModal .modal-body #txtMaterial").html(category.materialInfo);
	        	   $("#myModal").modal();
	        	   
	        }
	    });
		
	});
	function loadCatalog(){
		$.ajax({
	        url: "/iCook/getCategory",
	        type: "GET",
	        success: function(category) {
	            for (var i = 0; i < category.length; i++) {
		            $('#cbbCategory').append($("<option/>", {
		                value: category[i].categoryId,
		                text: category[i].categoryName
		            }));

				}
	                   
	        }
	    });
	}
	
	$('#btnSaveChange').click(function(){
		var dat = JSON.stringify({
			"foodId" :$("#txtID").val(),
		    "foodName" : $('#txtFoodName').val() ,
		    "tutorial": $('#txtContent').val(),
		    "description": $('#txtDescription').val() , 
		    "linkImage": $('#txtImage').val(), 
		    "listMaterial": $('#txtMaterial').val(), 
		    "materialInfo": $('#txtInfo').val(), 
		    "categoryId": $( "#cbbCategory option:selected" ).val(),
		    "user": $( "#txtUser").val(),
		    "visitNum": $( "#txtView" ).val()
		});
		alert(dat);
		$.ajax({
			 url: "/iCook/updateFood", 
			 type: 'POST', 
			 dataType: 'json',
			 data: (dat), 
			 beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        }, 
			 success: function(food) { 
			 		alert(food.foodName + " updated đã cập nhật vào cơ sở dữ liệu." );
			    } 
		});
	});
 	$("#btnSaveCatelog").click(function(){
 		var dat = JSON.stringify({
			"categoryName" :$("#txtCatelog").val()
		});
 		$.ajax({
			 url: "/iCook/createCaltalogue", 
			 type: 'POST', 
			 dataType: 'json',
			 data: (dat), 
			 beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        }, 
			 success: function(catelog) { 
				 if(catelog!= null){
			 		alert(catelog.categoryName + " updated đã cập nhật vào cơ sở dữ liệu." );
				 }
				
			  },
			  error: function (request, status, error) {
			        alert($("#txtCatelog").val()+" đã tồn tại trong cơ sở dữ liệu.");
			    }
		      
		});
 	});
	    loadCatalog();
	});