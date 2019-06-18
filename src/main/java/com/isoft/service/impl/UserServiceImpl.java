package com.isoft.service.impl;

import com.isoft.dao.impl.UserDAOImpl;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDAOImpl userDAO;
    @Override
    public List<Map<String, String>> login(String uname, String upwd) {
        List<Map<String, String>> list = userDAO.login(uname, upwd);
        return list;
    }

    @Override
    public List<Map<String, String>> findAllUser(Map map) {
        List<Map<String, String>> allUser = userDAO.findAllUser(map);
        return allUser;
    }

    @Override
    public List<Map<String, String>> findCount() {
        List<Map<String, String>> allUser = userDAO.findCount();
        return allUser;
    }

    @Override
    public int deleteBatchById(String id) {
        int i = userDAO.deleteBatchById(id);
        return i;
    }

    @Override
    public List<Map<String, String>> userGenderAnalysis() {
        return userDAO.userGenderAnalysis();
    }

    @Override
    public int updataPhoto(Map map) {
        return userDAO.updataPhoto(map);
    }
}
