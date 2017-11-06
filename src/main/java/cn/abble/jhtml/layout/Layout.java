package cn.abble.jhtml.layout;

import cn.abble.jhtml.tags.Tag;

/**
 * 所有的布局均实现了此接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public interface Layout {
    /**
     * 向根标签注入布局标签
     * @param root 根标签
     */
    void init(Tag root);
}
