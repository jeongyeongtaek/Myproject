<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 등록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
    <style>
        body {
            background-color: rgb(244, 243, 250);
        }

        .my-content-bgcolor {
            background-color: white;
        }

        .my-content-box {
            padding-bottom: 100px;
        }

        .my-content-box-mw {
            min-width: 900px;
        }
        .my-list-margin {
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .my-lsit-content-padding {
            padding: 15px 30px 15px 30px;
        }        
    </style>
</head>

<%@ include file="../../includes/header.jsp"%>

    <!-- content -->
    <div class="container-fluid">
        <div class="row align-items-center">
            <!-- align-items-center 수직 중앙 정렬 -->
            <div class="col-md-2 col-0"></div> <!-- 좌측 기본 여백 -->

            <!-- 내용이 들어갈 div-->
            <div class="col-md-8 col-12 my-content-bgcolor my-content-box">

                <!-- 상단 자동 슬라이드 뷰 -->
                <!-- /상단 자동 슬라이드 뷰 끝 -->
                
                <!-- 검색창 -->
                <form class="row" action="searchProject" method="get">
                    <div class="col-2"></div>
                    <div class="col-2">
                        <select class="custom-select" name="area">
	                          <option value="" selected="selected">선택안함</option>
							  <option value="서울특별시">서울특별시</option>
							  <option value="광주광역시">광주광역시</option>
							  <option value="울산광역시">울산광역시</option>
							  <option value="대전광역시">대전광역시</option>
							  <option value="대구광역시">대구광역시</option>
							  <option value="부산광역시">부산광역시</option>
							  <option value="인천광역시">인천광역시</option>
							  <option value="경기도">경기도</option>
							  <option value="강원도">강원도</option>
							  <option value="전라남도">전라남도</option>
							  <option value="전라북도">전라북도</option>
							  <option value="경상북도">경상북도</option>
							  <option value="경상남도">경상남도</option>
							  <option value="제주특별자치도">제주특별자치도</option>
						</select>
                    </div>
                    <div class="col-2">
                        <select class="custom-select" name="sortBy">
                            <option value="최신순" selected>최신순</option>
                            <option value="좋아요순">좋아요순</option>
                        </select>
                    </div>
                    <div class="col-4">
                        <div class="input-group">
                            <input type="text" class="form-control" name="search" placeholder="검색어를 입력하세요!">
                            <span class="input-group-btn">
                                <button class="btn btn-secondary" type="submit"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-search" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
                                    <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
                                </svg></button>
                            </span>
                        </div>
                    </div>
                </form>
                <!-- /검색창 -->

                <br>

                <!-- 메인 content -->
                <div class="row">
                    <!-- 좌측 여백 -->
                    <div class="col-1"></div>
                    <!-- /좌측 여백 -->
                    
                    <!-- 프로젝트 리스트 -->
                    <div class="col-10">
                        <!-- test 목록 1 -->
                        <c:forEach var="proj" items="${listProj}">
	                        <div class="row my-list-margin my-list-height border rounded shadow p-3 mb-5 bg-white">
	                            <!-- 썸네일 처리 -->
	                            <!-- /썸네일 처리 -->
	                            <!-- 목록 간단 정보 -->
	                            <div class="col my-lsit-content-padding">
	                                <div><a class="move" href="<c:out value='${proj.hierId}'/>"> 
	                                	<h1><c:out value ="${proj.projTitle}" /></h1>
	                                </a></div>
	                                <br>
	                                <div style="height: 100px"><h3><c:out value="${proj.content}"></c:out></h3></div>
	                                <div style="height: 30px"><h6> 지역1 : <c:out value="${proj.areaA}"></c:out></h6></div>
	                                <div style="height: 30px"><h6> 지역2 : <c:out value="${proj.areaB}"></c:out></h6></div>
	                                <div style="height: 30px"><h6> 생성인 : <c:out value="${proj.writerId.partyId}"></c:out></h6></div>
	                                <div style="height: 30px"><h6> 생성일 : <c:out value="${proj.creation}"></c:out></h6></div>
	                                <div class="float-right"><c:out value="좋아요: "></c:out><c:out value="${proj.likes}"></c:out></div>
	                                <div style="height: 30px"><a href="application?hierId=${proj.hierId }">참여하기</a></div>
	                            </div>
	                            <!-- /목록 간단 정보 -->
	                        </div>
	                    </c:forEach>    
	                 </div><br>
                        <!-- /test 목록 1 -->
                    </div>
                    <!-- /프로젝트 리스트 -->
                    
                    <!-- 페이징 처리 -->   
                    <div class='pull-right'>
	                  <ul class='pagination'>
	                     <c:if test="${pageMaker.prev}">
	                        <li class="paginate_button previous"><a
	                           href="${pageMaker.startPage - 1}">Previous</a></li>
	                     </c:if>
	
	                     <c:forEach var="num" begin="${pageMaker.startPage}"
	                        end="${pageMaker.endPage}">
	                        <li
	                           class="paginate_button ${pageMaker.cri.pageNum == num ? "active":"" }">
	                           <a href="${num}">${num}</a>
	                        </li>
	                     </c:forEach>
	
	                     <c:if test="${pageMaker.next}">
	                        <li class="paginate_button next"><a
	                           href="${pageMaker.endPage + 1}">Next</a></li>
	                     </c:if>
	                  </ul>
	                  
	                  <form id='actionForm' action='/board/proj/projectList' method='get'>
	                     <input type="hidden" name='pageNum' value='${pageMaker.cri.pageNum}'> 
	                     <input type="hidden" name='amount' value='${pageMaker.cri.amount}'>
	                  </form>
              		</div>
              		
               <!-- /페이징 처리 -->

                </div>
                <!-- /메인 content -->

            </div>
            <!-- /내용이 들어갈 div-->

            <div class="col-md-2 col-0"></div> <!-- 우측 기본 여백 -->
        </div>
    </div>
    <!-- end content -->
</body>
<script>
    $(document).ready(function () { // 상단 자동 슬라이드 시작
        $('#myCarousel').find('.item').first().addClass('active');
    });
    $('.carousel').carousel({       // 상단 자동 슬라이드 시간 제어
        interval: 5000              // 5초
    })
    
    
    $('.move').on(
         'click',
         function(e) {
            e.preventDefault();
            //this : event가 일어난 객체 - 제목이 출력된 ancher tag입니다
            //attr('href') 속성 중 href인 것을 찾아 그 값을 추출
            actionForm.append("<input type='text' name='hierId' value='"
                  + $(this).attr('href') + "'/>");
            actionForm.attr("action", "/board/proj/findById");
            actionForm.submit();

         });
   
    
   var actionForm = $('#actionForm');
   $('.paginate_button a').on('click', function(e) {
      e.preventDefault();

      var choosedPage = $(this).attr('href');
      actionForm.find("input[name='pageNum']").val(choosedPage);

      actionForm.submit();
   });
</script>

</html>