package com.wt.study.designpattern.singleton;

/**
 * 1.构造私有。
 * 2.以静态方法或者枚举返回实例。
 * 3.确保实例只有一个，尤其是多线程环境。
 * 4.确保反序列换时不会重新构建对象。
 */
public class Singleton01 {
    /**
     * 内部静态类
     */
    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static Singleton01 INSTANCE = new Singleton01();
    }
}
