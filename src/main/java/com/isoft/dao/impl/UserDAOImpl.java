package com.isoft.dao.impl;

import com.isoft.dao.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Override
    public List<Map<String, String>> login(String uname, String upwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String statement="com.isoft.mapping.userMapper.findUserByUnameAndUpwd";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        List<Map<String, String>> list = sqlSession.selectList(statement,map);
        return list;
    }

    @Override
    public List<Map<String, String>> findAllUser(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String statement="com.isoft.mapping.userMapper.findAllUser";
        List<Map<String, String>> list = sqlSession.selectList(statement,map);
        return list;

    }

    @Override
    public List<Map<String, String>> findCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String statement="com.isoft.mapping.userMapper.findCount";
        List<Map<String, String>> list = sqlSession.selectList(statement);
        return list;
    }

    @Override
    public List<Map<String, String>> userGenderAnalysis() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String statement="com.isoft.mapping.userMapper.userGenderAnalySis";
        List<Map<String, String>> list = sqlSession.selectList(statement);
        return list;
    }

    @Override
    public int deleteBatchById(String id) {
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            String statement="com.isoft.mapping.userMapper.deleteBatchById";
            int i= sqlSession.delete(statement,id);
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updataPhoto(Map map) {
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            String statement="com.isoft.mapping.userMapper.updatePhoto";
            int i= sqlSession.update(statement,map);
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
