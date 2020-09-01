package www.tp.com.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import www.tp.com.chat.model.ChatMessageVO;
import www.tp.com.chat.model.ChatRoomParticipantVO;
import www.tp.com.chat.model.ChatRoomVO;
import www.tp.com.chat.persistence.ChatMapper;
import www.tp.com.party.model.PartyVO;

@Service
@Log4j
public class ChatServiceImpl implements ChatService {
	
	@Setter(onMethod_ = @Autowired)
	private ChatMapper chatMapper;

//	채팅방 만들기
	@Override
	public void createChatRoom(ChatRoomVO chatRoom) {
		log.info("createChatRoom......" + chatRoom);
		
		chatMapper.createChatRoom(chatRoom);
	}
	
//	채팅방 리스트 가져오기
	@Override
	public List<ChatRoomVO> getChatRoomList(PartyVO party) {
		log.info("getChatRoomList.......");
		
		return chatMapper.getChatRoomList(party);
	}

//	채팅방 초대하기
	@Override
	public void inviteChatRoom(ChatRoomVO chatRoom) {
		log.info("inviteChatRoom......");
	}

//	채팅방 참여하기
	@Override
	public void joinChatRoom(ChatRoomParticipantVO participant) {
		log.info("joinChatRoom......");
		
		chatMapper.joinChatRoom(participant);
	}

//	채팅방 나가기
	@Override
	public void outChatRoom(ChatRoomParticipantVO participant) {
		log.info("outChatRoom......");
		
		chatMapper.outChatRoom(participant);
	}

//	메시지 리스트 가져오기
	@Override
	public List<ChatMessageVO> getMessageList(ChatRoomVO chatRoom) {
		log.info("getMessageList......");
		
		return chatMapper.getMessageList(chatRoom);
	}

//	메시지 보내기
	@Override
	public void sendMessage(ChatMessageVO message) {
		log.info("sendMessage......");
		
		chatMapper.sendMessage(message);
	}
	
}
