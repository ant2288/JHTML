package cn.abble.jhtml.css;

/**
 * 用来存储css属性和值的类
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class CSSKeyAndValue {
    /**
     * 属性
     */
    private String key;

    /**
     * 属性值
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CSSKeyAndValue(String key,String value){
        this.key = key;
        this.value = value;
    }
}
