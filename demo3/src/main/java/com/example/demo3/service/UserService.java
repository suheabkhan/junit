package com.example.demo3.service;

import com.example.demo3.DAO.UserDao;

public class UserService {

    UserDao userDao;
    public UserService(){

    }
    public UserService( UserDao userDao){
        this.userDao=userDao;
    }
    public String getNameById(int id){
       String name=userDao.findByIdAndGiveName(id);
       return name;
    }
    public String getEmailById(int id){
        String email=userDao.findByIdAndGiveEmail(id);
        return email;
    }
    public String hideName(String name){
        String maskedName=maskName(name);
        return maskedName;
    }
    private String maskName(String name){
        return "***"+name.substring(2)+"***"+name.charAt(0)+"***"+name.charAt(1);
    }
}
