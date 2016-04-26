package schibsted.com.dynamiclayout.util;

import android.graphics.Bitmap;
import android.widget.ImageView;

public interface OnImageDownloadedListener {
    void onImageDownloaded(ImageView iv, String url, Bitmap b);
}
