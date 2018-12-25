package com.baizhi.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String name;
    private String value;

    public Address() {
        super();
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Address(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
