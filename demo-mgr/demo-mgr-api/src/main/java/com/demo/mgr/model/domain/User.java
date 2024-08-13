package com.demo.mgr.model.domain;

import com.demo.mgr.model.domain.BaseTimeDomain;
import com.oceancode.cloud.api.validation.Validator;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.BusinessRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;

public class User extends BaseTimeDomain implements Validator  {
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 登录账号
     */
    private String username;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void validate() {
        super.validate();
        if (this.nickname!=null && this.nickname.length() > 15) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "the size of nickname is too large.");
        }

        if (ValueUtil.isEmpty(this.password)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "password is required.");
        }
        if (this.password!=null && this.password.length() > 36) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "the size of password is too large.");
        }

        if (ValueUtil.isEmpty(this.username)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "username is required.");
        }
        if (this.username!=null && this.username.length() > 15) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "the size of username is too large.");
        }

    }
}