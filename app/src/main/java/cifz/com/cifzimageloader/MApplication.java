package cifz.com.cifzimageloader;

import android.app.Application;

import cifz.com.imageloader.DoubleCache;
import cifz.com.imageloader.ImageLoader;
import cifz.com.imageloader.ImageloaderConfig;

/**
 * Author : cifz
 * Time : 2018/7/26
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class MApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ImageloaderConfig config = ImageloaderConfig.builder()
                .setDefaultImage(cifz.com.imageloader.R.mipmap.ic_launcher_round)
                .setImageCache(new DoubleCache())
                .setThreadCount(4)
                .creqat();
        ImageLoader.getInstance().init(config);
    }
}
