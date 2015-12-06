<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Title and other stuffs -->
  <title><decorator:title /></title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="author" content="">


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
<div class="se-pre-con"></div>
<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
  
    <div class="conjtainer">
      <!-- Menu button for smallar screens -->
      <div class="navbar-header">
		  <button class="navbar-toggle btn-navbar" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
			<span>Menu</span>
		  </button>
		  <!-- Site name for smallar screens -->
		  <a href="index.html" class="navbar-brand hidden-lg">MacBeth</a>
		</div>
      
      

      <!-- Navigation starts -->
      <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">         

        <ul class="nav navbar-nav">  

          <!-- Upload to server link. Class "dropdown-big" creates big dropdown -->
          <li class="dropdown dropdown-big">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="label label-success"><i class="fa fa-cloud-upload"></i></span> Upload to Cloud</a>
            <!-- Dropdown -->
            <ul class="dropdown-menu">
              <li>
                <!-- Progress bar -->
                <p>Photo Upload in Progress</p>
                <!-- Bootstrap progress bar -->
                <div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info"  role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
						<span class="sr-only">40% Complete</span>
					</div>
			    </div>

                <hr />

                <!-- Progress bar -->
                <p>Video Upload in Progress</p>
                <!-- Bootstrap progress bar -->
                <div class="progress progress-striped active">
					<div class="progress-bar progress-bar-success"  role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
						<span class="sr-only">80% Complete</span>
					</div>
			    </div> 

                <hr />             

                <!-- Dropdown menu footer -->
                <div class="drop-foot">
                  <a href="#">View All</a>
                </div>

              </li>
            </ul>
          </li>

          <!-- Sync to server link -->
          <li class="dropdown dropdown-big">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="label label-danger"><i class="fa fa-refresh"></i></span> Sync with Server</a>
            <!-- Dropdown -->
            <ul class="dropdown-menu">
              <li>
                <!-- Using "icon-spin" class to rotate icon. -->
                <p><span class="label label-info"><i class="fa fa-cloud"></i></span> Syncing Members Lists to Server</p>
                <hr />
                <p><span class="label label-warning"><i class="fa fa-cloud"></i></span> Syncing Bookmarks Lists to Cloud</p>

                <hr />

                <!-- Dropdown menu footer -->
                <div class="drop-foot">
                  <a href="#">View All</a>
                </div>

              </li>
            </ul>
          </li>

        </ul>

        <!-- Search form -->
        <form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
        <!-- Links -->
        <ul class="nav navbar-nav pull-right">
          <li class="dropdown pull-right">            
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <i class="fa fa-user"></i> ${sessionScope.username } <b class="caret"></b>              
            </a>
            
            <!-- Dropdown menu -->
            <ul class="dropdown-menu">
              <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
              <li><a href="#"><i class="fa fa-cogs"></i> Settings</a></li>
              <li><a href="login.html"><i class="fa fa-sign-out"></i> Logout</a></li>
            </ul>
          </li>
          
        </ul>
      </nav>

    </div>
  </div>


<!-- Header starts -->
  <header>
    <div class="container">
      <div class="row">

        <!-- Logo section -->
        <div class="col-md-4">
          <!-- Logo. -->
          <div class="logo">
            <h1><a href="#">i<span class="bold">Cook</span></a></h1>
            <p class="meta">Nấu gì hôm nay</p>
          </div>
          <!-- Logo ends -->
        </div>

        <!-- Button section -->
        <div class="col-md-4">

          <!-- Buttons -->
          <ul class="nav nav-pills">

            <!-- Comment button with number of latest comments count -->
            <li class="dropdown dropdown-big">
              <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                <i class="fa fa-comments"></i> Chats <span   class="label label-info">6</span> 
              </a>

                <ul class="dropdown-menu">
                  <li>
                    <!-- Heading - h5 -->
                    <h5><i class="fa fa-comments"></i> Chats</h5>
                    <!-- Use hr tag to add border -->
                    <hr />
                  </li>
                  <li>
                    <!-- List item heading h6 -->
                    <h6><a href="#">Hi :)</a> <span class="label label-warning pull-right">10:42</span></h6>
                    <div class="clearfix"></div>
                    <hr />
                  </li>
                  <li>
                    <h6><a href="#">How are you?</a> <span class="label label-warning pull-right">20:42</span></h6>
                    <div class="clearfix"></div>
                    <hr />
                  </li>
                  <li>
                    <h6><a href="#">What are you doing?</a> <span class="label label-warning pull-right">14:42</span></h6>
                    <div class="clearfix"></div>
                    <hr />
                  </li>                  
                  <li>
                    <div class="drop-foot">
                      <a href="#">View All</a>
                    </div>
                  </li>                                    
                </ul>
            </li>

            <!-- Message button with number of latest messages count-->
            <li class="dropdown dropdown-big">
              <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                <i class="fa fa-envelope"></i> Inbox <span class="label label-primary">6</span> 
              </a>

                <ul class="dropdown-menu">
                  <li>
                    <!-- Heading - h5 -->
                    <h5><i class="fa fa-envelope"></i> Messages</h5>
                    <!-- Use hr tag to add border -->
                    <hr />
                  </li>
                  <li>
                    <!-- List item heading h6 -->
                    <h6><a href="#">Hello how are you?</a></h6>
                    <!-- List item para -->
                    <p>Quisque eu consectetur erat eget  semper...</p>
                    <hr />
                  </li>
                  <li>
                    <h6><a href="#">Today is wonderful?</a></h6>
                    <p>Quisque eu consectetur erat eget  semper...</p>
                    <hr />
                  </li>
                  <li>
                    <div class="drop-foot">
                      <a href="#">View All</a>
                    </div>
                  </li>                                    
                </ul>
            </li>

            <!-- Members button with number of latest members count -->
            <li class="dropdown dropdown-big">
              <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                <i class="fa fa-user"></i> Users <span   class="label label-success">6</span> 
              </a>

                <ul class="dropdown-menu">
                  <li>
                    <!-- Heading - h5 -->
                    <h5><i class="fa fa-user"></i> Users</h5>
                    <!-- Use hr tag to add border -->
                    <hr />
                  </li>
                  <li>
                    <!-- List item heading h6-->
                    <h6><a href="#">Ravi Kumar</a> <span class="label label-warning pull-right">Free</span></h6>
                    <div class="clearfix"></div>
                    <hr />
                  </li>
                  <li>
                    <h6><a href="#">Balaji</a> <span class="label label-important pull-right">Premium</span></h6>
                    <div class="clearfix"></div>
                    <hr />
                  </li>
                  <li>
                    <h6><a href="#">Kumarasamy</a> <span class="label label-warning pull-right">Free</span></h6>
                    <div class="clearfix"></div>
                    <hr />
                  </li>                  
                  <li>
                    <div class="drop-foot">
                      <a href="#">View All</a>
                    </div>
                  </li>                                    
                </ul>
            </li> 

          </ul>

        </div>

        <!-- Data section -->

        <div class="col-md-4">
          <div class="header-data">

            <!-- Traffic data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with red background -->
                <i class="fa fa-signal bred"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">7000</a> <em>visits</em></p>
              </div>
              <div class="clearfix"></div>
            </div>

            <!-- Members data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with blue background -->
                <i class="fa fa-user bblue"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">3000</a> <em>users</em></p>
              </div>
              <div class="clearfix"></div>
            </div>

            <!-- revenue data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with green background -->
                <i class="fa fa-money bgreen"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">5000</a><em>orders</em></p>
              </div>
              <div class="clearfix"></div>
            </div>                        

          </div>
        </div>

      </div>
    </div>
  </header>

<!-- Header ends -->

<!-- Main content starts -->

<div class="content">

  	<!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-dropdown"><a href="#">Navigation</a></div>

        <!--- Sidebar navigation -->
        <!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
        <ul id="nav">
          <!-- Main menu with font awesome icon -->
          <li <c:if test="${activeTab eq 'Dashboard'}">class="open"</c:if> ><a href="/iCook"><i class="fa fa-home"></i> Dashboard</a>
            <!-- Sub menu markup 
            <ul>
              <li><a href="#">Submenu #1</a></li>
              <li><a href="#">Submenu #2</a></li>
              <li><a href="#">Submenu #3</a></li>
            </ul>-->
          </li>
          <li <c:if test="${activeTab eq 'CreatePost'}">class="open"</c:if>><a href="/iCook/CreatePost" id="postCreate"><i class="fa fa-list-alt"></i>Tạo bài viết <span class="pull-right"><i class="fa fa-chevron-right"></i></span></a>
          </li>  
          <li <c:if test="${activeTab eq 'ManagePost'}">class="open"</c:if>><a href="/iCook/ManagePost" id="postManage"><i class="fa fa-file-o"></i>Quản lý bài viết <span class="pull-right"><i class="fa fa-chevron-right"></i></span></a>
<!--             <ul>
              <li><a href="post.html">Post</a></li>
              <li><a href="login.html">Login</a></li>
              <li><a href="register.html">Register</a></li>
              <li><a href="support.html">Support</a></li>
              <li><a href="invoice.html">Invoice</a></li>
              <li><a href="gallery.html">Gallery</a></li>
            </ul> -->
          </li> 
<!--           <li class="has_sub"><a href="#"><i class="fa fa-file-o"></i> Pages #2  <span class="pull-right"><i class="fa fa-chevron-right"></i></span></a> -->
<!--             <ul> -->
<!--               <li><a href="media.html">Media</a></li> -->
<!--               <li><a href="statement.html">Statement</a></li> -->
<!--               <li><a href="error.html">Error</a></li> -->
<!--               <li><a href="error-log.html">Error Log</a></li> -->
<!--               <li><a href="calendar.html">Calendar</a></li> -->
<!--               <li><a href="grid.html">Grid</a></li> -->
<!--             </ul> -->
<!--           </li>       -->
<!-- 		  <li class="has_sub"><a href="#"><i class="fa fa-table"></i> Tables  <span class="pull-right"><i class="fa fa-chevron-right"></i></span></a> -->
<!--             <ul> -->
<!--               <li><a href="tables.html">Tables</a></li> -->
<!--               <li><a href="dynamic-tables.html">Dynamic Tables</a></li> -->
<!--             </ul> -->
<!--           </li>  -->
<!--           <li><a href="charts.html"><i class="fa fa-bar-chart-o"></i> Charts</a></li>  -->
<!--           <li><a href="forms.html"><i class="fa fa-tasks"></i> Forms</a></li> -->
<!--           <li><a href="ui.html"><i class="fa fa-magic"></i> User Interface</a></li> -->
        </ul>
    </div>

    <!-- Sidebar ends -->

  	<!-- Main bar -->
  	<div class="mainbar">

      <!-- Page heading -->
      <div class="page-head">
        <h2 class="pull-left"><i class="fa fa-home"></i> ${pageheader}</h2>

        <!-- Breadcrumb -->
        <div class="bread-crumb pull-right">
          <a href="index.html"><i class="fa fa-home"></i> Home</a> 
          <!-- Divider -->
          <span class="divider">/</span> 
          <a href="#" class="bread-current">${pageheader}</a>
        </div>

        <div class="clearfix"></div>

      </div>
      <!-- Page heading ends -->


	    <!-- Matter -->

	    <div class="matter">
        <div class="container">
          
                <!-- Body -->
                <decorator:body/>
         
        </div>
		  </div>

		<!-- Matter ends -->

    </div>

   <!-- Mainbar ends -->	    	
   <div class="clearfix"></div>

</div>
<!-- Content ends -->

<!-- Footer starts -->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
            <!-- Copyright info -->
            <p class="copy">Copyright &copy; 2012 | <a href="#">Your Site</a> </p>
      </div>
    </div>
  </div>
</footer> 	

<!-- Footer ends -->

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="fa fa-chevron-up"></i></a></span> 

<!-- JS -->
<script src="<c:url value="/resources/js/jquery.js" ></c:url>"></script> <!-- jQuery -->
<script src="<c:url value="/resources/js/bootstrap.min.js" ></c:url>"></script> <!-- Bootstrap -->
<script src="<c:url value="/resources/js/jquery-ui.min.js" ></c:url>"></script> <!-- jQuery UI -->
<script src="<c:url value="/resources/js/moment.min.js" ></c:url>"></script> <!-- Moment js for full calendar -->
<script src="<c:url value="/resources/js/fullcalendar.min.js" ></c:url>"></script> <!-- Full Google Calendar - Calendar -->
<script src="<c:url value="/resources/js/jquery.rateit.min.js" ></c:url>"></script> <!-- RateIt - Star rating -->
<script src="<c:url value="/resources/js/jquery.prettyPhoto.js" ></c:url>"></script> <!-- prettyPhoto -->
<script src="<c:url value="/resources/js/jquery.slimscroll.min.js" ></c:url>"></script> <!-- jQuery Slim Scroll -->
<script src="<c:url value="/resources/js/jquery.dataTables.min.js" ></c:url>"></script> <!-- Data tables -->

<!-- jQuery Flot -->
<script src="<c:url value="/resources/js/excanvas.min.js" ></c:url>"></script>
<script src="<c:url value="/resources/js/jquery.flot.js" ></c:url>"></script>
<script src="<c:url value="/resources/js/jquery.flot.resize.js" ></c:url>"></script>
<script src="<c:url value="/resources/js/jquery.flot.pie.js" ></c:url>"></script>
<script src="<c:url value="/resources/js/jquery.flot.stack.js" ></c:url>"></script>

<!-- jQuery Notification - Noty -->
<script src="<c:url value="/resources/js/jquery.noty.js" ></c:url>"></script> <!-- jQuery Notify -->
<script src="<c:url value="/resources/js/themes/default.js" ></c:url>"></script> <!-- jQuery Notify -->
<script src="<c:url value="/resources/js/layouts/bottom.js" ></c:url>"></script> <!-- jQuery Notify -->
<script src="<c:url value="/resources/js/layouts/topRight.js" ></c:url>"></script> <!-- jQuery Notify -->
<script src="<c:url value="/resources/js/layouts/top.js" ></c:url>"></script> <!-- jQuery Notify -->
<!-- jQuery Notification ends -->

<script src="<c:url value="/resources/js/sparklines.js" ></c:url>"></script> <!-- Sparklines -->
<script src="<c:url value="/resources/js/jquery.cleditor.min.js" ></c:url>"></script> <!-- CLEditor -->
<script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" ></c:url>"></script> <!-- Date picker -->
<script src="<c:url value="/resources/js/jquery.onoff.min.js" ></c:url>"></script> <!-- Bootstrap Toggle -->
<script src="<c:url value="/resources/js/filter.js" ></c:url>"></script> <!-- Filter for support page -->
<script src="<c:url value="/resources/js/custom.js" ></c:url>"></script> <!-- Custom codes -->
<script src="<c:url value="/resources/js/charts.js" ></c:url>"></script> <!-- Charts & Graphs -->
<script type="text/javascript" src='<c:url value="/resources/js/ajaxload.js"></c:url>'></script>  <!-- load database -->
</body>
</html>