
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Title and other stuffs -->
  <title>Dashboard User</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="author" content="">s

  <!-- Stylesheets -->
  <link  href="<c:url value="/resources/css/bootstrap.min.css" ></c:url>"  rel="stylesheet">
  <!-- Font awesome icon -->
  <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" ></c:url>"> 
  <!-- jQuery UI -->
  <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" ></c:url>"> 
  <!-- Calendar -->
  <link rel="stylesheet" href="<c:url value="/resources/css/fullcalendar.css" ></c:url>">
  <!-- prettyPhoto -->
  <link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css" ></c:url>">  
  <!-- Star rating -->
  <link rel="stylesheet" href="<c:url value="/resources/css/rateit.css" ></c:url>">
  <!-- Date picker -->
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css" ></c:url>">
  <!-- CLEditor -->
  <link rel="stylesheet" href="<c:url value="/resources/css/jquery.cleditor.css" ></c:url>">  
  <!-- Data tables -->
  <link rel="stylesheet" href="<c:url value="/resources/css/jquery.dataTables.css" ></c:url>"> 
  <!-- Bootstrap toggle -->
  <link rel="stylesheet" href="<c:url value="/resources/css/jquery.onoff.css" ></c:url>">
  <!-- Main stylesheet -->
  <link href="<c:url value="/resources/css/style.css" ></c:url>" rel="stylesheet">
  <!-- Widgets stylesheet -->
  <link href="<c:url value="/resources/css/widgets.css" ></c:url>" rel="stylesheet">   
  
  <script src="<c:url value="/resources/js/respond.min.js" ></c:url>"></script>
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="<c:url value="/resources/img/favicon/favicon.png" ></c:url>">
</head>

<body>

		<div class="col-md-12">
			<div class="alert alert-success">
							Chào mừng trở lại <b>${sessionScope.username}</b>. Hãy bắt đầu chia sẻ!
			</div>
					
			<div class="widget">

	               <div class="widget-head">
	                  <div class="pull-left">New Post</div>
	                  <div class="widget-icons pull-right">
	                    <a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a> 
	                    <a href="#" class="wclose"><i class="fa fa-times"></i></a>
	                  </div>  
	                  <div class="clearfix"></div>
	               </div>
				<div class="widget-content">
                  <div class="padd">
                    <!-- Content goes here -->
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                              <label class="col-lg-2 control-label">Tên món ăn:</label>
                              <div class="col-lg-5">
                                <input type="text" class="form-control" placeholder="Input title Here" id="txtFoodName">
                              </div>
                        </div>
                        <div class="form-group">
                                  <label class="col-lg-2 control-label">Chủ đề:</label>
                                  <div class="col-lg-2">
                                    <select class="form-control" id="cbbCategory">
                                    </select>
                                  </div>
                                </div>    
                         <div class="form-group">
                                  <label class="col-lg-2 control-label">Ảnh đại diện:</label>
                                  <div class="col-lg-5">
                                    <input type="text" class="form-control imagelink" placeholder="Image Link" id="txtImageLink">
                                  </div>
                          </div>
                          <div class="form-group">
                                  <label class="col-lg-2 control-label">Xem trước:</label>
                                  <div class="col-lg-5">
                                    <a id ="imageZoom"  class="prettyPhoto[pp_gal]"><img id="imageFood" alt="" height="160" width="160"></a>
                                  </div>
                          </div>   
                        <div class="form-group">
                              <label class="col-lg-2 control-label">Mô tả:</label>
                              <div class="col-lg-6">
                                <textarea  id="txtDescription" cols="100" rows="8" style="resize:none"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                              <label class="col-lg-2 control-label">Nguyên liệu cần thiết:</label>
                              <div class="col-lg-6">
                                <textarea  id="txtMaterialLst" cols="100" rows="8" style="resize:none"></textarea>
                            </div>
                        </div>
                         <div class="form-group">
                              <label class="col-lg-2 control-label">Chi tiết nguyên liệu:</label>
                              <div class="col-lg-6">
                                <textarea  id="txtMaterialDetail" class="cleditor"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Hướng dẫn:</label>
                            <div class="col-lg-6">
                                <textarea class="cleditor" id="txtContent"></textarea>
                            </div>
                         </div>
                          <div class="form-group">
                                  <label class="col-lg-2 control-label">Nguồn:</label>
                                  <div class="col-lg-5">
                                    <input type="text" class="form-control imagelink" placeholder="Nguồn" id="txtSource">
                                  </div>
                          </div>
                        <div class="form-group">
                           <div class="col-lg-offset-2 col-lg-6">
                            <button id="btnSubmit" type="button" class="btn btn-sm btn-default">Submit</button>
                            <button id="btnReset" type="button" class="btn btn-sm btn-primary">Cancel</button>
                            </div>
                        </div>
                        <div class="form-group">
                           <div class="col-lg-offset-2 col-lg-6" id="createSuccess">
                           </div>
                          </div>                                                      
                    </form>
                  </div>
                  <div class="widget-foot">
                    <!-- Footer goes here -->
                  </div>
                </div>
				</div>
			</div>
	

	</html>
