package com.wt.study.util.enumstudy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {

    private static EnumSet<PizzaStatusEnum> UNDELIVERED_PIZZA_STATUSES = EnumSet.of(PizzaStatusEnum.ORDERED, PizzaStatusEnum.READY);

    private PizzaStatusEnum status;

    /**
     * EnumSet 是一种专门为枚举类型所设计的 Set 类型，使用内部位向量表示
     */
    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream()
                .filter(s -> UNDELIVERED_PIZZA_STATUSES.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    /**
     * EnumMap是一个专门化的映射实现，用于将枚举常量用作键。与对应的 HashMap 相比，它是一个高效紧凑的实现，并且在内部表示为一个数组
     */
    public static EnumMap<PizzaStatusEnum, List<Pizza>> groupPizzaByStatus(List<Pizza> pizzaList) {
        return pizzaList.stream().collect(
                Collectors.groupingBy(Pizza::getStatus, () -> new EnumMap<>(PizzaStatusEnum.class), Collectors.toList()));
    }

    public void deliver() {
        if (!isDeliverable()) {
            return;
        }
        PizzaDeliverySystemSingleton.getInstance().getDeliveryStrategy().deliver(this);
        this.status = PizzaStatusEnum.DELIVERED;
    }

    public Boolean isDeliverable() {
        return this.status.isReady();
    }

    private int getDeliveryTimeInDays() {
        return this.status.getTimeToDelivery();
    }

    private void printTimeToDeliver() {
        System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery() + " days");
    }
}
