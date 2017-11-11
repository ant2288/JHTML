package cn.abble.jhtml.component;
/**
 * 所有组件的抽象类
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public abstract class AbstractComponent implements Component{
    public String value;
    public boolean enable = true;
    public String name;
    public String id;

    @Override
    public void setId(String id){
        this.id = id;
    }

    @Override
    public void setEnable(boolean enable){
        this.enable = enable;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    public String getValue(){
        return value;
    }

}
