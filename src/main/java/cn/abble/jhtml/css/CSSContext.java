package cn.abble.jhtml.css;

import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
/**
 * 每个CSSContext对象对应一个完整的CSS内容。
 * 如：某个CSSContext对应 #table{color:black;}
 *    一个或者多个CSSContext组成一个完整的CSS样式表
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class CSSContext {
    /**
     * 选择符
     */
    private String selector;

    /**
     * 属性和值
     */

    private List<CSSKeyAndValue> list;

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public List<CSSKeyAndValue> getList() {
        return list;
    }

    public void setList(List<CSSKeyAndValue> list) {
        this.list = list;
    }

    public CSSContext(String selector,List<CSSKeyAndValue> list){
        this.selector = checkNotNull(selector);
        this.list = checkNotNull(list);
    }

    public CSSContext(){
        list = new LinkedList<>();
    }

    /**
     * 添加属性
     * @param cssKeyAndValue
     */
    public void addKeyAndValue(CSSKeyAndValue cssKeyAndValue){
        list.add(cssKeyAndValue);
    }

    /**
     * 使用字符串添加css样式
     * @param keyAndValue css样式
     */
    public void add(String keyAndValue){
        checkNotNull(keyAndValue);
        String[] list = keyAndValue.split(":");
        CSSKeyAndValue cssKeyAndValue = new CSSKeyAndValue(list[0],list[1]);
        this.addKeyAndValue(cssKeyAndValue);
    }


    public void getText(StringBuffer buffer){
        for(CSSKeyAndValue c : list){
            buffer.append("\t");
            buffer.append(c.getKey());
            buffer.append(":");
            String temp = c.getValue();
            if(temp.contains(";")){
                buffer.append(temp+"\n");
            }else{
                buffer.append(temp+";\n");
            }
        }
    }

    public String getKeyAndValueText(){
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(cssKeyAndValue -> {
            stringBuilder.append(cssKeyAndValue.getKey());
            stringBuilder.append(":");
            stringBuilder.append(cssKeyAndValue.getValue());
            stringBuilder.append(";");
        });
        return stringBuilder.toString();
    }
}
