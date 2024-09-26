package com.ypan.project.singletonModel.zerenlian;

public class HandlerA extends Handler {
    @Override
    public void handle() {
        boolean handled = false; //...
        if (!handled && successor != null) {
            successor.handle();
        }
    }

}

