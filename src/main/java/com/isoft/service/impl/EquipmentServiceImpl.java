package com.isoft.service.impl;

import com.isoft.dao.EquipmentDao;
import com.isoft.entity.Equipment;
import com.isoft.service.IEquipmentService;
import com.isoft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date @time 2019/6/19 13:15
 */
@Service
public class EquipmentServiceImpl implements IEquipmentService {
	@Autowired
	private EquipmentDao equipmentDao;
	@Override
	public Page getList (Map<String,Object> params) {
		List list = equipmentDao.findAll(params);
		int count = equipmentDao.getCount(params);
		Page page = new Page();
		page.setCode("0");
		page.setMsg("操作成功");
		page.setCount(count);
		page.setData(list);
		return page;
	}
	@Override
	public Page getList2 (Map<String,Object> params) {
		List list = equipmentDao.findWarnAll(params);
		int count = equipmentDao.getCount(params);
		Page page = new Page();
		page.setCode("0");
		page.setMsg("操作成功");
		page.setCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public void update (Equipment equipment) {
		equipmentDao.update(equipment);
	}

	@Override
	public void delete (String id) {
		equipmentDao.delete(id);
	}

	@Override
	public void add (Equipment equipment) {
		equipmentDao.add(equipment);
	}
}
