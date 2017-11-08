package cn.abble.jhtml.component;

import cn.abble.jhtml.tags.Tag;

/**
 * 组件接口，任何组件都实现了这个接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public interface Component {
    /**
     * 返回整个组件的根标签
     * @return 组件的根标签
     */
    Tag getTag();

    /**
     * 设置组件id
     * @param id
     */
    void setId(String id);

    /**
     * 设置组件名称
     * @param name 名称
     */
    void setName(String name);

    /**
     * 设置是否启用组件
     * @param enable 是否启用
     */
    void setEnable(boolean enable);
}
