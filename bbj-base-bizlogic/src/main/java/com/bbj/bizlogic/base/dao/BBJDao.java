package com.bbj.bizlogic.base.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.bbj.bizlogic.base.domain.BBJEntity;
import com.bbj.bizlogic.base.utils.StringUtils;

public abstract class BBJDao{
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	protected BBJEntity curruntBBJEntity;
	
	public BBJDao() {
		curruntBBJEntity = initEntity();
	}

	public abstract BBJEntity initEntity();


	/**
	 * 增加一条记录
	 * @param bbjEntity
	 * @return the number of rows affected
	 */
	public int insert(BBJEntity bbjEntity){
		List<String> listAttrKeys = bbjEntity.getAttrKeys();
		// 构造参数列表
		StringBuilder sbAttrKeys = new StringBuilder();
		StringBuilder sbParamAttr = new StringBuilder();
		List<String> listParamAttr = new ArrayList<String>();
		for(int i = 0;i < listAttrKeys.size();i ++){
			String key = listAttrKeys.get(i);
			if(StringUtils.isNotEmpty(key)){
				if(sbAttrKeys.length() == 0){
					sbAttrKeys.append(key);
					sbParamAttr.append("?");
				}else{
					sbAttrKeys.append(","+key);
					sbParamAttr.append(",?");
				}
				listParamAttr.add(bbjEntity.getAttr(key));
			}
		}
		String insertSql = " insert into " + bbjEntity.getTableName() 
						+ "(" + sbAttrKeys.toString() + ")"
						+ "values("	+ sbParamAttr.toString() + ")" ;
		return jdbcTemplate.update(insertSql, listParamAttr.toArray(new Object[0]));
	}
	
	/**
	 * 根据主键进行删除
	 * @param primaryValue
	 * @return the number of rows affected
	 */
	public int deleteById(String primaryValue){
		String updateSql = " update " + curruntBBJEntity.getTableName() 
						+ " set " + BBJEntity.delete_state + " = " + BBJEntity.delete_state_yes 
						+ " where " + BBJEntity.id + " = ?";
		return jdbcTemplate.update(updateSql, new Object[]{primaryValue});
	}
	/**
	 * 修改一条记录
	 * @param bbjEntity
	 * @return the number of rows affected
	 */
	public int update(BBJEntity bbjEntity){
		List<String> listAttrKeys = bbjEntity.getAttrKeys();
		// 构造参数列表
		StringBuilder sbParamAttrPair = new StringBuilder();
		List<String> listParamAttr = new ArrayList<String>();
		for(int i = 0;i < listAttrKeys.size();i ++){
			String key = listAttrKeys.get(i);
			if(StringUtils.isNotEmpty(key) && !BBJEntity.id.equals(key)){
				if(sbParamAttrPair.length() == 0){
					sbParamAttrPair.append(key + "=?");
				}else{
					sbParamAttrPair.append("," + key + "=?");
				}
				listParamAttr.add(bbjEntity.getAttr(key));
			}
		}
		int sex = 1;
		switch (sex) {
		case 1: // 男
			
			break;
		case 2: // 女
			
			break;

		default:
			break;
		}
		listParamAttr.add(bbjEntity.getAttr(BBJEntity.id));
		String insertSql = " update " + bbjEntity.getTableName() 
						+ " set "
						+ sbParamAttrPair.toString()
						+ " where " + BBJEntity.id + "=?";
		return jdbcTemplate.update(insertSql, listParamAttr.toArray(new Object[0]));
	}
	
	/**
	 * 根据主键值查找一个对象
	 * @param primaryValue
	 * @return
	 */
	public BBJEntity queryById(String primaryValue){
		String sql = "  select "+curruntBBJEntity.getAttrKeysStr()
					+ " from " + curruntBBJEntity.getTableName() 
					+ " where " + BBJEntity.id + " = ? " 
					+ " and " + BBJEntity.delete_state + " <> ? ";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, primaryValue,BBJEntity.delete_state_yes);
		
		if(rs.next()){
			BBJEntity bbjEntity = new BBJEntity() {
				private static final long serialVersionUID = 1L;
				@Override
				public String initTable() {
					return curruntBBJEntity.getTableName();
				}
				@Override
				public String[] initAttr() {
					return curruntBBJEntity.getAttrKeys().toArray(new String[0]);
				}
			};
			List<String> keys = curruntBBJEntity.getAttrKeys();
			for (int i = 0; i < keys.size(); i++) {
				bbjEntity.setAttr(keys.get(i), rs.getString(keys.get(i)));
			}
			return bbjEntity;
		}
		return null;
	}
	
	/**
	 * 分页查询(不支持过滤)
	 * @return
	 */
	public List<BBJEntity> queryByPage(int tagPage,int pageSize){
		
		int totalRow = getTotalRow();
		int totalPage = getTotalRow() / pageSize;
		if(totalPage *  pageSize < totalRow){ // 不能够整除，总页数应该 + 1
			totalPage = totalPage + 1;
		}
		if(tagPage <= 0){
			tagPage = totalPage;
		}		
		int startId = pageSize * (tagPage - 1 );
		
		String sql = " select "+curruntBBJEntity.getAttrKeysStr()
				+ " from " + curruntBBJEntity.getTableName() 
				+ " where " + BBJEntity.delete_state + " <> ? limit ?,? ";
				
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,new Object[]{BBJEntity.delete_state_yes,startId,pageSize});
		List<BBJEntity> list = new ArrayList<BBJEntity>();
		while(rs.next()){
			BBJEntity bbjEntity = new BBJEntity() {
				private static final long serialVersionUID = 1L;
				@Override
				public String initTable() {
					return curruntBBJEntity.getTableName();
				}
				@Override
				public String[] initAttr() {
					return curruntBBJEntity.getAttrKeys().toArray(new String[0]);
				}
			};
			List<String> keys = curruntBBJEntity.getAttrKeys();
			for (int i = 0; i < keys.size(); i++) {
				bbjEntity.setAttr(keys.get(i), rs.getString(keys.get(i)));
			}
			list.add(bbjEntity);
		}
		return list;
	}
	
	/**
	 * 查询有多少条记录
	 * @return
	 */
	public int getTotalRow(){
		String sql = " select count(1) from " + curruntBBJEntity.getTableName() 
				+ " where " + BBJEntity.delete_state + " <> ? " ;
		int row = jdbcTemplate.queryForObject(sql,new Object[]{BBJEntity.delete_state_yes},Integer.class);
		return row <=0 ? 1 : row;
	}
}
