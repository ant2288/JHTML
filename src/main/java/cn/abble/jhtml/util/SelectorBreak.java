package cn.abble.jhtml.util;

/**
 * 选择器结束搜索条件
 * @author 张郡峰
 * @version Version
 * @since 1.0
 */
@FunctionalInterface
public interface SelectorBreak {

    boolean readyBreak();
}
