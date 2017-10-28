package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attributes;

import java.util.List;
import java.util.Objects;

/**
 * html的标签，实现了Tag接口。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class HTML implements Tag {
    public static final String TAG_NAME = "html";

    /**
     * 用于存储该标签的所有属性
     */
    private Attributes attributes;

    /**
     * 获取该标签的所有属性
     * @return 该标签的所有属性
     */
    public Attributes getAttributes() {
        return attributes;
    }

    private HTML(){
        attributes = new Attributes();
    }
    @Override
    public String getTagName() {
        return TAG_NAME;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<Tag> getChildrenTags() {
        return null;
    }

    @Override
    public Tag getParent() {
        return null;
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
        //TODO:比较子标签
        return true;
    }

    @Override
    public int hashCode(){
        //TODO:计算子标签的hash值
        return Objects.hash(TAG_NAME,attributes);
    }
}
