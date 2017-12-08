package com.bbj.test.base.crud;

import org.springframework.stereotype.Repository;

import com.bbj.bizlogic.base.dao.BBJDao;
import com.bbj.bizlogic.base.domain.BBJEntity;

@Repository
public class DemoDao2 extends BBJDao{

	@Override
	public BBJEntity initEntity() {
		return new DemoDomain2();
	}

}
