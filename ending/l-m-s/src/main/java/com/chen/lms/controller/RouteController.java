package com.chen.lms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.lms.bean.Msg;
import com.chen.lms.bean.Route;
import com.chen.lms.service.RouteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ������·CRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class RouteController {

	@Autowired
	RouteService routeService;
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/route/{rouIds}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("rouIds")String rouIds){
		//����ɾ��
		if(rouIds.contains("-")){
			List<Integer> del_rouIds = new ArrayList<>();
			String[] str_rouIds = rouIds.split("-");
			//��װid�ļ���
			for (String string : str_rouIds) {
				del_rouIds.add(Integer.parseInt(string));
			}
			routeService.deleteBatch(del_rouIds);
		}else{
			Integer id = Integer.parseInt(rouIds);
			routeService.deleteRoute(id);
		}
		return Msg.success();
	}
	
	/**
	 * ��·���·���
	 * @param route
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/route/{rouId}",method=RequestMethod.PUT)
	public Msg updateRoute(Route route){
		//System.out.println(route.getRouId());
//		System.out.println("��Ҫ���µ�Ա�����ݣ�"+route);
//		System.out.println("�������е�idֵ��"+request.getParameter("rouId"));
//		System.out.println("�������е�nameֵ��"+request.getParameter("area"));
		routeService.updateRoute(route);
		return Msg.success();
	}
	
	/**
	 * ����rouId��ѯ��·
	 * @param rouId
	 * @return
	 */
	@RequestMapping(value="/route/{rouId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getRoute(@PathVariable("rouId")Integer rouId){
		System.out.println("sys"+rouId);
		Route route = routeService.getRoute(rouId);
		return Msg.success().add("emp", route);
	}
	
	/**
	 * ��·����
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * @return
	 */
	@RequestMapping(value="/route",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveRoute(Route route){
//		System.out.println(route.getArea());
//		System.out.println(route.getDscope());
		routeService.saveRoute(route);
		return Msg.success();
	}
	
	/**
	 * ��ѯ��·���ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	//����������
	 @RequestMapping("/Rlist")
	public String getRoutes(
			//�����ҳ����
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Route> routes = routeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(routes, 5);
		model.addAttribute("pageInfo", page);

		//��תҳ��
		return "list";
	}
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/routes")
	@ResponseBody
	public Msg getRoutesWithJspn(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 5);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Route> routes = routeService.getAll();
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(routes, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * �������е�route��Ϣ
	 */
	@RequestMapping("/Routes")
	@ResponseBody
	public Msg getRoutes(){
		//�����������·��Ϣ
		List<Route> list = routeService.getRoutes();
		return Msg.success().add("routes", list);
	}
	/**
	 * ������·id��ѯ��·
	 * @param ��·
	 * @return
	 */
	@RequestMapping("/routesID/{rouId}")
	@ResponseBody
	public Msg getRoutesWithJspn2(@PathVariable("rouId")Integer rouId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 5);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Route> routes = routeService.getAll2(rouId);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(routes, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
}
