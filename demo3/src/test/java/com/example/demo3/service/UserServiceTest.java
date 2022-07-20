package com.example.demo3.service;

import com.example.demo3.DAO.UserDao;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService service;

    @BeforeEach
    public void init(){

    }

    @Test
    @DisplayName("Find By ID and return name")
    public void testGetNameByUserId(){
        UserDao userDao = PowerMockito.mock(UserDao.class);
        service= new UserService(userDao);
        PowerMockito.when(userDao.findByIdAndGiveName(101)).thenReturn("John");
         String actualName=service.getNameById(101);
         String expectedName="Nick";
         assertEquals(expectedName,actualName);
    }

    @Test
    @DisplayName("Find By ID and return email")
    public void testGetEmailByUserId(){
        UserDao userDao = PowerMockito.mock(UserDao.class);
        service= new UserService(userDao);
        PowerMockito.when(userDao.findByIdAndGiveName(101)).thenReturn("Nick@gmail.com");
        String actualName=service.getNameById(101);
        String expectedName="Nick@gmail.com";
        assertEquals(expectedName,actualName);
    }

    @Test
    @DisplayName("Test Mask Name Method")
    public void testhideNamePrivatemethodWithMock() throws Exception{
       UserService service = new UserService();
        String maskedName="";
        //we can only mock private methods using the spy objects
        UserService spy= PowerMockito.spy( new UserService());
            PowerMockito.when(spy,"maskName","suheab").thenReturn("***heab***s***u");
             maskedName=service.hideName("suheab");
        assertEquals("***heab***s***u",maskedName);
    }
}