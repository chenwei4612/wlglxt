package com.chen.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lms.bean.OrderGExample;
import com.chen.lms.bean.Storehouse;
import com.chen.lms.bean.StorehouseExample;
import com.chen.lms.bean.StorehouseExample.Criteria;
import com.chen.lms.dao.StorehouseMapper;

@Service
public class StorehouseService {
	
	@Autowired
	StorehouseMapper storehouseMapper;

	/**
	 * ��ѯ�ֿ����ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	public List<Storehouse> getAll() {
		// TODO Auto-generated method stub
		return storehouseMapper.selectByExampleWithBLOBs(null);
	}

	/**
	 * Storehouse����
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * 
	 * @return
	 */
	public void saveStorehouse(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseMapper.insertSelective(storehouse);
	}


	/**
	 * ����storeId��ѯstore
	 * @param rouId
	 * @return
	 */
	public Storehouse getStorehouse(int storeId) {
		// TODO Auto-generated method stub
		Storehouse storehouse = storehouseMapper.selectByPrimaryKey(storeId);
		return storehouse;
	}

	/**
	 * �ֿ���·���
	 * @param route
	 * @return
	 */
	public void updateStorehouse(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseMapper.updateByPrimaryKeySelective(storehouse);
	}

	/**
	 * �ֿ�ɾ��
	 * @param id
	 */
	public void deleteStorehouse(int id) {
		// TODO Auto-generated method stub
		storehouseMapper.deleteByPrimaryKey(id);
	}
	/**
	 * �ֿ�ɾ��
	 * @param ids
	 */
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		StorehouseExample  example = new StorehouseExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andStoreIdIn(ids);
		storehouseMapper.deleteByExample(example);
	}
	
	/**
	 * �������еĲֿ�������Ϣ
	 */
	public List<Storehouse> getType() {
		// TODO Auto-generated method stub
		List<Storehouse> list =storehouseMapper.selecttype(null);
		return list;
	}
	
	/**
	 * ���ֿ�id�Ƿ����
	 * @param phone
	 * @return
	 */
	public boolean checkUser5(Integer stId) {
		// TODO Auto-generated method stub
		StorehouseExample example = new StorehouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStoreIdEqualTo(stId);
		long count = storehouseMapper.countByExample(example);
		return count == 1;
	}

	/**
	 * ���ݲֿ�id��ѯ�ֿ���Ϣ
	 * @param pn
	 * @return
	 */
	public List<Storehouse> getAll2(Integer storeId) {
		// TODO Auto-generated method stub
		StorehouseExample example = new StorehouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStoreIdEqualTo(storeId);
		return storehouseMapper.selectByExampleWithBLOBs(example);
	}

	/**
	 * �ֿ���Ϣͳ��
	 * @param num
	 * @return
	 */
	public List<Storehouse> StCount() {
		// TODO Auto-generated method stub
		return storehouseMapper.selecttypeCount();
	}

}
