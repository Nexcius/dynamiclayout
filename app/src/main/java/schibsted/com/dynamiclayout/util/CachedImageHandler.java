package schibsted.com.dynamiclayout.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class CachedImageHandler implements OnImageDownloadedListener {
    private final ImageCache imageCache = new ImageCache();

    public void setImageBitmap(ImageView iv, String url) {
        final String imageKey = url;

        final Bitmap bitmap = imageCache.getFromCache(imageKey);
        if (bitmap != null) {
            onImageDownloaded(iv, url, bitmap);
        } else {
            new ImageDownloader(iv, this).execute(url);
        }
    }

    @Override
    public void onImageDownloaded(ImageView iv, String url, Bitmap b) {
        imageCache.addToCache(url, b);
        iv.setImageBitmap(b);
        iv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}
