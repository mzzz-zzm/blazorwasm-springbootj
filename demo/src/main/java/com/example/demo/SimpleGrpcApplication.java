package com.example.demo;

import org.springframework.grpc.server.service.GrpcService;

import com.example.grpc.lib.HelloReply;
import com.example.grpc.lib.HelloRequest;

import io.grpc.stub.StreamObserver;

import com.example.grpc.lib.GreetServiceGrpc.GreetServiceImplBase;

@GrpcService
public class SimpleGrpcApplication extends GreetServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        var res = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
