package com.demo.mgr.model.domain;

import com.oceancode.cloud.api.validation.Validator;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.BusinessRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;

public class BaseDomain implements Validator  {
    /**
     * 主键
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void validate() {
        if (ValueUtil.isEmpty(this.id)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "id is required.");
        }
        if (this.id!=null && this.id < 1) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "id invalid");
        }

    }
}