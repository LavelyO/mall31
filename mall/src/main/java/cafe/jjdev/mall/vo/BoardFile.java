package cafe.jjdev.mall.vo;

public class BoardFile {
	private int boardFileNo;
	private int boardNo;
	private String boardFileOriginName;
	private String boardFileSaveName;
	private String boardFileExt;
	private long boardFileSize;
	private String boardFileType;
	
	public int getBoardFileNo() {
		return boardFileNo;
	}
	public void setBoardFileNo(int boardFileNo) {
		System.out.println(boardFileNo + "setBoardFileNo BoardFile.java");
		this.boardFileNo = boardFileNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		System.out.println(boardNo + "setBoardNo BoardFile.java");
		this.boardNo = boardNo;
	}
	public String getBoardFileOriginName() {
		return boardFileOriginName;
	}
	public void setBoardFileOriginName(String boardFileOriginName) {
		System.out.println(boardFileOriginName + "setBoardFileOriginName BoardFile.java");
		this.boardFileOriginName = boardFileOriginName;
	}
	public String getBoardFileSaveName() {
		return boardFileSaveName;
	}
	public void setBoardFileSaveName(String boardFileSaveName) {
		System.out.println(boardFileSaveName + "setBoardFileSaveName BoardFile.java");
		this.boardFileSaveName = boardFileSaveName;
	}
	public String getBoardFileExt() {
		return boardFileExt;
	}
	public void setBoardFileExt(String boardFileExt) {
		System.out.println(boardFileExt + "setBoardFileExt BoardFile.java");
		this.boardFileExt = boardFileExt;
	}
	public long getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(long boardFileSize) {
		System.out.println(boardFileSize + "setBoardFileSize BoardFile.java");
		this.boardFileSize = boardFileSize;
	}
	public String getBoardFileType() {
		return boardFileType;
	}
	public void setBoardFileType(String boardFileType) {
		System.out.println(boardFileType + "setBoardFileType BoardFile.java");
		this.boardFileType = boardFileType;
	}
	@Override
	public String toString() {
		return "BoardFile [boardFileNo=" + boardFileNo + ", boardNo=" + boardNo + ", boardFileOriginName="
				+ boardFileOriginName + ", boardFileSaveName=" + boardFileSaveName + ", boardFileExt=" + boardFileExt
				+ ", boardFileSize=" + boardFileSize + ", boardFileType=" + boardFileType + "]";
	}
	
}
