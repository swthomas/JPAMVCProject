package data;

import entities.Member;

public interface MemberDAO {
	public Member createMember(Member member);
	public Member updateMember(Member member);
	public Member deleteMember(Member member);
}
