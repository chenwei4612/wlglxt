package com.chen.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lms.bean.Employee;
import com.chen.lms.bean.EmployeeExample;
import com.chen.lms.bean.EmployeeExample.Criteria;
import com.chen.lms.bean.Msg;
import com.chen.lms.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

	/**
	 * login
	 * @return
	 */
	public long loginByUserNameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		//long count = employeeMapper.loginByUserNameAndPassword(employee);
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(employee.getPhone());
		criteria.andPasswordEqualTo(employee.getPassword());
		long count = employeeMapper.countByExample2(example);
		long de=0;
		if(count == 1){
			Employee employee2=employeeMapper.selectByPrimaryKey(employee.getPhone());
			de=employee2.getDepId();
		}
//		System.out.println(count);
		return de;
	}
	public List<Employee> loginByUserNameAndPassword2(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.loginByUserNameAndPassword(employee);
	}


	/**
	 * Ա������
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertSelective(employee);
	}

	/**
	 * ����phone�Ƿ����
	 * 
	 * @param phone
	 * @return  true������ǰphone����   fasle��������
	 */
	public boolean checkUser(String phone) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		long count = employeeMapper.countByExample(example);
//		System.out.println("checkUser"+count);
		return count == 0;
	}
	/**
	 * ����emId�Ƿ����
	 * 
	 * @param emId
	 * @return  true������ǰemId����   fasle��������
	 */
	public boolean checkUser2(String emId) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo(emId);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * ����Ա��phone��ѯԱ��
	 * @param phone
	 * @return
	 */
	public Employee getEmp(String phone) {
		// TODO Auto-generated method stub
		Employee employee = employeeMapper.selectByPrimaryKey(phone);
		return employee;
	}

	/**
	 * Ա������
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	/**
	 * Ա��ɾ��
	 * @param id
	 */
	public void deleteEmp(String phone) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(phone);
	}
	/**
	 * Ա��ɾ��
	 * @param ids
	 */
	public void deleteBatch(List<String> phones) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andPhoneIn(phones);
		employeeMapper.deleteByExample(example);
	}
	/**
	 * ����emp_id��ѯԱ����Ϣ
	 * @param pn
	 * @return
	 */
	public List<Employee> getAll2(String empId) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdEqualTo(empId);
		return employeeMapper.selectByExampleWithDept(example);
	}
	/**
	 * Ա����Ϣͳ��
	 * @param sex
	 * @return
	 */
	public List<Employee> SexNumber() {
		List<Employee> list = employeeMapper.countSexNum(null);
		return list;
	}

	public List<Employee> RoleNumber() {
		List<Employee> list = employeeMapper.countRoleNum(null);
		return list;
	}

}
