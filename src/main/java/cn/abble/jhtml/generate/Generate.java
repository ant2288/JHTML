package cn.abble.jhtml.generate;

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
    public Generate(Tag root){
        this.root = root;
    }

    public void generate(String path){
        checkNotNull(path);
        File file = createFile(path);
        String html = root.getText();
        System.out.print(html);
        try {
            write(file,html);
        }catch (Exception e){
            e.printStackTrace();
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
