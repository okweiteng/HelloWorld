package com.wt.study.util.enumstudy;

import com.wt.study.springboot.richenum.pizza.Pizza;
import com.wt.study.springboot.richenum.pizza.PizzaStatusEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    @Test
    public void givenPizzaOrder_whenReady_thenDeliverable() {
        Pizza testPz = new Pizza(PizzaStatusEnum.READY);
        assertTrue(testPz.isDeliverable());
    }

    @Test
    public void givenPizzaOrders_whenRetrievingUnDeliveredPzs_thenCorrectlyRetrieved() {
        List<Pizza> pizzaList = Arrays.asList(new Pizza(PizzaStatusEnum.DELIVERED),
                new Pizza(PizzaStatusEnum.ORDERED),
                new Pizza(PizzaStatusEnum.ORDERED),
                new Pizza(PizzaStatusEnum.READY));
        List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pizzaList);
        assertEquals(3, undeliveredPzs.size());
    }

    @Test
    public void givenPizzaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {
        List<Pizza> pizzaList = Arrays.asList(new Pizza(PizzaStatusEnum.DELIVERED),
                new Pizza(PizzaStatusEnum.ORDERED),
                new Pizza(PizzaStatusEnum.ORDERED),
                new Pizza(PizzaStatusEnum.READY));

        EnumMap<PizzaStatusEnum,List<Pizza>> map = Pizza.groupPizzaByStatus(pizzaList);
        assertEquals(1, map.get(PizzaStatusEnum.DELIVERED).size());
        assertEquals(2, map.get(PizzaStatusEnum.ORDERED).size());
        assertEquals(1, map.get(PizzaStatusEnum.READY).size());
    }

    @Test
    public void givenPizzaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pizza = new Pizza(PizzaStatusEnum.READY);
        pizza.deliver();
        assertSame(pizza.getStatus(), PizzaStatusEnum.DELIVERED);
    }
}