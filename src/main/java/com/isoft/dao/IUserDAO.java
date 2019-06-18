package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IUserDAO {
    List<Map<String,String>> login(String uname, String upwd);
    List<Map<String,String>> findAllUser(Map map);
    List<Map<String,String>> findCount();
    List<Map<String,String>> userGenderAnalysis();
    int deleteBatchById(String id);
    int updataPhoto(Map map);
}
