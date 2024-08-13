package com.demo.grpc.function.api.user;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: api/user/UserFunction.proto")
public final class UserFunctionGrpc {

  private UserFunctionGrpc() {}

  public static final String SERVICE_NAME = "UserFunction";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUserLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> METHOD_USER_LOGIN = getUserLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> getUserLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> getUserLoginMethod() {
    return getUserLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> getUserLoginMethodHelper() {
    io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_, com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> getUserLoginMethod;
    if ((getUserLoginMethod = UserFunctionGrpc.getUserLoginMethod) == null) {
      synchronized (UserFunctionGrpc.class) {
        if ((getUserLoginMethod = UserFunctionGrpc.getUserLoginMethod) == null) {
          UserFunctionGrpc.getUserLoginMethod = getUserLoginMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_, com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserFunction", "userLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_.getDefaultInstance()))
                  .setSchemaDescriptor(new UserFunctionMethodDescriptorSupplier("userLogin"))
                  .build();
          }
        }
     }
     return getUserLoginMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUserInfoByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> METHOD_GET_USER_INFO_BY_ID = getGetUserInfoByIdMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> getGetUserInfoByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> getGetUserInfoByIdMethod() {
    return getGetUserInfoByIdMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_,
      com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> getGetUserInfoByIdMethodHelper() {
    io.grpc.MethodDescriptor<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_, com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> getGetUserInfoByIdMethod;
    if ((getGetUserInfoByIdMethod = UserFunctionGrpc.getGetUserInfoByIdMethod) == null) {
      synchronized (UserFunctionGrpc.class) {
        if ((getGetUserInfoByIdMethod = UserFunctionGrpc.getGetUserInfoByIdMethod) == null) {
          UserFunctionGrpc.getGetUserInfoByIdMethod = getGetUserInfoByIdMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_, com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserFunction", "getUserInfoById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_.getDefaultInstance()))
                  .setSchemaDescriptor(new UserFunctionMethodDescriptorSupplier("getUserInfoById"))
                  .build();
          }
        }
     }
     return getGetUserInfoByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserFunctionStub newStub(io.grpc.Channel channel) {
    return new UserFunctionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserFunctionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserFunctionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserFunctionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserFunctionFutureStub(channel);
  }

  /**
   */
  public static abstract class UserFunctionImplBase implements io.grpc.BindableService {

    /**
     */
    public void userLogin(com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_ request,
        io.grpc.stub.StreamObserver<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> responseObserver) {
      asyncUnimplementedUnaryCall(getUserLoginMethodHelper(), responseObserver);
    }

    /**
     */
    public void getUserInfoById(com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_ request,
        io.grpc.stub.StreamObserver<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserInfoByIdMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUserLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_,
                com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_>(
                  this, METHODID_USER_LOGIN)))
          .addMethod(
            getGetUserInfoByIdMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_,
                com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_>(
                  this, METHODID_GET_USER_INFO_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class UserFunctionStub extends io.grpc.stub.AbstractStub<UserFunctionStub> {
    private UserFunctionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFunctionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFunctionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFunctionStub(channel, callOptions);
    }

    /**
     */
    public void userLogin(com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_ request,
        io.grpc.stub.StreamObserver<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUserLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserInfoById(com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_ request,
        io.grpc.stub.StreamObserver<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserInfoByIdMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserFunctionBlockingStub extends io.grpc.stub.AbstractStub<UserFunctionBlockingStub> {
    private UserFunctionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFunctionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFunctionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFunctionBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_ userLogin(com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_ request) {
      return blockingUnaryCall(
          getChannel(), getUserLoginMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_ getUserInfoById(com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_ request) {
      return blockingUnaryCall(
          getChannel(), getGetUserInfoByIdMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserFunctionFutureStub extends io.grpc.stub.AbstractStub<UserFunctionFutureStub> {
    private UserFunctionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFunctionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFunctionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFunctionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_> userLogin(
        com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_ request) {
      return futureUnaryCall(
          getChannel().newCall(getUserLoginMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_> getUserInfoById(
        com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_ request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserInfoByIdMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_USER_LOGIN = 0;
  private static final int METHODID_GET_USER_INFO_BY_ID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserFunctionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserFunctionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_USER_LOGIN:
          serviceImpl.userLogin((com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginReq_) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.function.api.user.UserFunctionDescriptor.UserLoginRes_>) responseObserver);
          break;
        case METHODID_GET_USER_INFO_BY_ID:
          serviceImpl.getUserInfoById((com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdReq_) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.function.api.user.UserFunctionDescriptor.GetUserInfoByIdRes_>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserFunctionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserFunctionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.grpc.function.api.user.UserFunctionDescriptor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserFunction");
    }
  }

  private static final class UserFunctionFileDescriptorSupplier
      extends UserFunctionBaseDescriptorSupplier {
    UserFunctionFileDescriptorSupplier() {}
  }

  private static final class UserFunctionMethodDescriptorSupplier
      extends UserFunctionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserFunctionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserFunctionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserFunctionFileDescriptorSupplier())
              .addMethod(getUserLoginMethodHelper())
              .addMethod(getGetUserInfoByIdMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
