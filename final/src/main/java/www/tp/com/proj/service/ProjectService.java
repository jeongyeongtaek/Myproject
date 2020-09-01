package www.tp.com.proj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.tp.com.hashtag.model.HashTagVO;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.page.model.Criteria;
import www.tp.com.proj.model.BoardVO;
import www.tp.com.proj.model.ProjAddInfo;
import www.tp.com.proj.model.ProjectVO;
import www.tp.com.proj.model.ReplyVO;

public interface ProjectService {
	// 태그로 검색하기
	public List<ProjectVO> searchByTag(Criteria cri, String searchTag, String area);
	public List<ProjectVO> searchByTagLike(Criteria cri, String searchTag, String area);
	
	// 프로젝트 리스트들 검색
	public List<ReplyVO> findProjAll(Criteria cri);
	// 부가정보를 포함한 프로젝트 검색(hid 이용)
	public ProjectVO findAddInfoProject(@Param("hid") String hid);
	// 프로젝트 게시물에 대한 댓글 리스트들 검색(hid 이용)
	public List<ReplyVO> findReplyById(@Param("reply") ReplyVO reply);
//		--------------------------검색-----------------------------

	// 페이징처리
	public List<ReplyVO> findreplyByIdPage(@Param("reply") ReplyVO reply, @Param("cri") Criteria cri);
	public List<ProjectVO> findAllByPage(Criteria cri);
//		--------------------------게시물 보기-------------------------

	// 댓글 insert
	public int insertReply(@Param("parent") ReplyVO parent, @Param("reply") ReplyVO reply);
	// 프로젝트 기본정보,부가정보 insert
	public int insertProject(@Param("project") ProjectVO project);
	// 프로젝트 참여 버튼 누르면 삽입
	public void insertProjMemberType(@Param("project") ProjectVO project);
//	----------------------------------삽입---------------------------------

	// 프로젝트 기본정보 수정
	public void updateProject(@Param("project") ProjectVO project);
	// 프로젝트 추가정보 수정
	public void updateAddInfoProject(@Param("project") ProjectVO project);
	// 댓글 수정
	public void updateReply(@Param("reply") ReplyVO reply);
	// 회원 수락해서 가입상태 join으로 변경
	public void updateJoinState(@Param("project") ProjectVO project, @Param("party") PartyVO party);
	public void updateLikes(@Param("project") ProjectVO project);
//	-----------------------------------수정--------------------------------
	
	// 프로젝트 삭제
	public void deleteProject(@Param("reply") ReplyVO reply);
	// 댓글만 삭제
	public void deleteReply(@Param("reply") ReplyVO reply);
//	------------------------------------삭제---------------------------------
	public int countTotalProj(String searchTag);
	
	
	public List<ProjectVO> findByIdMember(String partyId);
	public List<ProjectVO> findByIdOwner(String partyId);
	
	public void deleteWaitState(String hierId, String partyId);
}
