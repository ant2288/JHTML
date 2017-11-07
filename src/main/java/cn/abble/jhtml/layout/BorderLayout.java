package cn.abble.jhtml.layout;

import cn.abble.jhtml.Frame.JHTML;
import cn.abble.jhtml.css.CSS;
import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.util.Create;

/**
 * 页面布局，这个布局将页面分为5个位置，分别是CENTER、EAST、WEST、NORTH、SOUTH
 * 和JFrame的差不多
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class BorderLayout implements Layout{
    public static final String CENTER = "center";
    public static final String EAST   =   "east";
    public static final String WEST   =   "west";
    public static final String NORTH  =  "north";
    public static final String SOUTH  =  "south";


    public BorderLayout(){

    }

    @Override
    public void init(Tag root){
        Tag east = Create.createTagByNameWithAttribute("div","id='jhtml_east'");
        Tag west = Create.createTagByNameWithAttribute("div","id='jhtml_west'");
        Tag south = Create.createTagByNameWithAttribute("div","id='jhtml_south'");
        Tag north = Create.createTagByNameWithAttribute("div","id='jhtml_north'");
        Tag center = Create.createTagByNameWithAttribute("div","id='jhtml_center'");

        Tag container = Create.createTagByNameWithAttribute("div","id='jhtml_container'");
        container.addChildren(north);
        Tag main = Create.createTagByNameWithAttribute("div","id='jhtml_main'");
        container.addChildren(main);
        Tag centerBox = Create.createTagByNameWithAttribute("div","id='jhtml_centerBox'");
        main.addChildren(centerBox);
        centerBox.addChildren(center);
        main.addChildren(east);
        main.addChildren(west);
        container.addChildren(south);
        root.addChildren(container);


    }

    @Override
    public void addCSS(CSS css) {
        css.addManyCSS("*","padding:0;margin:0");
        css.addManyCSS("body,html","height:100%;font:20px/40px\"microsoft yahei\";color:black");
        css.addManyCSS("#jhtml_container","width:100%;margin:0 auto;height:100%");
        css.addManyCSS("#jhtml_north,#jhtml_south","height:12.5%;width:100%;background:deeppink;");
        css.addManyCSS("#jhtml_main","height:75%");
        css.addManyCSS("#jhtml_centerBox,#jhtml_west,#jhtml_east","height:100%;float:left");
        css.addManyCSS("#jhtml_centerBox","width:100%;color:#1fc195");
        css.addManyCSS("#jhtml_west","background: lightgrey;width: 15%;margin-left: -100%;");
        css.addManyCSS("#jhtml_east","background: #2e6da4;width: 15%;margin-left: -15%;");
        css.addManyCSS("#jhtml_center","padding-left: 15%;");
    }
}
