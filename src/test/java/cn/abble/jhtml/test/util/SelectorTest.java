package cn.abble.jhtml.test.util;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;
import cn.abble.jhtml.util.SelectReturnResult;
import cn.abble.jhtml.util.Selector;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class SelectorTest {
    @Test
    public void SelectorTest(){
        //构建框架
        Tag html = Create.createTagByName("html");
        Tag head = Create.createTagByNameWithParent("head",html);
        Tag body = Create.createTagByNameWithParent("body",html);
        Tag div = Create.createTagByNameWithParent("div",body);
        Tag div2 = Create.createTagByNameWithParent("div",body);
        div.addAttribute("id='div'","class='divClass'");
        div2.addAttribute("id='div'","class='divClass'");

        SelectReturnResult result = Selector.select("#div",html);
        System.out.print(result.getMessage());

    }
}
