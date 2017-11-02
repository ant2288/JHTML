package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的title标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TITLE extends AbstractTag {

    private TITLE(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createTITLETag(){
        return new TITLE();
    }

    @Override
    public String getTagName() {
        return "title";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
