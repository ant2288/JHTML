package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attribute;
import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;
import cn.abble.jhtml.util.StringToAttributeList;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * html的标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class HTML extends AbstractTag{
    public static final String TAG_NAME = "html";

    public static final boolean SELF_CLOSING_TAG = false;

    public static Tag createHTMLTag(){
        return new HTML();
    }

    private HTML(){
        attributes = new Attributes();
        subTags = new SubTags();
    }

    @Override
    public String getTagName() {
        return TAG_NAME;
    }

    @Override
    public boolean isSelfClosingTag() {
        return SELF_CLOSING_TAG;
    }

    @Override
    public void setParent(@Nullable Tag parent) {
        return;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof HTML)){
            return false;
        }
        HTML temp = (HTML)o;
        if(!attributes.equals(temp.getAttributes())){
            return false;
        }
        if(!subTags.equals(temp.subTags)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(TAG_NAME,attributes,subTags);
    }
}
