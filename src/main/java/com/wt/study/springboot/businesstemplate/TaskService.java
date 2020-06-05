package com.wt.study.springboot.businesstemplate;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    public void processAuthResultDataCallback(String message) {
        String result = new AbstractUpdateTask() {
            @Override
            protected boolean validateParameters(String message) {
                return false;
            }

            @Override
            protected boolean businessRulesChecker(String message) {
                return false;
            }

            @Override
            protected String cache2Redis(String message) {
                // redisTemplate
                return "数据缓存到了 redis";
            }

            @Override
            protected String updateTask(String cacheResult) {
                return "成功更新任务";
            }
        }.doProcess(message);
    }

    /**
     * 控制逻辑分离——业务模板 Pattern of NestedBusinessTemplate
     * 使用业务模板方式 分离 业务逻辑与实现逻辑
     */
    abstract class AbstractUpdateTask {
        public final String doProcess(String message) {
            boolean valid = validateParameters(message);
            boolean checked = businessRulesChecker(message);
            String cacheResult = cache2Redis(message);
            return updateTask(cacheResult);
        }

        protected abstract boolean validateParameters(String message);

        protected abstract boolean businessRulesChecker(String message);

        protected abstract String cache2Redis(String message);

        protected abstract String updateTask(String cacheResult);
    }
}
