package www.tp.com.chat.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessageVO extends ChatRoomParticipantVO {
	private String message;
	private Timestamp messageSendTime;
}
