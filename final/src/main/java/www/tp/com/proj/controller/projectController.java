package www.tp.com.proj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.page.model.Criteria;
import www.tp.com.party.page.model.pageVO;
import www.tp.com.proj.model.AreaVO;
import www.tp.com.proj.model.ProjAddInfo;
import www.tp.com.proj.model.ProjectVO;
import www.tp.com.proj.model.ReplyVO;
import www.tp.com.proj.service.ProjectService;


@Controller
@AllArgsConstructor
@RequestMapping("/board/proj/*")
public class projectController {
	ProjectService projectservice;
	
	
	@GetMapping("/registerProject")
	public void openRegisterProject() {
		
	}
	
	@GetMapping("likeUp")
	public String likeUp(String hierId) {
		ProjectVO project = new ProjectVO();
		project.setHierId(hierId);
		projectservice.updateLikes(project);
		return "redirect:/board/proj/findById?hierId="+hierId;
	}
	
	@GetMapping("/application")
	public void application(String hierId) {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			PartyVO party = new PartyVO(user.getUsername());
			ProjectVO project = new ProjectVO();
			project.setWriterId(party);
			project.setHierId(hierId);
			
			projectservice.insertProjMemberType(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/registerProject")
	public String registerProject(ReplyVO reply, ProjectVO project, ProjAddInfo projaddinfo, String projAreaA, String projAreaB) {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			PartyVO party = new PartyVO(user.getUsername());
			
			project.setProjAddInfo(projaddinfo);
			project.setWriterId(party);
			project.setAreaA(projAreaA);
			project.setAreaB(projAreaB);
			project.setBoardId(1);
			project.setProjTitle(project.getProjTitle());
			projectservice.insertProject(project);
			
			return "redirect:/board/proj/projectList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

	@GetMapping("/findById")
	   public String findById(@RequestParam("hierId") ReplyVO reply, @ModelAttribute("cri") Criteria cri, Model model) {
	      model.addAttribute("project", projectservice.findAddInfoProject(reply.getHierId()));
	      
	        ReplyVO reReply = new ReplyVO();
		    reReply.setParent(reply);
			List<ReplyVO> listReply = projectservice.findReplyById(reReply.getParent());
			
			model.addAttribute("reply", listReply);
			
			List<ReplyVO> listRereply = new ArrayList<>();
			for (ReplyVO x : listReply) {
				listReply = projectservice.findReplyById(x);
				listRereply.addAll(listReply);
			}
			
			model.addAttribute("reReply", listRereply);
			
	      return "board/proj/detailProject";
	   }
	
	@PostMapping("/findById")
	public String replyProject(@RequestParam("hid") ReplyVO reply, @RequestParam("pageId") ReplyVO page, PartyVO party, String reContent, Criteria cri) {
			try {
				ReplyVO replyinfo;
				User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				party.setPartyId(user.getUsername());
				replyinfo = new ReplyVO();
				replyinfo.setContent(reContent);
				replyinfo.setWriterId(party);
				
				projectservice.insertReply(reply, replyinfo);

				return "redirect:/board/proj/findById?pageNum=" + cri.getPageNum() + "&amount=" 
					+ cri.getAmount() + "&hierId=" + page.getHierId();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "board/proj/projectList";
	}
	
	
	@GetMapping("/searchProject")
	public String searchProject(String area, String sortBy, String search, Criteria cri, Model model) {
		//프로젝트 총 개수 구하고 페이징 처리	
		int totalProj = totalCountProject(search);
		model.addAttribute("pageMaker", new pageVO(totalProj, cri));
		//지역과 검색어로 검색된 프로젝트 리스트
		if(sortBy.equals("최신순")) {
			List<ProjectVO> list = projectservice.searchByTag(cri, search, area);
			model.addAttribute("listProj", list);
		}
		else if(sortBy.equals("좋아요순")) {
			List<ProjectVO> list = projectservice.searchByTagLike(cri, search, area);
			model.addAttribute("listProj", list);
		}
		return "board/proj/projectList";
	}
	
	@GetMapping("/projectList")
	public void openProjectList(Criteria cri, Model model) {
		String search = "";
		List<ProjectVO> list = projectservice.findAllByPage(cri);
		model.addAttribute("listProj", list);
		int totalProj = totalCountProject(search);
		model.addAttribute("pageMaker", new pageVO(totalProj, cri));
	}
	
	@GetMapping("/deleteReply")
	public String deleteReply(@RequestParam("hid") ReplyVO reply, @RequestParam("pageId") ReplyVO page, Criteria cri) {
		projectservice.deleteReply(reply);
		
		return "redirect:/board/proj/findById?pageNum=" + cri.getPageNum() + "&amount=" + cri.getAmount() + "&hierId=" + page.getHierId();
	}
	
	public int totalCountProject(String search) {
		int totalProj = projectservice.countTotalProj(search);
		return totalProj;
	}
}
