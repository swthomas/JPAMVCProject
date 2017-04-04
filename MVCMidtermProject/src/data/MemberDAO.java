package data;

import java.util.List;

import entities.Family;
import entities.Member;

public interface MemberDAO {
<<<<<<< HEAD
	List<Member> createMembersList(Member member, Family family);
=======
	public List<Member> createMembersList(List<Member> memberList, Family family);
	public Member createMember(Member member, Family family);
>>>>>>> c3c6312708a262b34e2e9060209f7a7669f931c5
	public Member updateMember(Member member);
	public Member showMember(int id);
	public boolean deleteMember(int id);
}
