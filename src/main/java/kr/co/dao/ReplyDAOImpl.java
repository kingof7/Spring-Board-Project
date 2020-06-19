package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject SqlSession sql;
	
	//댓글조회
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		// replyMapper.xml을 호출
		return sql.selectList("replyMapper.readReply", bno);
	}

	//댓글작성
	@Override
	public void writdReply(ReplyVO vo) throws Exception {
		sql.insert("replyMapper.writeReply", vo);
		
	}
	
	

}
