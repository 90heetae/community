package kr.co.community.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.community.vo.Customer;

/**
 * 회원 관련 DAO 
 */
@Repository
public class CustomerDAO {

	@Autowired
	SqlSession sqlSession;
	
/**
 * 회원 가입 처리
 * @param customer 사용자가 입력한 가입 정보 
 * @return
 */
	public int insert(Customer customer) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertCustomer(customer);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ID로 회원정보 검색 
	 * @param id 검색할 ID
	 * @return 검색된 회원정보. 없으면 null.
	 */
	public Customer get(String id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer c = mapper.selectCustomer(id);
		return c;
	}
}