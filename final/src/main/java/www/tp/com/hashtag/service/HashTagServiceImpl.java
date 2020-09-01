package www.tp.com.hashtag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HashTagServiceImpl implements HashTagService {
	private static Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

	@Override
	public List<String> extractHashTag(String strToAnalyze) {
		List<String> ret = new ArrayList<>();
		
		KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);
		List<Token> tokenList = analyzeResultList.getTokenList();
		for (Token token : tokenList) {
			if (token.getPos().startsWith("NN") || token.getPos().equals("SL")) {
				ret.add(token.getMorph());
			}
		}
		return ret;
	}
}
