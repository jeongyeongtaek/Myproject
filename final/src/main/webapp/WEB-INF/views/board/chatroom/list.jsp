<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


</head>

<div class="inbox_people">
	<div class="headind_srch">
        <div class="srch_bar">
        	<form action="../../board/chatroom/createChatRoom">
	            <div class="stylish-input-group">
	                <input name="chatRoomName" type="text" class="search-bar" placeholder="Search">
	                <span class="input-group-addon">
	                    <button type="btn btn-info submit">방 만들기</button>
	                </span>
				</div>
			</form>
        </div>
    </div>
	<div class="inbox_chat">
		<input type="hidden" id="partyId" value="${partyId }">
		<c:forEach items="${chatRoomList}" var="chatRoom">
			<a data-toggle="modal" href="#chatMessage"
				data-remote="../../board/chatroom/message?chatRoomId=${chatRoom.chatRoomId }">
				<div class="chat_list">
					<div class="chat_people">
						<div class="chat_img">
							<img src="https://ptetutorials.com/images/user-profile.png"
								alt="sunil">
						</div>
						<div class="chat_ib">
							<h5>
								<c:out value="${chatRoom.chatRoomName }" />
								<span class="chat_date"><fmt:formatDate
										pattern="MM-dd hh:mm"
										value="${chatRoom.lastMessage.messageSendTime }" /></span>
							</h5>
							<p>
								<c:out value="${chatRoom.lastMessage.message }" />
							</p>
						</div>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</div>

<script>
Date.prototype.format = function(f) {
    if (!this.valueOf()) return " ";

    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var d = this;

    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear();
            case "yy": return (d.getFullYear() % 1000).zf(2);
            case "MM": return (d.getMonth() + 1).zf(2);
            case "dd": return d.getDate().zf(2);
            case "E": return weekName[d.getDay()];
            case "HH": return d.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return d.getMinutes().zf(2);
            case "ss": return d.getSeconds().zf(2);
            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};


String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};
</script>
<script type="text/javascript">
	$(document).on("click",".msg_send_btn",function() {
		sendMessage();
		$('.write_msg').val('')
	});
	
	$(document).on("keydown",".write_msg",function(key) {
		if (key.keyCode == 13) {
	    	sendMessage();
			$('.write_msg').val('')
		}
	});
	
	let sock = new SockJS("http:// :8080/websocket");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	
	// 메시지 전송
	function sendMessage() {
		var msg = {
			    text: $(".write_msg").val(),
			    partyId: $("#partyId").val(),
			    chatRoomId: $("#chatRoomId").val()
			    };
		sock.send(JSON.stringify(msg));
	}
	
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		var data = JSON.parse(msg.data);
		var text = data.text;
		var partyId = data.partyId;
		var date = new Date();
		var dateInfo = date.format('HH:mm | MM-dd');
		
		if(partyId == $("#partyId").val()){
			$(".msg_history").append("<div class='outgoing_msg'>"+
			        	"<div class='sent_msg'>"+
			            "<p>"+text+"</p>"+
			            "<span class='time_date'> "+dateInfo+"</span></div></div>")
		    .stop()
		    .animate({ scrollTop: $('.msg_history')[0].scrollHeight }, 1000);
		}else {
			$(".msg_history").append("<div class='incoming_msg_img'>"+
		        	"<img src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div>"+
		        	"<div class='received_msg'><div class='received_withd_msg'>"+
		        	partyId +"<div class='received_withd_msg'>"+
		            "<p>"+text+"</p>"+
		            "<span class='time_date'> "+dateInfo+"</span></div></div></div>")
		    .stop()
		    .animate({ scrollTop: $('.msg_history')[0].scrollHeight }, 1000);
		}
	}
	
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$(".msg_history").append("<div class='outgoing_msg'>"+
		        	"<div class='sent_msg'>"+
		            "<p>서버오류</p>"+
		            "<span class='time_date'> "+dateInfo+"</span></div></div>")
		.stop()
		.animate({ scrollTop: $('.msg_history')[0].scrollHeight }, 1000);
	
	}
</script>


</html>