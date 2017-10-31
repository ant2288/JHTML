package cn.abble.jhtml.Frame;

import cn.abble.jhtml.tags.Tag;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

/**
 * 标签管理器，用来管理一整个页面所有的标签以及结构。
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class TagManager {
    Multimap<String,Tag> map;
    Tag root;
    public TagManager(Tag root){
        map = LinkedListMultimap.create();
        this.root = root;
    }



}
