package com.qiumingjie.springboot.dto;

import com.qiumingjie.springboot.entity.User;
import com.qiumingjie.springboot.inter.IGroupB;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @author QiuMingJie
 * @date 2020-03-02 16:59
 * @description 用于空值验证的dto
 */
public class ValidateDto {

    /**
     * 假如里面还有对象，得嵌套校验，得用valid，不可以用Validated
     */
    @Valid
    private User user;

    @NotEmpty(message = "id不能为空")
    private String userId;

    private String userName;

    /**
     * 分组B
     * 可以为string或者空
     */
    @Min(value = 18, message = "年龄不能小于18岁", groups = {IGroupB.class})
    private Integer age;

    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
    private String phoneNum;

    @Email(message = "邮箱格式错误")
    private String email;

    // @MyConstraint
    private String className;

    private String userPassword;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
