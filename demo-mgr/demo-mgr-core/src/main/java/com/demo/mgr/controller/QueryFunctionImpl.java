package com.demo.mgr.controller;

import com.demo.mgr.model.user.UserInfo;
import com.demo.mgr.function.user.UserFunction;

import com.oceancode.cloud.annotation.Query;
import com.oceancode.cloud.api.permission.Permission;
import com.oceancode.cloud.api.permission.PermissionConst;
import com.oceancode.cloud.common.util.ComponentUtil;
import com.oceancode.cloud.function.QueryFunction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryFunctionImpl implements QueryFunction {
    @Permission(authorities = {PermissionConst.AUTHORITY_LOGIN})
    @Query(name = "user_info")
    public UserInfo getUserInfoById0(Long id) {
        return ComponentUtil.getBean(UserFunction.class).getUserInfoById(id);
    }

}
