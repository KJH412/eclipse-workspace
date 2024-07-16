package com.shinhan.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	  System.out.println("ServletContextListener 소멸");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("ServletContextListener 초기화(처음으로 초기화)");
    }
	
}
