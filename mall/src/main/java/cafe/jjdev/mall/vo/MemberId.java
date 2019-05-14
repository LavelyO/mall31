package cafe.jjdev.mall.vo;

public class MemberId {
	private String memberId;
	private String memberInDate;
	private String memberOutDate;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberInDate() {
		return memberInDate;
	}
	public void setMemberInDate(String memberInDate) {
		this.memberInDate = memberInDate;
	}
	public String getMemberOutDate() {
		return memberOutDate;
	}
	public void setMemberOutDate(String memberOutDate) {
		this.memberOutDate = memberOutDate;
	}
	@Override
	public String toString() {
		return "MemberId [memberId=" + memberId + ", memberInDate=" + memberInDate + ", memberOutDate=" + memberOutDate
				+ "]";
	}
	
	
}
