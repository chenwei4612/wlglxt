package com.chen.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lms.bean.OrderG;
import com.chen.lms.bean.OrderGExample;
import com.chen.lms.bean.OrderGExample.Criteria;
import com.chen.lms.dao.OrderGMapper;


@Service
public class OrderGService {
	
	@Autowired
	OrderGMapper orderGMapper;
	//����ʡ��
	String srpr(int n){
		String s="";
		if (n==8) {
			s="������";
		}else if (n==14) {
			s="ɽ��ʡ";
		}else if (n==9) {
			s="����ʡ";
		}else if (n==33) {
			s="�Ϻ���";
		}else if (n==10) {
			s="�㽭ʡ";
		}else if (n==12) {
			s="����ʡ";
		}else if (n==3) {
			s="����ʡ";
		}else if (n==13) {
			s="����ʡ";
		}else if (n==1) {
			s="�㶫ʡ";
		}else if (n==25) {
			s="����׳��������";
		}else if (n==2) {
			s="����ʡ";
		}else if (n==15) {
			s="����ʡ";
		}else if (n==17) {
			s="����ʡ";
		}else if (n==16) {
			s="����ʡ";
		}else if (n==31) {
			s="������";
		}else if (n==11) {
			s="�ӱ�ʡ";
		}else if (n==5) {
			s="ɽ��ʡ";
		}else if (n==24) {
			s="���ɹ�������";
		}else if (n==27) {
			s="���Ļ���������";
		}else if (n==23) {
			s="�ຣʡ";
		}else if (n==21) {
			s="����ʡ";
		}else if (n==22) {
			s="����ʡ";
		}else if (n==28) {
			s="�½�ά���������";
		}else if (n==18) {
			s="�Ĵ�ʡ";
		}else if (n==19) {
			s="������";
		}else if (n==34) {
			s="������";
		}else if (n==20) {
			s="����ʡ";
		}else if (n==26) {
			s="����������";
		}else if (n==32) {
			s="�����";
		}else if (n==6) {
			s="����ʡ";
		}else if (n==7) {
			s="����ʡ";
		}else if (n==29) {
			s="�����";
		}else if (n==30) {
			s="������";
		}else if (n==4) {
			s="̨����";
		}else{
			s="";
		}
		return s;
	}
	//�ջ���ַ
	int sraddress(String s){
		int n=0;
		if (s.indexOf("����")!=-1) {
			n=8;
		}else if (s.indexOf("ɽ��")!=-1) {
			n=14;
		}else if (s.indexOf("����")!=-1) {
			n=9;
		}else if (s.indexOf("�Ϻ�")!=-1) {
			n=33;
		}else if (s.indexOf("�㽭")!=-1) {
			n=10;
		}else if (s.indexOf("����")!=-1) {
			n=12;
		}else if (s.indexOf("����")!=-1) {
			n=3;
		}else if (s.indexOf("����")!=-1) {
			n=13;
		}else if (s.indexOf("�㶫")!=-1) {
			n=1;
		}else if (s.indexOf("����")!=-1) {
			n=25;
		}else if (s.indexOf("����")!=-1) {
			n=2;
		}else if (s.indexOf("����")!=-1) {
			n=15;
		}else if (s.indexOf("����")!=-1) {
			n=17;
		}else if (s.indexOf("����")!=-1) {
			n=16;
		}else if (s.indexOf("����")!=-1) {
			n=31;
		}else if (s.indexOf("�ӱ�")!=-1) {
			n=11;
		}else if (s.indexOf("ɽ��")!=-1) {
			n=5;
		}else if (s.indexOf("���ɹ�")!=-1) {
			n=24;
		}else if (s.indexOf("����")!=-1) {
			n=27;
		}else if (s.indexOf("�ຣ")!=-1) {
			n=23;
		}else if (s.indexOf("����")!=-1) {
			n=21;
		}else if (s.indexOf("����")!=-1) {
			n=22;
		}else if (s.indexOf("�½�")!=-1) {
			n=28;
		}else if (s.indexOf("�Ĵ�")!=-1) {
			n=18;
		}else if (s.indexOf("����")!=-1) {
			n=19;
		}else if (s.indexOf("����")!=-1) {
			n=20;
		}else if (s.indexOf("����")!=-1) {
			n=34;
		}else if (s.indexOf("����")!=-1) {
			n=20;
		}else if (s.indexOf("����")!=-1) {
			n=26;
		}else if (s.indexOf("���")!=-1) {
			n=32;
		}else if (s.indexOf("����")!=-1) {
			n=6;
		}else if (s.indexOf("����")!=-1) {
			n=7;
		}else if (s.indexOf("���")!=-1) {
			n=29;
		}else if (s.indexOf("����")!=-1) {
			n=30;
		}else if (s.indexOf("̨��")!=-1) {
			n=4;
		}else{
			n=0;
		}
		return n;
	}

	/**
	 * ��ѯ�������ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	public List<OrderG> getAll() {
		// TODO Auto-generated method stub
		return orderGMapper.selectByExampleWithBLOBs(null);
	}

	/**
	 * �¶�������
	 * 1��֧��JSR303У��
	 * 2������Hibernate-Validator
	 * @return
	 */
	public void saveOrderG(OrderG orderG) {
		// TODO Auto-generated method stub
		orderGMapper.insertSelective(orderG);
	}


	/**
	 * ����ordId��ѯorderG
	 * @param rouId
	 * @return
	 */
	public OrderG getOrderG(String carId) {
		// TODO Auto-generated method stub
		OrderG orderG = orderGMapper.selectByPrimaryKey(carId);
		String rpr=orderG.getRaddress().substring(0, 2);
		//orderG.setRpovince(rpr);
		String spr=orderG.getSaddress().substring(0, 2);
		//System.out.println(orderG.getSaddress());
		int rpi=sraddress(rpr);
		int spi=sraddress(spr);
		orderG.setRpi(rpi);
		orderG.setSpi(spi);
		System.out.println(rpr+" "+rpi);
		System.out.println(spr+" "+spi);
		//orderG.setRpovince(spr);
		return orderG;
	}

	/**
	 * �������·���
	 * @param route
	 * @return
	 */
	public void updateOrderG(OrderG orderG) {
		// TODO Auto-generated method stub
//		String rprovin=orderG.getRpovince();
//		String sprovin=orderG.getSpovince();
		int rapr=Integer.parseInt(orderG.getRpovince());
		int sapr=Integer.parseInt(orderG.getSpovince());
		String raddress=srpr(rapr)+orderG.getRaddress().substring(2);
		String saddress=srpr(sapr)+orderG.getSaddress().substring(3);
//		System.out.println("ors"+rapr);
//		System.out.println("ors"+sapr);
//		System.out.println("ors"+raddress);
//		System.out.println("ors"+saddress);
		orderG.setRaddress(raddress);
		orderG.setSaddress(saddress);
//		System.out.println(rprovin+sprovin);
//		System.out.println(rapr+sapr);
		orderGMapper.updateByPrimaryKeySelective(orderG);
	}

	/**
	 * ����ɾ��
	 * @param id
	 */
	public void deleteOrderG(String id) {
		// TODO Auto-generated method stub
		orderGMapper.deleteByPrimaryKey(id);
	}
	/**
	 * ����ɾ��
	 * @param ids
	 */
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		OrderGExample  example = new OrderGExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andOrdIdIn(ids);
		orderGMapper.deleteByExample(example);
	}
	/**
	 * ����orId�Ƿ����
	 * @param orId
	 * @return  true������ǰorId����   fasle��������
	 */
	public boolean checkUser4(String orId) {
		// TODO Auto-generated method stub
		OrderGExample example = new OrderGExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrdIdEqualTo(orId);
		long count = orderGMapper.countByExample(example);
		return count == 1;
	}
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param pn
	 * @return
	 */
	public List<OrderG> getOrderG2(String ordid) {
		// TODO Auto-generated method stub
		//OrderG orderG = orderGMapper.selectByPrimaryKey(ordid);
		OrderGExample example = new OrderGExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrdIdEqualTo(ordid);
		return orderGMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * ������Ϣͳ��
	 * @param year
	 * @return
	 */
	public List<OrderG> OrdNumber() {
		// TODO Auto-generated method stub
		return orderGMapper.selectByOCN();
	}
	/**
	 * ������Ϣͳ��
	 * @param month
	 * @return
	 */
	public List<OrderG> OrdNumber2() {
		// TODO Auto-generated method stub
		return orderGMapper.selectByOCN2();
	}

}
