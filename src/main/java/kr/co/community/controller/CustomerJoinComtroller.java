package kr.co.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.community.dao.CustomerDAO;
import kr.co.community.vo.Customer;

/**
 * 회원 가입 컨트롤러  
 * 모델에 "customer" 라는 이름의 값이 저장될 때, 세션에도 저장 
 * 가입단계의 시작부터 마지막 단계까지 세션의 값 유지 
 */
@Controller
@RequestMapping("customer")
@SessionAttributes("customer")
public class CustomerJoinComtroller {

	@Autowired
	CustomerDAO dao;  //회원 관련 데이터 처리 객체
	
	/**
	 * 회원가입 폼 보기
	 */
	@RequestMapping (value="join", method=RequestMethod.GET)
	public String joinForm(Model model) {
		// 빈 VO객체를 만들어 세션에 저장 
		Customer customer = new Customer();
		model.addAttribute("customer", customer); //정보를 저장해서 리턴하는 화면에 전달 
		return "customer/joinForm";
	}
	
	/**
	 * 회훤가입 처리
	 * @param customer joinForm()에서 생성한 VO객체에 사용자가 입력한 가입 정보가 추가된 객체.
	 * 			세션에 해당값이 없으면 에러
	 */
	@RequestMapping (value="join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute("customer") Customer customer,
			Model model) {
	
		int result = dao.insert(customer);
		if (result != 1) {
			//DB 저장에 실패한 경우 alert() 출력용 메시지를 모델에 저장
			model.addAttribute("errorMsg", "가입 실패");
			return "customer/joinForm";
		}
		return "redirect:joinComplete";
	}
	
	
	@RequestMapping(value="joinComplate", method=RequestMethod.GET)
	public String joinComplate(
			@ModelAttribute("customer") Customer customer,
			SessionStatus sessionStatus,Model model) {
		
		//가입 처리된  ID를 모델에 저장 
		model.addAttribute("id", customer.getCustid());
		sessionStatus.setComplete();
		return "customer/joinComplete";
	}
}

