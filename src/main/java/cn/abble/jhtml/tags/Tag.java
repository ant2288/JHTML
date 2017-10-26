package cn.abble.jhtml.tags;

import java.util.List;

/**
 * 所有的标签都实现了这个接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public interface Tag {
    /**
     * 获取标签的名称，如html,body,h1,h2
     * @return 返回标签名称
     */
    String getTagName();

    /**
     * 获取该标签的HTML文本，如<input id="username" name="username" type="text"/>
     * @return 该标签的HTML文本
     */
    String getText();

    /**
     * 获取所有的子标签
     * @return 返回所有的子标签
     */
    List<Tag> getChildrenTags();

    /**
     * 获取父标签
     * @return 返回父标签
     */
    Tag getParent();
}
