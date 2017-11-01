package cn.abble.jhtml.Excetion;

/**
 * 参数有误时抛出该异常
 * @author 张郡峰
 */
public class IllegalParameterException extends Exception {
    public IllegalParameterException(String message){
        super(message);
    }
}
