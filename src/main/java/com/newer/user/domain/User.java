package com.newer.user.domain;

/**
 * 用户模块实体类
 *
 * @author qdmmy6
 */
/*
 * 属性哪里来
 * 1. t_user表：因为我们需要把t_user表查询出的数据封装到User对象中
 * 2. 该模块所有表单：因为我们需要把表单数据封装到User对象中
 */
public class User {
    // 对应数据库表
    private String uid;//主键
    private String loginname;//登录名
    private String loginpass;//登录密码
    private String email;//邮箱
    private int status;//状态，true表示已激活，或者未激活
    private String activationCode;//激活码，它是唯一值！即每个用户的激活码是不同的！

    // 注册表单
    private String reloginpass;//确认密码
//    private String verifyCode;//验证码

    // 修改密码表单
    private String newpass;//新密码

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getReloginpass() {
        return reloginpass;
    }

    public void setReloginpass(String reloginpass) {
        this.reloginpass = reloginpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }
}
