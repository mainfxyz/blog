package com.service;

public interface UserSerInt {
    boolean login(String passswd, String user);

    boolean logout();

    void say(Integer id,String body);

    void say(Integer id,String body,Integer reply);


}