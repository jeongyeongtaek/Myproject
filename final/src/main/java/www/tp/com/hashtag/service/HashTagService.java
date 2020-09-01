package www.tp.com.hashtag.service;

import java.util.List;

public interface HashTagService {
	/** 주어진 문장에서 Komoran을 이용하여 HashTag로 사용될만한 단어들을 추출해 줍니다*/
	public List<String> extractHashTag(String strToAnalyze);
}
