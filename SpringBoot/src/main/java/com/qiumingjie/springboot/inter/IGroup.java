package com.qiumingjie.springboot.inter;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @author QiuMingJie
 * @date 2020-03-02 17:30
 * @description 组序列，默认情况下 不同级别的约束验证是无序的，但是在一些情况下，顺序验证却是很重要。
 */

@GroupSequence({Default.class, IGroupA.class, IGroupB.class})
public interface IGroup {
}
