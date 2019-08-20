package com.newer.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {
    private Integer usercount = 0;

    public void sessionCreated(HttpSessionEvent arg0) {
        // arg0.getSession().setMaxInactiveInterval(30);
        System.out.println( arg0.getSession().getId() +  "--进入系统----hashcode=" + this.hashCode());
        usercount = usercount+1;
        System.out.println("当前在线人数" + usercount);
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        usercount = usercount-1;
        System.out.println( arg0.getSession().getId() +  "退出系统");
        System.out.println("当前在线人数" + usercount);
    }
}
