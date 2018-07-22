package cifz.com.cifzimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import cifz.com.imageloader.DoubleCache;
import cifz.com.imageloader.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_show;

    String url = "http://192.168.43.133:8080/timg.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_show = findViewById(R.id.iv_show);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.setImageCache(new DoubleCache());
        imageLoader.displayImage(url,iv_show);

    }
}
