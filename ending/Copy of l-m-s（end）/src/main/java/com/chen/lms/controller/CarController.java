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
import com.chen.lms.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ��������CRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class CarController {

	@Autowired
	CarService carService;
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/car/{carIds}",method=RequestMethod.DELETE)
	public Msg deleteCar(@PathVariable("carIds")String carIds){
		//����ɾ��
		if(carIds.contains("-")){
			List<Integer> del_carIds = new ArrayList<>();
			String[] str_carIds = carIds.split("-");
			//��װid�ļ���
			for (String string : str_carIds) {
				del_carIds.add(Integer.parseInt(string));
			}
			carService.deleteBatch(del_carIds);
		}else{
			Integer id = Integer.parseInt(carIds);
			carService.deleteCar(id);
		}
		return Msg.success();
	}
	
	/**
	 * ��·���·���
	 * @param route
	 * @return msg
	 */
	@ResponseBody
	@RequestMapping(value="/car/{carId}",method=RequestMethod.PUT)
	public Msg UpdateCar(Car car){
//		System.out.println("��Ҫ���µ�Ա�����ݣ�"+car);
//		System.out.println("�������е�idֵ��"+request.getParameter("carId"));
//		System.out.println("�������е�nameֵ��"+request.getParameter("roadId"));
		carService.updateCar(car);
		return Msg.success();
	}
	
	/**
	 * ����carId��ѯcar
	 * @param carId
	 * @return
	 */
	@RequestMapping(value="/car/{carId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getCar(@PathVariable("carId")Integer carId){
		System.out.println("sys"+carId);
		Car car = carService.getCar(carId);
		return Msg.success().add("emp", car);
	}
	
	/**
	 * car����
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * @return
	 */
	@RequestMapping(value="/car",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveCar(Car car){
//		System.out.println(car.getEmId());
//		System.out.println(car.getRoadId());
		carService.saveCar(car);
		return Msg.success();
	}
	
	/**
	 * ��ѯ��·���ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	//����������
	 @RequestMapping("/Clist")
	public String getCars(
			//�����ҳ����
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Car> cars = carService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(cars, 5);
		model.addAttribute("pageInfo", page);

		//��תҳ��
		return "car";
	}
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/cars")
	@ResponseBody
	public Msg getRoutesWithJspn(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 8);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Car> cars = carService.getAll();
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(cars, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * ����carid��ѯcar��Ϣ
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/carID/{carId}")
	@ResponseBody
	public Msg getRoutesWithJspn2(@PathVariable("carId")Integer carId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
			// ����PageHelper��ҳ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 8);
			// startPage��������������ѯ����һ����ҳ��ѯ
			List<Car> cars = carService.getAll2(carId);
			// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
			PageInfo page = new PageInfo(cars, 5);
//				model.addAttribute("pageInfo", page);
			return Msg.success().add("pageInfo", page);
	}
	/**
	 * carͳ��
	 * @param ��·
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CarCount")
	public Msg CarCount(){
		//���ݿ��û����ظ�У��
		List<Car> list = carService.CarCount();
		return Msg.success().add("cars", list);
	}
	/**
	 * carͳ��2
	 * @param ����
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CarCount2")
	public Msg CarCount2(){
		//���ݿ��û����ظ�У��
		List<Car> list = carService.CarCount2();
		return Msg.success().add("cars", list);
	}
}
