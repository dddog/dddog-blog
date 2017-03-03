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
