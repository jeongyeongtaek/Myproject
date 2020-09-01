package www.tp.com.party.persistence;
		
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import www.tp.com.party.model.PartyAddinfoVO;
import www.tp.com.party.model.PartyVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Log4j
public class PartyMapperTest {
	@Setter(onMethod_ = @Autowired)
	private PartyMapper partyMapper;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	/** 
	 * tbl_party내용 가져오기
	 * */
	
//	@Test
	public void test() {
		System.out.println("============================");
		log.info(partyMapper);
		
		System.out.println("============================");
	}
//	@Test
	public void selectTest() {
		List<PartyAddinfoVO> list = partyMapper.selectList();
		for(int i=0; i<list.size(); i++) {
			log.info(list);
		}
		
	}

	/** 
	 * tbl_party와 tbl_party_add_info 의 내용 합쳐서 가져오기
	 * 필요시 쿼리문 수정하면 됨
	 * */
//	@Test
	public void selectById() {
		PartyVO party = new PartyVO("prjs123");
		PartyAddinfoVO partyAddinfo = partyMapper.selectById(party);
		log.info(partyAddinfo);
	}
	
	/**
	 * 회원가입 한다는 가정
	 *  */
//	@Test
	public void test_2_insertParty() {
		try {
			PartyVO party = new PartyVO();
			PartyAddinfoVO partyAddInfo = new PartyAddinfoVO(party);

				partyAddInfo.getParty().setPartyId("user");
				partyAddInfo.getParty().setPartyPw("1234");
				partyAddInfo.getParty().setName("김유저");
				partyAddInfo.setPartyInfoId(party.getPartyId());
				partyAddInfo.setEmail("prjs12@naver.com");
				partyAddInfo.setPhoneNum("010-5678-1234");
				partyAddInfo.setParty(party);
				
				partyMapper.insertParty(partyAddInfo);
				partyMapper.insertPartyAddinfo(partyAddInfo);
		} catch (Exception e) {

		}
	}
	
	/**
	 * 아이디 삭제
	 * */
//	@Test
	public void test_3_deleteParty() {
		try {
			PartyVO party = new PartyVO("realzz");
			PartyAddinfoVO partyAddInfo = new PartyAddinfoVO(party,party.getPartyId());
			
			partyMapper.deleteParty(partyAddInfo);
			partyMapper.deletePartyAddinfo(partyAddInfo);
		} catch (Exception e) {

		}
	}
	
	/**
	 * 아이디 수정
	 * 수정 가능한 내용
	 * party: 비밀번호(Party_pw),이름(name)
	 * party_add_info: 이메일(email), 폰번호(Phone_num)
	 * */
//	@Test
	public void test_4_updateParty() {
		try {
			PartyVO party = new PartyVO("prjs12");
			PartyAddinfoVO partyAddInfo = new PartyAddinfoVO(party,party.getPartyId());
			partyAddInfo.setEmail("update3mail@naver.com");
			partyAddInfo.setPhoneNum("010-3678-9013");
			partyAddInfo.getParty().setPartyPw("updatePw1");
			partyAddInfo.getParty().setName("updateName1");
			
			partyMapper.updateParty(partyAddInfo);
			partyMapper.updatePartyAddinfo(partyAddInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void test_223_insertParty() {
		try {
			PartyVO party = new PartyVO();
			PartyAddinfoVO partyAddInfo = new PartyAddinfoVO(party);

				partyAddInfo.getParty().setPartyId("admin");
				partyAddInfo.getParty().setPartyPw(pwencoder.encode("admin"));
				partyAddInfo.getParty().setName("관리자");
				partyAddInfo.setPartyInfoId(party.getPartyId());
				partyAddInfo.setEmail("prjs12@naver.com");
				partyAddInfo.setPhoneNum("010-5678-1234");
				partyAddInfo.setParty(party);
				
				partyMapper.insertParty(partyAddInfo);
				partyMapper.insertPartyAddinfo(partyAddInfo);
		} catch (Exception e) {

		}
	}
	
	@Test
	public void test_2222_Idcheck() {
		try {
			PartyAddinfoVO partyAddInfo = new PartyAddinfoVO();
			PartyVO party = new PartyVO();
			party.setPartyId("user");
			
			partyAddInfo.setParty(party);
			int result = partyMapper.idCheck(party);
			
			System.out.println(result);
		} catch (Exception e) {

		}
	}

}
