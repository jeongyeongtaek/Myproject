package www.tp.com.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomVO {
	private String chatRoomId;
	private String chatRoomName;
	
	private ChatMessageVO lastMessage;
}
