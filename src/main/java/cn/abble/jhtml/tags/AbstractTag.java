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

    /**@Override
    public void addAttribute(String name,@Nullable String value){
        attributes.add(checkNotNull(name),value);
    }**/

    @Override
    public void clearAttributes(){
        attributes.cleanAll();
    }

    @Override
    public void delAttribute(String name){
        attributes.del(checkNotNull(name));
    }

    @Override
    public StringBuffer getText(int c,StringBuffer sb) {
        //StringBuffer sb = new StringBuffer();
        for(int i=0;i<c;i++){
            sb.append("\t");
        }
        sb.append("<"+this.getTagName()+" ");
        sb.append(attributes.getText());
        if(this.isSelfClosingTag()){
            sb.append("/>");
            return sb;
        }else{
            sb.append(">\n");
            subTags.getText(c+1,sb);
            for(int i=0;i<c;i++){
                sb.append("\t");
            }
            sb.append("</" + this.getTagName() + ">\n");
            return sb;
        }
    }

    @Override
    public Attribute getAttributeByName(String name){
        return attributes.get(name);
    }

    @Override
    public boolean hasAttributeByName(String name){
        return attributes.hasAttribute(name);
    }

    @Override
    public String getText(){
        return getText(0,new StringBuffer()).toString();
    }

}
