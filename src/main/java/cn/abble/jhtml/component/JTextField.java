package cn.abble.jhtml.component;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;

import javax.swing.*;

/**
 * 文本输入组件
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class JTextField extends AbstractComponent {
    public JTextField(){
        this("");
    }

    public JTextField(String initValue){
        value = initValue;
    }

    @Override
    public Tag getTag() {
        Tag input = Create.createTagByName("input");
        input.addAttribute("type='text'");
        if(name != null){
            input.addAttribute("name='"+name+"'");
        }
        if(id != null){
            input.addAttribute("id='"+id+"'");
        }
        if(!enable){
            input.addAttribute("readOnly");
        }
        return input;
    }
}
