<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/solid.js" integrity="sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js" integrity="sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
    <style>
        body {
            position: relative;
        }

        ul.my-side-nav-pills {
            top: 150px;
            left: 300px;
            position: fixed;
        }

        div.my-project-content > div {
            height: 300px;
            padding:30px 20px;
        }
        
        .my-project-content {
        	background-color: white;
        }
    </style>
</head>

<%@ include file="../../includes/header.jsp"%>

<body data-spy="scroll" data-target="#myScrollspy" data-offset="1">
    

    <!-- content -->
    <div class="container-fluid">
        <br><br>
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-2">
                <!-- ScrollSpy -->
<!--                 <nav class="col-md-2" id="myScrollspy"> -->
<!--                     <ul class="nav nav-pills flex-column shadow mb-5 bg-white rounded my-side-nav-pills" style="padding: 0px;"> -->
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link active" href="#section1">Section 1</a> -->
<!--                         </li> -->
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link" href="#section2">Section 2</a> -->
<!--                         </li> -->
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link" href="#section3">Section 3</a> -->
<!--                         </li> -->
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link" href="#section4">Section 4</a> -->
<!--                         </li> -->
<!--                     </ul> -->
<!--                 </nav> -->
            </div>
            <div class="my-project-content col-md-6">
                <!-- 프로젝트 내용 -->
                <div id="section1" class="my-section shadow p-3 mb-5 bg-white rounded">
                    <h1>소개</h1><hr>
                    <h4><c:out value = "${project.projAddInfo.introdution }"></c:out></h4>
                </div>
                <br>
                <div id="section2" class="my-section shadow p-3 mb-5 bg-white rounded">
                    <h1>계획</h1><hr>
                    <h4><c:out value = "${project.projAddInfo.plan }"></c:out></h4>
                </div>
                <br>
                <div id="section3" class="my-section shadow p-3 mb-5 bg-white rounded">
                    <h1>모토</h1><hr>
                    <h4><c:out value = "${project.projAddInfo.motto }"></c:out></h4>
                </div>
                <br>
                <div id="section4" class="my-section shadow p-3 mb-5 bg-white rounded">
                    <h1>계기</h1><hr>
                    <h4><c:out value = "${project.projAddInfo.motivation }"></c:out></h4>
                </div>
                <br>
                <hr>
               	 <a href="likeUp?hierId=${project.hierId }">좋아요!</a>
                <hr>
                <br>
                <!-- 댓글 창 -->
                <h2>Reply</h2>
                <br>
                <div class="row my-section">
                    <div class="col-md-1"></div>
                    <div class="col-md-7">
                        <!-- 댓글 입력 창 -->
                        <div class="row border" style="padding: 0px;">
                            <div class="col-md-2">
                                <div class="border" style="margin-top: 15px; font-size : 13px; padding:13px; width: 95px; height: 90px;">
                                	댓글을<br>입력하세요</div>
                            </div>
                            <form action="findById" method="post" class="col-md-10">
                                <div class="row" style="width: 100%; margin: 10px;">
                                    <textarea class="form-control" name="reContent" style="width: 100%; height: 100px; margin: 5px;"></textarea>
                                </div>
                                <div class="row" style="margin-bottom: 10px;">
                                    <div style="padding-left: 30px;">   <!-- 향후 삭제 가능성 있음 -->
                                        <button type="button" class="btn btn-light border">Reply</button>
                                        <!-- <button type="button" class="btn btn-light border">Q&A</button> -->
                                    </div>
                                    <div class="ml-auto">
                                        <button type="button" class="btn btn-light border"><i class="fas fa-camera"></i></button>
                                        <input type="hidden" name="hid" value="${project.hierId}"/>
                                        <input type="hidden" name="pageId" value="${project.hierId}"/>
                                        <input type="hidden" name="cri" value="${cri}"/>
                                        <button type="submit" class="btn btn-light border">댓글 달기</button>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <br>
                        <!-- 댓글 목록 -->
                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link active" id="pills-reply-tab" data-toggle="pill" href="#pills-reply" role="tab" aria-controls="pills-reply" aria-selected="true">
                                    Reply
                                </a>
                            </li>
                            <!-- <li class="nav-item" role="presentation">
                                <a class="nav-link" id="pills-QandA-tab" data-toggle="pill" href="#pills-QandA" role="tab" aria-controls="pills-QandA" aria-selected="false">
                                    Q&A
                                </a>
                            </li> -->
                        </ul>
                        <div class="tab-content" id="pills-tabContent">
                            <div class="tab-pane fade show active" id="pills-reply" role="tabpanel" aria-labelledby="pills-reply-tab">
                                
                                <!-- 댓글 -->
                            <c:forEach var="reply" items="${reply}">  
                            	<c:set var="rep" value="${reply.hierId}"/>
                            	
                                <div class="row border" style="font-size:15px; padding: 0px;">
                                    <div class="col-md-2">
                                        <div class="border" style="margin-top: 15px; width: 80px; height: 80px;">
                                        "<c:out value="${reply.writerId.partyId}" />" 님의 <br> 댓글</div>
                                    </div>
                                <form action="deleteReply" method ="get" class="col-md-10" style="padding: 10px 5px 10px 20px;">    <!-- padding 기준 -->
                                    <div><c:out value="${reply.content}" /></div>
                                    <input type="hidden" name="cri" value="${cri}"/>
                        			<input type="hidden" name="pageId" value="${project.hierId}"/>
                        			<input type="hidden" name="hid" value="${reply.hierId}"/>
                        			<button type="submit" class="btn btn-light border">삭제</button>
                                </form>
                                <form action="findById" method="post" >
										<input type="text" name="reContent" />
										<input type="hidden" name="cri" value="${cri}"/>
										<input type="hidden" name="pageId" value="${project.hierId}"/>
										<input type="hidden" name="hid" value="${reply.hierId}" />
										<input type="submit" class="btn btn-light border" value="답글 등록">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</form>
                                </div>
                                 <!-- 대댓 아이콘 -->
                                
		                             <c:forEach var="reReply" items="${reReply}"> 
		                             <c:set var="reRep" value="${reReply.hierId}"/>
			                             <c:if test="${fn:contains(reRep, rep)}" > 
			                                <form action="deleteReply" method="get" class="row">
			                                    <div class="col-md-1">
			                                        <i class="fas fa-arrow-right"></i>
			                                    </div>
			                                    <!-- 대댓 구역 -->
			                                    <div class="col-md-11">
			                                        <!-- 대댓1 -->
			                                        <div class="row border" style="font-size:14px; padding: 0px;">
			                                            <div class="col-md-2" style="width:100px;">
			                                                <div>"<c:out value="${reReply.writerId.partyId}" />" 님의 <br> 답글</div>
			                                            </div>
			                                            <div class="col-md-10" style="padding: 10px 5px 10px 20px;">
			                                                <div><c:out value="${reReply.content}" /></div>
			                                                <input type="hidden" name="cri" value="${cri}"/>
															<input type="hidden" name="pageId" value="${project.hierId}"/>
															<input type="hidden" name="hid" value="${reReply.hierId}"/>
			                                                <button type="submit" class="btn btn-light border">삭제</button>
			                                            </div>
			                                    	</div>
			                                    </div>
			                                    <br>
			                                </form>
			                                </c:if>
		                             </c:forEach>
                             </c:forEach>
                                <br>
                            </div>
                            <div class="tab-pane fade" id="pills-QandA" role="tabpanel" aria-labelledby="pills-QandA-tab">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">123</div>
                </div>
            </div>
        </div>
    </div>
</body>
