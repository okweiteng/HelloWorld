package com.wt.study.designpattern.state.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Activity {
    private Long id;
    private String name;
    private ActivityStateEnum state;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public void updateState(ActivityStateEnum state) {
        this.state = state;
    }
}
