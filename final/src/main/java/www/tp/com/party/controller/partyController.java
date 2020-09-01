package www.tp.com.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import www.tp.com.party.model.PartyAddinfoVO;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.service.PartyService;
import www.tp.com.proj.model.ProjectVO;
import www.tp.com.proj.service.ProjectService;

@Controller
@Log4j
@RequestMapping("/board/party/*")
public class partyController {
	boolean joinState;
	
	@Setter(onMethod_ = @Autowired)
	private PartyService partyService;
	
	@Setter(onMethod_ = @Autowired)
	private ProjectService projectService;
	
//	@GetMapping("/header")
//	public void login(String error, String logout, Model model) {
//		if(error != null) {
//			model.addAttribute("error", "로그인 에러");
//		} 
//		if(logout != null) {
//			model.addAttribute("logout", "로그아웃");
//		}
//	}
	
	@GetMapping("/login")
	public void openLoginModal() {
		
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
	}
	
	@GetMapping("/joinSuccess")
	public String joinSuccess() {
		return "home";
	}
	
	@GetMapping("/logout")
	public void openLogoutPage() {
		
	}
	
	@PostMapping("/logout")
	public String logoutPage() {
		return "/";
	}
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		model.addAttribute("msg", "접근이 거부되었습니다.");
	}
	
	@GetMapping("/partyRegister")
	public void openJoinPage() {
	}
	
	@PostMapping("/partyRegister")
	public String insertJoinPage(PartyVO party, PartyAddinfoVO partyaddinfo, Model model) {
		try {	
		String move = idcheck(party, model);
			
			if(joinState) {
				partyaddinfo.setParty(party);
				partyaddinfo.setPartyInfoId(party.getPartyId());
				partyService.insertParty(partyaddinfo);
			}
			return joinState ? "board/party/joinSuccess" : move;
		} catch (Exception e) {
			return "board/party/partyRegister";
		}
		
	}
	
	@GetMapping("/idcheck")
	public String JoinPage(@RequestParam("name") String id, Model model) {
		PartyVO party = new PartyVO();
		party.setPartyId(id);
		
		String move = idcheck(party, model);
		return move;
	}
	
	public String idcheck(PartyVO party, Model model) {
		int result = partyService.idCheck(party);
		
		if(result == 1) {
			model.addAttribute("msg","중복된 아이디가 있습니다.");
			joinState = false;
			return "board/party/partyRegister";
		} else if(result == 0) {
			model.addAttribute("possibleId", party.getPartyId());
			model.addAttribute("msg","사용 가능한 아이디 입니다.");
			joinState = true;
			return "board/party/partyRegister";
		}
		return "board/party/partyRegister";
	}
	
	@GetMapping("/profile")
	   public void profile(String hierId, Model model) {
	      
	      User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      PartyVO party = new PartyVO(user.getUsername());
	      
	      PartyAddinfoVO partyAdd = partyService.selectById(party);
	      model.addAttribute("party",partyAdd);
	      
	      List<PartyVO> waiter = partyService.findByWaiter(party.getPartyId());
	      model.addAttribute("waiter", waiter);
	      
	      List<ProjectVO> projectOwner = projectService.findByIdOwner(party.getPartyId());
	      model.addAttribute("projO", projectOwner);
	      
	      List<ProjectVO> projectMember = projectService.findByIdMember(party.getPartyId());
	      model.addAttribute("projM", projectMember);
	   }
	
	@PostMapping("/profile") 
		public String joinAllow(@RequestParam("project") ProjectVO project, @RequestParam("party") PartyVO party) {
			projectService.updateJoinState(project, party);
			
			return "redirect:/board/party/profile";
	}
}

	