package cn.abble.jhtml.tags;

import cn.abble.jhtml.attribute.Attribute;
import cn.abble.jhtml.attribute.Attributes;
import cn.abble.jhtml.tags.util.SubTags;

import javax.annotation.Nullable;

/**
 * 所有的标签都实现了这个接口
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public interface Tag {
    /**
     * 获取标签的名称，如html,body,h1,h2
     * @return 返回标签名称
     */
    String getTagName();

    /**
     * 获取该标签的HTML文本，如<input id="username" name="username" type="text"/>
     * @return 该标签的HTML文本
     */
    String getText();

    /**
     * 获取所有的子标签
     * @return 返回所有的子标签
     */
    SubTags getChildrenTags();

    /**
     * 获取父标签
     * @return 返回父标签
     */
    Tag getParent();

    /**
     * 返回该标签是否是一个自闭和标签
     * @return
     */
    boolean isSelfClosingTag();

    /**
     * 向该标签添加属性
     * @param name 属性名
     * @param value 属性值 可以为空
     */
   // void addAttribute(String name,@Nullable String value);

    /**
     * 向该标签添加多个属性。
     * 属性名称和属性值使用等号分割,不需要属性值的就直接输入属性名就可以如:
     * input.addAttribute("id=1","class='username'","readonly");
     * @param nameAndValue 属性名与属性值，可以使用等号分割,如input.addAttribute("id=1","class='username'","readonly");
     */
    void addAttribute(String... nameAndValue);

    /**
     * 清空该标签的所有属性。
     */
    void clearAttributes();

    /**
     * 根据属性名删除属性
     * @param name 属性名
     * @return 是否删除成功 true是成功，false是不成功
     */
    void delAttribute(String name);

    /**
     * 设置父标签
     * @param parent 父标签
     */
    void setParent(Tag parent);

    /**
     * 添加子节点到最后一个位置
     * @param children 要添加的子节点
     */
    void addChildren(Tag children);

    /**
     * 添加子节点到第一个位置
     * @param children 要添加的子节点
     */
    void addChildrenFirst(Tag children);

    /**
     * 获取所有的属性
     * @return Attributes 所有的属性
     */
    Attributes getAttributes();

    /**
     * 返回一个可阅读的html字符串，一般不需要手动调用
     * @param c 层数
     * @return sb
     */
    StringBuffer getText(int c,StringBuffer sb);

    /**
     * 根据属性名称获取属性。
     * @param name 属性名称
     * @return 获取的属性，如果不存在，返回一个新的Attribute
     */
    Attribute getAttributeByName(String name);

    /**
     * 根据属性名判断是否存在该属性
     * @param name 属性名
     * @return 如果存在返回true，否则返回false
     */
    boolean hasAttributeByName(String name);

    /**
     * 设置标签内文本，如<p>文本</p>
     * @param text 设置的文本
     */
    void setInnerText(String text);
}
