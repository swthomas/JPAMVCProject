package data;

import entities.Member;

public interface MemberDAO {
	public Member updateMember(Member member);
	public Member createMember(Member member);
	public Member showMember(int id);
	public boolean deleteMember(int id);
}
