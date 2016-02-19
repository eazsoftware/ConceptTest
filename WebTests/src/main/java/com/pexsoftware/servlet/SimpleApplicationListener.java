package com.pexsoftware.servlet;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class SimpleApplicationListener implements ServletContextListener 
{

    public void contextInitialized(ServletContextEvent evt) {
         System.out.println("contextInitialized loaded!");
    }

    public void contextDestroyed(ServletContextEvent evt) {
        
    }        
    
}