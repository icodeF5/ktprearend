package edu.ktp.utils;

import java.util.Set;
import java.util.UUID;

public class Generate {
    public static String GenerateCode(Set<String > codeSet){
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while(codeSet.contains(sb.toString())||flag){
            sb = new StringBuilder();
            flag = false;
            for (int i = 0; i < 6; i++) {
                //生成一个随机的大写英文字符
                char c = (char) (int) (Math.random() * 26 + 65);
                //把字符添加到字符串中
                sb.append(c);
            }
        }
        //返回字符串
        return sb.toString();
    }

    public static String GenerateHomeWorkId(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        return s.replace("-","");
    }
}
