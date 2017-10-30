package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的img标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class IMG extends AbstractTag{
    private IMG(){
        attributes = new Attributes();
        subTags = new SubTags();
    }
    public static Tag createIMGTag(){
        return new IMG();
    }
    @Override
    public String getTagName() {
        return "img";
    }

    @Override
    public boolean isSelfClosingTag() {
        return true;
    }
}
