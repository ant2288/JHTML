package cn.abble.jhtml.test.util;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;
import org.junit.Test;

public class CreateTest {
    @Test
    public void createTagByNameTest(){
        Tag tag = Create.createTagByName("div");



        System.out.print(tag.getText());
    }
}
