package com.zhao.january;

public class ParentService {

    private HelloWorldService helloWorldService;

    public void hello() {
        helloWorldService.hello();
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
