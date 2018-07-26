package cifz.com.imageloader;

/**
 * Author : cifz
 * Time : 2018/7/26
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class ImageloaderConfig {
    ImageCache imageCache = new MemoryCache();
    int defaultImage = R.mipmap.ic_launcher;
    int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    private ImageloaderConfig() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
         ImageCache imageCache = new MemoryCache();
         int defaultImage = R.mipmap.ic_launcher;
         int threadCount = Runtime.getRuntime().availableProcessors() + 1;

        public Builder setImageCache(ImageCache imageCache) {
            this.imageCache = imageCache;
            return this;
        }

        public Builder setDefaultImage(int defaultImage) {
            this.defaultImage = defaultImage;
            return this;
        }

        public Builder setThreadCount(int threadCount) {
            this.threadCount = Math.max(1,threadCount);
            return this;
        }

        public void applyConfig(ImageloaderConfig config){
            config.defaultImage = this.defaultImage;
            config.imageCache = this.imageCache;
            config.threadCount = this.threadCount;
        }

        public ImageloaderConfig creqat(){
            ImageloaderConfig config = new ImageloaderConfig();
            applyConfig(config);
            return config;
        }

    }

}
