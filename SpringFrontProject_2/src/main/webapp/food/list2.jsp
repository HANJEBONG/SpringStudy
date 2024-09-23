<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.link:hover {
	cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
    	<div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="'https://www.menupan.com'+vo.poster" :title="vo.name" style="width:230px;height: 150px">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </div>
    <div style="height: 10px"></div>
   <div class="row">
   	<div class="text-center">
       <ul class="pagination">
	     <li v-if="startpage>1"><a class="link" @click="prev()">&lt;</a></li>
	 	 <li v-for="i in range(startpage,endpage)" :class="i===curpage?'active':''"><a class="link" @click="pageChange(i)">{{i}}</a></li>
	     <li v-if="endpage<totalpage"><a class="link" @click="next()">&gt;</a></li>
      </ul>
     </div>
   </div>
  </div>
  <script>
  /*
  		1. 라이브러리 로드
  		2. 태그안에서 속성으로 제어
  		 v- : 디렉티브
  		 반복문 : v-for ==> 형식) v-for="받는 변수 in 배열"
  		 						v-for="(vo,index) in 배열" => index=0
  		 조건문 : v-if => 형식) v-if="조건문"
  		        v-if ~ v-else
  		        v-if ~ v-else-if ~ v-else
  		 기타
  		 		v-show="조건문" => true(show) , false(hide)
  		 		데이터값을 받아서 출력 <태그>{{}}</태그>
  		 		속성으로 받아서 출력 :속성값
  */
  	let foodApp=Vue.createApp({
  		data(){
  			return{
  				food_list:[],
  				curpage:1,
  				totalpage:0,
  				startpage:0,
  				endpage:0
  			}
  		},
  		// ViewModel => 데이터를 수정 => View로 변경된 데이터 전송
  		// 사용자 정의 함수 / 라이브러리 함수 : 생명주기와 관련
  		mounted(){
  			// onload => 브라우저에 화면이 보이기 전
  			// 서버 연결
  			this.dataRecv()
  		},
  		methods:{
  			pageChange(page){
  				this.curpage=page
  				this.dataRecv()
  			},
  			prev(){
  				this.curpage=this.startpage-1
  				this.dataRecv()
  			},
  			next(){
  				this.curpage=this.endpage+1
  				this.dataRecv()
  			},
  			dataRecv(){
  				axios.get("http://localhost:8080/web/food/list_vue.do",{
  	  				params:{
  	  					page:this.curpage
  	  				}
  	  			}).then(response=>{
  	  				console.log(response.data)
  	  				this.food_list=response.data.list
  	  				this.curpage=response.data.curpage
  	  				this.totalpage=response.data.totalpage
  	  				this.startpage=response.data.startpage
  	  				this.endpage=response.data.endpage
  	  			})
  			}
  			,
  			range(start,end){
  				let arr=[]
  				let len=end-start
  				for(let i=0;i<=len;i++){
  					arr[i]=start
  					start++
  				}
  				return arr
  			}
  		}
  		
  	}).mount('.container')
  </script>
</body>
</html>