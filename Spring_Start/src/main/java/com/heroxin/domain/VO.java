package com.heroxin.domain;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-21-15:18
 * @Description:
 */
public class VO {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
