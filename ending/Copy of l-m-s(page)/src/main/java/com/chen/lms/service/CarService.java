package com.chen.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lms.bean.Car;
import com.chen.lms.bean.CarExample;
import com.chen.lms.bean.CarExample.Criteria;
import com.chen.lms.dao.CarMapper;

@Service
public class CarService {
	
	@Autowired
	CarMapper carMapper;

	/**
	 * ��ѯ���г�����Ϣ
	 * @return
	 */
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return carMapper.selectByExample(null);
	}



	/**
	 * ��car����
	 * @param employee
	 */
	public void saveCar(Car car) {
		// TODO Auto-generated method stub
		carMapper.insertSelective(car);
	}


	/**
	 * ����Ա��carId��ѯcar
	 * @param carId
	 * @return
	 */
	public Car getCar(Integer carId) {
		// TODO Auto-generated method stub
		Car car = carMapper.selectByPrimaryKey(carId);
		return car;
	}

	/**
	 * ��·����
	 * @param Route
	 */
	public void updateCar(Car car) {
		// TODO Auto-generated method stub
		carMapper.updateByPrimaryKeySelective(car);
	}

	/**
	 * ��·ɾ��
	 * @param id
	 */
	public void deleteCar(Integer id) {
		// TODO Auto-generated method stub
		carMapper.deleteByPrimaryKey(id);
	}
	/**
	 * ��·ɾ��
	 * @param ids
	 */
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		CarExample  example = new CarExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andCarIdIn(ids);
		carMapper.deleteByExample(example);
	}
	
	/**
	 * ���ݳ���id��ѯ������Ϣ
	 * @param ids
	 */
	public List<Car> getAll2(Integer carId) {
		// TODO Auto-generated method stub
		CarExample  example = new CarExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andCarIdEqualTo(carId);
		return carMapper.selectByExample(example);
	}

	/**
	 * ������Ϣͳ��
	 * @param ��·
	 */
	public List<Car> CarCount() {
		// TODO Auto-generated method stub
		return carMapper.selectByCCN();
	}

	/**
	 * ������Ϣͳ��
	 * @param ����
	 */
	public List<Car> CarCount2() {
		// TODO Auto-generated method stub
		return carMapper.selectByCCN2();
	}

}
