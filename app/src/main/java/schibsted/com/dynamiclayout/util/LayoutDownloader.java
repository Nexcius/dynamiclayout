package schibsted.com.dynamiclayout.util;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import schibsted.com.dynamiclayout.models.LayoutData;

public class LayoutDownloader extends AsyncTask<String, Void, Integer> {
    private OnLayoutUpdateListener listener;
    private LayoutData layoutData;

    public LayoutDownloader(OnLayoutUpdateListener listener) {
        this.listener = listener;
    }


    @Override
    protected Integer doInBackground(String... filePath) {
        String str = "";

        try {
            URL url = new URL(filePath[0]);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                str += line;
            }

            in.close();
            Log.d(LayoutDownloader.class.getSimpleName(), "Got new layout: " + str);
            layoutData = LayoutData.fromJSON(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JsonSyntaxException e) {
            Log.e(LayoutDownloader.class.getSimpleName(), "Unable to parse layout file");
            e.printStackTrace();
        }

        return str.length();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        listener.OnLayoutUpdate(layoutData);
    }
}
