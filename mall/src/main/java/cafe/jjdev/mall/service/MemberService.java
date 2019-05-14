package cafe.jjdev.mall.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.mall.mapper.MemberMapper;
import cafe.jjdev.mall.vo.Member;
import cafe.jjdev.mall.vo.MemberId;

@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	public Member getMember(Member member) {
		System.out.println(member + "◀■■loginMember MemberService.java");
		return memberMapper.getMember(member);
	}
	public Member getMember(int memberNo) {
		return memberMapper.selectMember(memberNo);
	}
	public void passwordUpdate(Map<String, Object> map) {
		memberMapper.passwordUpdate(map);
	}
	public void deleteMember(Map<String, Object> map) {
		memberMapper.deleteMember(map);
	}
	/*public int deleteMember2(MemberId memberId) {
		return memberMapper.deleteMember2(memberId);
	}*/
	public Map<String, Object> myPage(int memberNo) {
		Member member = memberMapper.selectMember(memberNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", member);
		return map;
	}
	public int joinMember(Member member) {
		return memberMapper.joinMember(member);
	}
	public int joinMember2(MemberId memberId) {
		return memberMapper.joinMember2(memberId);
	}
	public String idCheck(MemberId memberId) {
		return memberMapper.idCheck(memberId);
	}
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}
	public String idSearchResult(Member member) {
		return memberMapper.idSearchResult(member);
	}
	public String pwSearchResult(Member member) {
		return memberMapper.pwSearchResult(member);
	}
}
