package ru.dmrval.entity;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: BankAccountInfo.proto")
public final class BankAccountInfoServiceGrpc {

  private BankAccountInfoServiceGrpc() {}

  public static final String SERVICE_NAME = "ru.dmrval.entity.BankAccountInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.dmrval.entity.BankAccountInfoRequest,
      ru.dmrval.entity.BankAccountInfoResponse> getGetAccountsByTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAccountsByType",
      requestType = ru.dmrval.entity.BankAccountInfoRequest.class,
      responseType = ru.dmrval.entity.BankAccountInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.dmrval.entity.BankAccountInfoRequest,
      ru.dmrval.entity.BankAccountInfoResponse> getGetAccountsByTypeMethod() {
    io.grpc.MethodDescriptor<ru.dmrval.entity.BankAccountInfoRequest, ru.dmrval.entity.BankAccountInfoResponse> getGetAccountsByTypeMethod;
    if ((getGetAccountsByTypeMethod = BankAccountInfoServiceGrpc.getGetAccountsByTypeMethod) == null) {
      synchronized (BankAccountInfoServiceGrpc.class) {
        if ((getGetAccountsByTypeMethod = BankAccountInfoServiceGrpc.getGetAccountsByTypeMethod) == null) {
          BankAccountInfoServiceGrpc.getGetAccountsByTypeMethod = getGetAccountsByTypeMethod = 
              io.grpc.MethodDescriptor.<ru.dmrval.entity.BankAccountInfoRequest, ru.dmrval.entity.BankAccountInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ru.dmrval.entity.BankAccountInfoService", "getAccountsByType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.dmrval.entity.BankAccountInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.dmrval.entity.BankAccountInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BankAccountInfoServiceMethodDescriptorSupplier("getAccountsByType"))
                  .build();
          }
        }
     }
     return getGetAccountsByTypeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankAccountInfoServiceStub newStub(io.grpc.Channel channel) {
    return new BankAccountInfoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankAccountInfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BankAccountInfoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankAccountInfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BankAccountInfoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BankAccountInfoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAccountsByType(ru.dmrval.entity.BankAccountInfoRequest request,
        io.grpc.stub.StreamObserver<ru.dmrval.entity.BankAccountInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountsByTypeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAccountsByTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.dmrval.entity.BankAccountInfoRequest,
                ru.dmrval.entity.BankAccountInfoResponse>(
                  this, METHODID_GET_ACCOUNTS_BY_TYPE)))
          .build();
    }
  }

  /**
   */
  public static final class BankAccountInfoServiceStub extends io.grpc.stub.AbstractStub<BankAccountInfoServiceStub> {
    private BankAccountInfoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankAccountInfoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankAccountInfoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankAccountInfoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAccountsByType(ru.dmrval.entity.BankAccountInfoRequest request,
        io.grpc.stub.StreamObserver<ru.dmrval.entity.BankAccountInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountsByTypeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankAccountInfoServiceBlockingStub extends io.grpc.stub.AbstractStub<BankAccountInfoServiceBlockingStub> {
    private BankAccountInfoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankAccountInfoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankAccountInfoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankAccountInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.dmrval.entity.BankAccountInfoResponse getAccountsByType(ru.dmrval.entity.BankAccountInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountsByTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankAccountInfoServiceFutureStub extends io.grpc.stub.AbstractStub<BankAccountInfoServiceFutureStub> {
    private BankAccountInfoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankAccountInfoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankAccountInfoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankAccountInfoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.dmrval.entity.BankAccountInfoResponse> getAccountsByType(
        ru.dmrval.entity.BankAccountInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountsByTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNTS_BY_TYPE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankAccountInfoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankAccountInfoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNTS_BY_TYPE:
          serviceImpl.getAccountsByType((ru.dmrval.entity.BankAccountInfoRequest) request,
              (io.grpc.stub.StreamObserver<ru.dmrval.entity.BankAccountInfoResponse>) responseObserver);
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

  private static abstract class BankAccountInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankAccountInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.dmrval.entity.BankAccountInfoOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankAccountInfoService");
    }
  }

  private static final class BankAccountInfoServiceFileDescriptorSupplier
      extends BankAccountInfoServiceBaseDescriptorSupplier {
    BankAccountInfoServiceFileDescriptorSupplier() {}
  }

  private static final class BankAccountInfoServiceMethodDescriptorSupplier
      extends BankAccountInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankAccountInfoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BankAccountInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankAccountInfoServiceFileDescriptorSupplier())
              .addMethod(getGetAccountsByTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
