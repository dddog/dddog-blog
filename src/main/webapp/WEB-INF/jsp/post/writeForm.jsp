<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			
			<%-- <form id="writePostForm" role="form" action="/post/write" method="post"> --%>
			<form:form action="${requestScope['javax.servlet.forward.servlet_path']}" commandName="postCommand" id="post" onsubmit="if($('#pen').html()!='<p><br></p>')$('#content').val($('#pen').summernote('code'));" method="post">
				<%-- <sec:csrfInput /> --%>
				<form:input type="hidden" path="_csrf" value="${_csrf.token}"></form:input>
				<div class="col-xs-12 col-sm-9">
					<p class="pull-right visible-xs">
						<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
					</p>
					<div class="row">
						<h1 class="page-header">새글쓰기</h1>
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<div class="input-group">
										<span class="input-group-addon" id="basic-addon1">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</span>
										<form:input type="text" path="title" placeholder="Title" class="form-control" aria-describedby="basic-addon1" />
										<form:errors path="title" cssClass="error" />
									</div>
								</div>
								<div class="row">
									<div class="input-group">
										<span class="input-group-addon" id="basic-addon1">서브제목</span>
										<form:input type="text" path="subtitle" placeholder="Subtitle (option)" class="form-control" aria-describedby="basic-addon1" />
									</div>
								</div>
								<div class="row">
									<div class="input-group">
										<span class="input-group-addon" id="basic-addon1">카테고리</span>
										<form:select path="categoryId" items="${categoryMap}" id="category" class="form-control"/>
										<form:errors path="categoryId" cssClass="error" />
									</div>
								</div>
							</div>
							<div class="panel-body">
								<div class="summernote" id="pen"></div>
								<form:input type="hidden" path="content" id="content" />
								<form:errors path="content" cssClass="error" />
								
								<hr style="margin-top: 2px; border-top: 1px solid #999;">
								
								<form:input type="text" path="tags" placeholder="Tag (option - 최대 10개. ','으로 구분합니다.)" data-role="tagsinput" />
							</div>
							
							<div class="panel-footer ">
								<div class="row">
									<div class="col-xs-4 text-left">
										<button id="preview" class="btn btn-primary" onclick="preview()" data-toggle="modal" data-target="#myModal">Preview</button>
									</div>
									<div class="col-xs-4 text-center">
										<a href="/post"><button class="btn btn-primary">list</button></a>
									</div>
									<div class="col-xs-4 text-right">
										<button id="save" class="btn btn-primary" type="submit">Save</button>
									</div>
								</div>
							</div>
						</div>
						
			        </div><!--/row-->
				</div><!--/.col-xs-12.col-sm-9-->
			</form:form>
			<%-- </form> --%>
			
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
				<div class="well">
					<h4>Category Add</h4>
					<form action="/category/add" method="post" id="add_category" >
						<input type="text" name="categoryName" class="form-control" placeholder="새로운 카테고리" required="required">
						<input type="hidden" name="_csrf" value="${_csrf.token}">
						<button type="submit" class="form-control">추가</button>
					</form>
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

		$(document).ready(function() {
			$('.summernote').summernote({
			toolbar: [
					    ['style', ['style']],
					    ['font', ['bold', 'italic', 'underline', 'clear']],
					    // ['font', ['bold', 'italic', 'underline', 'strikethrough', 'superscript', 'subscript', 'clear']],
					    //['fontname', ['fontname']],
					    ['fontsize', ['fontsize']],
					    ['color', ['color']],
					    ['para', ['ul', 'ol', 'paragraph']],
					    ['height', ['height']],
					    ['table', ['table']],
					    ['highlight', ['highlight']],
					    ['insert', ['link', 'picture', 'hr']],
					    ['view', ['fullscreen', 'codeview']],
					    ['help', ['help']]
					 ],
				lang: 'ko-KR',
				height: $(window).height()/3,
				placeholder: '',
				callbacks: {
		        	onImageUpload: function(files, editor, welEditable) {
						for (var i = files.length - 1; i >= 0; i--) {
							sendFile(files[i], this);
						}
					}
				}
			});
			
			$('#pen').html($('#content').val());
		});
		

		function sendFile(file, el) {
			var form_data = new FormData(jQuery('form')[0]);
			form_data.append('file', file);
			
			$.ajax({
				data : form_data,
				type : "POST",
				url : '/image',
				cache : false,
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(url) {
					$(el).summernote('editor.insertImage', url);
				}
			});
		}
		
		// 카테고리 추가
		$('#add_category').submit(function(event) {
			var form = $(this);
						
			$.ajax({
				type : form.attr('method'),
				url : form.attr('action'),
				data : form.serialize()
			}).done(function(c) {				
				$("#category").append("<option value=" + c.id + ">" + c.name + "</option>");
				$("#category").val(c.id);
				
				alert(c.name + " 카테고리가 추가되었습니다.");
			}).fail(function() {
				alert('error');
			});
			event.preventDefault();
		});
	</script>
	
    </div><!--/.container-->

  </body>
</html>
