package com.isoft.service;

import com.isoft.entity.Equipment;
import com.isoft.util.Page;

import java.util.Map;

/**
 * @author chenhy
 * @date @time 2019/6/19 13:13
 */
public interface IJournalService {

	public Page getList(Map<String,Object> params);

	public void update(Equipment equipment);

	public void delete(String id);

	public void add(Equipment equipment);
}
