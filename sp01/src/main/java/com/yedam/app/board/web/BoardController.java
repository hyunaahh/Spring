package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired 
	BoardService boardService; //기능 연결! 
	
	//전체조회 : URI = boardList / return : board/boardList
		//*나중에 paging 하려면 매개면수 여기도 필요함
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		// 데이터보내는 model 클래스
		List<BoardVO> list = boardService.getBoardAll();
		model.addAttribute("boardList", list); //jsp에서 list 불러낼떄 이름:"boardList"
		//데이터 페이지에! 
		return "board/boardList";
	}
	
	//개별조회 : URI = boardInfo / parameter : boardVO / return : board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		//커맨드객체기반! (VO)
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		
		return "board/boardInfo";
	}
	
	
	//등록(페이지) : URI = boardInsert / return : board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardInfoForm() {
		return "board/boardInsert";
	}
	
	
	//등록(처리) : URI = boardInsert / parameter : boardVO / return : *전체조회다시호출(->redirect)
	@PostMapping("boardInsert")		
	public String insertBoardProcess(BoardVO boardVO) {
		 boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}
	
	
	//수정(페이지) : URI = boardUpdate / parameter : boardVO / return :  board/boardUpdate
	@GetMapping("boardUpdate")
	public String updateBoardInfoForm(BoardVO boardVO) {
		return "board/boardUpdate";
	}
	
	//수정(처리) : URI = boardUpdate / parameter : boardVO / return : 수정결과데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(BoardVO boardVO){
		return boardService.updateBoardInfo(boardVO);
	}
	
	
	//삭제 : URI = boardDelete / return : board/boardList
	@GetMapping("boardDelete")
	public String boardDelte(@RequestParam Integer bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}
	
	
	
	
}
