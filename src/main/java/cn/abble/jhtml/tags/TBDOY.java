package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html的tbody标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TBDOY extends AbstractTag{
    private TBDOY(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createTBODYTag(){
        return new TBDOY();
    }

    @Override
    public String getTagName() {
        return "tbdoy";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
