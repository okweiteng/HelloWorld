package com.wt.study.designpattern.chain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class OrderHandlerChain implements ApplicationContextAware {
    private List<AbstractOrderHandler> chain = new ArrayList<>();

    public void handle(OrderHandlerContext context) {
        if (context.getPos() >= this.chain.size()) {
            return;
        }
        AbstractOrderHandler handler = chain.get(context.getPos());

        // 移动位于处理器链中的位置
        // TODO 必须先设置pos位置，在handle，否则会报错
        context.setPos(context.getPos() + 1);

        handler.doHandle(context, this);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, AbstractOrderHandler> beansMap = applicationContext.getBeansOfType(AbstractOrderHandler.class);
        chain.addAll(beansMap.values());
        // 根据处理器的权重，对处理器链中元素进行排序
        chain.sort(Comparator.comparingInt(AbstractOrderHandler::weight));
    }
}
