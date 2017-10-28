package cn.abble.jhtml.attribute;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * HTML标签的单个“属性-值”对象，如class="table"、onclick="return fun();"。属性由键和值两部分组成。每个Attributeh对象表示一个“属性-值”对。
 * 值可以为null，如果为null，则返回"";
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class Attribute {
    private String key;
    private String value;

    public Attribute(){
        key = "defaultKey";
    }

    /**
     * 构造方法，使用属性名和属性值创建一个属性(Attribute)对象
     * @param key 属性名
     * @param value 属性值
     */
    public Attribute(String key,String value){

        this.key = Preconditions.checkNotNull(key);
        this.value = value;
    }

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

    /**
     * 返回HTML样式的Attribute字符串
     * @return 返回HTML样式的Attribute字符串
     */

    public String getText(){

        return getValue() != null ?getKey()+"="+getValue() : getKey();
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add("key",getKey())
                .add("value",getValue())
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Attribute)){
            return false;
        }
        Attribute temp = (Attribute)obj;
        if(!this.getKey().equals(temp.getKey())){
            return false;
        }
        if(this.getValue() == null && temp.getValue() == null){
            return true;
        }
        if(this.getValue() != null && temp.getValue() == null){
            return false;
        }

        if(this.getValue() == null && temp.getValue() != null){
            return false;
        }

        if(this.getValue().equals(temp.getValue())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key,value);
    }
}
