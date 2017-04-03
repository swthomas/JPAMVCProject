package data;

import java.util.List;

import entities.Family;
import entities.Member;

public interface MemberDAO {
	List<Member> createMembersList(List<Member> memberList, Family family);
	public Member updateMember(Member member);
	public Member createMember(Member member);
	public Member showMember(int id);
	public boolean deleteMember(int id);
}
