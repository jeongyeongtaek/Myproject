<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file = "../../includes/header.jsp" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 등록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
        .my-thumnail-size {
            padding: 10px 10px 10px 10px;
            min-width: 200px;
        }
        .thumbnail-wrappper {
            width: 25%;
        }
        .thumbnail {
            position: relative;
            padding-top: 100%; /* 1:1 ratio */
            overflow: hidden;
        } 
        .thumbnail .centered {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            -webkit-transform: translate(50%,50%);
            -ms-transform: translate(50%,50%);
            transform: translate(50%,50%);
        }
        .thumbnail .centered img {
            position: absolute;
            top: 0;
            left: 0;
            max-width: 100%;
            height: auto;
            -webkit-transform: translate(-50%,-50%);
            -ms-transform: translate(-50%,-50%);
            transform: translate(-50%,-50%);
        }
    </style>
</head>


    <!-- content -->
    <div class="container-fluid">
        <!-- align-items-center 수직 중앙 정렬 -->
        <div class="row align-items-center">        
            <!-- 좌측 기본 여백 -->
            <div class="col-md-2 col-0"></div>               
            <!-- 내용이 들어갈 div-->
            <div class="col-md-8 col-12 my-content-bgcolor my-content-box">
                <!-- 메인 content -->
                <div class="row mt-5">
                    <!-- 좌측 여백 -->
                    <div class="col-1"></div>
                    <!-- /좌측 여백 -->

                    <!-- 프로필 -->
                    <div class="col-10">
                        <div class="row">
                            <div class="offset-1">
                                <!-- 썸네일 처리 -->
                                <div class="col-2 my-thumnail-size" style="background-color: teal;">
                                    <div class="thumbnail-wrapper">
                                        <div class="thumbnail">
                                            <div class="centered">
                                                <img src="img/main.jpg">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /썸네일 처리 -->
                            </div>
                            <div class="col-md-6">    <!-- 이름, 이메일 등 -->
                                <br>
                                <div>이름 : ${party.party.name }</div>
                                <br>
                                <div>이메일 : ${party.email }</div>
                            </div>
                            <!-- 필요할 경우 사용 -->
                            <div class="col-md-3"></div>    
                        </div>
                        <br>
                        <hr>
                        <br>
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <a class="nav-item nav-link active" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="true">Profile</a>
                                <a class="nav-item nav-link" id="nav-owner-tab" data-toggle="tab" href="#nav-owner" role="tab" aria-controls="nav-owner" aria-selected="true">Owner</a>
                                <a class="nav-item nav-link" id="nav-member-tab" data-toggle="tab" href="#nav-member" role="tab" aria-controls="nav-member" aria-selected="false">Member</a>
                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                자기소개
                            </div>
                            
                            
                            <div class="tab-pane fade" id="nav-owner" role="tabpanel" aria-labelledby="nav-owner-tab">
	                             <h3>관리중인 프로젝트</h3>
		                            <c:forEach var="proj" items="${projO}">
		                               <a href="/board/proj/findById?hierId=${proj.hierId}">
										<div class="row border">${proj.projTitle }</div></a>
									</c:forEach>
									<br>
									
									<h3>참 여 대 기 인 원</h3>
	                               	<c:forEach var="waiter" items="${waiter}">
	                               	<form action="profile" method="post">
	                               		포로젝트 명 : ${waiter.projTitle } / 대기ID : ${ waiter.partyId }
                               	 		<input type="hidden" name="project" value="${waiter.hierId}">
                               	 		<input type="hidden" name="party" value="${waiter.partyId}">
                               	 		<input type="submit" value="참여확정">
                               	 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	                                </form>
	                        		<br>
	                                </c:forEach>  
							</div>
							
                           	<div class="tab-pane fade" id="nav-member" role="tabpanel" aria-labelledby="nav-member-tab">
                           		 <h3>참여 중인 프로젝트</h3>
		                            <c:forEach var="proj" items="${projM}">
		                               <a href="/board/proj/findById?hierId=${proj.hierId}">
										<div class="row border">${proj.projTitle }</div></a>
									</c:forEach>
                          	</div>
                            
                        </div>
                    </div>
                    <!--  프로필 -->

                </div>
                <!-- /메인 content -->

            </div>
            <!-- /내용이 들어갈 div-->

            <!-- 우측 기본 여백 -->
            <div class="col-md-2 col-0"></div>               
        </div>
    </div>
    <!-- end content -->
</body>
</html>