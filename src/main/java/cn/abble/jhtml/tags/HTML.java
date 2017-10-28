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
public class HTML implements Tag {
    public static final String TAG_NAME = "html";

    public static final boolean SELF_CLOSING_TAG = false;

    /**
     * 用于存储该标签的所有属性
     */
    private Attributes attributes;

    /**
     * 存储子标签
     */
    private SubTags subTags;

    /**
     * 获取该标签的所有属性
     * @return 该标签的所有属性
     */
    public Attributes getAttributes() {
        return attributes;
    }

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
    public String getText() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html ");
        sb.append(this.attributes.getText());
        sb.append(">");
        sb.append(this.subTags.getText());
        sb.append(this.closeTag());
        return sb.toString();
    }

    @Override
    public SubTags getChildrenTags() {
        return subTags;
    }

    @Override
    public Tag getParent() {
        return null;
    }

    @Override
    public String closeTag() {
        return "</html>";
    }

    @Override
    public boolean isSelfColsingTag() {
        return SELF_CLOSING_TAG;
    }

    @Override
    public void addAttribute(String name, @Nullable String value) {
        this.attributes.add(checkNotNull(name),value);
    }

    @Override
    public void addAttribute(String... nameAndValue) {
        List<Attribute> list = StringToAttributeList.StringToAttributeList(checkNotNull(nameAndValue));
        this.attributes.add(list);
    }

    @Override
    public void clearAttributes() {
        this.attributes.cleanAll();
    }

    @Override
    public void delAttribute(String name) {
        this.attributes.del(checkNotNull(name));
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
