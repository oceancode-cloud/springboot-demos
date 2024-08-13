package com.demo.mgr.controller;

import com.demo.mgr.model.user.UserLoginRequest;
import com.demo.mgr.function.user.UserFunction;

import com.oceancode.cloud.api.permission.Permission;
import com.oceancode.cloud.api.permission.PermissionConst;
import com.oceancode.cloud.common.constant.CommonConst;
import com.oceancode.cloud.common.entity.ResultData;
import com.oceancode.cloud.common.util.ComponentUtil;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CommonConst.API_PREFIX)
public class ApiController {

    @Permission(authorities = {PermissionConst.AUTHORITY_UN_LOGIN})
    @PostMapping("user/login")
    public ResultData<Void> userLogin0( @RequestBody UserLoginRequest param) {
        ComponentUtil.getBean(UserFunction.class).userLogin(param);
        return ResultData.isOk();
    }

}
