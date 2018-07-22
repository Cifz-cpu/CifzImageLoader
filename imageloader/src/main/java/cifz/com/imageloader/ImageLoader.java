package cifz.com.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author : cifz
 * Time : 2018/7/20 23:21
 * e_mail : wangzhen1798@gmail.com
 * function: 图片加载类  仅用于学习!!!!!!!!!!!!!!!!!!
 */
public class ImageLoader {

    //线程池 线程数量为CPU数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private ImageCache imageCache;

    public void setImageCache(ImageCache imageCache) {
        this.imageCache = imageCache;
    }

    public void displayImage(final String url, final ImageView imageView){
        Bitmap bitmap = imageCache.get(url);
        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if(bitmap == null){
                    return;
                }
                if (imageView.getTag().equals(url)){
                    imageView.setImageBitmap(bitmap);
                }
                imageCache.put(url,bitmap);
            }
        });
    }
    
    public void displayImage(int image,ImageView imageView){
        imageView.setBackgroundResource(image);
    }

    private Bitmap downloadImage(String imagUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imagUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
