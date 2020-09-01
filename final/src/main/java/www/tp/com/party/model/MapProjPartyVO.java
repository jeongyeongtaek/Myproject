package www.tp.com.party.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MapProjPartyVO {

	private String projId;
	private String partyId;
	private String partyType;
	private String joinState;
	
}
