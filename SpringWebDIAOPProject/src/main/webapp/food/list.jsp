<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
	margin: 50px;	
}
p{
	  width:300px;
      overflow:hidden;
      text-overflow:ellipsis;
      white-space:nowrap;
	
}
</style>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">AWS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a href="../goods/list.do">Goods</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
	<div class="row">
    <c:forEach var="vo" items="${list }">
	  <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="../music/detail.do?mno=${vo.fno }">
	        <img src="https://www.menupan.com${vo.poster}" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.name}</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </c:forEach>
  </div>
  <div style="height: 20px"></div>
  <div class="row">
    <div class="text-center">
      <table class="table">
      	<tr>
    		<td colspan="5" class="text-center">
     		  <a href="../food/list.do?page=${curpage-1 }" class="btn btn-sm btn-success">이전</a>
    		   ${curpage } page / ${totalpage } pages
    		  <a href="../food/list.do?page=${curpage+1 }" class="btn btn-sm btn-info">다음</a>
  	 	   </td>
     	 </tr>
      </table>
    </div>
  </div>
</body>
</html>