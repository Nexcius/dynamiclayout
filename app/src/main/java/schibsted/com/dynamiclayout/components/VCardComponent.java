package schibsted.com.dynamiclayout.components;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import schibsted.com.dynamiclayout.models.ComponentData;
import schibsted.com.dynamiclayout.models.SquareImage;
import schibsted.com.dynamiclayout.util.CachedImageHandler;


public class VCardComponent extends LinearLayout {
    public VCardComponent(Context context, ComponentData data, CachedImageHandler cache) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        SquareImage iv = new SquareImage(context);
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if(data.image != null) {
            cache.setImageBitmap(iv, data.image);
        }

        TextView title = new TextView(context);
        title.setTypeface(null, Typeface.BOLD);
        title.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        String titleText = data.title != null ? data.title : "";
        title.setText(titleText);

        TextView subtitle = new TextView(context);
        subtitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        String subtitleText = data.title != null ? data.subtitle : "";
        subtitle.setText(subtitleText);

        setPadding(0, 0, 0, 50);

        addView(iv);
        addView(title);
        addView(subtitle);
    }


}
