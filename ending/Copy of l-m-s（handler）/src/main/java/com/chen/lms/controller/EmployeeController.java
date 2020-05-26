package com.chen.lms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.chen.lms.bean.Employee;
import com.chen.lms.bean.Msg;
import com.chen.lms.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ����Ա��CRUD����
 * 
 * @author cw
 * 
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{phones}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("phones")String phones){
		//����ɾ��
		if(phones.contains("-")){
			List<String> del_phones = new ArrayList<>();
			String[] str_phones = phones.split("-");
			//��װphone�ļ���
			for (String string : str_phones) {
				del_phones.add(string);
			}
			employeeService.deleteBatch(del_phones);
		}else{
			String id = phones;
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	
	String Epid(String dp,String ro){
		Date date =new Date();
		String id = new SimpleDateFormat("yyyyMM").format(date)+dp+ro+(int)(Math.random()*123+12);
		return id;
	}
	/**
	 * ���ֱ�ӷ���ajax=PUT��ʽ������
	 * ��װ������
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * ���⣺
	 * �������������ݣ�
	 * ����Employee�����װ���ϣ�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * ԭ��
	 * Tomcat��
	 * 		1�����������е����ݣ���װһ��map��
	 * 		2��request.getParameter("empName")�ͻ�����map��ȡֵ��
	 * 		3��SpringMVC��װPOJO�����ʱ��
	 * 				���POJO��ÿ�����Ե�ֵ��request.getParamter("email");
	 * AJAX����PUT����������Ѫ����
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò���
	 * 		Tomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װ������Ϊmap
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * ���������
	 * ����Ҫ��֧��ֱ�ӷ���PUT֮�������Ҫ��װ�������е�����
	 * 1��������HttpPutFormContentFilter��
	 * 2���������ã����������е����ݽ�����װ��һ��map��
	 * 3��request�����°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 * Ա�����·���
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{phone}",method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee){
		System.out.println("��Ҫ���µ�Ա�����ݣ�"+employee);
//		System.out.println("�������е�ֵ��"+request.getParameter("sex"));
//		System.out.println("�������е�idֵ��"+request.getParameter("empId"));
//		System.out.println("�������е�nameֵ��"+request.getParameter("name"));
//		String id=request.getParameter("empId");
        String	id=employee.getEmpId();	
		String depid=employee.getDepId()+"";
		String roleid=employee.getRole()+"";
		String empId;
		if(depid.equals(null+"")&&roleid.equals(null+"")){
			empId=id;
		}else {
			empId=depid+roleid+id.substring(2, id.length());
		}
		employee.setEmpId(empId);
		employeeService.updateEmp(employee);
		return Msg.success()	;
	}
	
	/**
	 * Ա��������·���
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/empup/{phone}",method=RequestMethod.PUT)
	public Msg saveEmp2(Employee employee,HttpServletRequest request){
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	
	
	/**
	 * ����phone��ѯԱ��
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/emp/{phone}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("phone")String phone){
//		System.out.println("sys"+phone);
		Employee employee = employeeService.getEmp(phone);
//		System.out.println(employee.getName());
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * ���phone�Ƿ����
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("phone")String phone){
		//���ж��û����Ƿ��ǺϷ��ı��ʽ;
		String regx = "(^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$)";
		if(!phone.matches(regx)){
			return Msg.fail().add("va_msg", "������Ϸ��ֻ���");
		}
		//���ݿ��û����ظ�У��
		boolean b = employeeService.checkUser(phone);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "�ֻ�������");
		}
	}
	
	/**
	 * ���id�Ƿ����
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser2")
	public Msg checkuser2(@RequestParam("emId")String emId){
		//���ݿ��û����ظ�У��
		boolean b = employeeService.checkUser2(emId);
		if(b){
			return Msg.fail().add("va_msg", "Ա��id������");
		}else{
			return Msg.success();
		}
	}
	
	
	/**
	 * Ա������
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			//У��ʧ�ܣ�Ӧ�÷���ʧ�ܣ���ģ̬������ʾУ��ʧ�ܵĴ�����Ϣ
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("������ֶ�����"+fieldError.getField());
				System.out.println("������Ϣ��"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			String depid=employee.getDepId()+"";
			String roleid=employee.getRole()+"";
			String empId=Epid(depid, roleid);
//			System.out.println(empId);
			employee.setEmpId(empId);
			employeeService.saveEmp(employee);
			return Msg.success();
		}
		
	}

	
	/**
	 * ��ѯԱ�����ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	//����������
	 @RequestMapping("/employee")
	public String getEmps(
			//�����ҳ����
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);

		return "employee";
		//��תҳ��
//		return "employee";
	}
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJspn(@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model){
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 8);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
	//	model.addAttribute("pageInfo", page);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * ����emp_id��ѯԱ����Ϣ
	 * @param pn
	 * @return
	 */
	@RequestMapping("/empsEP/{empId}")
	@ResponseBody
	public Msg getEmpsWithJspn2(@PathVariable("empId")String empId,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 8);
		// startPage��������������ѯ����һ����ҳ��ѯ
		System.out.println(empId);
		List<Employee> emps = employeeService.getAll2(empId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
//		model.addAttribute("pageInfo", page);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * Ա����Ϣͳ��
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/EmSexCount")
	public Msg DepNumber(){
		//���ݿ��û����ظ�У��
		List<Employee> list = employeeService.SexNumber();
		return Msg.success().add("emps", list);
	}
	
	/**
	 * Ա����Ϣͳ��
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/EmRoleCount")
	public Msg RolepNumber(){
		//���ݿ��û����ظ�У��
		List<Employee> list = employeeService.RoleNumber();
		return Msg.success().add("emps", list);
	}
	
	/**
	 * ���phone�Ƿ���ô���
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuserPhone")
	public Msg checkuserPhone(@RequestParam("phone")String phone){
		//���ж��û����Ƿ��ǺϷ��ı��ʽ;
		String regx = "(^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$)";
		if(!phone.matches(regx)){
			return Msg.fail().add("va_msg", "������Ϸ��ֻ���");
		}
		//���ݿ��û����ظ�У��
		boolean b = employeeService.checkUser(phone);
		if(b){
//			System.out.println("1");
			return Msg.fail().add("va_msg", "�ֻ������û򲻴��������䣡");
		}else{
//			System.out.println("0");
			return Msg.success();
		}
	}
}
