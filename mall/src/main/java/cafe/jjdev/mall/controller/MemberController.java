package cafe.jjdev.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.MemberService;
import cafe.jjdev.mall.vo.Member;
import cafe.jjdev.mall.vo.MemberId;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	// 1. 로그인 폼
	@GetMapping("/member/login")
	public String getMember(HttpSession session) {
		if(session.getAttribute("loginMember") != null) {
			return "redirect:/";
		} else {
			return "/member/login"; // /member/login.jsp
		}
	}
	// 2. 로그인 액션
	@PostMapping("/member/login")
	public String getMember (HttpSession session, Member member) {
		System.out.println(member + "");
		Member loginMember = memberService.getMember(member);
		System.out.println(loginMember + "◀■■loginMember MemberController.java");
		if(loginMember == null) {
			return "redirect:/";
		} else {
			session.setAttribute("loginMember", loginMember);
			session.setAttribute("memberId", loginMember.getMemberId());
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberLevel", loginMember.getMemberLevel());
			return "redirect:/";
		}
	}
	 // 3. 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
	// 4. 회원가입페이지 join.jsp
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	// 아이디 중복확인
	
	// 5. 회원가입처리 join.jsp에서 -> form post전송
	@PostMapping("/member/join")
	public String joinMember(Member member, MemberId memberId) {
		memberService.joinMember(member);
		memberService.joinMember2(memberId);
		return "redirect:/member/joinToLogin";
	}
	// 6. 회원가입처리 후 로그인페이지 joinToLogin.jsp
	@GetMapping("/member/joinToLogin")
	public String joinToLogin() {
		return "/member/joinToLogin";
	}
	// 7. index.jsp에서 myPage.jsp 클릭했을때.
	@GetMapping("/member/myPage")
	public String myPage(Model model, @RequestParam(value="memberNo", required = true) int memberNo) {
		System.out.println(memberNo + "◀ memberNo myPage MemberController.java");
		Map<String, Object> map = memberService.myPage(memberNo);
		model.addAttribute("member", map.get("member"));
		return "/member/myPage";
	}
	// 8. mypage에서 회원정보 수정페이지 클릭했을때, 회원정보 수정폼으로 회원정보 데이터 가져가기
	@GetMapping("/member/memberModify")
	public String memberModify(Model model, @RequestParam(value="memberNo", required = true) int memberNo) {
		System.out.println(memberNo + "◀ memberNo memberModify MemberController.java");
		Map<String, Object> map = memberService.myPage(memberNo);
		model.addAttribute("member", map.get("member"));
		return "/member/memberModify";
	}
	// 9. 회원정보 수정처리. 수정폼에서 post 했을때 처리하는 과정.
	@PostMapping("/member/memberModify")
	public String memberModify(Member member) {
		int result = memberService.modifyMember(member);
		return "redirect:/member/myPage?memberNo="+member.getMemberNo();
	}
	// 7. 비밀번호 수정 폼
	@GetMapping("/member/passwordUpdate")
	public String passwordUpdate(Model model, @RequestParam(value="memberNo", required = true) int memberNo) {
		System.out.println(memberNo + "memberNo passwordUpdate MemberController.java");
		Member member = memberService.getMember(memberNo);
		model.addAttribute("member", member);
		return "/member/passwordUpdate";
	}
	// 8. 비밀번호 수정 액션
	@PostMapping("/member/passwordUpdate")
	public String passwordUpdate(String currentPw, String memberPw, String confirmPw, int memberNo) {
		if (memberPw.equals(confirmPw)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", memberNo);
			map.put("currentPw", currentPw);
			map.put("memberPw", memberPw);
			memberService.passwordUpdate(map);
		}
		//memberService.passwordUpdate(member);
		return "redirect:/member/myPage?memberNo="+memberNo;
	}
	// 9. 회원탈퇴 폼
	@GetMapping("/member/deleteMember")
	public String deleteMember(Model model, @RequestParam(value="memberNo", required = true) int memberNo) {
		System.out.println(memberNo + "memberNo passwordUpdate MemberController.java");
		Member member = memberService.getMember(memberNo);
		model.addAttribute("member", member);
		return "/member/deleteMember";
	}
	// 10. 회원탈퇴 처리
	@PostMapping("/member/deleteMember")
	public String deleteMember(String memberPw, int memberNo, Member member, HttpSession session, MemberId memberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("memberPw", memberPw);
		memberService.deleteMember(map);
//		int result = memberService.deleteMember2(memberId);
		//return "redirect:/";//비밀번호 틀렸을 때
		session.invalidate();
		return "redirect:/member/goodBye";//회원 탈퇴 처리 됐을때.
	}
	@GetMapping("/member/goodBye")
	public String goodBye() {
		return "/member/goodBye";
	}
	//아이디 찾기 폼
	@GetMapping("/member/idSearchForm")
	public String idSearch() {
		return "/member/idSearchForm";
	}
	//아이디 찾기 처리
	@PostMapping("/member/idSearchResult")
	public String idSearchResult(Member member) {
		//idSearchForm에서 입력한 memberName, memberPhone 따로 안 받아와도 Member에 받을 수 있다. 스프링이니까!
		String id = memberService.idSearchResult(member);
		if (id != null) {
			return "redirect:/member/idSearchResult?memberId="+id;
		} else {
			return "redirect:/member/idSearchResult";
		}
	}
	@GetMapping("/member/idSearchResult")
	public String idSearchResult(Model model, String memberId) {
		model.addAttribute("memberId", memberId);
		return "/member/idSearchResult";
	}
	//비밀번호 찾기 폼
	@GetMapping("/member/passwordSearchForm")
	public String passwordSearch() {
		return "/member/passwordSearchForm";
	}
	//비밀번호 찾기 처리
	@PostMapping("member/pwSearchResult")
	public String pwSearchResult(Member member) {
		//pwSearchFrom에서 입력한 항목들 따로 안 받아와도 Member에 받을 수 있다.
		String id = memberService.pwSearchResult(member);
		if (id != null) {
			
			return "redirect:/member/pwSearchResult?memberId="+id;
		} else {
			return "redirect:/member/pwSearchResult";
		}
	}
	//비밀번호 찾기 결과
	@GetMapping("/member/pwSearchResult")
	public String pwSearchResult(Model model, String memberId) {
		model.addAttribute("memberId", memberId);
		return "/member/pwSearchResult";
	}
	// ++++++++ 4. 회원가입 폼 GET addMember
	// ++++++++ 5. 회원가입 액션 POST addMember
	// 6. 개인정보 확인 get/post 구분하세요
	// 7. 비밀번호 수정 폼		//비밀번호 찾기, 아이디찾기는 팀과제.
	// 8. 비밀번호 수정 액션
	// 9. 회원정보 수정 폼
	// 10. 회원정보 수정 액션
	// 11. 회원탈퇴 폼 - MemberController.removeMember -> removeMember.jsp
	// 12. 회원탈퇴 액션 - MemberController.removeMember -> MemberService.removeMember ->
	// 00. 압축해서 zip파일로.
	
	// 00. 이건 내일......
	// 13. ID 찾기
	// 14. PW 찾기
	// 15. member_out_id 테이블 생성 후 탈퇴시 member 테이블에서 삭제, member_out_id에 저장.
}
