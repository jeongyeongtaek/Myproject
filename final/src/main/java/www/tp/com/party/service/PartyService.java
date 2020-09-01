package www.tp.com.party.service;

import java.util.List;

import www.tp.com.party.model.PartyAddinfoVO;
import www.tp.com.party.model.PartyVO;
import www.tp.com.proj.model.ProjectVO;

public interface PartyService {
//	전체 목록 뽑아오기
	public List<PartyAddinfoVO> selectList();
//	Id로 게시판 내용불러오기
	public PartyAddinfoVO selectById(PartyVO party);
	
//  회원가입시 , 기본정보 + 부가정보 삽입	
	public int insertParty(PartyAddinfoVO partyAddInfo);
//
	
//	회원수정시 , 기본정보 + 부가정보 수정
	public int updateParty(PartyAddinfoVO partyAddInfo);
	public int updatePartyAddinfo(PartyAddinfoVO partyAddInfo);
//	
	
//	회원탈퇴시 , 기본정보 + 부가정보 삭제
	public int deleteParty(PartyAddinfoVO partyAddInfo);
	public int deletePartyAddinfo(PartyAddinfoVO partyAddInfo);
//	
	public int idCheck(PartyVO party);
	public List<PartyVO> findByWaiter(String partyId);
	
}
