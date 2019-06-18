package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String,String>> login(String uname, String upwd);
    List<Map<String,String>> findAllUser(Map map);
    List<Map<String,String>> findCount();
    int deleteBatchById(String id);
    List<Map<String,String>> userGenderAnalysis();
    int updataPhoto(Map map);
}
