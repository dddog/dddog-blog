<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<c:forEach items="${postPage.content }" var="post">
						<div class="col-xs-6 col-lg-4">
							<h2>${post.title }</h2>
							<p>${post.subtitle }</p>
							<p><a class="btn btn-default" href="/post/${post.id }" role="button">View details &raquo;</a></p>
						</div><!--/.col-xs-6.col-lg-4-->
					</c:forEach>
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
				<!-- <div class="well">
					<a href="/post/write">
						<button class="btn btn-default" type="button">Write</button>
					</a>
				</div> -->
				<sec:authorize access="isAuthenticated()">
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<div class="well">
							<a href="/post/write">
								<button class="btn btn-default" type="button">Write</button>
							</a>
						</div>
					</sec:authorize>
				</sec:authorize>
			
				<div class="well">
					<h4>Category</h4>
					<div class="list-group">
						<c:forEach items="${categoryList }" var="c">
							<a href="/category/${c.id }/post/list" class="list-group-item">${c.name }</a>
						</c:forEach>
					</div>
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
