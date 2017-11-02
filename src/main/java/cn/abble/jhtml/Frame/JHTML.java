package cn.abble.jhtml.Frame;

import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;
import static com.google.common.base.Preconditions.*;

/**
 * 通过继承此类即可生成html代码
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class JHTML {
    public static Tag root;
    public static TagManager tagManager;
    public static Tag html;

    static{
        root = Create.createTagByName("html");
        tagManager = new TagManager(root);
        html = root;
    }

    public void setTitle(String title){
        checkNotNull(title);
        Tag head = Create.createTagByNameWithParent("head",root);
        Tag titleTag = Create.createTagByNameWithParent("title",head);
        titleTag.setInnerText(title);
    }
}
