package com.isoft.entity;

/**
 * @author chenhy
 * @date @time 2019/6/19 10:17
 */
public class journal {
	private String id;
	private String equipmentName;//设备名称
	private String overhaulTime;//检修时间
	private String faultReason;//故障原因
	private String department;//所属科室


	public String getId () {
		return id;
	}

	public void setId (String id) {
		this.id = id;
	}

	public String getEquipmentName () {
		return equipmentName;
	}

	public void setEquipmentName (String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getOverhaulTime () {
		return overhaulTime;
	}

	public void setOverhaulTime (String overhaulTime) {
		this.overhaulTime = overhaulTime;
	}

	public String getFaultReason () {
		return faultReason;
	}

	public void setFaultReason (String faultReason) {
		this.faultReason = faultReason;
	}

	public String getDepartment () {
		return department;
	}

	public void setDepartment (String department) {
		this.department = department;
	}
}
