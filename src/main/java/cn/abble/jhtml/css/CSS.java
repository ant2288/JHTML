package cn.abble.jhtml.css;

import com.google.common.base.Splitter;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 一个完整的css类，由这个类的对象可以生成一个css文件或者一个内嵌css的html。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class CSS {
    private Map<String,CSSContext> map;

    public CSS(){
        map = new HashMap<>();
    }

    /**
     * 添加一个css样式
     * @param selector 选择符
     * @param keyAndValue 属性和属性名称
     */
    public void add(String selector,String keyAndValue){
        //合并
        if(map.containsKey(selector)){
            CSSContext cssContext = map.get(selector);
            cssContext.add(keyAndValue);
        }else{//新建
            CSSContext cssContext = new CSSContext();
            cssContext.add(keyAndValue);
            map.put(selector,cssContext);
        }
    }

    /**
     * 一次性添加多个css样式
     * @param selector 选择器
     * @param keyAndValues 样式
     */
    public void addManyCSS(String selector,String keyAndValues){
       Iterable<String> split = Splitter.on(";")
                .trimResults()
                .omitEmptyStrings()
                .split(keyAndValues);

       split.forEach(e->add(selector,e));
    }

    /**
     * 获取css的文本
     * @return css文本
     */
    public String getText(){
        StringBuffer buffer = new StringBuffer();
        Set<String> key = map.keySet();
        Iterator<String> iterator = key.iterator();
        while(iterator.hasNext()){
            String keys = iterator.next();
            buffer.append(keys);
            buffer.append("{\n");
            map.get(keys).getText(buffer);
            buffer.append("}\n");
        }
        return buffer.toString();
    }

    public Map<String,CSSContext> getMap(){
        return map;
    }

    /**
     * 清除css所有内容
     */
    public void clean(){
        map.clear();
    }

}
