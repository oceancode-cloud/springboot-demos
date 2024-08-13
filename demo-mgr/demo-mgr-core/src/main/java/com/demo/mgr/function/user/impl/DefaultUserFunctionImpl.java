package com.demo.mgr.function.user.impl;

import com.demo.mgr.model.user.UserLoginRequest;
import com.demo.mgr.model.user.UserInfo;

import com.oceancode.cloud.common.function.BaseFunction;
import com.demo.mgr.function.user.UserFunction;
import com.oceancode.cloud.common.util.CheckParamUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class DefaultUserFunctionImpl extends BaseFunction<UserFunction> implements UserFunction {
    @Override
    protected Class<UserFunction> getInterfaceClass() {
        return UserFunction.class;
    }

    @Override
    public void userLogin(UserLoginRequest param) {
        CheckParamUtil.checkParam(param);
        getService().userLogin(param);
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
        CheckParamUtil.notEmpty(id, "id");
        CheckParamUtil.checkPrimaryKey(id,"id");
        return getService().getUserInfoById(id);
    }

}
