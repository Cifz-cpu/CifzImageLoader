package cifz.com.imageloader;

import android.graphics.Bitmap;

/**
 * Author : cifz
 * Time : 2018/7/22
 * e_mail : wangzhen1798@gmail.com
 * function: 图片缓存接口
 */
public interface ImageCache {
    void put(String url, Bitmap bitmap);
    Bitmap get(String url);
}
