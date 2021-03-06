package com.project2.matmaungdung.aesutil;

public enum AESLevel {

    LEVEL_128(128),
    LEVEL_256(256),
    DEFAULT(256);

    private Integer value;

    private AESLevel(Integer num) {
        this.value = num;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
