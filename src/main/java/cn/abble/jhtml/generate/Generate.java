package cn.abble.jhtml.generate;

import cn.abble.jhtml.css.CSS;
import cn.abble.jhtml.tags.Tag;

import java.io.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 用于生成HTML文件
 * @author 张郡峰
 * @version Version 1.0
 * @since 1.0
 */
public class Generate {
    private Tag root;
    private CSS css;
    private boolean externalCSS;
    public Generate(Tag root,CSS css,boolean externalCSS){
        this.root = root;
        this.css = css;
        this.externalCSS = externalCSS;
    }

    public void generate(String path){
        checkNotNull(path);
        File file = createFile(path+"\\jhtml.html");
        String html = root.getText();
        System.out.print(html);
        try {
            write(file,html);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(externalCSS){
            File cssFile = createFile(path+"\\jhtml_css.css");
            String cssText = css.getText();
            try {
                write(cssFile,cssText);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private File createFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private void write(File file,String html) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(html);
        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
