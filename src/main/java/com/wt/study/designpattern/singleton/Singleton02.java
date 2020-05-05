package com.wt.study.designpattern.singleton;

public enum  Singleton02 {
    /**
     * 枚举类实现单例模式
     */
    INSTANCE;
    public static Singleton02 getInstance() {
        return INSTANCE;
    }
}
