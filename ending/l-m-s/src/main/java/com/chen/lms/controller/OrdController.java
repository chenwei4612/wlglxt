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
import com.chen.lms.service.OrderGService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ������CRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class OrdController {

	@Autowired
	OrderGService orderGService;
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/orderG/{ordIds}",method=RequestMethod.DELETE)
	public Msg deleteorderG(@PathVariable("ordIds")String ordIds){
		//����ɾ��
		if(ordIds.contains("-")){
			List<String> del_ordIds = new ArrayList<>();
			String[] str_ordIds = ordIds.split("-");
			//��װid�ļ���
			for (String string : str_ordIds) {
				del_ordIds.add(string);
			}
			orderGService.deleteBatch(del_ordIds);
		}else{
			orderGService.deleteOrderG(ordIds);
		}
		return Msg.success();
	}
	//ʡ��
	String Rr1(String s){
    	String ss="";
    	if (s.indexOf("����")!=-1) {
			ss="000000";
		}else if (s.indexOf("ɽ��")!=-1) {
			ss="0000001";
		}else if (s.indexOf("����")!=-1) {
			ss="000010";
		}else if (s.indexOf("�Ϻ�")!=-1) {
			ss="000011";
		}else if (s.indexOf("�㽭")!=-1) {
			ss="000100";
		}else if (s.indexOf("����")!=-1) {
			ss="000101";
		}else if (s.indexOf("����")!=-1) {
			ss="000110";
		}else if (s.indexOf("����")!=-1) {
			ss="000111";
		}else if (s.indexOf("�㶫")!=-1) {
			ss="001000";
		}else if (s.indexOf("����")!=-1) {
			ss="001001";
		}else if (s.indexOf("����")!=-1) {
			ss="001010";
		}else if (s.indexOf("����")!=-1) {
			ss="001011";
		}else if (s.indexOf("����")!=-1) {
			ss="001100";
		}else if (s.indexOf("����")!=-1) {
			ss="001101";
		}else if (s.indexOf("����")!=-1) {
			ss="001110";
		}else if (s.indexOf("�ӱ�")!=-1) {
			ss="001111";
		}else if (s.indexOf("ɽ��")!=-1) {
			ss="010000";
		}else if (s.indexOf("���ɹ�")!=-1) {
			ss="010001";
		}else if (s.indexOf("����")!=-1) {
			ss="010010";
		}else if (s.indexOf("�ຣ")!=-1) {
			ss="010011";
		}else if (s.indexOf("����")!=-1) {
			ss="010100";
		}else if (s.indexOf("����")!=-1) {
			ss="010101";
		}else if (s.indexOf("�½�")!=-1) {
			ss="010110";
		}else if (s.indexOf("�Ĵ�")!=-1) {
			ss="010111";
		}else if (s.indexOf("����")!=-1) {
			ss="011000";
		}else if (s.indexOf("����")!=-1) {
			ss="011001";
		}else if (s.indexOf("����")!=-1) {
			ss="011010";
		}else if (s.indexOf("����")!=-1) {
			ss="011011";
		}else if (s.indexOf("����")!=-1) {
			ss="011100";
		}else if (s.indexOf("���")!=-1) {
			ss="011101";
		}else if (s.indexOf("����")!=-1) {
			ss="011110";
		}else if (s.indexOf("����")!=-1) {
			ss="011111";
		}else if (s.indexOf("���")!=-1) {
			ss="100000";
		}else if (s.indexOf("����")!=-1) {
			ss="110000";
		}else if (s.indexOf("̨��")!=-1) {
			ss="101000";
		}else{
			ss="111111";
		}
    	return ss;
    }
	//����ID
	String ordId(OrderG orderG){
		String a=(orderG.getDate()).replace('-', ' ');
		String da=a.replace(" ", "");
		String date=da.substring(2);
		//System.out.println(date);
		String rr= Rr1(orderG.getRaddress());
		String ordId =date+rr+(int)(Math.random()*100000+1234);
		//System.out.println(ordId);
		return ordId;
	}
	
	/**
	 * �������·���
	 * @param route
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/orderG/{ordId}",method=RequestMethod.PUT)
	public Msg updateOrderG(OrderG orderG){
		//System.out.println(route.getRouId());
//		System.out.println("��Ҫ���µ�Ա�����ݣ�"+orderG);
//		System.out.println("�������е�idֵ��"+request.getParameter("ordId"));
//		System.out.println("�������е�nameֵ��"+request.getParameter("date"));
		orderGService.updateOrderG(orderG);
		return Msg.success();
	}
	
	/**
	 * ����ordId��ѯorderG
	 * @param rouId
	 * @return
	 */
	@RequestMapping(value="/orderG/{ordId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getOrderG(@PathVariable("ordId")String ordId){
//		System.out.println("sys"+ordId);
		OrderG orderG = orderGService.getOrderG(ordId);
		return Msg.success().add("emp", orderG);
	}
	
	/**
	 * �¶�������
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * @return
	 */
	@RequestMapping(value="/orderG",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveOrderG(OrderG orderG){
//		System.out.println(orderG.getDate());
//		System.out.println(orderG.getRaddress());
		String raddress=orderG.getRpovince()+orderG.getRcity()+orderG.getRaddress();
		String saddress=orderG.getSpovince()+orderG.getScity()+orderG.getSaddress();
//		System.out.println(raddress);
//		System.out.println(saddress);
//		System.out.println(storehouse.getNumber());
//		System.out.println(storehouse.getStState());
//		System.out.println(storehouse.getRemark());
		String ordId= ordId(orderG);
		orderG.setOrdId(ordId);
		orderG.setRaddress(raddress);
		orderG.setSaddress(saddress);
		orderGService.saveOrderG(orderG);
		return Msg.success();
	}
	
	/**
	 * ��ѯ�������ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	//����������
	 @RequestMapping("/OGlist")
	public String getOrderGs(
			//�����ҳ����
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<OrderG> orderGs = orderGService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(orderGs, 7);
		model.addAttribute("pageInfo", page);
		//��תҳ��
		return "list";
	}
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/orderGs")
	@ResponseBody
	public Msg getOrderGsWithJspn(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 7);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<OrderG> orderGs = orderGService.getAll();
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(orderGs, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * ���orId�Ƿ����
	 * @param orId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser4")
	public Msg checkuser(@RequestParam("orId")String orId){
		boolean b = orderGService.checkUser4(orId);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "orId������");
		}
	}
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/orderGs/{orid}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getOrderGsWithJspn2(@PathVariable("orid")String ordid,Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			int pn=1;
			PageHelper.startPage(pn, 7);
			// startPage��������������ѯ����һ����ҳ��ѯ
			System.out.println("pn="+pn);
			System.out.println("ordid="+ordid);
			List<OrderG> orderGs =orderGService.getOrderG2(ordid);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(orderGs, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * ������Ϣͳ��
	 * @param year
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/OrdCount")
	public Msg OrdNumber(){
		List<OrderG> list = orderGService.OrdNumber();
		return Msg.success().add("ords", list);
	}
	/**
	 * ������Ϣͳ��
	 * @param month
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/OrdCount2")
	public Msg OrdNumber2(){
		List<OrderG> list = orderGService.OrdNumber2();
		return Msg.success().add("ords", list);
	}
}
