package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	EmpMapper empMapper; //mapper 여러개 사용 가능.
	
	@Override
	public List<BoardVO> getBoardAll() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		if(result == 1) {
			return boardVO.getBno();
		}else {
			return -1; //의미없는 값 적음 (bno가 가질 수 없는 값넣은거임)
		}
	}

	@Override
	public Map<String, Object> updateBoardInfo(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSucceeded = false; //얜 boolean 인데 객체니까 서로다른거 담을 수 있는  map
		
		int result = boardMapper.updateBoard(boardVO);
		if(result == 1) {
			isSucceeded = true;
		}
		map.put("result", isSucceeded);
		map.put("target", boardVO);
		
		return map;
	}

	@Override
	public boolean deleteBoardInfo(int boardNo) {
		int result = boardMapper.deleteBoard(boardNo);
		
		return result == 1 ? true : false;
	}

}
