package cn.abble.jhtml.tags.util;

import static com.google.common.base.Preconditions.checkNotNull;

import cn.abble.jhtml.tags.Tag;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 用于存放所有的子标签的工具类，使用LinkedList实现
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class SubTags {
    private LinkedList<Tag> list;

    public SubTags(){
        list = new LinkedList<>();
    }

    /**
     * 获取子标签的数量
     * @return int 子标签的数量
     */
    public int getSize(){
        return list.size();
    }

    /**
     * 获取第一个标签。
     * @return Tag 第一个标签
     */
    public Tag getFirst(){
        this.checkSize();
        return list.getFirst();
    }

    /**
     * 获取最后一个标签
     * @return Tag 最后一个标签
     */
    public Tag getLast(){
        this.checkSize();
        return list.getLast();
    }

    /**
     * 添加一个标签到子标签的第一个位置
     * @param tag 要添加的标签对象
     */
    public void addFirst(Tag tag){
        checkNotNull(tag);
        list.addFirst(tag);
    }

    /**
     * 添加一个标签到子标签的最后一个位置
     * @param tag 要添加的标签对象
     */
    public void addLast(Tag tag){
        checkNotNull(tag);
        list.addLast(tag);
    }

    public void addTagByIndex(Tag tag , int index){

    }

    /**
     * 获取所有子标签的HTML代码
     * @return 所有子标签的HTML代码;
     */
    public StringBuffer getText(int c,StringBuffer sb){
        //StringBuffer sb = new StringBuffer();
        for(Tag t : list){
            t.getText(c,sb);
        }
        return sb;
    }

    private void checkSize(){
        if(list.size() == 0){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(!(obj instanceof SubTags)){
            return false;
        }

        SubTags temp = (SubTags)obj;

        if(this.list.equals(temp.list)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
