package cn.abble.jhtml.test.compoent;

import cn.abble.jhtml.component.JButton;
import org.junit.Test;

public class JButtonTest {
    @Test
    public void jbuttonTest(){
        JButton button = new JButton();
        button.setId("asd");
        button.setEnable(false);
        System.out.print(button.getTag().getText());
    }
}
