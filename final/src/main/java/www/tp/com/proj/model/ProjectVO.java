package www.tp.com.proj.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectVO extends ReplyVO {
	private static final char CLS_TYPE = 'P';
	
	private static final String STATE_JOIN = "join";
	private static final String STATE_WAIT = "wait";
	
	private int boardId;
	private String projTitle;
	private int likes;
	
	private String areaA;
	private String areaB;
	private String creation;
	
	private ProjAddInfo projAddInfo;
	
	
	public ProjectVO(String hierId) {
		super(hierId);
	}
	
	public static char getClsType() {
		return CLS_TYPE;
	}
	
	@Override
	public String getHashTagTargetContent() {
		return super.getHashTagTargetContent() + " " + projTitle;
	}

	public static String getStateJoin() {
		return STATE_JOIN;
	}

	public static String getStateWait() {
		return STATE_WAIT;
	}
}
