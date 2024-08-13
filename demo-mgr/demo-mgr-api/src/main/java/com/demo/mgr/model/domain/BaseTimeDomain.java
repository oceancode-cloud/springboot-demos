package com.demo.mgr.model.domain;

import java.time.LocalDateTime;
import com.demo.mgr.model.domain.BaseDomain;
import com.oceancode.cloud.api.validation.Validator;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.BusinessRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;

public class BaseTimeDomain extends BaseDomain implements Validator  {
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 创建时间
     */
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public void validate() {
        super.validate();
        if (ValueUtil.isEmpty(this.createdAt)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "createdAt is required.");
        }

        if (ValueUtil.isEmpty(this.updatedAt)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "updatedAt is required.");
        }

    }
}