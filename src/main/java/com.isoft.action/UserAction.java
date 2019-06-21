package com.isoft.action;

import com.isoft.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/displayTest.do", method = RequestMethod.POST)
    @ResponseBody
    public List displayTest() {
        System.out.println("action test");
        List list = new ArrayList();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");
        System.out.println(list.toString());
        return list;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("uname") String uname, String upwd, HttpSession session) {

        List<Map<String, String>> list = userServiceImpl.login(uname, upwd);
        if (list.size() > 0) {
            session.setAttribute("uname", uname);
            session.setAttribute("user",list.get(0));
            return "success";
        } else {
            return "fails";
        }
    }

    @RequestMapping(value = "/deleteBanchByID.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteBanchById(String id) {
        String[] arr = id.split(",");
        int i = 0;
        for (String str : arr) {
            i = userServiceImpl.deleteBatchById(str);
        }
        if (i > 0) {
            return "success";
        } else {
            return "fault";
        }
    }

    @RequestMapping(value = "/uploadPhoto.do", method = RequestMethod.POST)
    @ResponseBody
    public Map uploadPhoto(MultipartFile file, HttpSession session) throws IOException {
        List allowPhotoTypelist = new ArrayList();
        allowPhotoTypelist.add(".jpg");
        allowPhotoTypelist.add(".png");
        allowPhotoTypelist.add(".bmp");
        allowPhotoTypelist.add(".jpeg");
        allowPhotoTypelist.add(".gif");
        Map map = new HashMap();
        String fileName = file.getOriginalFilename();
        System.out.print("上传的文件名：" + fileName);
        String extName = fileName.substring(fileName.lastIndexOf("."));
        if (allowPhotoTypelist.contains(extName)) {
            String realPath = session.getServletContext().getRealPath("images");
            File target = new File(realPath);
            if (!target.exists())
                target.mkdir();
            String newFileName = new Date().getTime() + extName;
            target = new File(realPath, newFileName);
            file.transferTo(target);
            map.put("uname", session.getAttribute("uname").toString());
            map.put("photo", "images/" + newFileName);
            userServiceImpl.updataPhoto(map);
            map.clear();
            map.put("code", 0);
        } else
            map.put("code", 2);
        return map;
    }

    @RequestMapping(value = "/findAllUser.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> findAllUser(String uname, int page, int limit) {
        System.out.print(uname);
        Map map = new HashMap();
        if (uname != null)
            map.put("uname", uname);
        map.put("recordIndex", (page - 1) * limit);
        map.put("pagesize", limit);
        List<Map<String, String>> allUser = userServiceImpl.findAllUser(map);
        List<Map<String, String>> count = userServiceImpl.findCount();
        map.clear();
        map.put("code", 0);
        map.put("msg", "查询记录成功");
        map.put("count", count.get(0).get("count"));
        map.put("data", allUser);
        return map;
    }

    @RequestMapping(value = "/userGenderAnalysis.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> userGenderAnalysis() {
        List<Map<String, String>> list = userServiceImpl.userGenderAnalysis();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for (Map map1 : list) {
            list1.add(map1.get("gender"));
            list2.add(map1.get("count"));
        }
        Map map = new HashMap();
        map.put("gender", list1);
        map.put("count", list2);
        return map;
    }

    @RequestMapping(value = "/manPercent.do", method = RequestMethod.GET)
    @ResponseBody
    public double manPercent() {
        List<Map<String, String>> list = userServiceImpl.userGenderAnalysis();
        int count = 0;
        int man = 0;

        for (Map map1 : list) {
            if (map1.get("gender").toString().equals("男")) {
                man = Integer.parseInt(map1.get("count").toString());
            }
            count += Integer.parseInt(map1.get("count").toString());
        }

        return (double) man / count;
    }
}
