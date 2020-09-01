package www.tp.com.proj.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import www.tp.com.hashtag.model.HashTagVO;
import www.tp.com.party.model.PartyVO;

@Data
@NoArgsConstructor
public class ReplyVO {
	private static final char CLS_TYPE = 'R';
	private static final char HID_DELI = '-';
	
	private String hierId;
	private String content;
	
	private ReplyVO parent;
	private PartyVO writerId;
	
	private List<HashTagVO> listHashTag = new ArrayList<>();
	
	public ReplyVO(String hierId) {
		this.hierId = hierId;
	}
	
	public char getHidDeli() {
		return HID_DELI;
	}
	
	public static char getClsType() {
		return CLS_TYPE;
	}

	public String getHashTagTargetContent() {
		if (writerId == null) {
			return content;
		} else {
			return content + " " + writerId.getName();
		}
	}

	public void addHashTag(HashTagVO hashTag) {
		listHashTag.add(hashTag);
	}
}
