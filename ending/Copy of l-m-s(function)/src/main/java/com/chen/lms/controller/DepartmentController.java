package com.chen.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.lms.bean.Department;
import com.chen.lms.bean.Msg;
import com.chen.lms.service.DepartmentService;

/**
 * ����Ͳ����йص�����
 * @author cw
 *
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * �������еĲ�����Ϣ
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//��������в�����Ϣ
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
	/**
	 * �������еĲ���ͳ��
	 */
	@RequestMapping("/deptNs")
	@ResponseBody
	public Msg getDeptNs(){
		List<Department> list = departmentService.getDeptNs();
		return Msg.success().add("depts", list);
	}
}
