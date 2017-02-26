<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<style type="text/css">
.btn-facebook, .btn-facebook:visited {
    background-color: #5975b1;
    color: #fff;
}
.btn-google, .btn-google:visited {
    background-color: #df4a32;
    color: #fff;
}
</style>
<title>login - dddog blog</title>
</head>

<body>
    <%@ include file="/WEB-INF/jspf/nav.jspf" %>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">
		
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-lg-6">
						<div class="panel panel-default">
                    		<div class="panel-heading">
                        		<h3 class="panel-title">소셜 로그인</h3>
                        	</div>
                        	<div class="panel-body" style="padding-top:40px; min-height: 250px;">
                        		<form action="/signin/facebook" method="POST">
                        			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
                        			<button type="sumit" class="btn btn-facebook btn-block"><i class="fa fa-facebook fa-fw"></i> Facebook 으로 로그인</button>
                        		</form>
                        		<br>
                        		<a href="/oauth/google/authenticate?redirectUrl=" provider="google" class="btn btn-google btn-block"><i class="fa fa-google fa-fw"></i> Google 로 로그인</a>
                        	</div>
                        </div>
					</div>
					
					<div class="col-xs-12 col-sm-6 col-lg-6">
						<div class="panel panel-default">
                    		<div class="panel-heading">
                        		<h3 class="panel-title">아이디 로그인</h3>
                        	</div>
                        	<div class="panel-body" style="padding-top:10px; min-height: 250px;">
                        	<c:url value="/user/login" var="loginUrl"/>
                        	<form action="${loginUrl}" class="form-signin form-user panel-body panel-margin" method="POST" id="loginForm" autocomplete="off">
                        		<div class="form-group">
	                                <label for="inputUserId">User Id</label>
	                                <input type="text" name="username" class="form-control" id="inputUserId" placeholder="Enter User Id">
	                            </div>
	                            <div class="form-group">
	                                <label for="inputPassword">Password</label>
	                                <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Enter Password">
	                            </div>
	                            <div class="checkbox">
	                                <label for="remember-me">
	                                    <input type="checkbox" name="remember-me" id="remember-me"> Remember me
	                                </label>
	                            </div>
	                            <button type="submit" class="btn btn-default">Submit</button>
	                            <sec:csrfInput />
	                          </form>
                        	</div>
                        </div>
					</div>
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
		</div><!--/.sidebar-offcanvas-->
		</div><!--/row-->

      <hr>

      <%@ include file="/WEB-INF/jspf/footer.jspf" %>

    </div><!--/.container-->

  </body>
</html>
