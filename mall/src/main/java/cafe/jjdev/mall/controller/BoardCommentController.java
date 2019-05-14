package cafe.jjdev.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.BoardCommentService;
import cafe.jjdev.mall.vo.BoardComment;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;
	
	@GetMapping(value="/board/removeBoardComment")
	public String deleteBoardCommentByCommentNo(Model model, BoardComment boardComment) {
		System.out.println(boardComment + "---------boardComment---------");
		model.addAttribute("boardComment", boardComment);
		return "/board/removeBoardComment";
	}
	@PostMapping(value="/board/removeBoardComment")
	public String deleteBoardCommentByCommentNo(BoardComment boardComment) {
		System.out.println(boardComment + "boardComment");
		boardCommentService.removeBoardComment(boardComment);
		return "redirect:/board/getBoard?boardNo="+boardComment.getBoardNo();
		
	}
	
	@PostMapping(value="/board/addBoardComment")
	public String addBoardComment(BoardComment boardComment) {
		int result = boardCommentService.addBoardComment(boardComment);
		return "redirect:/board/getBoard?boardNo="+boardComment.getBoardNo();
	}
}
