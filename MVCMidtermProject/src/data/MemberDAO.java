package data;

import java.util.List;

import entities.Member;

public interface MemberDAO {
	public List<Member> createMembersList(List<Member> memberList);
	public Member updateMember(Member member);
	public Member createMember(Member member);
	public Member showMember(int id);
	public boolean deleteMember(int id);
}
