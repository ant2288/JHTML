package cn.abble.jhtml.test.util;

import cn.abble.jhtml.attribute.Attribute;
import cn.abble.jhtml.util.StringToAttributeList;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class StringToAttributeListTest {
    @Test
    public void StringToList(){
        List<Attribute> list = StringToAttributeList.StringToAttributeList("name","id=1","class='Table'");
        for(Attribute a : list){
            System.out.println(a.getText());
        }
    }
}
