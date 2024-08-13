package com.demo.mgr.model.user;

import com.oceancode.cloud.api.validation.Validator;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.BusinessRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;

public class UserInfo implements Validator, java.io.Serializable  {
    /**
     * 主键
     */
    private Long id;

    /**
     * 登录账号
     */
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void validate() {
        if (ValueUtil.isEmpty(this.id)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "id is required.");
        }
        if (this.id!=null && this.id < 1) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "id invalid");
        }

        if (ValueUtil.isEmpty(this.username)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "username is required.");
        }
        if (this.username!=null && this.username.length() > 32) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "the size of username is too large.");
        }

    }
}