package com.formation.emergency.domain.dao.Impl;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.dao.IEquipmentSelector;

public class EquipmentSelectorImplTest {
	IEquipmentSelector selector = null; 
	ClassPathXmlApplicationContext context = null;
	SimpleDateFormat parser= new SimpleDateFormat("dd/MM/yyyy");
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		selector = (IEquipmentSelector) context.getBean("equipmentSelector");
		
	}

	@After
	public void tearDown() throws Exception {
		
		selector.findByCriteria(null, null, null, null, null,null);
	}

	@Test
	public void testFindByCriteria() {
		
	}

}
