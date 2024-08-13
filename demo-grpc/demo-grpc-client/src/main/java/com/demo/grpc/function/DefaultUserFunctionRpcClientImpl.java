package com.demo.grpc.function;

import com.demo.grpc.function.api.user.UserFunctionDescriptor;
import com.demo.grpc.function.api.user.UserFunctionGrpc;
import com.demo.grpc.function.model.user.UserInfoModel;
import com.demo.grpc.function.model.user.UserLoginRequestModel;
import com.demo.mgr.function.user.UserFunction;
import com.demo.mgr.model.user.UserInfo;
import com.demo.mgr.model.user.UserLoginRequest;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.ErrorCodeRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;
import io.grpc.Deadline;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DefaultUserFunctionRpcClientImpl implements UserFunction {
    @GrpcClient("user-function")
    private UserFunctionGrpc.UserFunctionBlockingStub blockingStub;

    @Override
    public void userLogin(UserLoginRequest param) {
        UserFunctionDescriptor.UserLoginReq_.Builder requestBuilder = UserFunctionDescriptor.UserLoginReq_.newBuilder();
        UserLoginRequestModel.UserLoginRequest.Builder requestDataBuilder = UserLoginRequestModel.UserLoginRequest.newBuilder();
        requestDataBuilder.setUsername(param.getUsername());
        requestDataBuilder.setPassword(param.getPassword());
        requestBuilder.setParam(requestDataBuilder.build());

        UserFunctionDescriptor.UserLoginRes_ response = blockingStub
                .withDeadline(Deadline.after(5, TimeUnit.SECONDS))
                .userLogin(requestBuilder.build());

        boolean calledSuccess = ValueUtil.isEmpty(response.getErrorCode()) || CommonErrorCode.SUCCESS.getCode().equals(response.getErrorCode());
        if (!calledSuccess) {
            throw new ErrorCodeRuntimeException(response.getErrorCode(), "userLogin rpc called failed.");
        }
    }

    @Override
    public List<UserInfo> getUserInfoById(Long id) {
        UserFunctionDescriptor.GetUserInfoByIdReq_.Builder requestBuilder = UserFunctionDescriptor.GetUserInfoByIdReq_.newBuilder();
        requestBuilder.setId(id);

        UserFunctionDescriptor.GetUserInfoByIdRes_ response = blockingStub
                .withDeadline(Deadline.after(5, TimeUnit.SECONDS))
                .getUserInfoById(requestBuilder.build());

        boolean calledSuccess = ValueUtil.isEmpty(response.getErrorCode()) || CommonErrorCode.SUCCESS.getCode().equals(response.getErrorCode());
        if (!calledSuccess) {
            throw new ErrorCodeRuntimeException(response.getErrorCode(), "userLogin rpc called failed.");
        }

        List<UserInfoModel.UserInfo> resultData = response.getDataList();
        List<UserInfo> returnData = new ArrayList<>();
        if (resultData != null) {
            for (UserInfoModel.UserInfo item : resultData) {
                UserInfo it = new UserInfo();
                it.setId(item.getId());
                it.setUsername(item.getUsername());
                returnData.add(it);
            }
        }
        return returnData;
    }
}
