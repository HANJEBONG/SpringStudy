<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- AOP를 이용한 공통적용 데이터처리  -->
	<div class="col-sm-4">
		<h3>인기 레시피 Top5</h3>
		<div class="row">
		   <c:forEach var="vo" items="${footRList }" varStatus="s">
	    		
			      <a href="../recipe/detail.do?no=${vo.no }">
			        <img src="${vo.poster }" title="${vo.title}" style="width:100px;height: 100px">
			      </a>
	    </c:forEach>
		</div>
	</div>
	<div class="col-sm-4">
		<h3>인기 맛집 Top5</h3>
		<div class="row">
		   <c:forEach var="vo" items="${footFList }" varStatus="s">
	    		
			      <a href="../food/detail.do?fno=${vo.fno }">
			        <img src="http://menupan.com${vo.poster }" title="${vo.name}" style="width:100px;height: 100px">
			      </a>
	    </c:forEach>
		</div>
	</div>
	<div class="col-sm-4">
		<h3>인기 게시물 Top5</h3>
	</div>
</body>
</html>