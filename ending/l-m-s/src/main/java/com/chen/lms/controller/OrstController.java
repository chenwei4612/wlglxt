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

import com.chen.lms.bean.Car;
import com.chen.lms.bean.Msg;
import com.chen.lms.bean.Orst;
import com.chen.lms.service.OrstService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ��������ϸ��ϢCRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class OrstController {

	@Autowired
	OrstService orstService;
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/orst/{orIds}",method=RequestMethod.DELETE)
	public Msg deleteOrst(@PathVariable("orIds")String orIds){
		//����ɾ��
		if(orIds.contains("-")){
			List<String> del_orIds = new ArrayList<>();
			String[] str_orIds = orIds.split("-");
			//��װid�ļ���
			for (String string : str_orIds) {
				del_orIds.add(string);
			}
			orstService.deleteBatch(del_orIds);
		}else{
			
			orstService.deleteOrst(orIds);
		}
		return Msg.success();
	}
	
	/**
	 * ������ϸ���·���
	 * @param orst
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/orst/{orId}",method=RequestMethod.PUT)
	public Msg updateOrst(Orst orst){
		//System.out.println(route.getRouId());
//		System.out.println("��Ҫ���µ�Ա�����ݣ�"+orst);
//		System.out.println("�������е�idֵ��"+request.getParameter("orId"));
//		System.out.println("�������е�nameֵ��"+request.getParameter("status"));
		orstService.updateOrst(orst);
		return Msg.success();
	}
	
	/**
	 * ����orId��ѯor
	 * @param orId
	 * @return
	 */
	@RequestMapping(value="/orst/{orId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getOrst(@PathVariable("orId")String orId){
//		System.out.println("sys"+orId);
		List<Orst> ol = orstService.getOrst(orId);
//		System.out.println("ol"+ol.get(0));
//		System.out.println("ol"+ol.get(0).getOrId());
	    Orst orst=new Orst();
	    orst.setOrId(ol.get(0).getOrId());
	    orst.setRoId(ol.get(0).getRoId());
	    orst.setStatus(ol.get(0).getStatus());
	    orst.setStId(ol.get(0).getStId());
	    orst.setCarId(ol.get(0).getCarId());
		return Msg.success().add("emp", orst);
	}
	
	
	/**
	 * orst����
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * @return
	 */
	@RequestMapping(value="/orst",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveOrst(Orst orst){
//		System.out.println(orst.getStatus());
//		System.out.println(orst.getRoId());
		orstService.saveOrst(orst);
		return Msg.success();
	}
	
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/orsts")
	@ResponseBody
	public Msg getOrstsWithJspn(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 8);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Orst> orsts = orstService.getAll();
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(orsts, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * ����id��ѯ��Ϣ
	 * @param st
	 * @return
	 */
	@RequestMapping("/orstsST/{stId}")
	@ResponseBody
	public Msg getOrstsWithJspn2(@PathVariable("stId")int stId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
//		System.out.println(stId);
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 8);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Orst> orsts = orstService.getAll2(stId);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(orsts, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * ����id��ѯ��Ϣ
	 * @param or
	 * @return
	 */
	@RequestMapping("/orstsOR/{orId}")
	@ResponseBody
	public Msg getOrstsWithJspn3(@PathVariable("orId")String orId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		System.out.println(orId);//
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 8);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Orst> orsts = orstService.getAll3(orId);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(orsts, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * ����id��ѯ��Ϣ
	 * @param or
	 * @return
	 */
	@RequestMapping("/orstscar/{carId}")
	@ResponseBody
	public Msg getOrstsWithJspn4(@PathVariable("carId")int carId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		System.out.println(carId);//
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 8);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Orst> orsts = orstService.getAll4(carId);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(orsts, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * ��������ͳ��
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/OrstCount")
	public Msg OrstCount(){
		List<Orst> list = orstService.OrstCount();
		return Msg.success().add("orsts", list);
	}
	/**
	 * �ֿ�������ͳ��
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/OrstCount2")
	public Msg OrstCount2(){
		List<Orst> list = orstService.OrstCount2();
		return Msg.success().add("orsts", list);
	}
}
