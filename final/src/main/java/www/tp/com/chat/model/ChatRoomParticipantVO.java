package www.tp.com.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomParticipantVO {
	private String chatRoomId;
	private String partyId;
}
