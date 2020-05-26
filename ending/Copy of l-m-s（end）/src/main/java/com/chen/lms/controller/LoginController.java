package com.chen.lms.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.lms.bean.Employee;
import com.chen.lms.service.EmployeeService;

/**
 * Servlet implementation class LoginController
 */
@Controller
public class LoginController  {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Hello(){
		return "login";
	}
	
	@RequestMapping(value="reback")
	public String RBack(){
		return "login";
	}
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String Login(@RequestParam("phone") String phone,
			@RequestParam("password") String password, Map<String,Object> map,
			HttpSession session){
		session.setAttribute("loginUser",phone);
		System.out.println(phone);
		System.out.println(password);
        Employee employee = new Employee();
        employee.setPhone(phone);
        employee.setPassword(password);
		//		long b=Integer.parseInt(phone);
		long b =employeeService.loginByUserNameAndPassword(employee);
		System.out.println(b);
		if(b>4){
			return "index";
		}else if(b>2){
			return "index2";
		}else if(b>0){
			return "index3";
		}else{
			return "login";
		}
	}
}
