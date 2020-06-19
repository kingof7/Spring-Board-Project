package kr.co.service;

import java.util.List;

import kr.co.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;

	public void updateReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
}
