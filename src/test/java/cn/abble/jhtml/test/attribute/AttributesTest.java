package cn.abble.jhtml.test.attribute;

import cn.abble.jhtml.attribute.Attribute;
import cn.abble.jhtml.attribute.Attributes;
import org.junit.Test;

public class AttributesTest {
    @Test
    public void equalsTest(){
        Attributes a1 = new Attributes();
        Attributes a2 = new Attributes();
        a2.add("id","123");
        a1.add("id","123");
        System.out.print(a1.hashCode() + ":::" + a2.hashCode());

    }
}
