<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>프로젝트 등록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<title>Insert title here</title>


</head>
<div class="inbox_msg">
	<div class="headind_srch">
        <div class="srch_bar">
        	<form action="../../board/chatroom/inviteChatRoom">
	            <div class="stylish-input-group">
	                <input name="partyId" type="text" class="search-bar" placeholder="Search">
	                <input type="hidden" name="chatRoomId" value="${chatRoomId }">
	                <span class="input-group-addon">
	                    <button type="btn btn-info submit">초대하기</button>
	                </span>
				</div>
			</form>
        </div>
    </div>
	<div class="mesgs">
		<div id="msg_history" class="msg_history">
			<input type="hidden" id="chatRoomId" value="${chatRoomId }">
			<input type="hidden" id="chatRoomId" value="${partyId }">
			<c:forEach items="${messageList}" var="message">
				<c:if test="${message.partyId == partyId }">
					<div class="outgoing_msg">
						<div class="sent_msg">
							<p>
								<c:out value="${message.message }" />
							</p>
							<span class="time_date"><fmt:formatDate
									pattern="hh:mm | MM-dd" value="${message.messageSendTime }" /></span>
						</div>
					</div>
				</c:if>
				<c:if test="${message.partyId != partyId and message.partyId != 'system'}">
					<div class="incoming_msg">
						<div class="incoming_msg_img">
							<img src="https://ptetutorials.com/images/user-profile.png"
								alt="sunil">
						</div>
						<span><c:out value="${message.partyId}" /></span>
						<div class="received_msg">
							<div class="received_withd_msg">
								<p>
									<c:out value="${message.message }" />
								</p>
								<span class="time_date"><fmt:formatDate
									pattern="hh:mm | MM-dd" value="${message.messageSendTime }" /></span>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${message.partyId == 'system'}">
					<p>
						<c:out value="system : ${message.message }" />
					</p>
				</c:if>
			</c:forEach>
			<div id="messageArea"></div>
		</div>
		<div class="type_msg">
			<div class="input_msg_write">
				<input type="text" class="write_msg" placeholder="Type a message" />
				<button class="msg_send_btn" type="submit">
					<i class="fa fa-paper-plane-o" aria-hidden="true"></i>
				</button>
			</div>
		</div>
	</div>
</div>