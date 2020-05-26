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
import com.chen.lms.bean.OrderG;
import com.chen.lms.bean.Route;
import com.chen.lms.bean.Storehouse;
import com.chen.lms.service.StorehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ����ֿ�CRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class StorehouseController {

	@Autowired
	StorehouseService storehouseService;
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/storehouse/{storeIds}",method=RequestMethod.DELETE)
	public Msg deletestorehouse(@PathVariable("storeIds")String storeIds){
		//����ɾ��
		if(storeIds.contains("-")){
			List<Integer> del_storeIds = new ArrayList<>();
			String[] str_storeIds = storeIds.split("-");
			//��װid�ļ���
			for (String string : str_storeIds) {
				del_storeIds.add(Integer.parseInt(string));
			}
			storehouseService.deleteBatch(del_storeIds);
		}else{
			Integer id = Integer.parseInt(storeIds);
			storehouseService.deleteStorehouse(id);
		}
		return Msg.success();
	}
	
	/**
	 * �ֿ���·���
	 * @param route
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/storehouse/{storeId}",method=RequestMethod.PUT)
	public Msg updateStorehouse(Storehouse storehouse){
		//System.out.println(route.getRouId());
//		System.out.println("��Ҫ���µ�Ա�����ݣ�"+storehouse);
//		System.out.println("�������е�idֵ��"+request.getParameter("storeId"));
//		System.out.println("�������е�nameֵ��"+request.getParameter("date"));
		storehouseService.updateStorehouse(storehouse);
		return Msg.success();
	}
	
	/**
	 * ����storeId��ѯstore
	 * @param rouId
	 * @return
	 */
	@RequestMapping(value="/storehouse/{storeId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getStorehouse(@PathVariable("storeId")Integer storeId){
		System.out.println("sys"+storeId);
		Storehouse storehouse = storehouseService.getStorehouse(storeId);
		return Msg.success().add("emp", storehouse);
	}
	
	/**
	 * Storehouse����
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * 
	 * @return
	 */
	@RequestMapping(value="/storehouse",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStorehouse(Storehouse storehouse){
//		System.out.println(storehouse.getDate());
//		System.out.println(storehouse.getType());
//		System.out.println(storehouse.getNumber());
//		System.out.println(storehouse.getStState());
//		System.out.println(storehouse.getRemark());
//		String storeId= storeId(storehouse);
//		storehouse.setStoreId(storeId);
		storehouseService.saveStorehouse(storehouse);
		return Msg.success();
	}
	
	/**
	 * �������еĲֿ�������Ϣ
	 */
	@RequestMapping("/shtype")
	@ResponseBody
	public Msg getType(){
		//��������в�����Ϣ
		List<Storehouse> list = storehouseService.getType();
		return Msg.success().add("storehouse", list);
	}
	
	/**
	 * ��ѯ�ֿ����ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	//����������
	 @RequestMapping("/Shlist")
	public String getStorehouses(
			//�����ҳ����
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Storehouse> storehouses = storehouseService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(storehouses, 5);
		model.addAttribute("pageInfo", page);

		//��תҳ��
		return "list";
	}
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/storehouses")
	@ResponseBody
	public Msg getStorehousesWithJspn(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 7);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Storehouse> storehouses = storehouseService.getAll();
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(storehouses, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * ���ֿ�id�Ƿ����
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser5")
	public Msg checkuser(@RequestParam("stId")Integer stId){
		
		//���ݿ��û����ظ�У��
		boolean b = storehouseService.checkUser5(stId);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "stId������");
		}
	}
	
	/**
	 * ���ݲֿ�id��ѯ�ֿ���Ϣ
	 * @param pn
	 * @return
	 */
	@RequestMapping("/storehousesID/{storeId}")
	@ResponseBody
	public Msg getStorehousesWithJspn2(@PathVariable("storeId")Integer storeId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 7);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Storehouse> storehouses = storehouseService.getAll2(storeId);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(storehouses, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * �ֿ���Ϣͳ��
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/StCount")
	public Msg StCount(){
		//���ݿ��û����ظ�У��
		List<Storehouse> list = storehouseService.StCount();
		return Msg.success().add("sths", list);
	}
}
