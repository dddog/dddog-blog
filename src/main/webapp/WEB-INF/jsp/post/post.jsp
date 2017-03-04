<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<link rel="stylesheet" href="/webjars/summernote/0.8.2/dist/summernote.css">
<link rel="stylesheet" href="/css/bootstrap-tagsinput.css">
<link rel="stylesheet" href="/css/style.css">
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
			
			<div class="col-lg-8">
			
				<!-- Title -->
                <h1>${post.title }</h1>
                
                <!-- Sub Title -->
                <h3>${post.subtitle }</h3>
                
                <p class="lead text-right">
                    
                </p>
                <hr>
                <p class="text-right">
                	by <a href="#">${post.userid }</a> &nbsp;&nbsp;&nbsp;&nbsp; <span class="glyphicon glyphicon-time"></span> <c:out value="${post.regDate }"/>
                </p>
                <hr>
                
                <div class="post-content">
		            ${post.content }
                </div>
                
                <hr>
                <div class="well">
                    <h4>Leave a Comment:</h4>
                    <form role="form">
                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
			</div>
			
			<div class="col-md-4" id="sidebar">
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
				</div>
			</div><!--/.sidebar-offcanvas-->
		</div><!--/row-->

      <hr>

	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	<script src="/webjars/summernote/0.8.2/dist/summernote.min.js"></script>
	<script src="/webjars/summernote/0.8.2/dist/lang/summernote-ko-KR.min.js"></script>
	<script src="/js/summernote-ext-highlight.js"></script>
	<script src="/js/bootstrap-tagsinput.js"></script>
	<script type="text/javascript">

	</script>
	
    </div><!--/.container-->

  </body>
</html>
