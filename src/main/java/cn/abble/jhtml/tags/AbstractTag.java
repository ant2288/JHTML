package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attribute;
import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;
import cn.abble.jhtml.util.StringToAttributeList;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 一个抽象的标签类，实现了Tag接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public abstract class AbstractTag implements Tag{
    protected SubTags subTags;

    protected Attributes attributes;

    protected Tag parent;

    @Override
    public SubTags getChildrenTags() {
        return subTags;
    }

    @Override
    public Attributes getAttributes(){
        return attributes;
    }

    @Override
    public Tag getParent(){
        return parent;
    }

    @Override
    public void setParent(Tag parent){
        this.parent = checkNotNull(parent);
        parent.addChildren(this);
    }

    @Override
    public void addChildren(Tag children){
        subTags.addLast(children);
    }

    @Override
    public void addChildrenFirst(Tag children){
        subTags.addFirst(children);
    }

    @Override
    public void addAttribute(String... nameAndValue){
        List<Attribute> list = StringToAttributeList.StringToAttributeList(checkNotNull(nameAndValue));
        attributes.add(list);
    }

    @Override
    public void addAttribute(String name,@Nullable String value){
        attributes.add(checkNotNull(name),value);
    }

    @Override
    public void clearAttributes(){
        attributes.cleanAll();
    }

    @Override
    public void delAttribute(String name){
        attributes.del(checkNotNull(name));
    }

    @Override
    public String getText() {
        StringBuffer sb = new StringBuffer();
        sb.append("<"+this.getTagName()+" ");
        sb.append(attributes.getText());
        if(this.isSelfClosingTag()){
            sb.append("/>");
            return sb.toString();
        }else{
            sb.append(">");
            sb.append(subTags.getText());
            sb.append("</" + this.getTagName() + ">");
            return sb.toString();
        }
    }


}
