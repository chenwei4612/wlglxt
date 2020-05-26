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
 * ����ʡ��CRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class PrController {

	@Autowired
	PrService prService;
	
	/**
	 * �������е�ʡ����Ϣ
	 */
	@RequestMapping("/Prs")
	@ResponseBody
	public Msg getPrs(){
		//���������ʡ����Ϣ
		List<Province> list = prService.getPrs();
		return Msg.success().add("pr", list);
	}
}
