<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 600px;
}
h3{
   text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0
$(function(){
	$('#addbtn').on('click',function(){
		$('#file-tbody').append(
			'<tr id="f'+fileIndex+'">'
			+'<td width="20%">File'+(fileIndex+1)+'</td>'
			+'<td width="80%"><input type="file" name="files['+fileIndex+']" size="20"></td>'
			+'</tr>'
		)
		fileIndex++
	})
	$('#removebtn').on('click',function(){
		if(fileIndex>0){
			$('#f'+(fileIndex-1)).remove()
			fileIndex--
		}
	})
	
})
</script>
</head>
<body>
   <div class="container">
     <h3>글쓰기</h3>
     <div class="row">
      <form method="post" action="insert_ok.do">
      <table class="table">
        <tr>
         <th width=20% class="text-right">이름</th>
         <td width="80%">
          <input type=text name=name size=20 class="input-sm" required>
         </td>
        </tr>
        <tr>
         <th width=20% class="text-right">제목</th>
         <td width="80%">
          <input type=text name=subject size=60 class="input-sm" required>
         </td>
        </tr>
        <tr>
         <th width=20% class="text-right">내용</th>
         <td width="80%">
          <textarea rows="10" cols="52" name=content required></textarea>
         </td>
        </tr>
        <tr>
         <th width=20% class="text-right">첨부파일</th>
         <td width="80%">
          <table class="table">
            <tr>
              <td class="text-right">
                <input type="button" class="btn-xs btn-danger" value="add" id="addbtn">
                <input type="button" class="btn-xs btn-info" value="remove" id="removebtn">
              </td>
            </tr>
          </table>
          <table class="table" id="user-table">
            <tbody id="file-tbody">
            
            </tbody>
          </table>
         </td>
        </tr>
        <tr>
         <th width=20% class="text-right">비밀번호</th>
         <td width="80%">
          <input type=password name=pwd size=10 class="input-sm" required>
         </td>
        </tr>
        <tr>
         <td colspan="2" class="text-center">
          <button class="btn-sm btn-danger">글쓰기</button>
          <input type=button value="취소" class="btn-sm btn-primary"
           onclick="javascript:history.back()">
         </td>
        </tr>
      </table>
      </form>
     </div>
   </div>
</body>
</html>