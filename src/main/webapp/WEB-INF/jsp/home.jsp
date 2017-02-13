<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<title>dddog blog</title>
</head>

<body>
    <%@ include file="/WEB-INF/jspf/nav.jspf" %>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">
		
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>안녕하세요.</h1>
					<p>Spring Boot Project - Blog</p>
				</div>
				<div class="row">
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
						<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
					</div><!--/.col-xs-6.col-lg-4-->
		        </div><!--/row-->
			</div><!--/.col-xs-12.col-sm-9-->
		
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="well">
				<h4>Blog Search</h4>
				<div class="input-group">
					<input type="text" class="form-control">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<!-- /.input-group -->
			</div>
			<div class="list-group">
				<a href="#" class="list-group-item active">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
				<a href="#" class="list-group-item">Link</a>
			</div>
		</div><!--/.sidebar-offcanvas-->
		</div><!--/row-->

      <hr>


	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
    </div><!--/.container-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
