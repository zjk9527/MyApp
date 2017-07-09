package com.zjk.my_app.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by pjy on 2017/4/28.
 */

public class StreamUtil {
    public static String getStrFromStream(InputStream is){
        String jsonStr="";
        BufferedReader reader=null;
        StringBuilder builder=new StringBuilder();
        try{
            reader=new BufferedReader(new InputStreamReader(is,"utf-8"));
            String line="";
            while((line=reader.readLine())!=null){
                builder.append(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        jsonStr=builder.toString();
        return jsonStr;
    }
    public  static byte[] getByteArrayFromStream(InputStream is){
        ByteArrayOutputStream os=null;
        byte[] datas=null;
        try{
            os=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=0;
            while((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            os.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        datas=os.toByteArray();
        return datas;
    }
}
