package com.max.springmvc.views;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component
public class HelloViews implements View{

	@Override
	public String getContentType() {
		return "text/html";
		
	}
	
	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.getWriter().write("Hello View, time:" + new Date());
	}

	
	  
}
