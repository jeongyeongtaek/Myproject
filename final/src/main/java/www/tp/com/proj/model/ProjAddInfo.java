package www.tp.com.proj.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProjAddInfo {
	private static final char HID_DELI = '-';

	private String projInfoId;
	private String introdution;
	private String motivation;
	private String motto;
	private String plan;
	private Date creation;
	private Date deadline;

	public char getHidDeli() {
		return HID_DELI;
	}
}
