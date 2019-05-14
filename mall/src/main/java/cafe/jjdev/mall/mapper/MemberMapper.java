package cafe.jjdev.mall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Member;
import cafe.jjdev.mall.vo.MemberId;
@Mapper
public interface MemberMapper {

	public int joinMember(Member member);
	public int joinMember2(MemberId memberId);
	public String idCheck(MemberId memberId);//아이디 중복확인
	public int updateMember(Member member);
	public Member getMember(Member member);//로그인
	public Member selectMember(int memberNo);//회원정보조회
	public int passwordUpdate(Map<String, Object> map);//비밀번호 변경
	public int deleteMember(Map<String, Object> map);//회원삭제
	public String idSearchResult(Member member);
	public String pwSearchResult(Member member);
	//public int deleteMember2(MemberId memberId);//탈퇴회원저장테이블 탈퇴날짜 업데이트쿼리
}
