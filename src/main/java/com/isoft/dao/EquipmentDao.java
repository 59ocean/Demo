package com.isoft.dao;

import com.isoft.entity.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date @time 2019/6/19 13:16
 */

public interface EquipmentDao {
	public List findAll(Map map);
	public int getCount(Map map);

	public void add(Equipment equipment);

	public void delete(String id);

	public void update(Equipment equipment);
}
