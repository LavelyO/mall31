package cafe.jjdev.mall.service;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.mall.mapper.BoardCommentMapper;
import cafe.jjdev.mall.mapper.BoardFileMapper;
import cafe.jjdev.mall.mapper.BoardMapper;
import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;
import cafe.jjdev.mall.vo.BoardFile;
import cafe.jjdev.mall.vo.BoardRequest;

@Service
@Transactional
public class BoardService {
	@Autowired private BoardMapper boardMapper;
	@Autowired private BoardCommentMapper boardCommentMapper;
	@Autowired private BoardFileMapper boardFileMapper;
	
	public Map<String, Object> getBoardAndCommentListAndFile(int boardNo) {
		//1.Board 받아오기
		Board board = boardMapper.selectBoard(boardNo);
		//2.Comment 받아오기
		List<BoardComment> boardCommentList
					= boardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
		//3.BoardFile 받아오기
		BoardFile boardFile = boardFileMapper.selectBoardFileByFK(boardNo);
		//List<BoardFile> boardFileList = boardFileMapper.selectBoardFileListByBoardNo(boardNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("boardCommentList", boardCommentList);
		map.put("boardFile", boardFile);
		return map;
	}
	public Map<String, Object> getBoardAndCommentListAndFileList(int boardNo) {
		Board board = boardMapper.selectBoard(boardNo);
		List<BoardComment> boardCommentList
					= boardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
		List<BoardFile> boardFileList
					= boardFileMapper.selectBoardFileListByBoardNo(boardNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("boardCommentList", boardCommentList);
		map.put("boardFileList", boardFileList);
		return map;
	}
	
	public Map<String, Object> getBoardAndCommentList(int boardNo) {
		Board board = boardMapper.selectBoard(boardNo);
		List<BoardComment> boardCommentList 
					= boardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("boardCommentList", boardCommentList);
		return map;
	}
	
	public Board getBoard(int boardNo) {
		return boardMapper.selectBoard(boardNo);
	}
	
	public Map<String, Object> getBoardList(int currentPage) {
		final int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE; 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		List<Board> list = boardMapper.selectBoardList(map);
		int boardCount = boardMapper.selectBoardCount();
		int lastPage = boardCount/ROW_PER_PAGE;
		if(boardCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("boardCount", boardCount);
		return returnMap;
	}
	
	
	public int modifyBoard(Board board) {
		return boardMapper.updateBoard(board);
	}
	
	public void addBoard(BoardRequest boardRequest, String path) {
		// 1. BoardRequest 에서 Board를 꺼내야 한다.
		Board board = new Board();
		board.setBoardPw(boardRequest.getBoardPw());
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		board.setBoardUser(boardRequest.getBoardUser());
		board.setBoardDate(boardRequest.getBoardDate());
		System.out.println(board);
	 	boardMapper.insertBoard(board); // board.setBoardNo(ai값)
		
		// 2. BoardRequest -> MultipartFile -> BoardFile
		MultipartFile multipartFile = boardRequest.getBoardFile();
		if (multipartFile.isEmpty() == false) {
		//System.out.println(multipartFile);
		String contentType = multipartFile.getContentType();
		String name = multipartFile.getName();
		String originalFileName = multipartFile.getOriginalFilename();
		//abc.hwp일 때
		int i = originalFileName.lastIndexOf(".");
		String originName = originalFileName.substring(0, i);
		String ext = originalFileName.substring(i+1).toLowerCase();
		long size = multipartFile.getSize();
		UUID uuid = UUID.randomUUID();
		String saveName = uuid.toString().replace("-", "");
		
		
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardNo(board.getBoardNo());
		boardFile.setBoardFileSize(multipartFile.getSize());
		boardFile.setBoardFileType(multipartFile.getContentType());
		boardFile.setBoardFileOriginName(originName);
		boardFile.setBoardFileSaveName(saveName);
		boardFile.setBoardFileExt(ext);

		System.out.println(boardFile);
	//	3. 폴더에 저장
		//String path = "c:/temp/"; // c:/temp 이렇게 해도 찾아감.
		File file = new File(path + "/" + saveName + "." + ext); //빈파일
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}//multipartFile 여기 있는 파일을 transferTo(복사해서) file에 넣어주세요
		
		boardFileMapper.insertBoardFile(boardFile);
		}
	}
	
	public void removeBoard(Board board) {
		boardFileMapper.deleteBoardFileByBoardNo(board.getBoardNo());
		boardCommentMapper.deleteBoardCommentByBoardNo(board.getBoardNo());
		boardMapper.deleteBoard(board);
		//int commentResult = boardCommentMapper.deleteBoardCommentByBoardNo(board.getBoardNo());
		//int boardResult = boardMapper.deleteBoard(board);
	}
	
	
}
