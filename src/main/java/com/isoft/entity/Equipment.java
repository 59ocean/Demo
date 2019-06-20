package com.isoft.entity;

import java.util.Date;

/**
 * @author chenhy
 * @date @time 2019/6/19 10:14
 */
public class Equipment {
	private String id;
	private String name;//名称
	private Date buyTime;//购买时间
	private String department;//所属科室
	private String supplier;//所属供应商
	private int overhaulCycle;//检修周期
	private Date lastOverhaulTime;//上次检修时间

	public String getId () {
		return id;
	}

	public void setId (String id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Date getBuyTime () {
		return buyTime;
	}

	public void setBuyTime (Date buyTime) {
		this.buyTime = buyTime;
	}

	public String getDepartment () {
		return department;
	}

	public void setDepartment (String department) {
		this.department = department;
	}

	public String getSupplier () {
		return supplier;
	}

	public void setSupplier (String supplier) {
		this.supplier = supplier;
	}

	public int getOverhaulCycle () {
		return overhaulCycle;
	}

	public void setOverhaulCycle (int overhaulCycle) {
		this.overhaulCycle = overhaulCycle;
	}

	public Date getLastOverhaulTime () {
		return lastOverhaulTime;
	}

	public void setLastOverhaulTime (Date lastOverhaulTime) {
		this.lastOverhaulTime = lastOverhaulTime;
	}
}
