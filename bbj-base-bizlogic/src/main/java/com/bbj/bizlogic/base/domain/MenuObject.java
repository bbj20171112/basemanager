package com.bbj.bizlogic.base.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单对象
 * @author bage
 *
 */
public class MenuObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// 菜单属性
	private Map<String,String> attributes = new HashMap<String, String>();
	// 子菜单
	private List<MenuObject> children = new ArrayList<MenuObject>();
	
	// 构造函数
	public MenuObject() {
		super();
	}
	public MenuObject(Map<String, String> attributes) {
		super();
		this.attributes = attributes;
	}
	public MenuObject(Map<String, String> attributes, List<MenuObject> children) {
		super();
		this.attributes = attributes;
		this.children = children;
	}
	
	// 设置属性
	/**
	 * 获取属性
	 * @return
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}
	/**
	 * 重新设置属性
	 * @param attributes
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	/**
	 * 增加或设置属性
	 * @param key
	 * @param value
	 */
	public void addAttributes(String key,String value) {
		this.attributes.put(key, value);
	}
	/**
	 * 删除属性
	 * @param key
	 */
	public void deleteAttributes(String key) {
		if(this.attributes.containsKey(key)){
			this.attributes.remove(key);
		}
	}
	/**
	 * 包含属性
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key) {
		return this.attributes.containsKey(key);
	}
	// 设置子菜单
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<MenuObject> getChildren() {
		return children;
	}
	/**
	 * 重新设置子菜单
	 * @param children
	 */
	public void setChildren(List<MenuObject> children) {
		this.children = children;
	}
	/**
	 * 增加子菜单
	 * @param children
	 */
	public void addChildren(List<MenuObject> children) {
		this.children.addAll(children);
	}
	/**
	 * 覆盖性增加子菜单
	 * @param menu
	 */
	public void addChildren(MenuObject menu) {
		if(this.children.contains(menu)){
			this.children.remove(menu);
		}
		this.children.add(menu);
	}
	/**
	 * 删除子菜单
	 * @param menu
	 */
	public void deleteChildren(MenuObject menu) {
		if(this.children.contains(menu)){
			this.children.remove(menu);
		}
	}
	/**
	 * 清空所有子菜单
	 */
	public void deleteChildrenAll() {
		this.children.clear();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuObject other = (MenuObject) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (attributes.get("id") == null) {
			if (other.attributes.get("id") != null)
				return false;
		} else if (!attributes.get("id").equals(other.attributes.get("id")))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Menu [attributes=" + attributes + ", children=" + children + "]";
	}
	
}
