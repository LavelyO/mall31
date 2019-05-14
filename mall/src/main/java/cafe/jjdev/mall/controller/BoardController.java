package cafe.jjdev.mall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cafe.jjdev.mall.commons.PathStr;
import cafe.jjdev.mall.service.BoardService;
import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;
import cafe.jjdev.mall.vo.BoardRequest;

@Controller
public class BoardController {
	final String path = "D:\\jjdev\\sts-workspace\\mall\\src\\main\\webapp\\upload";
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value="/board/getBoard")
	public String getBoard(Model model, @RequestParam(value="boardNo", required = true) int boardNo) {
		Map<String, Object> map = boardService.getBoardAndCommentListAndFile(boardNo);
		
		model.addAttribute("board", map.get("board"));
		model.addAttribute("boardCommentList", map.get("boardCommentList"));
		model.addAttribute("boardFile", map.get("boardFile"));
		//model.addAttribute("boardFileList", map.get("boardFileList"));
		return "/board/getBoard";
	}
	@GetMapping(value="/board/addBoard")
	public String addBoard() {
		return "/board/addBoard";
	}
	@PostMapping(value="/board/addBoard")
	public String addBoard(BoardRequest boardRequest) {
		//String path = ServletUriComponentsBuilder.fromCurrentContextPath().path("upload").toUriString();
		//String path = "D:\\jjdev\\sts-workspace\\mall\\src\\main\\webapp\\upload";
		System.out.println(path + "◀.path BoardService.java");
		boardService.addBoard(boardRequest, PathStr.UPLOAD_PATH);
		return "redirect:/board/getBoardList";
	}
	
	@GetMapping(value="/board/removeBoard")
	public String deleteBoard(Model model
								,@RequestParam(value="boardNo", required = true) int boardNo) {
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);
		return "/board/removeBoard";
	}
	
	@PostMapping(value="/board/removeBoard")
	public String deleteBoard(Board board) {
		boardService.removeBoard(board);
		return "redirect:/board/getBoardList";
	}
	
	@GetMapping(value="/board/modifyBoard")
	public String modifyBoard(Model model
							,@RequestParam(value="boardNo", required = true) int boardNo) {	
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);
		return "/board/modifyBoard";
	}
	@PostMapping(value="/board/modifyBoard")
	public String modifyBoard(Board board) {
		int result = boardService.modifyBoard(board);
		return "redirect:/board/getBoard?boardNo="+board.getBoardNo();
	}
	
	
	
	
	@GetMapping(value="/board/getBoardList")
	public String getBoardList(
			Model model
			,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		Map<String, Object> map = boardService.getBoardList(currentPage);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("boardCount", map.get("boardCount"));
		model.addAttribute("currentPage", currentPage);
		return "board/getBoardList";
	}
}
