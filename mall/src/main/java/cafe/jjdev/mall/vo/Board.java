package cafe.jjdev.mall.vo;

public class Board { 
    private int boardNo;
    private String boardPw;
    private String boardTitle;
    private String boardContent;
    private String boardUser;
    private String boardDate;
    public int getBoardNo() {
        return boardNo;
    }
    public void setBoardNo(int boardNo) {
    	System.out.println(boardNo + "setBoardNo Board.java");
        this.boardNo = boardNo;
    }
    public String getBoardPw() {
        return boardPw;
    }
    public void setBoardPw(String boardPw) {
    	System.out.println(boardPw + "setBoardPw Board.java");
        this.boardPw = boardPw;
    }
    public String getBoardTitle() {
        return boardTitle;
    }
    public void setBoardTitle(String boardTitle) {
    	System.out.println(boardTitle + "setBoardTitle Board.java");
        this.boardTitle = boardTitle;
    }
    public String getBoardContent() {
        return boardContent;
    }
    public void setBoardContent(String boardContent) {
    	System.out.println(boardContent + "setBoardContent Board.java");
        this.boardContent = boardContent;
    }
    public String getBoardUser() {
        return boardUser;
    }
    public void setBoardUser(String boardUser) {
    	System.out.println(boardUser + "setBoardUser Board.java");
        this.boardUser = boardUser;
    }
    public String getBoardDate() {
        return boardDate;
    }
    public void setBoardDate(String boardDate) {
    	System.out.println(boardDate + "setBoardDate Board.java");
        this.boardDate = boardDate;
    }
    @Override
    public String toString() {
        return "Board [boardNo=" + boardNo + ", boardPw=" + boardPw + ", boardTitle=" + boardTitle + ", boardContent="
                + boardContent + ", boardUser=" + boardUser + ", boardDate=" + boardDate + "]";
    }
}