package com.qiumingjie.springboot.controller;

import com.qiumingjie.springboot.dto.ValidateDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-03-02 16:57
 * @description 空值处理学习
 * 概述：
 * @Valid是使用Hibernate validation的时候使用
 * @Validated是只用Spring Validator校验机制使用
 * 说明：java的JSR303声明了@Valid这类接口，而Hibernate-validator对其进行了实现
 * @Validation对@Valid进行了二次封装，在使用上并没有区别，但在分组、注解位置、嵌套验证等功能上有所不同，这里主要就这几种情况进行说明。 注解位置：
 * @Validated：用在类型、方法和方法参数上。但不能用于成员属性（field）
 * @Valid：可以用在方法、构造函数、方法参数和成员属性（field）上 如果@Validated注解在成员属性上，则会报  不适用于field错误
 * 分组校验：
 * @Validated：提供分组功能，可以在参数验证时，根据不同的分组采用不同的验证机制
 * @Valid：没有分组功能
 */
@RestController
public class ValidatedExample {
    /**
     * 仅仅校验分组B
     *
     * @param validateDto
     * @return
     */
    @RequestMapping("/validate")
    public String test(@Validated @RequestBody ValidateDto validateDto) {
        return "";
    }
}
