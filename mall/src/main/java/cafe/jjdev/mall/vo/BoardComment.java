package cafe.jjdev.mall.vo;

public class BoardComment {
	private int boardCommentNo;
	private int boardNo;
	private String boardCommentContent;
	private String boardCommentUser;
	private String boardCommentPw;
	
	public int getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public String getBoardCommentUser() {
		return boardCommentUser;
	}
	public void setBoardCommentUser(String boardCommentUser) {
		this.boardCommentUser = boardCommentUser;
	}
	public String getBoardCommentPw() {
		return boardCommentPw;
	}
	public void setBoardCommentPw(String boardCommentPw) {
		this.boardCommentPw = boardCommentPw;
	}
	@Override
	public String toString() {
		return "BoardComment [boardCommentNo=" + boardCommentNo + ", boardNo=" + boardNo + ", boardCommentContent="
				+ boardCommentContent + ", boardCommentUser=" + boardCommentUser + ", boardCommentPw=" + boardCommentPw
				+ "]";
	}
		
}
