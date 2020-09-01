package www.tp.com.chat.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import www.tp.com.chat.model.ChatMessageVO;
import www.tp.com.chat.model.ChatRoomParticipantVO;
import www.tp.com.chat.model.ChatRoomVO;
import www.tp.com.chat.service.ChatService;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.service.PartyService;

@Controller
@RequestMapping("/board/chatroom/*")
public class ChatController {
	
	@Setter(onMethod_ = @Autowired)
	private ChatService chatService;
	
	@Setter(onMethod_ = @Autowired)
	private PartyService partyService;
	
	
	@GetMapping("/list")
	public void chatRoomList(PartyVO party, Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		party = new PartyVO(user.getUsername());
		
		model.addAttribute("partyId", party.getPartyId());
		model.addAttribute("chatRoomList", chatService.getChatRoomList(party));
		
	}
	
	
	@GetMapping("/message")
	public void chat(@RequestParam("chatRoomId") String chatRoomId, Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PartyVO party = new PartyVO(user.getUsername());
		
		ChatRoomVO chatRoom = new ChatRoomVO();
		chatRoom.setChatRoomId(chatRoomId);
		
		model.addAttribute("partyId", party.getPartyId());
		model.addAttribute("chatRoomId", chatRoomId);
		model.addAttribute("messageList", chatService.getMessageList(chatRoom));
		
	}
	
	@GetMapping("/createChatRoom")
	public String createChatRoom(@RequestParam("chatRoomName") String chatRoomName) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PartyVO party = new PartyVO(user.getUsername());
		
		ChatRoomVO chatRoom = new ChatRoomVO();
		ChatRoomParticipantVO participant = new ChatRoomParticipantVO();
		ChatMessageVO chatMessage = new ChatMessageVO();
		
		chatRoom.setChatRoomName(chatRoomName);
		chatService.createChatRoom(chatRoom);
		
		participant.setChatRoomId(chatRoom.getChatRoomId());
		participant.setPartyId(party.getPartyId());
		
		chatService.joinChatRoom(participant);
		
		chatMessage.setChatRoomId(chatRoom.getChatRoomId());
		chatMessage.setMessage("채팅방이 개설되었습니다.");
		chatMessage.setPartyId("system");
		chatMessage.setMessageSendTime(Timestamp.valueOf(LocalDateTime.now()));
		
		chatService.sendMessage(chatMessage);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/inviteChatRoom")
	public String inviteChatRoom(@RequestParam("chatRoomId") String chatRoomId, @RequestParam("partyId") String partyId) {
		
		PartyVO party = new PartyVO(partyId);
		int idCheck = partyService.idCheck(party);
		if(idCheck == 0) {
			return "redirect:/";
		}
		
		ChatRoomParticipantVO participant = new ChatRoomParticipantVO();
		ChatMessageVO chatMessage = new ChatMessageVO();
		
		participant.setChatRoomId(chatRoomId);
		participant.setPartyId(partyId);
		
		chatService.joinChatRoom(participant);
		
		chatMessage.setChatRoomId(chatRoomId);
		chatMessage.setMessage("'" + partyId + "'님이 초대되었습니다.");
		chatMessage.setPartyId("system");
		chatMessage.setMessageSendTime(Timestamp.valueOf(LocalDateTime.now()));
		
		chatService.sendMessage(chatMessage);
		
		return "redirect:/";
		
	}
}
