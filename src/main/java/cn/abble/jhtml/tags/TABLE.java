package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

/**
 * html中的table标签，继承了抽象类AbstractTag
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TABLE extends AbstractTag {

    private TABLE(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createTABLETag(){
        return new TABLE();
    }

    @Override
    public String getTagName() {
        return "table";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }
}
