package com.bbj.test.base.entity;

import com.bbj.test.base.crud.DemoDomain;

public class TestDomain {

	public static void main(String[] args) {
		DemoDomain demo = new DemoDomain();
		System.out.println(demo.getTableName());
		System.out.println(demo.getAttr(DemoDomain.id));
		System.out.println(demo.getAttrKeys());
	}
	
}
