package com.demo.mgr.function.user;

import com.demo.mgr.model.user.UserLoginRequest;
import com.demo.mgr.model.user.UserInfo;

import java.util.List;

public interface UserFunction {
    void userLogin(UserLoginRequest param);

    UserInfo getUserInfoById(Long id);

}
