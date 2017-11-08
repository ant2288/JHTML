package cn.abble.jhtml.layout;

import cn.abble.jhtml.component.Component;
import cn.abble.jhtml.css.CSS;
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

    /**
     * 添加css
     * @param css css对象
     */
    void addCSS(CSS css);

    /**
     * 向布局里添加组件
     * @param component 组件
     */
    void add(Component component);

    /**
     * 向布局里指定位置添加组件
     * @param component 组件
     * @param position 位置
     */
    void add(Component component,String position);
}
