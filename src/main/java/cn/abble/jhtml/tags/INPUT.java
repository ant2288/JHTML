package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的input标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class INPUT extends AbstractTag {
    private INPUT(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createINPUTTag(){
        return new INPUT();
    }

    @Override
    public String getTagName() {
        return "input";
    }

    @Override
    public boolean isSelfClosingTag() {
        return true;
    }
}
