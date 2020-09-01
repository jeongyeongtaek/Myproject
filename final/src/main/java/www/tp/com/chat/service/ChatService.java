package www.tp.com.chat.service;

import java.util.List;

import www.tp.com.chat.model.ChatMessageVO;
import www.tp.com.chat.model.ChatRoomParticipantVO;
import www.tp.com.chat.model.ChatRoomVO;
import www.tp.com.party.model.PartyVO;

public interface ChatService {
	
	// 채팅방 만들기
	public void createChatRoom(ChatRoomVO chatRoom);
	// 채팅방 리스트 가져오기
	public List<ChatRoomVO> getChatRoomList(PartyVO party);
	// 채팅방 초대하기
	public void inviteChatRoom(ChatRoomVO chatRoom);
	// 채팅방 참여하기
	public void joinChatRoom(ChatRoomParticipantVO participant);
	// 채팅방 나가기
	public void outChatRoom(ChatRoomParticipantVO participant);
	// 메시지 리스트 가져오기
	public List<ChatMessageVO> getMessageList(ChatRoomVO chatRoom);
	// 메시지 보내기
	public void sendMessage(ChatMessageVO message);
	
}
