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
<title>login - dddog blog</title>
</head>

<body>
    <%@ include file="/WEB-INF/jspf/nav.jspf" %>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">
			
			<div class="col-lg-8">
				<c:forEach items="${postPage.content }" var="post">
					<div class="post-preview">
						<a href="/post/${post.id}">
							<h2 class="post-title">
								<c:out value="${post.title}" escapeXml="true"></c:out>
							</h2>
							<h3 class="post-subtitle">
								<c:out value="${post.subtitle}" escapeXml="true"></c:out>
							</h3>
						</a>
						<p class="post-meta">Posted by <a href="#">${post.name}</a> in <a href="/category/${post.category.id}/post/list"><c:out value="${post.category.name}" escapeXml="true" /></a> on ${post.regDate}</p>
					</div>
					<hr>
				</c:forEach>
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
							<c:choose>
								<c:when test="${activeCategoryId eq c.id }">
									<a href="/category/${c.id }/post/list" class="list-group-item active">${c.name }</a>
								</c:when>
								<c:otherwise>
									<a href="/category/${c.id }/post/list" class="list-group-item">${c.name }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
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
