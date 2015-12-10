<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>Register - MacAdmin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="author" content="">
  <meta name="decorator" content="register" />
  <!-- Stylesheets -->
  <link href="<c:url value="/resources/css/bootstrap.min.css"></c:url>" rel="stylesheet">
  <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"></c:url>">
  <link href="<c:url value="/resources/css/style.css"></c:url>" rel="stylesheet">
  
  <script src="<c:url value="/resources/js/respond.min.js"></c:url>"></script>
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href='<c:url value="/resources/img/favicon/favicon.png"></c:url>'>
</head>

<body>

<div class="admin-form">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <!-- Widget starts -->
            <div class="widget wred">
              <div class="widget-head">
                <i class="fa fa-lock"></i> Register 
              </div>
              <div class="widget-content">
                <div class="padd">
                  
                  <spring:form cssClass="form-horizontal" commandName="newUser" action="/iCook/register">
                    <!-- Registration form starts -->
                                      <!-- Name -->
                                          <div class="form-group">
                                            <label class="control-label col-lg-3" for="name">Họ tên:</label>
                                            <div class="col-lg-9">
                                              <input type="text" class="form-control" id="name" name ="txtfullName" required="true">
                                            </div><br/>
                                            
                                          </div>   
                                          
                                          <!-- Email -->
                                          <div class="form-group">
                                            <label class="control-label col-lg-3" for="email">Email</label>
                                            <div class="col-lg-9">
                                              <input type="email" class="form-control" id="email" name ="txtEmail" required="true">
                                            </div>
                                          </div>                                      
                                          <!-- Username -->
                                          <div class="form-group">
                                            <label class="control-label col-lg-3" for="username">Username</label>
                                            <div class="col-lg-9">
                                              <spring:input cssClass="form-control" path="userName" required="true"/>
                                            </div>
                                            <label class="control-label col-lg-3" ></label>
                                            <c:if test="${not empty userNameDub.userName}">
                                            <div class="col-lg-9">
                                            	<font color="red">${userNameDub.userName} đã tồn tại trong cơ sở dữ liệu.</font>
                                            </div>
                                            </c:if>
                                          </div>
                                          <!-- Password -->
                                          <div class="form-group">
                                            <label class="control-label col-lg-3" for="email">Mật khẩu:</label>
                                            <div class="col-lg-9">
                                              <spring:password  cssClass="form-control" path="password" />
                                            </div>
                                          </div>
                                          <div class="form-group">
                                            <label class="control-label col-lg-3" for="email">Nhập lại mật khẩu:</label>
                                            <div class="col-lg-9">
                                              <input type="password" class="form-control" id="repassword" name ="txtRepassword" required="true">
                                            </div>
                                            <label class="control-label col-lg-3" ></label>
                                            <c:if test="${not empty wrongPassword}">
                                            <div class="col-lg-9">
                                            	<font color="red">Mật khẩu không trùng nhau.</font>
                                            </div>
                                            </c:if>
                                          </div>
                                          <div class="form-group">
                                            <label class="control-label col-lg-3" for="email">Số điện thoại:</label>
                                            <div class="col-lg-9">
                                              <input type="text" class="form-control" id="txtPhone" name ="txtPhoneNum" required="true">
                                            </div>
                                          </div>
                                          <!-- Accept box and button s-->
                                          <div class="form-group">
                                            <div class="col-lg-9 col-lg-offset-3">
											  <div class="checkbox">
                                              <label>
                                                <input type="checkbox"> Accept Terms &amp; Conditions
                                              </label>
											  </div>
                                              <br />
                                              <button type="submit" class="btn btn-sm btn-info">Register</button>
                                              <button type="reset" class="btn btn-sm btn-default">Reset</button>
                                            </div>
                                          </div>
                  </spring:form>

                </div>
              </div>
                <div class="widget-foot">
                  Already Registred? <a href="login.html">Login</a>
                </div>
            </div>  
      </div>
    </div>
  </div> 
</div>
	
		

<!-- JS -->
<script src="<c:url value="/resources/js/jquery.js"></c:url>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"></c:url>"></script>
</body>
</html>