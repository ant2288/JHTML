package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html中的div标签，继承自AbstractTag,实现了Tag接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class DIV extends AbstractTag {

    private DIV(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createDIVTag(){
        return new DIV();
    }

    @Override
    public String getTagName() {
        return "div";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
