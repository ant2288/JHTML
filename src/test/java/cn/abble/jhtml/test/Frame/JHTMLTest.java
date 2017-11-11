package cn.abble.jhtml.test.Frame;

import cn.abble.jhtml.Frame.JHTML;
import cn.abble.jhtml.component.JButton;
import cn.abble.jhtml.component.JTextField;
import cn.abble.jhtml.layout.BorderLayout;
import org.junit.Test;

public class JHTMLTest {
    @Test
    public void jhtmlTest(){
        JHTML jhtml = new JHTML();
        jhtml.setTitle("boo123456");
        JButton jButton = new JButton();
        jhtml.add(jButton);
        jhtml.setLayout(new BorderLayout());
        String path = "D:\\jthmlTest";
        jhtml.start(path,true);
    }


}
