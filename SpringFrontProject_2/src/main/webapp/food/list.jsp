<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.a{
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
</style>
</head>
<body>
<div class="container">
 <div class="row">
    <form method="post" action="../recipe/find.do">
     <input type=text name=fd size=20 class="input-sm" value="${fd}">
     <button class="btn-sm btn-primary">검색</button>
    </form>
   </div>
   <div class="row">
    <c:forEach var="vo" items="${list }">
      <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../recipe/detail_before.do?no=${vo.fno }">
		        <img src="https://www.menupan.com${vo.poster }" title="${vo.name}" style="width:230px;height: 150px">
		        <div class="caption">
		          <p>${vo.name }</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </c:forEach>
   </div>
   <div style="height: 10px"></div>
   <div class="row">
     <div class="text-center">
       <ul class="pagination">
         <c:if test="${startpage>1 }">
	      <li><a href="../food/list.do?page=${startpage-1}" class="btn btn-sm btn-warning">&lt;</a></li>
	 	 </c:if>
	 	 <c:forEach var="i" begin="${startpage }" end="${endpage }">
	 	 	<li ${curpage==i?"class=active":"" }><a href="../food/list.do?page=${i}">${i }</a></li>
	 	 </c:forEach>
	 	 <c:if test="${endpage<totalpage }">
	      <li><a href="../food/list.do?page=${endpage+1}" class="btn btn-sm btn-warning">&gt;</a></li>
      	 </c:if>
      </ul>
     </div>
   </div>
</div>
</body>
</html>