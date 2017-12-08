package com.bbj.test.base.crud;

import com.bbj.bizlogic.base.domain.BBJEntity;

public class DemoDomain2 extends BBJEntity{

	private static final long serialVersionUID = 1L;

	public static final String tableName = "base_demo2";
	
	public static final String attr1 = "attr3";
	public static final String attr2 = "attr4";
	public static final String attr3 = "attr5";
	
	@Override
	public String initTable() {
		return tableName;
	}

	@Override
	public String[] initAttr() {
		return new String[]{attr1,attr2,attr3};
	}
	
}
