package www.tp.com.websocket.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.Setter;
import www.tp.com.chat.model.ChatMessageVO;
import www.tp.com.chat.service.ChatService;

@RequestMapping("/websocket/*")
public class WebsocketController extends TextWebSocketHandler {
	
	@Setter(onMethod_ = @Autowired)
	private ChatService chatService;
	
	// 세션 리스트
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	private static Logger logger = LoggerFactory.getLogger(WebsocketController.class);
	
	// 클라이언트가 연결 되었을 때 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.info("{} 연결됨", session.getId());
	}
	
	// 클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
		
		JSONParser paser = new JSONParser();
		JSONObject obj = (JSONObject) paser.parse(message.getPayload());
		String chatMessageText = (String) obj.get("text");
		String chatRoomId = (String) obj.get("chatRoomId");
		String partyId = (String) obj.get("partyId");
		
		ChatMessageVO chatMessage = new ChatMessageVO();
		chatMessage.setChatRoomId(chatRoomId);
		chatMessage.setMessage(chatMessageText);
		chatMessage.setPartyId(partyId);
		chatMessage.setMessageSendTime(Timestamp.valueOf(LocalDateTime.now()));
		
		chatService.sendMessage(chatMessage);
		
		// 모든 유저에게 메시지 출력
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(message.getPayload()));
		}

	}
	
	// 클라이언트 연결을 끊었을 때 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} 연결 끊김.", session.getId());
	}
	
}
