package cn.abble.jhtml.util;

import cn.abble.jhtml.annotation.NotTest;
import cn.abble.jhtml.tags.Tag;
import cn.abble.jhtml.tags.util.SubTags;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 实现js的一些选择方法，如getElementById……
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class Selector {
    static ArrayList<Tag> result = new ArrayList<>();
    public static final String ID = "id";

    @NotTest
    private static List<Tag> DFS(Tag root,SelectorJudge judge,SelectorBreak selectorBreak){
        Stack<Tag> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Tag temp = stack.pop();
            if(judge.judge(temp)){
                result.add(temp);
            }
            if(selectorBreak.readyBreak()){
                break;
            }
            SubTags subtags = temp.getChildrenTags();
            List<Tag> list = subtags.getAll();
            for(Tag tag : list){
                stack.push(tag);
            }
        }
        return result;
    }

    /**
     * 使用选择器进行选择，返回选择的结果
     * @param grammar 原则语法，和jQuery类似
     * @return 选择的结果
     */
    @NotTest
    public static List<Tag> select(String grammar,Tag root){
        checkNotNull(grammar);
        grammar = grammar.trim();
        if(grammar.length() == 0){
            throw new IllegalArgumentException("grammar length is 0");
        }
        /**
         * 获取第一个字符，用来判断使用哪种选择器
         */
        char first = grammar.charAt(0);
        switch (first){
            case '#':
                grammar = removeFirstChar(grammar);
                idSelector(grammar,root);
                break;

            case '.' ://TODO 类选择器


            default: //TODO 标签选择器
        }
        return null;
    }

    private static String removeFirstChar(String s){
        return s.substring(1);
    }

    private static void idSelector(String grammar,Tag root){
        SelectorJudge selectorJudge = e -> e.hasAttributeByName(ID) ?
                (e.getAttributeByName(ID).getValue().equals(grammar)?true:false):false;

        SelectorBreak selectorBreak = ()->result.size() == 0 ? false : true;
        DFS(root,selectorJudge,selectorBreak);
    }

    private static void classSelector(String grammar,Tag root){
        SelectorJudge selectorJudge = e -> !e.hasAttributeByName("class")?false:e.getAttributeByName("class").getValue().equals(grammar)?true:false;
        SelectorBreak selectorBreak = () -> false;
        DFS(root,selectorJudge,selectorBreak);
    }

    private static void tagSelector(String grammar,Tag root){
        SelectorJudge selectorJudge = e -> e.getTagName().equals(grammar)?true:false;
        SelectorBreak selectorBreak = () -> false;
        DFS(root,selectorJudge,selectorBreak);
    }

}
