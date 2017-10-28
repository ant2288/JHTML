package cn.abble.jhtml.test.tags;

import cn.abble.jhtml.tags.HTML;
import cn.abble.jhtml.tags.Tag;
import org.junit.Test;

public class HTMLTest {
    @Test
    public void equlsTest(){
        Tag h1 = HTML.createHTMLTag();
        Tag h2 = HTML.createHTMLTag();
        System.out.print(h1.equals(h2));
    }

    @Test
    public void getTextTest(){
        Tag h1 = HTML.createHTMLTag();
        h1.addAttribute("id=1","class='table'","readyOnly");
        System.out.print(h1.getText());
    }
}
