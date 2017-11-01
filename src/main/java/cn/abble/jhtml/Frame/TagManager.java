package cn.abble.jhtml.Frame;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.SelectReturnResult;
import cn.abble.jhtml.util.Selector;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import static com.google.common.base.Preconditions.*;

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

    /**
     * 根据id获取标签，如果id出现了多次，则使用第一次出现的
     * @param id 标签id
     * @return 一个标签
     */
    public Tag getTagById(String id){
        checkNotNull(id);
        SelectReturnResult selectReturnResult = Selector.select("#"+id,root);
        if(selectReturnResult.getMessage().equals("OK")){
            return selectReturnResult.getResult().get(0);
        }else{
            return null;
        }
    }



}
