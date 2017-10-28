package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;

import java.util.List;

/**
 * html的标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class HTML implements Tag {
    public static final String TAG_NAME = "html";

    /**
     * 用于存储该标签的所有属性
     */
    private Attributes attributes;

    private HTML(){
        attributes = new Attributes();
    }
    @Override
    public String getTagName() {
        return TAG_NAME;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<Tag> getChildrenTags() {
        return null;
    }

    @Override
    public Tag getParent() {
        return null;
    }
}
