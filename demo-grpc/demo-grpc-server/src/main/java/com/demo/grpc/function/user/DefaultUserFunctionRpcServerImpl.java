package com.demo.grpc.function.user;

import com.demo.grpc.function.model.user.UserInfoModel;
import com.demo.mgr.model.user.UserLoginRequest;
import com.demo.mgr.model.user.UserInfo;
import com.demo.grpc.function.api.user.UserFunctionDescriptor;
import com.demo.grpc.function.api.user.UserFunctionGrpc;
import com.demo.mgr.function.user.UserFunction;

import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.ErrorCodeRuntimeException;
import com.oceancode.cloud.common.util.ComponentUtil;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class DefaultUserFunctionRpcServerImpl extends UserFunctionGrpc.UserFunctionImplBase  {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserFunctionRpcServerImpl.class);
    private UserFunction targetFunction;

    public DefaultUserFunctionRpcServerImpl() {
        this.targetFunction = ComponentUtil.getLocalFunction(UserFunction.class);
    }
    @Override
    public void userLogin(UserFunctionDescriptor.UserLoginReq_ request, StreamObserver<UserFunctionDescriptor.UserLoginRes_> responseObserver) {
        UserFunctionDescriptor.UserLoginRes_.Builder builder = UserFunctionDescriptor.UserLoginRes_.newBuilder();
        try {
            UserLoginRequest model = new UserLoginRequest();
            model.setUsername(request.getParam().getUsername());
            model.setPassword(request.getParam().getPassword());
            targetFunction.userLogin(model);

        } catch (Throwable e) {
            LOGGER.error("rpc server call failed.", e);
            if (e instanceof ErrorCodeRuntimeException) {
                builder.setErrorCode(((ErrorCodeRuntimeException) e).getErrorCode());
            } else {
                builder.setErrorCode(CommonErrorCode.SERVER_ERROR.getCode());
            }
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUserInfoById(UserFunctionDescriptor.GetUserInfoByIdReq_ request, StreamObserver<UserFunctionDescriptor.GetUserInfoByIdRes_> responseObserver) {
        UserFunctionDescriptor.GetUserInfoByIdRes_.Builder builder = UserFunctionDescriptor.GetUserInfoByIdRes_.newBuilder();
        try {            List<UserInfo> resultData = targetFunction.getUserInfoById(request.getId());
            if (resultData != null) {
                for (UserInfo item : resultData) {
                    UserInfoModel.UserInfo.Builder itBuilder = UserInfoModel.UserInfo.newBuilder();
                    if (item.getId() != null) {
                        itBuilder.setId(item.getId());
                    }
                    if (item.getUsername() != null) {
                        itBuilder.setUsername(item.getUsername());
                    }
                    builder.addData(itBuilder.build());
                }
            }
        } catch (Throwable e) {
            LOGGER.error("rpc server call failed.", e);
            if (e instanceof ErrorCodeRuntimeException) {
                builder.setErrorCode(((ErrorCodeRuntimeException) e).getErrorCode());
            } else {
                builder.setErrorCode(CommonErrorCode.SERVER_ERROR.getCode());
            }
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}
