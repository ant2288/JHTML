package cn.abble.jhtml.util;

import cn.abble.jhtml.tags.Tag;

import java.lang.reflect.InvocationTargetException;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 一个工具类，更方便的创建标签
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class Create {
    public static Tag createTagByName(String tagName){
        String name = checkNotNull(tagName).trim().toUpperCase();
        Tag tag = null;
        try {
            Class c = Class.forName("cn.abble.jhtml.tags." + name);
            tag = (Tag)c.getMethod("create"+name+"Tag",null).invoke(null,null);
            return tag;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        checkNotNull(tag,"Create HTML Tag Fail. The return value is null.Please check tagName");
        return tag;
    }

    public static Tag createTagByNameWithAttribute(String tagName,String... nameAndValue){
        Tag tag = createTagByName(tagName);
        tag.addAttribute(nameAndValue);
        return tag;
    }

    public static Tag createTagByNameWithParent(String tagName,Tag parent){
        Tag tag = createTagByName(tagName);
        tag.setParent(parent);
        return tag;
    }

    public static Tag createTagByNameWithParent(String tagName,String parentTagName){
        Tag tag = createTagByName(tagName);
        Tag tag1 = createTagByName(parentTagName);
        tag.setParent(tag1);
        return tag;
    }
}
