package cafe.jjdev.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.BoardFile;

@Mapper
public interface BoardFileMapper {
	public int insertBoardFile(BoardFile boardFile);
	public BoardFile selectBoardFileByFK(int boardNo);
	public List<BoardFile> selectBoardFileListByBoardNo(int boardNo);
	public void deleteBoardFileByFileNo(BoardFile BoardFile);
	public int deleteBoardFileByBoardNo(int boardNo);
}
