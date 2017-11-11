package cn.abble.jhtml.layout;

import cn.abble.jhtml.Frame.JHTML;
import cn.abble.jhtml.component.Component;
import cn.abble.jhtml.css.CSS;
import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;
import cn.abble.jhtml.util.SelectReturnResult;
import cn.abble.jhtml.util.Selector;

import java.util.LinkedList;

/**
 * 页面布局，这个布局将页面分为5个位置，分别是CENTER、EAST、WEST、NORTH、SOUTH
 * 和JFrame的差不多
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class BorderLayout implements Layout{

    /**
     * 这是统计这是当前第几个BorderLayout布局。
     * 用来标识标签id
     */
    public static int count = 0;

    public static final String CENTER = "JHTML_center";
    public static final String EAST   =   "JHTML_east";
    public static final String WEST   =   "JHTML_west";
    public static final String NORTH  =  "JHTML_north";
    public static final String SOUTH  =  "JHTML_south";
    private Tag root;
    /**
     * 该布局的所有css样式
     */
    private CSS css;
    /**
     * 这个对象的序号，用来标识htmlId
     */
    private int orderNumber;

    /**
     * 用于删除所有标签。
     */
    private Tag temp;
    
    public BorderLayout(){
        css = new CSS();
        count++;
        orderNumber = count;

    }


    @Override
    public void init(Tag root){
        this.root = root;
        Tag east = Create.createTagByNameWithAttribute("div","id='JHTML_east"+orderNumber+"'");
        Tag west = Create.createTagByNameWithAttribute("div","id='JHTML_west"+orderNumber+"'");
        Tag south = Create.createTagByNameWithAttribute("div","id='JHTML_south"+orderNumber+"'");
        Tag north = Create.createTagByNameWithAttribute("div","id='JHTML_north"+orderNumber+"'");
        Tag center = Create.createTagByNameWithAttribute("div","id='JHTML_center"+orderNumber+"'");

        Tag container = Create.createTagByNameWithAttribute("div","id='JHTML_container"+orderNumber+"'");
        container.addChildren(north);
        Tag main = Create.createTagByNameWithAttribute("div","id='JHTML_main"+orderNumber+"'");
        container.addChildren(main);
        Tag centerBox = Create.createTagByNameWithAttribute("div","id='JHTML_centerBox"+orderNumber+"'");
        main.addChildren(centerBox);
        centerBox.addChildren(center);
        main.addChildren(east);
        main.addChildren(west);
        container.addChildren(south);
        root.addChildren(container);

        temp = container;

    }

    @Override
    public void addCSS() {
        css.addManyCSS("*","padding:0;margin:0");
        css.addManyCSS("body,html","height:100%;font:20px/40px\"microsoft yahei\";color:black");
        css.addManyCSS("#JHTML_container"+orderNumber,"width:100%;margin:0 auto;height:100%");
        css.addManyCSS("#JHTML_north"+orderNumber+",#jhtml_south"+orderNumber,"height:12.5%;width:100%;background:deeppink;");
        css.addManyCSS("#JHTML_main"+orderNumber,"height:75%");
        css.addManyCSS("#JHTML_centerBox"+orderNumber+",#JHTML_west"+orderNumber+",#JHTML_east"+orderNumber,"height:100%;float:left");
        css.addManyCSS("#JHTML_centerBox"+orderNumber,"width:100%;color:#1fc195");
        css.addManyCSS("#JHTML_west"+orderNumber,"background: lightgrey;width: 15%;margin-left: -100%;");
        css.addManyCSS("#JHTML_east"+orderNumber,"background: #2e6da4;width: 15%;margin-left: -15%;");
        css.addManyCSS("#JHTML_center"+orderNumber,"padding-left: 15%;");
    }

    @Override
    public void add(Component component) {
        add(component,CENTER);
    }

    @Override
    public void add(Component component, String position) {
       SelectReturnResult result =  Selector.select("#"+position+orderNumber,root);
       if(result.getMessage().equals(SelectReturnResult.OK)){
           result.getResult().get(0).addChildren(component.getTag());
       }
    }

    @Override
    public CSS getCSS(){
        return css;
    }

    @Override
    public void clean() {
        css.clean();
        root.remove(temp);
    }
}
