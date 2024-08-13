package com.demo.mgr.model.user;

import com.oceancode.cloud.api.validation.Validator;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.BusinessRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;

public class UserLoginRequest implements Validator, java.io.Serializable  {
    /**
     * 登录密码
     */
    private String password;

    /**
     * 登录账号
     */
    private String username;

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