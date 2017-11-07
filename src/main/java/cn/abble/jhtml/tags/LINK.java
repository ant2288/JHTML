package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html中的link标签，继承自AbstractTag,实现了Tag接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class LINK extends AbstractTag {

    private LINK(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createLINKTag(){
        return new LINK();
    }

    @Override
    public String getTagName() {
        return "link";
    }

    @Override
    public boolean isSelfClosingTag() {
        return true;
    }
}
