package cn.abble.jhtml.test.util;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;
import org.junit.Test;

public class CreateTest {
    @Test
    public void createTagByNameTest(){
        Tag html = Create.createTagByName("html");
        Tag head = Create.createTagByName("head");
        Tag body = Create.createTagByNameWithAttribute("body","id='body'","readyOnly");
        Tag x = Create.createTagByNameWithParent("head",body);
        head.setParent(html);
        body.setParent(html);
        System.out.print(html.getText());
    }
}
