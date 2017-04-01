package data;

import entities.Member;

public interface MemberDAO {
	public Member updateMember(int id, Member member);
	public Member createMember(Member member);
	public Member showMember(int id);
	public boolean deleteMember(int id);
}
