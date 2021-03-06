package schibsted.com.dynamiclayout.util;

import android.graphics.Bitmap;
import android.util.LruCache;

public class ImageCache {
    private LruCache<String, Bitmap> mMemoryCache;


    public ImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public void addToCache(String key, Bitmap bitmap) {
        if (getFromCache(key) == null && key != null && bitmap != null ) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getFromCache(String key) {
        return mMemoryCache.get(key);
    }
}
