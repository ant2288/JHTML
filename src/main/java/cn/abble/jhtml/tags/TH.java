package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的th标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TH extends AbstractTag{
    private TH(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createTHTag(){
        return new TH();
    }
    @Override
    public String getTagName() {
        return "th";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
