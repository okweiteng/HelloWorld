package com.wt.study.springboot.richenum.pizza;

public enum PizzaDeliveryStrategy {
    /**
     * 使用枚举实现策略模式
     */
    EXPRESS {
        @Override
        public void deliver(Pizza pizza) {
            System.out.println("Pizza will be delivered in express mode");
        }
    },

    NORMAL {
        @Override
        public void deliver(Pizza pizza) {
            System.out.println("Pizza will be delivered in normal mode");
        }
    };

    public abstract void deliver(Pizza pizza);
}
