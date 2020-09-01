package www.tp.com.proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import www.tp.com.hashtag.model.HashTagVO;
import www.tp.com.hashtag.persistence.HashTagMapper;
import www.tp.com.hashtag.service.HashTagService;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.page.model.Criteria;
import www.tp.com.proj.model.ProjAddInfo;
import www.tp.com.proj.model.ProjectVO;
import www.tp.com.proj.model.ReplyVO;
import www.tp.com.proj.persistence.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Setter(onMethod_ = @Autowired)
	private ProjectMapper projectMapper;
	
	@Setter(onMethod_ = @Autowired)
	private HashTagMapper hashTagMapper;
	
	@Setter(onMethod_ = @Autowired)
	private HashTagService hashTagService;
	
	@Override
	public List<ProjectVO> findByIdMember(String partyId) {
		// TODO Auto-generated method stub
		return projectMapper.findByIdMember(partyId);
	}

	@Override
	public List<ProjectVO> findByIdOwner(String partyId) {
		// TODO Auto-generated method stub
		return projectMapper.findByIdOwner(partyId);
	}
	
	
	@Override
	public int countTotalProj(String searchTag) {
		int cnt = projectMapper.countTotalProj(searchTag);
		return cnt;
	}
	
	@Override
	public List<ProjectVO> searchByTag(Criteria cri, String searchTag, String area) {
		// TODO Auto-generated method stub
		return projectMapper.searchByTag(cri, searchTag, area);
	}
	
	@Override
	public List<ProjectVO> searchByTagLike(Criteria cri, String searchTag, String area) {
		return projectMapper.searchByTagLike(cri, searchTag, area);
	}


	@Override
	public List<ReplyVO> findProjAll(Criteria cri) {
		// TODO Auto-generated method stub
		return projectMapper.findProjAll(cri);
	}


	@Override
	public ProjectVO findAddInfoProject(String hid) {
		
		return projectMapper.findAddInfoProject(hid); 
	}


	@Override
	public List<ReplyVO> findReplyById(ReplyVO reply) {
		// TODO Auto-generated method stub
		return projectMapper.findReplyById(reply);
	}


	@Override
	public List<ReplyVO> findreplyByIdPage(ReplyVO reply, Criteria cri) {
		// TODO Auto-generated method stub
		return projectMapper.findreplyByIdPage(reply, cri);
	}


	@Override
	public List<ProjectVO> findAllByPage(Criteria cri) {
		// TODO Auto-generated method stub
		return projectMapper.findAllByPage(cri);
	}


	@Override
	public int insertReply(ReplyVO parent, ReplyVO reply) {
		int cnt = projectMapper.insertReply(parent, reply);
		updateRelationBetweenHashTag(reply);
		return cnt;
	}


	@Override
	public int insertProject(ProjectVO project) {
		// TODO Auto-generated method stub
		
		int cnt = projectMapper.insertProject(project);
		projectMapper.insertProjectAddInfo(project);
		projectMapper.insertProjOwnerType(project);
		updateRelationBetweenHashTag(project);
		updateRelationBetweenArea(project);
		
		return cnt;
	}

	@Override
	public void insertProjMemberType(ProjectVO project) {
		// TODO Auto-generated method stub
		projectMapper.insertProjMemberType(project);
		
	}


	@Override
	public void updateProject(ProjectVO project) {
		// TODO Auto-generated method stub
		hashTagMapper.deleteMapBetweenReply(project.getHierId());
		updateRelationBetweenHashTag(project);
		projectMapper.updateProject(project);
	}


	@Override
	public void updateAddInfoProject(ProjectVO project) {
		// TODO Auto-generated method stub
		projectMapper.updateAddInfoProject(project);
	}


	@Override
	public void updateReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		hashTagMapper.deleteMapBetweenReply(reply.getHierId());
		updateRelationBetweenHashTag(reply);
		projectMapper.updateReply(reply);
	}


	@Override
	public void updateJoinState(ProjectVO project, PartyVO party) {
		// TODO Auto-generated method stub
		projectMapper.updateJoinState(project, party);
		
	}


	@Override
	public void updateLikes(ProjectVO project) {
		// TODO Auto-generated method stub
		projectMapper.updateLikes(project);
	}


	@Override
	public void deleteProject(ReplyVO reply) {
		hashTagMapper.deleteMapBetweenProject(reply);
		projectMapper.deleteProject(reply);
		projectMapper.deleteAddinfo(reply);
		projectMapper.deleteMapPartyProj(reply);
	}

	@Override
	public void deleteReply(ReplyVO reply) {
		projectMapper.deleteReply(reply);
		hashTagMapper.deleteMapBetweenReply(reply.getHierId());
	}
	
	@Override
	public void deleteWaitState(String hierId, String partyId) {
		projectMapper.deleteWaitState(hierId, partyId);
		
	}
	
	  /** 게시물과 HashTag 사이의 관계 정보 수정 */
	   private void updateRelationBetweenHashTag(ReplyVO reply) {
	      String strToAnalyze = reply.getHashTagTargetContent();
	      for (String str : hashTagService.extractHashTag(strToAnalyze)) {
	         HashTagVO hashTagVO = new HashTagVO();
	         hashTagVO.setName(str);
	         reply.addHashTag(hashTagVO);   // reply <- 현재 작성한 글에 모든 해쉬태그
	      }
	      
	      /* 현재 입력하고자 하는 게시글에 등재된 Hash Tag 중에 
	       * tbl_hash_tag 테이블에서 관리 중인 목록 찾기 */ 
	      List<HashTagVO> newHashTagList = hashTagMapper.findExists(reply.getListHashTag());
	      // listFound <- 현재 작성한 글에 모든 해쉬태그 중 테이블에 있는 내용과 겹치는 해쉬태그 (*기존 해쉬태그)
	      
	      /* 현재 입력하고자 하는 게시글에 등재된 Hash Tag 중에 
	       * 새롭게 만들어야 할 Hash Tag목록을 구하기 */ 
	      reply.getListHashTag().removeAll(newHashTagList);   // reply <- 현재 작성한 글에서 기존 해쉬태그를 뺀 해쉬태그 (*새로운 해쉬태그)   
	      for (HashTagVO createTarget : reply.getListHashTag()) {
	         hashTagMapper.insertHashTag(createTarget);
	      }
	      
	      reply.getListHashTag().addAll(newHashTagList); // reply <- 현재 작성한 글에 모든 해쉬태그
	      List<HashTagVO> hashTagingListFound = hashTagMapper.findExists(reply.getListHashTag());
	      
	      /* 기존 관리 항목 및 신규 입력 항목 전체 연결고리 작업을 수행 */
	      for (HashTagVO createTarget : hashTagingListFound) {
	            hashTagMapper.insertMapBetweenReply(reply.getHierId(), createTarget,createTarget.getType());
	      }
	   }
	   
	   private void updateRelationBetweenArea(ProjectVO project) {
			List<String> listarea = new ArrayList<>();
			listarea.add(project.getAreaA());
			listarea.add(project.getAreaB());
			
			HashTagVO hash = new HashTagVO();
			for (int i = 0; i < listarea.size(); i++) {
				HashTagVO hashTag = new HashTagVO();
				hashTag.setType("L");
				hashTag.setName(listarea.get(i));
				hash = hashTagMapper.findExistsByArea(hashTag.getName());
				if(hash == null) {
					hashTagMapper.insertHashTag(hashTag);
					hashTagMapper.insertMapBetweenReply(project.getHierId(), hashTag, hashTag.getType());
				}else {
					hashTagMapper.insertMapBetweenReply(project.getHierId(), hash, hashTag.getType());
				}
				
			}
		}
}
