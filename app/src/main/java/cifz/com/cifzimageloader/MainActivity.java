package cifz.com.cifzimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.net.URL;

import cifz.com.imageloader.DoubleCache;
import cifz.com.imageloader.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_show;

    String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1532573147000&di=ce2e4dfe40739ab311a11bdde3e5d0e6&imgtype=0&src=http%3A%2F%2Fs6.sinaimg.cn%2Fmw690%2F006LDoUHzy7auXEaYER25%26690";
//    String url = "http://192.168.43.133:8080/timg.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_show = findViewById(R.id.iv_show);
        ImageLoader.getInstance().displayImage(url,iv_show);
    }
}
