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
	
	@RequestMapping(value="Employee")
	public String Employee(){
		return "employee";
	}
	@RequestMapping(value="Employee2")
	public String Employee2(){
		return "employee2";
	}
	
	@RequestMapping(value="car")
	public String Car(){
		return "car";
	}
	@RequestMapping(value="car2")
	public String Car2(){
		return "car2";
	}

	@RequestMapping(value="Route")
	public String Route(){
		return "route";
	}
	@RequestMapping(value="Route2")
	public String Route2(){
		return "route2";
	}
	
	@RequestMapping(value="Orst")
	public String Orst(){
		return "orst";
	}
	@RequestMapping(value="Orst2")
	public String Orst2(){
		return "orst2";
	}
	
	@RequestMapping(value="OrderG")
	public String OrderG(){
		return "orderG";
	}
	@RequestMapping(value="OrderG2")
	public String OrderG2(){
		return "orderG2";
	}
	
	@RequestMapping(value="storehouse")
	public String Storehouse(){
		return "storehouse";
	}
	@RequestMapping(value="storehouse2")
	public String Storehouse2(){
		return "storehouse2";
	}
	
	@RequestMapping(value="DeptCount")
	public String DeptCount(){
		return "DeptCount";
	}
	
	@RequestMapping(value="St_type_count")
	public String St_type_count(){
		return "St_type_count";
	}
	
	@RequestMapping(value="OrderGCount")
	public String OrderGCount(){
		return "OrderGCount";
	}
	
	@RequestMapping(value="CARCount")
	public String CARCount(){
		return "CarCount";
	}
}
