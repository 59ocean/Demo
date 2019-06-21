package com.isoft.service.impl;

import com.isoft.dao.EquipmentDao;
import com.isoft.dao.JournalDao;
import com.isoft.entity.Equipment;
import com.isoft.service.IJournalService;
import com.isoft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date @time 2019/6/19 13:12
 */
@Service
public class JournalServiceImpl implements IJournalService {

	@Autowired
	private JournalDao journalDao;

	@Override
	public Page getList (Map<String,Object> params) {
		List list = journalDao.findAll(params);
		int count = journalDao.getCount(params);
		Page page = new Page();
		page.setCode("0");
		page.setMsg("操作成功");
		page.setCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public void update (Equipment equipment) {
		journalDao.update(equipment);
	}

	@Override
	public void delete (String id) {
		journalDao.delete(id);
	}

	@Override
	public void add (Equipment equipment) {
		journalDao.add(equipment);
	}
}
