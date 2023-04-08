package ch05.ex00.repository;

import java.util.List;

import ch05.ex00.entity.Member;

public interface MemberRepository {
	/** 
	 *  新增一筆記錄
	 */
	public Member save(Member member);
    /** 
    *  依主鍵讀取一筆記錄
	*/
	public Member findById(Long id);
	
	public boolean existsById(Long id);
    /** 
    *  依主鍵更新一筆記錄
    */	
	public void update(Member member);
    /** 
    *  依主鍵刪除一筆記錄
    */
	public void deleteById(Long id) ;
   /** 
    * 讀取多筆記錄
    */
	public List<Member> findAll() ;
	
    public boolean existsByMemberId(String memberId);
}
