package www.tp.com.proj.persistence;

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
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.page.model.Criteria;
import www.tp.com.proj.model.AreaVO;
import www.tp.com.proj.model.ProjAddInfo;
import www.tp.com.proj.model.ProjectVO;
import www.tp.com.proj.model.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectMapperTest {
   @Setter(onMethod_ = @Autowired)
   private ProjectMapper projectMapper;
   
   @Setter(onMethod_ = @Autowired)
   private HashTagService hashTagService;

   @Setter(onMethod_ = @Autowired)
   private HashTagMapper hashTagMapper;

//   @Test //@Autowired 로 바인딩 다됐는지 확인
   public void test() {
      System.out.println("=====================================");
      System.out.println(projectMapper);
      System.out.println(hashTagService);
      System.out.println(hashTagMapper);
      System.out.println("=====================================");
   }
   
   /**
    * 태그로 검색하기
    * */
//   @Test
   public void test_map_prj_tag_search() {
      String searchTag = "콘솔";
      String area = "인천시 계양구";
      Criteria cri = new Criteria(1, 5);
     // List<ProjectVO> result = projectMapper.searchByTag(cri, searchTag, area);
//      result.forEach(project->{
//    	  System.out.println(project);
//      });
      
   }
   /**
    * 페이징처리해서 포스트찾기
    * */
//   @Test
   public void test_111_findPostByPage() {
      try {
         Criteria cri = new Criteria(1, 1);
         List<ProjectVO> list = projectMapper.findAllByPage(cri);
         list.forEach(project ->{
            System.out.println(project);
         });
      }catch(Exception e) {
         
      }
   }
   /**
    * 페이징처리로 댓글보기
    * */
//   @Test
   public void test_222_findReplyById() {
      try {
         Criteria cri = new Criteria(2,20);
         ReplyVO reply = new ReplyVO("5");
         List<ReplyVO> list = projectMapper.findreplyByIdPage(reply,cri);
         list.forEach(project ->{
            System.out.println(project);
         });
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

   /** 프로젝트 정보 insert */
//    @Test
   public void test_2222_insertProject() {
      try {
         List<String> list = new ArrayList<String>();
    	 AreaVO area = new AreaVO();
         ProjectVO project = new ProjectVO();
         project.setContent("테스트 내용");
         project.setProjTitle(" 콘솔창에 결과가 찍히는 로또프로그램을 만들어보았습니다 new new");
//         area.setA1("서울 특별시");
//         area.setA2("강동구");
//        
//         area.setB1("경기도");
//         area.setB2("파주시");
//         list.add(area.getA());
//         list.add(area.getB());
         PartyVO party = new PartyVO();
         party.setPartyId("prjs12");
         party.setName("김종수");
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
         for(int i=0; i<list.size(); i++) {
        	 HashTagVO hashTag = new HashTagVO();
        //	 hashTag.setName(project.getArea().get(i));
        	 hashTagMapper.insertHashTag(hashTag);
         }
         projectMapper.insertProject(project);
         projectMapper.insertProjectAddInfo(project);
         
         
         } catch (Exception e) {
        	 e.printStackTrace();
      }
   }

   /** 댓글 정보 insert */
//    @Test
   public void test_1111_insertReply() {
      try {
         ReplyVO reply = new ReplyVO();
         reply.setContent("처음에는 파라미터가 전달 안되는 걸로만 알고");

         PartyVO party = new PartyVO();
         party.setPartyId("prjs12");
         party.setName("김종수");
         reply.setWriterId(party);

         ReplyVO parent = new ReplyVO();
         parent.setHierId("2");
         reply.setParent(parent);
         
         projectMapper.insertReply(parent, reply);
         System.out.println("============================");
         System.out.println(reply.getHierId());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /** 프로젝트 및 댓글 delete */
    @Test
   public void test_4444_deleteReply() {
      try {
         ReplyVO reply = new ReplyVO();
         reply.setHierId("2-O");
         projectMapper.deleteReply(reply);
         hashTagMapper.deleteMapBetweenReply(reply.getHierId());
      } catch (Exception e) {

      }
   }

    @Test
   public void test_7777_deleteProject() {
      try {
         ReplyVO reply = new ReplyVO();
         reply.setHierId("5");
         projectMapper.deleteProject(reply);
         hashTagMapper.deleteMapBetweenReply(reply.getHierId());
      } catch (Exception e) {

      }
   }
//    @Test
   public void test_7777_deleteAddinfo() {
      try {
         ProjectVO project = new ProjectVO("2");
         projectMapper.deleteAddinfo(project);
      } catch (Exception e) {
         
      }
   }

   /** 프로젝트 상세 정보 update */

   /** 프로젝트 기본정보 update */
//    @Test
   public void test_1111_updateProject() {
      try {
         ProjectVO project = new ProjectVO();
         project.setHierId("2");
         project.setContent("변경내용이다");
         project.setProjTitle("변경제목이다");

         projectMapper.updateProject(project);
      } catch (Exception e) {

      }
   }

   /** 프로젝트 댓글 update */
//    @Test
   public void test_5555_updateReply() {
      try {
         ReplyVO reply1 = new ReplyVO();
         reply1.setHierId("2");

         ReplyVO reply2 = new ReplyVO();
         reply2.setParent(reply1);
         reply2.setHierId("2-3");
         reply2.setContent("222변경변경변경");
         projectMapper.updateReply(reply2);
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
         projectMapper.updateAddInfoProject(project);
      } catch (Exception e) {

      }
   }
   
   //owner와 member가 프로젝트에 가입할때 매퍼테이블 삽입
//  @Test
  public void test_66_insertmapProjParty() {
     try {
        ProjectVO project = new ProjectVO();
        PartyVO party = new PartyVO();
        party.setPartyId("test");
        
        project.setHierId("S");
        project.setWriterId(party);
        
//        projectMapper.insertProjOwnerType(project);
        projectMapper.insertProjMemberType(project);
     } catch (Exception e) {
        e.printStackTrace();
     }
  }
  
  //수락 누르면 대기상태에서 join상태로
//  @Test
  public void test_66_updatemapProjParty() {
     try {
        ProjectVO project = new ProjectVO();
        PartyVO party = new PartyVO();
        party.setPartyId("test");
        
        project.setHierId("S");
        project.setWriterId(party);
        
        projectMapper.updateJoinState(project, party);
     } catch (Exception e) {
        e.printStackTrace();
     }
  }
//	@Test
  public void test_updateLikes() {
	  ProjectVO project = new ProjectVO("2");
	  projectMapper.updateLikes(project);
  }
 
}