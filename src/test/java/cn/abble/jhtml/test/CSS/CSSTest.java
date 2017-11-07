package cn.abble.jhtml.test.CSS;

import cn.abble.jhtml.css.CSS;
import org.junit.Test;

public class CSSTest {
    @Test
    public void csstest(){
        CSS css = new CSS();
        css.addManyCSS("#id","         color:red;font:16px;;");
        System.out.print(css.getText());
    }
}
