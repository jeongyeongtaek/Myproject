package www.tp.com.chat.persistence;

import java.util.List;

import www.tp.com.chat.model.ChatMessageVO;
import www.tp.com.chat.model.ChatRoomParticipantVO;
import www.tp.com.chat.model.ChatRoomVO;
import www.tp.com.party.model.PartyVO;

public interface ChatMapper {
	
	// 파티가 가지고 있는 채팅방 리스트 출력
	public List<ChatRoomVO> getChatRoomList(PartyVO party);
	// 채팅방 만들기
	public void createChatRoom(ChatRoomVO chatRoom);
	// 채팅방 이름 바꾸기
	public void changeChatRoomName(ChatRoomVO chatRoom);
	// 채팅방 삭제하기 (채팅 리스트 삭제 -> 관계 삭제, 이후에 실행 할 것) 
	public void deleteChatRoom(ChatRoomVO chatRoom);

	// 채팅방과 참여자 관계 추가하기
	public void joinChatRoom(ChatRoomParticipantVO participant);
	// 채팅방과 참여자 관계 삭제하기 (채팅방 나가기)
	public void outChatRoom(ChatRoomParticipantVO participant);
	
	// 방을 기준으로 메시지 리스트 출력
	public List<ChatMessageVO> getMessageList(ChatRoomVO chatRoom);
	// 방을 기준으로 메시지 입력
	public void sendMessage(ChatMessageVO message);
	// 방을 기준으로 채팅 모두 삭제하기 (방이 삭제 될 때 실행)
	public void deleteAllMessage(ChatRoomVO chatRoom);
	
}
