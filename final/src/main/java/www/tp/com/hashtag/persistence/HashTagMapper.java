package www.tp.com.hashtag.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.tp.com.hashtag.model.HashTagVO;
import www.tp.com.proj.model.ReplyVO;


public interface HashTagMapper {
	//해시태그 삽입 (해시태그 테이블 + 매핑테이블)
	//해시태그 검색 
	public List<HashTagVO> findExists(List<HashTagVO> listHT);
	public HashTagVO findExistsByArea(String area);

	public void insertHashTag(@Param("hashTag") HashTagVO hashTag);
	
	public void insertMapBetweenReply(@Param("hierId") String hierId, @Param("hashTag") HashTagVO hashTag, @Param("type")String type);
	
	public void deleteMapBetweenProject(@Param("reply") ReplyVO reply);

	public void deleteMapBetweenReply(String hierId);
}
