package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;


/**
 * head的标签，实现了Tag接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class HEAD extends AbstractTag implements Tag{
    public static final String TAG_NAME = "head";

    public static final boolean SELF_CLOSING_TAG = false;

    private HEAD(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    public static Tag createHEADTag(){
        return new HEAD();
    }

    @Override
    public String getTagName() {
        return TAG_NAME;
    }

    @Override
    public boolean isSelfClosingTag() {
        return SELF_CLOSING_TAG;
    }

}
