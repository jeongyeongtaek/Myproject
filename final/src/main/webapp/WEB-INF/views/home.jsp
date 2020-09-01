<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ include file="includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- content -->
    <div class="container-fluid">
        <div class="row align-items-center">        <!-- align-items-center 수직 중앙 정렬 -->
            <div class="col-md-2"></div>            <!-- 왼쪽 여백을 위한 div -->
            <div class="col-md-4">
                <h1>REVERSER MOUNTAIN<small>에서</small></h1>
                <h2>당신의 관심과 흥미를</h2>
                <h2>한단계 업그레이드하세요</h2>
                <br>
                <div class="row">
                    <div class="col-md-5"><a type="button" href="board/proj/registerProject" class="btn btn-info btn-lg" style="width: 200px;"><b>내 관심 드러내기</b></a></div>
                    <div class="col-md-5"><a type="button" href="board/proj/projectList" class="btn btn-info btn-lg" style="width: 200px;"><b>관심 참여하기</b></a></div>
                </div>
            </div>
            <div class="col-md-6"><img src="../resources/img/main.jpg" width="85%"></div>        <!-- 이미지 주소 수정 예정 -->
        </div>
    </div>
    <!-- end content -->
</body>
</html>
