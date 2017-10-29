package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

public class BODY extends AbstractTag{

    @Override
    public String getTagName() {
        return "body";
    }

    @Override
    public boolean isSelfClosingTag() {
        return false;
    }

    private BODY(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createBODYTag(){
        return new BODY();
    }
}
