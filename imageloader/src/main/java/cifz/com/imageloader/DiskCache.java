package cifz.com.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author : cifz
 * Time : 2018/7/21
 * e_mail : wangzhen1798@gmail.com
 * function:将图片缓存到磁盘
 */
public class DiskCache implements ImageCache{
    public final static String CACHE_DIR = "sdcard/cache/";

    @Override
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(CACHE_DIR + url);
    }

    @Override
    public void put(String url , Bitmap bitmap){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(CACHE_DIR+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
