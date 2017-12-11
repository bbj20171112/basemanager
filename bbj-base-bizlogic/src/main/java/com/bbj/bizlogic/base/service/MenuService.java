package com.bbj.bizlogic.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bbj.bizlogic.base.domain.MenuObject;
import com.bbj.bizlogic.base.utils.JsonUtils;
import com.bbj.bizlogic.base.utils.PrintUtils;

@Service(value="menuService")
public class MenuService {

	public static void main(String[] args) {
		List<MenuObject> list = new MenuService().retrieve();
		PrintUtils.println(list);
		System.out.println(JsonUtils.toJson(list));
	}
	/**
	 * 查询
	 * @return
	 */
	public List<MenuObject> retrieve(){
		List<MenuObject> list = generateMenuData();
		return buildMenuTree(list);
	}

	private List<MenuObject> buildMenuTree(List<MenuObject> list) {
		List<MenuObject> roots = new ArrayList<MenuObject>();
		
		MenuObject childMenu = null;
		MenuObject parentMenu = null;
		boolean[] isFoundParent = new boolean[list.size()];
		for (int i = 0; i < list.size(); i++) {
			
			if(isFoundParent[i]){
				continue ;
			}
			childMenu = list.get(i);
			if("-1".equals(childMenu.getAttributes().get("upId"))){
				roots.add(childMenu);
			}
			for (int j = 0; j < list.size(); j++) {
				parentMenu = list.get(j);
				if(childMenu.getAttributes().get("upId").equals(parentMenu.getAttributes().get("id"))){
					parentMenu.addChildren(childMenu);
					isFoundParent[j] = true;
				}
			}
		}
		return roots;
		
	}

	/**
	 * 模拟生成数据
	 * @return
	 */
	private List<MenuObject> generateMenuData() {
		List<MenuObject> list = new ArrayList<MenuObject>();
		
		Map<String, String> attr = new HashMap<String, String>();
		attr.put("id", "0");
		attr.put("upId", "-1");
		attr.put("text", "");
		attr.put("link", "template/blank");
		MenuObject menu = new MenuObject(attr );
		list.add(menu );
		
		attr = new HashMap<String, String>();
		attr.put("id", "1");
		attr.put("upId", "0");
		attr.put("text", "menu1");
		attr.put("link", "template/500");
		menu = new MenuObject(attr );
		list.add(menu );
		
		attr = new HashMap<String, String>();
		attr.put("id", "2");
		attr.put("upId", "0");
		attr.put("text", "menu2");
		attr.put("link", "template/invoice");
		menu = new MenuObject(attr );
		list.add(menu );

		attr = new HashMap<String, String>();
		attr.put("id", "3");
		attr.put("upId", "0");
		attr.put("text", "JackW");
		attr.put("link", "template/profile");
		menu = new MenuObject(attr );
		list.add(menu );
		
		attr = new HashMap<String, String>();
		attr.put("id", "9");
		attr.put("upId", "3");
		attr.put("text", "register");
		attr.put("link", "/base/widgets/register");
		menu = new MenuObject(attr );
		list.add(menu );
		
		attr = new HashMap<String, String>();
		attr.put("id", "10");
		attr.put("upId", "3");
		attr.put("text", "login");
		attr.put("link", "/base/widgets/login");
		menu = new MenuObject(attr );
		list.add(menu );

		attr = new HashMap<String, String>();
		attr.put("id", "4");
		attr.put("upId", "1");
		attr.put("text", "menu4");
		attr.put("link", "template/lockscreen");
		menu = new MenuObject(attr );
		list.add(menu );

		attr = new HashMap<String, String>();
		attr.put("id", "5");
		attr.put("upId", "1");
		attr.put("text", "menu5");
		attr.put("link", "template/404");
		menu = new MenuObject(attr );
		list.add(menu );

		attr = new HashMap<String, String>();
		attr.put("id", "6");
		attr.put("upId", "4");
		attr.put("text", "menu6");
		attr.put("link", "template/login");
		menu = new MenuObject(attr );
		list.add(menu );

		attr = new HashMap<String, String>();
		attr.put("id", "7");
		attr.put("upId", "6");
		attr.put("text", "menu7");
		menu = new MenuObject(attr );
		list.add(menu );

		attr = new HashMap<String, String>();
		attr.put("id", "8");
		attr.put("upId", "4");
		attr.put("text", "menu8");
		menu = new MenuObject(attr );
		list.add(menu );
		
		return list;
		
	}
	
}
