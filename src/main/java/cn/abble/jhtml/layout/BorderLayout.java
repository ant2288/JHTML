package cn.abble.jhtml.layout;

import cn.abble.jhtml.Frame.JHTML;
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
        Tag west = Create.createTagByNameWithAttribute("div","id='jhtml_east'");
        Tag south = Create.createTagByNameWithAttribute("div","id='jhtml_south'");
        Tag north = Create.createTagByNameWithAttribute("div","id='jhtml_north'");
        Tag center = Create.createTagByNameWithAttribute("div","id='jhtml_center'");
        root.addChildren(east);
        root.addChildren(west);
        root.addChildren(south);
        root.addChildren(north);
        root.addChildren(center);
    }
}
