package cafe.jjdev.mall.vo;

import org.springframework.web.multipart.MultipartFile;

public class BoardRequest {
	private int boardNo;
    private String boardPw;
    private String boardTitle;
    private String boardContent;
    private String boardUser;
    private String boardDate;
    private MultipartFile boardFile;
    
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		System.out.println(boardNo + "setBoardNo BoardRequest.java");
		this.boardNo = boardNo;
	}
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		System.out.println(boardPw + "setBoardPw BoardRequest.java");
		this.boardPw = boardPw;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		System.out.println(boardTitle + "setBoardTitle BoardRequest.java");
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		System.out.println(boardContent + "setBoardContent BoardRequest.java");
		this.boardContent = boardContent;
	}
	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		System.out.println(boardUser + "setBoardUser BoardRequest.java");
		this.boardUser = boardUser;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		System.out.println(boardDate + "setBoardDate BoardRequest.java");
		this.boardDate = boardDate;
	}
	public MultipartFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile boardFile) {
		System.out.println(boardFile + "setBoardFile BoardRequest.java");
		this.boardFile = boardFile;
	}
	@Override
	public String toString() {
		return "BoardRequest [boardNo=" + boardNo + ", boardPw=" + boardPw + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardUser=" + boardUser + ", boardDate=" + boardDate
				+ ", boardFile=" + boardFile + "]";
	}
	
}
