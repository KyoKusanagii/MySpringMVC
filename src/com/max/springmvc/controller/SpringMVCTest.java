package com.max.springmvc.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.max.springmvc.model.User;

@Controller
//value�i�H��requset,session�P�ɦs��user�o�ӭȡA����user�O�@��VO�A�]�i�H�s�񫬧O�pString�A�H�K�s��String��������
//@SessionAttributes(value={"user"},types={String.class}) 
@RequestMapping("/SpringMVC")
public class SpringMVCTest {
	private final static String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/index.jsp";	//��^���r��p�G�a��forward:�άOredirect:�ASpringMVC�|�����@���ɩ����
	}
	
	@RequestMapping("/testView")
	public String testView() {
		System.out.println("testView");
		return "helloView";
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver() {
		System.out.println("testViewAndViewResolver");
		
		return SUCCESS;
	}
	
	/*
	 * ���аO@ModelAttribute����k�A���|�u���Q�I�s
	 * �I�s�y�{:
	 * 1.���榳�аO@ModelAttribute����k�A�qDB�o�쪫���T�A�A�⪫���Jmap
	 * 2.SpringMVC�qmap�q���X����A�ç��檺�ШD�Ѽƽᤩ�Ӫ����H�������ݩ�
	 * 3.�p�G���Ӫ����ݩʤw�g�b���]�w�L�F�A�N�u�ΡA�S���]�w�L���ݩʡA�z�����ݩʷ|���ŭ�
	 * 4.����SpringMVC�ˬd���ݩʦ��ŭȡA�|�۰ʧ�qDB���X�Ӫ����ݩʸ�Ʀ۰ʽᤩ�����åB�ŭȪ��ݩʸ�ơA��L�D�ŭȪ��ݩʫh���ק�
	 * 3.SpringMVC��W�z�ק諸��H�ǤJ�ؼФ�k���Ѽ�
	 * 
	 * 	�`�N:�b�аO@ModelAttribute����k���A��J��map��key�A�ݭn�M�ǤJ�ؼФ�k���Ѽƪ�key�@�P
	 * 	1.���аOModelAttribute����k�A���|�u���Q�I�s
	 *  2.�ӵ��Ѥ]��׹��ؼФ�kPOJO�������ǤJ�ѼơA��value���p�U���@��:
	 *  
	 *  �b��k�ѼƤ����аOModelAttribute�ѼơA�|�۰ʬd��ModelAttribute�̪�map��key�ȡA�öǤJ�ؼФ�k����ѼƭȡA
	 *  �p�G�Q�аO@ModelAttribute����k�̭��S���]�w�S�w����key�ȡA�h�ؼФ�k�̷|�۰ʲ��ͤ@�Ӹ�key������
	 *  
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map) {
		if(id != null) {
			//�����qDB�����ƫإߤ@�ӷs��user����
			System.out.println("�ǤJ��id = " + id);
			User user = new User(1090001, "Nancy", "00000", "Nancy@yahoo.com.tw", 22);
			User user2 = new User(1080054, "Cindy", "63636363", "Cindy@yahoo.com.tw", 24);
			System.out.println("�q��Ʈw�o��@��user��T:" + user);
			map.put("user", user);
			map.put("user2", user2);
		}
		
	}
	
	
	/*
	 * 
	 * �ǤJuser2�A��ܱq���аO@ModelAttribute����k���okey�ȳ]�w��"user2"���Ȫ���A�N���O�|�O�w�]��user�A�w�]���M�w����
	 *	�P���O�W�٬ۦP�Bkey�ȬO�Ĥ@�Ӧr���p�g�A�G�w�]���ǤJ�ȴN��user�A�Duser2
	 *
	 * 	�o�̪�user�A�O��getUser��k��key�Ȭ�user2������A�ӫD�w�]��user�A�]���w�g���w�n��user2�F
	 */
	
	@RequestMapping(value="/testModelAttribute",method=RequestMethod.POST)
	 public String testModelAttribute(@ModelAttribute("user2") User user) {
		 System.out.println("�ק�᪺user��T=" + user);
		 return SUCCESS;
	 }
	
	@RequestMapping("/helloWorld.do")
	public String helloWorld() {
		System.out.println("�@�ɧA�n!!!");
		return SUCCESS;
	}
	
	@RequestMapping(value="/helloWorld.do",method=RequestMethod.POST)
	public String badWorld() {
		System.out.println("�@�ɤ��n!!!");
		return "ASS";
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewname = SUCCESS; //�o�O�|��^�����ϭ��W��
		ModelAndView mav = new ModelAndView(viewname);

		
		//�K�[�ҫ��ƾڨ�ModelAndView���A�ĪG�۷��setAttribute����Nscope��
		mav.addObject("time", new Date());
		return mav;
	}
	
	@RequestMapping("/testsessionAttributes")
	public String sessionAttributes(Map<String , Object> map) {
		User user = new User("Max","30000","max@yahoo.comn.tw",25);
		map.put("user", user);
		map.put("job", "PG");
		return SUCCESS;
	}
	

}
