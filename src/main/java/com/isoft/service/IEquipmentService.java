package com.isoft.service;

import com.isoft.entity.Equipment;
import com.isoft.util.Page;

import java.util.Map;

/**
 * @author chenhy
 * @date @time 2019/6/19 13:15
 */
public interface IEquipmentService {

	public Page getList(Map<String,Object> params);
	public Page getList2(Map<String,Object> params);

	public void update(Equipment equipment);

	public void delete(String id);

	public void add(Equipment equipment);
}
