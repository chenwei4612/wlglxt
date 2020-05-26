package com.chen.lms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.lms.bean.Msg;
import com.chen.lms.bean.Position;
import com.chen.lms.service.PositionService;

/**
 * �����ְλ�йص�����
 * @author cw
 *
 */
@Controller
public class PositionController {
	@Autowired
	private PositionService positionService;
	/**
	 * �������е�ְλ��Ϣ
	 */
	@RequestMapping("/roles")
	@ResponseBody
	public Msg getRolets(){
		//���������ְλ��Ϣ
		List<Position> list = positionService.getRoles();
		return Msg.success().add("roles", list);
	}

}
