package com.wt.study.util.enumstudy;

public enum PizzaDeliverySystemSingleton {
    /**
     * 使用枚举实现单例模式
     */
    INSTANCE;

    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    PizzaDeliverySystemSingleton() {
        // Initialization configuration which involves
        // overriding defaults like delivery strategy
    }

    public static PizzaDeliverySystemSingleton getInstance() {
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}
