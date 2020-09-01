package www.tp.com.party.service;
		
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PartyServiceTest {
	@Setter(onMethod_ = @Autowired)
	private PartyService partyService;
	
//	@Test
	public void test() {
		System.out.println("============================");
		log.info(partyService);
		System.out.println("============================");
	}

	/** 
	 * tbl_party내용 가져오기
	 * */

	//	@Test
	public void selectTest() {
		List<PartyAddinfoVO> list = partyService.selectList();
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
		PartyAddinfoVO partyAddinfo = partyService.selectById(party);
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

				partyAddInfo.getParty().setPartyId("star11");
				partyAddInfo.getParty().setPartyPw("1111");
				partyAddInfo.getParty().setName("산다라박");
				partyAddInfo.setPartyInfoId(party.getPartyId());
				partyAddInfo.setEmail("prjs12@naver.com");
				partyAddInfo.setPhoneNum("01056781234");
				partyAddInfo.setParty(party);
				
				partyService.insertParty(partyAddInfo);
		} catch (Exception e) {

		}
	}
	
	/**
	 * 아이디 삭제
	 * */
//	@Test
	public void test_3_deleteParty() {
		try {
			PartyVO party = new PartyVO("realzz3");
			PartyAddinfoVO partyAddInfo = new PartyAddinfoVO(party,party.getPartyId());
			
			partyService.deleteParty(partyAddInfo);
			partyService.deletePartyAddinfo(partyAddInfo);
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
			
			partyService.updateParty(partyAddInfo);
			partyService.updatePartyAddinfo(partyAddInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void test_2222_Idcheck() {
		try {
			PartyVO party = new PartyVO();
			party.setPartyId("user");
			
			int result = partyService.idCheck(party);
			
			System.out.println(result);
		} catch (Exception e) {

		}
	}
}
