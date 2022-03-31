package com.study.unify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fff
 * @date 2022/3/31 0031 10:48
 * @description 由于responseAdvice返回体不能为String类型，所以创建这个实体
 */
@Data
@AllArgsConstructor
public class TestInfo {
    private String info;

}
