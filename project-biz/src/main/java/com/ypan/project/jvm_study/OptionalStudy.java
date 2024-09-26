package com.ypan.project.jvm_study;

import java.util.Optional;

public class OptionalStudy {

    public static void main(String[] args) {
        Optional<Object> o = Optional.of("123");
        System.out.println(o.get());
    }
}
