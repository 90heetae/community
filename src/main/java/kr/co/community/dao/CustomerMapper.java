package kr.co.community.dao;

import kr.co.community.vo.Customer;

/**
 *	회원 관련 Mybatis 사용 메서드  
 */
public interface CustomerMapper {
	//회원 정보 저장
	public int insertCustomer(Customer customer);
	//ID로 해당 회원 정보 검색
	public Customer selectCustomer(String id);
	//회원 정보 수정
	public int updateCustomer(Customer customer);
}
