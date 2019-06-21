package com.isoft.action;

import com.isoft.entity.Equipment;
import com.isoft.service.IEquipmentService;
import com.isoft.service.IJournalService;
import com.isoft.util.Json;
import com.isoft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author chenhy
 * @date @time 2019/6/19 13:31
 */
@Controller
@Scope("prototype")
@RequestMapping("/journal")
public class JurnalAction {
	@Autowired
	private IJournalService journalService;

	@RequestMapping("/list")
	@ResponseBody
	public Page list(HttpServletRequest request){
		String equipmentName = request.getParameter("equipmentName");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		Map<String,Object> params = new HashMap<>();
		params.put("equipmentName",equipmentName);
		int startIndex = (Integer.valueOf(page) - 1) * Integer.valueOf(limit);
		params.put("startIndex",startIndex);
		params.put("limit",Integer.valueOf(limit));
		return journalService.getList(params);
	}

	@RequestMapping(value="/add.do")
	@ResponseBody
	public Json add(Equipment equipment,String buyTime2) throws ParseException {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println("ddddddddd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		equipment.setBuyTime(sdf.parse(buyTime2));
		equipment.setId(uuid);
		journalService.add(equipment);

		return Json.ok();
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public Json delete(String id){
		journalService.delete(id);
		System.out.println(id);
		return Json.ok();
	}



	@RequestMapping(value="/update.do",method = RequestMethod.POST)
	@ResponseBody
	public Json update(Equipment equipment,String buyTime2) throws ParseException {
	/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		equipment.setBuyTime(sdf.parse(buyTime2));*/
		journalService.update(equipment);
		return Json.ok();
	}




}
