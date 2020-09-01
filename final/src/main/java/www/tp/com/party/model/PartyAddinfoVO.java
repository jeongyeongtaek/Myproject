package www.tp.com.party.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyAddinfoVO {
	
	private String partyInfoId;
	private String email; //
	private String phoneNum; //
	
	
	public PartyAddinfoVO(String partyInfoId) {
		super();
		this.partyInfoId = partyInfoId;
	}

	private PartyVO party;

	public PartyAddinfoVO(PartyVO party) {
		super();
		this.party = party;
	}

	public PartyAddinfoVO(PartyVO party, String partyInfoId) {
		super();
		this.party = party;
		this.partyInfoId = partyInfoId;
	}

}
