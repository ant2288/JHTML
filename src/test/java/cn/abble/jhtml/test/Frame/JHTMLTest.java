package cn.abble.jhtml.test.Frame;

import cn.abble.jhtml.Frame.JHTML;
import org.junit.Test;

public class JHTMLTest {
    @Test
    public void jhtmlTest(){
        JHTML jhtml = new JHTML();
        jhtml.setTitle("boo");
        System.out.print(JHTML.root.getText());
    }
}
