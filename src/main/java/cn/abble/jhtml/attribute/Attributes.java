package cn.abble.jhtml.attribute;

import static com.google.common.base.Preconditions.checkNotNull;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * HTML标签的属性对象，如“id='me' class='man' length='18'”,每个标签对象均有一个Attributes对象，该类实际上是一个装有
 * 任意个Attribute的Map,键就是属性名，值就是属性(Attribute)对象。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 * @see cn.abble.jhtml.attribute.Attribute
 */
public class Attributes {
    private Map<String,Attribute> map;

    public Attributes(){
        map = new HashMap<>();
    }

    private void add(String key,Attribute attribute){
        if(map.containsKey(checkNotNull(key))) {
            return;
        }
        map.put(checkNotNull(key),attribute);
    }

    private void add(Attribute attribute){
        this.add(attribute.getKey(),attribute);
    }

    /**
     * 添加属性，如果属性已经存在，则什么也不会发生，如果需要修改属性，请使用{@link #revise(String,String)}
     * @param name 属性名称
     * @param value 属性值
     */
    public void add(String name,String value){
        this.add(new Attribute(checkNotNull(name),value));
    }

    /**
     * 使用List批量添加属性
     * @param list 存储着Attribute的List
     */
    public void add(List<Attribute> list){
        for(Attribute a : list){
            this.add(a);
        }
    }

    private void revise(String key,Attribute attribute){
        if(map.containsKey(checkNotNull(key))){
            map.put(key,attribute);
        }
    }

    private void revise(Attribute attribute){
        this.revise(attribute.getKey(),attribute);
    }

    /**
     * 修改属性，如果传入的属性不存在，则什么也不会发生，如果需要添加属性(Attribute)，请使用{@link #add(String,String)}
     * @param name 要修改的属性名
     * @param value 修改之后的属性值
     */
    public void revise(String name,String value){
        this.revise(new Attribute(checkNotNull(name),value));
    }

    /**
     * 通过属性名获取属性(Attribute)对象，如果不存在该对象，则返回一个新的Attribute对象
     * @param name 属性名
     * @return 对应属性对象，如果不存在，则返回一个新的Attribute对象
     */
    public Attribute get(String name){
        Optional<Attribute> optional = Optional.fromNullable(map.get(name));
        return optional.or(new Attribute());
    }

    /**
     * 通过属性名删除属性(Attribute)对象并返回。如果不存在该对象，则返回一个新的Attribute对象
     * @param name 属性名
     * @return 被删除的属性对象，如果不存在，则返回一个新的Attribute对象
     */
    public Attribute del(String name){
        Optional<Attribute> optional = Optional.fromNullable(map.remove(checkNotNull(name)));
        return optional.or(new Attribute());
    }

    /**
     * 获取所有的属性(Attribute)对象,返回一个List
     * @return 返回一个List
     */
    public List<Attribute> getAll(){
        List<Attribute> list = Lists.newArrayListWithCapacity(5);
        for(Attribute attribute : map.values()){
            list.add(attribute);
        }
        return list;
    }

    /**
     * 返回HTML样式的Attributes字符串
     * @return 返回HTML样式的Attributes字符串
     */
    public String getText(){
        StringBuffer sb = new StringBuffer();
        List<Attribute> list = this.getAll();
        for(Attribute a : list){
            sb.append(a.getText() + " ");
        }
        return sb.toString().trim();
    }

    /**
     * 判断属性中是否包含有属性名为name的属性
     * @param name 属性名
     * @return 如果有返回true，反之返回false
     */
    public boolean hasAttribute(String name){
        if(map.get(name)==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 获取所有的属性map
     * @return 返回map，包含所有的属性
     */
    public Map<String, Attribute> getMap() {
        return map;
    }

    /**
     * 清空所有属性
     */
    public void cleanAll(){
        map.clear();
    }



    @Override
    public String toString(){
        List<Attribute> list = this.getAll();
        StringBuffer sb = new StringBuffer("{");
        for(Attribute a : list){
            sb.append(a.toString() + " ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Attributes)){
            return false;
        }

        Attributes temp = (Attributes)obj;
        if(map.equals(temp.getMap())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
