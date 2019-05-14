/*
	CREATE TABLE `member` (
	`member_no` INT(11) NOT NULL AUTO_INCREMENT,
	`member_id` VARCHAR(45) NOT NULL,
	`member_pw` VARCHAR(45) NOT NULL,
	`member_name` VARCHAR(45) NOT NULL,
	`member_phone` VARCHAR(45) NOT NULL,
	`member_address` VARCHAR(45) NOT NULL,
	`member_gender` VARCHAR(45) NOT NULL,
	`member_level` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`member_no`)
	)
*/

package cafe.jjdev.mall.vo;

public class Member {

	public Member() {
		super();
	}
	private int memberNo;
	private String memberId;
	private String memberPw; 
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private String memberGender;
	private String memberLevel;
	private String memberEmail;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		System.out.println(memberNo + "memberNo Member.java");
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		System.out.println(memberId + "memberId Member.java");
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		System.out.println(memberPw + "memberPw Member.java");
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		System.out.println(memberName + "memberName Member.java");
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		System.out.println(memberPhone + "memberPhone Member.java");
		this.memberPhone = memberPhone;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		System.out.println(memberAddress + "memberAddress Member.java");
		this.memberAddress = memberAddress;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		System.out.println(memberGender + "memberGender Member.java");
		this.memberGender = memberGender;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		System.out.println(memberLevel + "memberLevel Member.java");
		this.memberLevel = memberLevel;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		System.out.println(memberEmail + "memberEmail Member.java");
		this.memberEmail = memberEmail;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress + ", memberGender="
				+ memberGender + ", memberLevel=" + memberLevel + ", memberEmail=" + memberEmail + "]";
	}
	
	
}
