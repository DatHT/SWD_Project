<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<meta name="decorator" content="no" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>iCook</title>

    <!-- Bootstrap -->
    <link href='<c:url value="/resources/user_page/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <link href='<c:url value="/resources/user_page/css/bootstrap-theme.min.css"></c:url>' rel="stylesheet">
    <link href="<c:url value="/resources/user_page/css/font-awesome.min.css"></c:url>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/user_page/css/style.css"></c:url>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/user_page/css/initload.css"></c:url>">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <!--.preloader-->
  <div class="preloader"> <i class="fa fa-circle-o-notch fa-spin"></i></div>
  <!--/.preloader-->
  <header id="home">
    <nav class="navbar navbar-inverse navbar-fixed-top nav-pattern" role="navigation">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/iCook">
             <img class="img-responsive" src="<c:url value="/resources/user_page/images/whatcook.png"></c:url>" alt="logo" width="90%">
          </a>          
        </div>
      
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="#home">Đầu Trang</a></li>
              <li><a href="/iCook/Admin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div>
    </nav>  


    <div id="home-slider" class="carousel slide carousel-fade" data-ride="carousel">
      <div class="carousel-inner">
        <div class="item active" style="background-image: url('<c:url value="/resources/user_page/images/backgroud.png"></c:url>')">
          <div class="caption">
            <h1 class="animated fadeInLeftBig">Chào mừng đến với <span style="color: #e95748;">ICook</span></h1>
            <a data-scroll class="btn-start animated fadeInUpBig" href="#home-slider" data-slide="next">Bắt Đầu</a>
          </div>
        </div>
        <div class="item" style="background:#fff url('<c:url value="/resources/user_page/images/bg_main_background.jpg"></c:url>') bottom no-repeat;">
          <div class="caption-search">
            <div class="container">
              <h2>Nấu gì bây giờ nhỉ?</h2>
              <p>Icook sẽ giúp bạn chọn món ăn phù hợp.......</p>
              <form action="">
                <div class="row">
                  <div id="form-search"class="form-search col-sm-6 col-md-4 col-sm-offset-2 col-md-offset-3">
                    <input type="search" name="" id="input-search0" class="form-control input-lg" value="" title="" placeholder="Nguyên liệu">
                    <a id="btn-plus-search" data-scroll class="animated " href="#home-slider">
                      <img src="<c:url value="/resources/user_page/images/button-plus.png"></c:url>" class="img-responsive" alt="Image" margin-top="10px" width="30px">
                    </a>
                  </div>
                  <div id="search-button-container" class="form-button col-md-2 col-md-offset-1">
                    <a id="search-button" data-scroll class="animated " href="#search-result-container">
                      <img src="<c:url value="/resources/user_page/images/search.png"></c:url>" class="img-responsive" alt="Image" width="80px">
                    </a>
                  </div>
                </div>
              </form>
            </div> 
          </div>
        </div>
      </div>
    </div><!--/#home-slider--> 
  </header><!--/#home-->
    <input id="check-search" type="hidden" value="on">
    <div id="search-result-container" class="search-bacground" style='display:none !important'>
      <div class="pattern">
        <div  class="container">
          <div class="search-container">
              <div id="search-result" class="row">

                <div class="col-sm-4 col-md-3">
                  <div class="food-item">
                    <figure>
                      <img src="<c:url value="/resources/user_page/images/23.jpg"></c:url>">
                      <figcaption>
                        <h4 class="food-name">Cách làm sữa lắc với máy xay sinh tố thơm ngon bổ dưỡng</h4>
                        <p class="material">
                          Giò heo, cà chua
                        </p><!-- /.material -->
                      </figcaption>
                    </figure>
                    <div class="search-detail-container">
                      <div class="search-detail-btn">
                        <span class="search-detail-box description-container">
                          <a href="#" class="">
                            <h3>Cách làm sữa lắc với máy xay sinh tố thơm ngon bổ dưỡng</h3>
                            <p><span>12312412412312 31241241231231 241241231212 3213123 123123123</span></p>
                          </a><!-- /.facebook-btn -->
                        </span><!-- /.search-detail-box -->
                      </div><!-- /.search-detail-btn -->
                    </div><!-- /.search-detail-container -->
                  </div><!-- /.food-item -->
                </div><!-- /.col-md-3 -->

              </div><!-- /.row -->
          </div> 
          <div class="col-md-offset-6">
            <div id="loading"></div>
          </div>
        </div>
      </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/user_page/js/bootstrap.js"></c:url>"></script>
    <script src="<c:url value="/resources/user_page/js/newinput-content.js"></c:url>"></script>
    <script src="<c:url value="/resources/user_page/js/scroll.js"></c:url>"></script>
    <script src="<c:url value="/resources/user_page/js/initload.js"></c:url>"></script>
    
  </body>
</html>
