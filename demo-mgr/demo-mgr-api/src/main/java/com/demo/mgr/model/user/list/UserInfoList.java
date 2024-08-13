package com.demo.mgr.model.user.list;

import com.demo.mgr.model.user.UserInfo;

import java.util.ArrayList;
import java.util.Collection;

public class UserInfoList extends ArrayList<UserInfo> {

    public UserInfoList(Collection<? extends UserInfo> c) {
        super(c);
    }

    public UserInfoList() {
    }
}
