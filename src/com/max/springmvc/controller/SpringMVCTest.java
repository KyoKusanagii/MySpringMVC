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
//value可以讓requset,session同時存取user這個值，此時user是一個VO，也可以存放型別如String，以便存取String類型的值
//@SessionAttributes(value={"user"},types={String.class}) 
@RequestMapping("/SpringMVC")
public class SpringMVCTest {
	private final static String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/index.jsp";	//返回的字串如果帶有forward:或是redirect:，SpringMVC會直接作重導或轉交
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
	 * 有標記@ModelAttribute的方法，都會優先被呼叫
	 * 呼叫流程:
	 * 1.執行有標記@ModelAttribute的方法，從DB得到物件資訊，再把物件放入map
	 * 2.SpringMVC從map從取出物件，並把表單的請求參數賦予該物件對象的對應屬性
	 * 3.如果本來物件的屬性已經在表單設定過了，就沿用，沒有設定過的屬性，理當那個屬性會為空值
	 * 4.此時SpringMVC檢查到屬性有空值，會自動把從DB取出來的該屬性資料自動賦予對應並且空值的屬性資料，其他非空值的屬性則不修改
	 * 3.SpringMVC把上述修改的對象傳入目標方法的參數
	 * 
	 * 	注意:在標記@ModelAttribute的方法中，放入的map的key，需要和傳入目標方法的參數的key一致
	 * 	1.有標記ModelAttribute的方法，都會優先被呼叫
	 *  2.該註解也能修飾目標方法POJO類型的傳入參數，其value有如下的作用:
	 *  
	 *  在方法參數中有標記ModelAttribute參數，會自動查找ModelAttribute裡的map的key值，並傳入目標方法當成其參數值，
	 *  如果被標記@ModelAttribute的方法裡面沒有設定特定的該key值，則目標方法裡會自動產生一個該key的物件
	 *  
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map) {
		if(id != null) {
			//模擬從DB獲取資料建立一個新的user物件
			System.out.println("傳入的id = " + id);
			User user = new User(1090001, "Nancy", "00000", "Nancy@yahoo.com.tw", 22);
			User user2 = new User(1080054, "Cindy", "63636363", "Cindy@yahoo.com.tw", 24);
			System.out.println("從資料庫得到一個user資訊:" + user);
			map.put("user", user);
			map.put("user2", user2);
		}
		
	}
	
	
	/*
	 * 
	 * 傳入user2，表示從有標記@ModelAttribute的方法取得key值設定為"user2"的值物件，就不是會是預設的user，預設的決定條件為
	 *	與類別名稱相同且key值是第一個字母小寫，故預設的傳入值就為user，非user2
	 *
	 * 	這裡的user，是取getUser方法裡key值為user2的物件，而非預設的user，因為已經指定要拿user2了
	 */
	
	@RequestMapping(value="/testModelAttribute",method=RequestMethod.POST)
	 public String testModelAttribute(@ModelAttribute("user2") User user) {
		 System.out.println("修改後的user資訊=" + user);
		 return SUCCESS;
	 }
	
	@RequestMapping("/helloWorld.do")
	public String helloWorld() {
		System.out.println("世界你好!!!");
		return SUCCESS;
	}
	
	@RequestMapping(value="/helloWorld.do",method=RequestMethod.POST)
	public String badWorld() {
		System.out.println("世界不好!!!");
		return "ASS";
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewname = SUCCESS; //這是會返回的視圖頁名稱
		ModelAndView mav = new ModelAndView(viewname);

		
		//添加模型數據到ModelAndView中，效果相當於setAttribute到任意scope裡
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
