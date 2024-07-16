package com.shinhan.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//Listener: HttpSessionListener

//@WebListener
public class MySessionListener implements HttpSessionListener {
	//변수
   String user_id;
   String user_pw;
   static int total_user = 0; //static(정적)객체 생성없이 사용가능
	   
    public MySessionListener() {
    	 System.out.println("MySessionListener 생성");
    }

    public MySessionListener(String user_id,String user_pw) {
        this.user_id = user_id;
        this.user_pw = user_pw;
    }
    public void sessionCreated(HttpSessionEvent se)  { 
    	++total_user;
    	  System.out.println("MySessionListener 생성...sessionCreated: " + total_user);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	--total_user;
    	  System.out.println("MySessionListener 소멸...sessionDestroyed: " + total_user);
    }
	//getter,setter
    public static int getTotal_user() {
    	return total_user;
    }
    public static void setTotal_user(int total_user) {
    	MySessionListener.total_user = total_user;
    }
    
}
