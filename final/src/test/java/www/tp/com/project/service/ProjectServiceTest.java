package www.tp.com.project.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import www.tp.com.hashtag.model.HashTagVO;
import www.tp.com.hashtag.persistence.HashTagMapper;
import www.tp.com.hashtag.service.HashTagService;
import www.tp.com.party.model.PartyAddinfoVO;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.page.model.Criteria;
import www.tp.com.proj.model.AreaVO;
import www.tp.com.proj.model.ProjAddInfo;
import www.tp.com.proj.model.ProjectVO;
import www.tp.com.proj.model.ReplyVO;
import www.tp.com.proj.service.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectServiceTest {
	@Setter(onMethod_ = @Autowired)
	private ProjectService projectService;

	@Setter(onMethod_ = @Autowired)
	private HashTagMapper hashTagMapper;

//   @Test //@Autowired 로 바인딩 다됐는지 확인
	public void test() {
		System.out.println("=====================================");
		System.out.println(projectService);
		System.out.println("=====================================");
	}

	/**
	 * 태그로 검색하기
	 */
 //  @Test
	public void test_map_prj_tag_search() {
		String searchTag = "콘솔";
		String area = "인천광역시 계양구";
		
		Criteria cri = new Criteria(1, 5);
		List<ProjectVO> result = projectService.searchByTag(cri, searchTag, area);
		result.forEach(project -> {
			System.out.println(project);
		});

	}

	/**
	 * 페이징처리해서 포스트찾기
	 */
 // @Test
	public void test_111_findPostByPage() {
		try {
			Criteria cri = new Criteria(1, 5);
			List<ProjectVO> list = projectService.findAllByPage(cri);
			list.forEach(project -> {
				System.out.println(project);
				System.out.println(project.getWriterId().getPartyId());
			});
			
		} catch (Exception e) {

		}
	}

//	@Test
	public void countSelectProj() {
		try {
			String search = "";
			int cnt = projectService.countTotalProj(search);
			System.out.println("##@@#@#@##@@##@#@#@@#"+cnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 페이징처리로 댓글보기
	 */
//   @Test
	public void test_222_findReplyById() {
		try {
			Criteria cri = new Criteria(2, 20);
			ReplyVO reply = new ReplyVO("5");
			List<ReplyVO> list = projectService.findreplyByIdPage(reply, cri);
			list.forEach(project -> {
				System.out.println(project);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//   @Test
	public void test_222_findProjectAddInfoById() {
		try {
			String id = "j";
			ProjectVO proj = projectService.findAddInfoProject(id);
			System.out.println(proj);
			System.out.println(proj.getProjAddInfo());
		} catch (Exception e) {
			
		}
   }

	/** 프로젝트 정보 insert */
//	@Test
	public void test_2222_insertProject() {
		try {
			AreaVO area = new AreaVO();
			ProjectVO project = new ProjectVO();
			project.setContent("123123123123123dsafsafsafsㄴ");
			project.setProjTitle("control");
			area.setA1("인천광역시");

			area.setB1("경기도");
//			list.add(area.getA());
//			list.add(area.getB());
//			project.setAreaA(area.getA());
//			project.setAreaB(area.getB());
//			
//			System.out.println(area.getA());
			
			PartyVO party = new PartyVO();
			party.setPartyId("swings");
			party.setName("문지훈");
			project.setWriterId(party);
			project.setBoardId(1);

			ProjAddInfo projectinfo = new ProjAddInfo();
			projectinfo.setIntrodution("소개소개소개");
			projectinfo.setMotivation("계기계기계기");

			projectinfo.setMotto("모토모토모토.");
			projectinfo.setPlan("프로젝트 게획ㅇ111112323~");

			String inputdate = "2020.10.18";

			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
			Date endDate = dateFormat.parse(inputdate);

			projectinfo.setDeadline(endDate);
			// 마감일 넣어야함
			project.setProjAddInfo(projectinfo);
			
			projectService.insertProject(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 정보 insert */
 //   @Test
	public void test_1111_insertReply() {
		try {
			ReplyVO reply = new ReplyVO();
			reply.setContent("댓글을 적어봅니다.");

			PartyVO party = new PartyVO();
			party.setPartyId("prjs12");
			party.setName("김종수");
			reply.setWriterId(party);

			ReplyVO parent = new ReplyVO();
			parent.setHierId("M");
			reply.setParent(parent);

			projectService.insertReply(parent, reply);
			System.out.println("============================");
			System.out.println(reply.getHierId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** delete */
//    @Test
	public void test_4444_deleteReply() {
		try {
			ReplyVO reply = new ReplyVO();
			reply.setHierId("E-G");
			projectService.deleteReply(reply);
		} catch (Exception e) {

		}
	}

//    @Test
	public void test_7777_deleteProject() {
		try {
			ReplyVO reply = new ReplyVO();
			reply.setHierId("M");
			projectService.deleteProject(reply);
			
		} catch (Exception e) {

		}
	}

	/** 프로젝트 상세 정보 update */

	/** 프로젝트 기본정보 update */
//    @Test
	public void test_1111_updateProject() {
		try {
			ProjectVO project = new ProjectVO();
			project.setHierId("C");
			project.setContent("변경내용이다");
			project.setProjTitle("변경제목이다");
			project.setAreaA("강원도 원주시");
			project.setAreaB("경기도 고양시");
			projectService.updateProject(project);
		} catch (Exception e) {

		}
	}

	/** 프로젝트 댓글 update */
//    @Test
	public void test_5555_updateReply() {
		try {
			ReplyVO reply1 = new ReplyVO();
			reply1.setHierId("C");

			ReplyVO reply2 = new ReplyVO();
			reply2.setParent(reply1);
			reply2.setHierId("2-3");
			reply2.setContent("222변경변경변경");
			projectService.updateReply(reply2);
		} catch (Exception e) {

		}
	}

	/** 프로젝트 상세정보 update */
//    @Test
	public void test_5555_updateAddInfoProject() {
		try {

			ProjectVO project = new ProjectVO();
			ProjAddInfo addinfo = new ProjAddInfo();
			project.setHierId("2");

			addinfo.setMotivation("심심풀이");
			addinfo.setIntrodution("dddddd");
			addinfo.setIntrodution("dddddd");

			addinfo.setMotto("motto");
			addinfo.setPlan("plan");

			addinfo.setPlan("프로젝트 게획ㅇ111112323~");

			String inputdate = "2020.10.18";
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
			Date endDate = dateFormat.parse(inputdate);
			addinfo.setDeadline(endDate);

			project.setProjAddInfo(addinfo);
			System.out.println("-------------- : " + addinfo);
			projectService.updateAddInfoProject(project);
		} catch (Exception e) {

		}
	}

	// owner와 member가 프로젝트에 가입할때 매퍼테이블 삽입
//  @Test
	public void test_66_insertmapProjParty() {
		try {
			ProjectVO project = new ProjectVO();
			PartyVO party = new PartyVO();
			party.setPartyId("test");

			project.setHierId("S");
			project.setWriterId(party);

//        projectMapper.insertProjOwnerType(project);
			projectService.insertProjMemberType(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 수락 누르면 대기상태에서 join상태로
//  @Test
	public void test_66_updatemapProjParty() {
		try {
			ProjectVO project = new ProjectVO();
			PartyVO party = new PartyVO();
			party.setPartyId("test");

			project.setHierId("S");
			project.setWriterId(party);

			projectService.updateJoinState(project, party);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void test_updateLikes() {
		ProjectVO project = new ProjectVO("h");
		projectService.updateLikes(project);
	}

}