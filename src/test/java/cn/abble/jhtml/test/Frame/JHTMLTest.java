package cn.abble.jhtml.test.Frame;

import cn.abble.jhtml.Frame.JHTML;
import cn.abble.jhtml.layout.BorderLayout;
import org.junit.Test;

public class JHTMLTest {
    @Test
    public void jhtmlTest(){
        JHTML jhtml = new JHTML();
        jhtml.setTitle("boo");
        jhtml.setLayout(new BorderLayout());

        String path = "D:\\1.html";
        jhtml.start(path);
    }


}
