package cn.abble.jhtml.Frame;

import cn.abble.jhtml.component.Component;
import cn.abble.jhtml.css.CSS;
import cn.abble.jhtml.css.CSSContext;
import cn.abble.jhtml.generate.Generate;
import cn.abble.jhtml.layout.BorderLayout;
import cn.abble.jhtml.layout.Layout;
import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;
import cn.abble.jhtml.util.Selector;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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

    private Layout layout;

    private LinkedList<CSS> cssList;

    /**
     * 最后生成代码的时候，从cssList中取出所有css进行合并
     */
    private CSS AllCSS;

    static{
        root = Create.createTagByName("html");
        tagManager = new TagManager(root);
        html = root;
    }

    /**
     * 构造函数，用来初始化整个页面框架
     */
    public JHTML(){
        Tag head = Create.createTagByNameWithParent("head",root);
        Tag title = Create.createTagByNameWithParent("title",head);
        Tag body = Create.createTagByNameWithParent("body",root);
        cssList = new LinkedList<>();
        setLayout(new BorderLayout());
    }

    /**
     * 设置页面的标题(title标签)
     * @param title 标题文字
     */
    public void setTitle(String title){
        checkNotNull(title);
        Tag titleTag = Selector.select("title",root).getResult().get(0);
        titleTag.setInnerText(title);
    }

    /**
     * 设置布局，如果为null，则为绝对布局
     * @param layout 布局
     */
    public void setLayout(Layout layout){
        cssList.add(layout.getCSS());
        Tag body = Selector.select("body",root).getResult().get(0);
        if(this.layout == null){
            this.layout = layout;
        }else{
            cleanLayout(this.layout);
            this.layout = layout;
        }
        initLayout(body);
    }

    private void initLayout(Tag tag){
        layout.init(tag);
        layout.addCSS();
    }

    /**
     * 更改布局前，清除原来的布局遗留代码
     * @param layout 原来的布局
     */
    public void cleanLayout(Layout layout) {
        if (this.layout == null) {
            return;
        }

        //TODO:清除css遗留代码
        //TODO:清除html遗留代码
        layout.clean();
    }

    /**
     * 添加组件
     */
    public void add(Component component){
        layout.add(component);
    }

    public void add(Component component,String position){
        layout.add(component,position);
    }


    public void start(String path,boolean externalCSS){
        getAllCSS();
        if(externalCSS){
            Tag head = Selector.select("head",root).getResult().get(0);
            Tag link = Create.createTagByNameWithAttribute("link","rel='stylesheet'","href='./JHTML_css.css'","type='text/css'");
            head.addChildren(link);
        }

        Generate generate = new Generate(root,AllCSS,externalCSS);
        generate.generate(checkNotNull(path));
    }

    /**
     * 获取所有的css对象，并将这些对象的所有内容放入AllCSS对象中
     */
    private void getAllCSS(){
        //初始化AllCSS
        AllCSS = new CSS();
        //遍历cssList
        cssList.forEach(css -> {
            //获取一个css对象的map
            Map<String,CSSContext> map = css.getMap();
            //遍历map
            map.forEach((k,v)->{
                //获取cssContext的内容
                String keyAndValueText = v.getKeyAndValueText();
                //向AllCSS中添加
                AllCSS.addManyCSS(k,keyAndValueText);
            });
        });
    }

}
