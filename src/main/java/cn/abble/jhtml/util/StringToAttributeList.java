package cn.abble.jhtml.util;

import cn.abble.jhtml.attribute.Attribute;

import java.util.LinkedList;
import java.util.List;

/**
 * 用来将类似StringToAttributeList("id=1","class='table'","readonly")转成Attribute
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class StringToAttributeList {
    /**
     * 用来将类似StringToAttributeList("id=1","class='table'","readonly")转成List<Attribute>
     * @param NameAndValue 要转换的字符串
     * @return 一个List<Attribute>
     */
    public static List<Attribute> StringToAttributeList(String... NameAndValue){
        LinkedList<Attribute> list = new LinkedList<>();
        for(int i=0;i<NameAndValue.length;i++){
            String[] temp = NameAndValue[i].split("=");
            if(temp.length == 2){
                list.add(new Attribute(temp[0],temp[1]));
            }else{
                list.add(new Attribute(temp[0],null));
            }
        }
        return list;
    }
}
