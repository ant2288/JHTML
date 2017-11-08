package cn.abble.jhtml.component;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;

/**
 * 按钮组件
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class JButton implements Component {
    private String value;
    private boolean enable = true;
    private String name;
    private String id;

    @Override
    public void setId(String id){
        this.id = id;
    }

    public JButton(){
        value = "Button";
    }

    public JButton(String value){
        this.value = value;
    }

    @Override
    public void setEnable(boolean enable){
        this.enable = enable;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public Tag getTag(){
        Tag button = Create.createTagByNameWithAttribute("input","type='button'","value='"+value+"'");

        if(name != null){
            button.addAttribute("name='"+name+"'");
        }
        if(!enable){
            button.addAttribute("disable");
        }
        if(id != null){
            button.addAttribute("id='"+id+"'");
        }

        return button;
    }


}
