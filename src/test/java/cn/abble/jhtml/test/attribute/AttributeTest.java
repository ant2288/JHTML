package cn.abble.jhtml.test.attribute;

import cn.abble.jhtml.attribute.Attribute;
import cn.abble.jhtml.attribute.Attributes;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AttributeTest {
    @Test
    public void test(){
        Attributes attributes = new Attributes();
        attributes.add("id","myId");
        attributes.add("class","table");
        attributes.add("disabled",null);
        attributes.add("type","text");
        System.out.print(attributes.getText());
    }

    @Test
    public void test2(){
        Attributes attributes = new Attributes();
        Attribute attribute = attributes.del("asdasda");
        Assert.assertNotNull(attribute);
        System.out.print(attribute);
    }
}
