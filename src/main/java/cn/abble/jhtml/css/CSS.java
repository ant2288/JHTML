package cn.abble.jhtml.css;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 一个完整的css类，由这个类的对象可以生成一个css文件或者一个内嵌css的html。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class CSS {
    private Map<String,CSSContext> list;

    public CSS(){
        list = new HashMap<>();
    }

    /**
     * 添加一个css样式
     * @param selector 选择符
     * @param keyAndValue 属性和属性名称
     */
    public void add(String selector,String keyAndValue){
        //TODO:使用这两个参数向CSS中添加
    }


}
