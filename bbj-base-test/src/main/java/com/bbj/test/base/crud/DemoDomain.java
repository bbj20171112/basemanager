package com.bbj.test.base.crud;

import com.bbj.bizlogic.base.domain.BBJEntity;

public class DemoDomain extends BBJEntity{

	private static final long serialVersionUID = 1L;

	public static final String tableName = "base_demo";
	
	public static final String attr1 = "attr1";
	public static final String attr2 = "attr2";
	public static final String attr3 = "attr3";
	
	@Override
	public String initTable() {
		return tableName;
	}

	@Override
	public String[] initAttr() {
		return new String[]{attr1,attr2,attr3};
	}
	
}
