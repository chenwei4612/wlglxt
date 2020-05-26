package com.chen.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class LoginController
 */
@Controller
public class PageController  {
	
	@RequestMapping(value="home")
	public String Home(){
		return "home";
	}
	
	@RequestMapping("Employee")
	public String Employee(){
		return "employee";
	}
	@RequestMapping("employee2")
	public String Employee2(){
		return "employee2";
	}
	
	@RequestMapping("Car")
	public String Car(){
		return "car";
	}
	@RequestMapping("car2")
	public String Car2(){
		return "car2";
	}

	@RequestMapping("Route")
	public String Route(){
		return "route";
	}
	@RequestMapping("Route2")
	public String Route2(){
		return "route2";
	}
	
	@RequestMapping("Orst")
	public String Orst(){
		return "orst";
	}
	@RequestMapping("Orst2")
	public String Orst2(){
		return "orst2";
	}
	
	@RequestMapping("OrderG")
	public String OrderG(){
		return "orderG";
	}
	@RequestMapping("OrderG2")
	public String OrderG2(){
		return "orderG2";
	}
	
	@RequestMapping("Storehouse")
	public String Storehouse(){
		return "storehouse";
	}
	@RequestMapping("Storehouse2")
	public String Storehouse2(){
		return "storehouse2";
	}
	
	@RequestMapping("DeptCount")
	public String DeptCount(){
		return "DeptCount";
	}
	
	@RequestMapping("St_type_count")
	public String St_type_count(){
		return "St_type_count";
	}
	
	@RequestMapping("OrderGCount")
	public String OrderGCount(){
		return "OrderGCount";
	}
	
	@RequestMapping("CARCount")
	public String CARCount(){
		return "CarCount";
	}
}
