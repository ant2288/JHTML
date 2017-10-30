package cn.abble.jhtml.tags;


import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的tr标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TR extends AbstractTag {

    private TR(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createTRTag(){
        return new TR();
    }

    @Override
    public String getTagName() {
        return "tr";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
