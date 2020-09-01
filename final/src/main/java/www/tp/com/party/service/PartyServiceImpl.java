package www.tp.com.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import www.tp.com.party.model.PartyAddinfoVO;
import www.tp.com.party.model.PartyVO;
import www.tp.com.party.persistence.PartyMapper;
import www.tp.com.proj.model.ProjectVO;

@Service
public class PartyServiceImpl implements PartyService {

	@Setter(onMethod_ = @Autowired)
	PartyMapper partyMapper;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	@Override
	public List<PartyAddinfoVO> selectList() {
		// TODO Auto-generated method stub
		return partyMapper.selectList();
	}

	@Override
	public PartyAddinfoVO selectById(PartyVO party) {
		// TODO Auto-generated method stub
		return partyMapper.selectById(party);
	}

	@Transactional
	@Override
	public int insertParty(PartyAddinfoVO partyAddInfo) {
		// TODO Auto-generated method stub
		if(partyAddInfo != null) {
			partyAddInfo.getParty().setPartyPw(pwencoder.encode(partyAddInfo.getParty().getPartyPw()));
			partyMapper.insertParty(partyAddInfo);
			int cnt = partyMapper.insertPartyAddinfo(partyAddInfo);
			return cnt;
		} else {
			return 0;
		}
	}
	
	@Transactional
	@Override
	public int updateParty(PartyAddinfoVO partyAddInfo) {
		// TODO Auto-generated method stub
		return partyMapper.updateParty(partyAddInfo);
	}
	@Transactional
	@Override
	public int updatePartyAddinfo(PartyAddinfoVO partyAddInfo) {
		// TODO Auto-generated method stub
		return partyMapper.updatePartyAddinfo(partyAddInfo);
	}
	@Transactional
	@Override
	public int deleteParty(PartyAddinfoVO partyAddInfo) {
		// TODO Auto-generated method stub
		return partyMapper.deleteParty(partyAddInfo);
	}
	@Transactional
	@Override
	public int deletePartyAddinfo(PartyAddinfoVO partyAddInfo) {
		// TODO Auto-generated method stub
		return partyMapper.deletePartyAddinfo(partyAddInfo);
	}

	@Override
	public int idCheck(PartyVO party) {
		return partyMapper.idCheck(party);
	}
	
	@Override
	public List<PartyVO> findByWaiter(String partyId) {
		return partyMapper.findByWaiter(partyId);
	}
	
}
