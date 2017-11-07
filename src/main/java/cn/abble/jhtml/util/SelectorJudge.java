package cn.abble.jhtml.util;

import cn.abble.jhtml.tags.Tag;

/**
 * Selector的选择条件
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
@FunctionalInterface
public interface SelectorJudge {
    /**
     * 判断该标签是不是选择器(Selector)所需的
     * @param tag 要判断的标签
     * @return 是否需要
     */

    boolean judge(Tag tag);
}
