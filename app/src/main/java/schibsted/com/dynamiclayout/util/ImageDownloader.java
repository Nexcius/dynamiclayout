package schibsted.com.dynamiclayout.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;
    private OnImageDownloadedListener listener;
    private String url;

    public ImageDownloader(ImageView iv, OnImageDownloadedListener listener) {
        this.imageView = iv;
        this.listener = listener;
    }

    protected Bitmap doInBackground(String... urls) {
        this.url = urls[0];

        Bitmap bmp = null;
        try {
            InputStream in = new URL(url).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }

    protected void onPostExecute(Bitmap result) {
        listener.onImageDownloaded(imageView, url, result);
    }
}
