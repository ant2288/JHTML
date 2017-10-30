package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的td标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TD extends AbstractTag{
    private TD(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createTDTag(){
        return new TD();
    }
    @Override
    public String getTagName() {
        return "td";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
