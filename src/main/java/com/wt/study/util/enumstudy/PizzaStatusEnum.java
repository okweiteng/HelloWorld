package com.wt.study.util.enumstudy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PizzaStatusEnum {
    /**
     * 枚举类学习
     */
    ORDERED(5) {
        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2) {
        @Override
        public boolean isReady() {
            return true;
        }
    },
    DELIVERED(0) {
        @Override
        public boolean isDelivered() {
            return true;
        }
    };

    private int timeToDelivery;

    public boolean isOrdered() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public boolean isDelivered() {
        return false;
    }
}
