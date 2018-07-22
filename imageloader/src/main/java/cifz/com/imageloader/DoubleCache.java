package cifz.com.imageloader;

import android.graphics.Bitmap;

/**
 * Author : cifz
 * Time : 2018/7/21
 * e_mail : wangzhen1798@gmail.com
 * function: 双缓存类
 */
public class DoubleCache implements ImageCache{
    MemoryCache imageCache = new MemoryCache();
    DiskCache diskCache = new DiskCache();

    @Override
    public Bitmap get(String url){
        Bitmap bitmap = imageCache.get(url);
        if (bitmap == null){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap){
        imageCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }

}
