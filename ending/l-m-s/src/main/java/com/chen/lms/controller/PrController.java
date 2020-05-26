package com.chen.lms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.lms.bean.Msg;
import com.chen.lms.bean.Province;
import com.chen.lms.service.PrService;

/**
 * 处理省份CRUD请求
 * 
 * @author cw
 * 
 */
@Controller
public class PrController {

	@Autowired
	PrService prService;
	
	/**
	 * 返回所有的省份信息
	 */
	@RequestMapping("/Prs")
	@ResponseBody
	public Msg getPrs(){
		//查出的所有省份信息
		List<Province> list = prService.getPrs();
		return Msg.success().add("pr", list);
	}
}
