package schibsted.com.dynamiclayout.components;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import schibsted.com.dynamiclayout.models.ComponentData;
import schibsted.com.dynamiclayout.models.SquareImage;
import schibsted.com.dynamiclayout.util.CachedImageHandler;


public class HCardComponent extends LinearLayout {
    public HCardComponent(Context context, ViewGroup parent, ComponentData data, CachedImageHandler cache) {
        super(context);
        int width = parent.getLayoutParams().width > 0 ? parent.getLayoutParams().width : parent.getWidth();
        setLayoutParams(new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));

        int span = (data.span > 0) ? data.span : 3;
        int imageWidth = width / span;
        int textWidth = width - imageWidth;

        SquareImage iv = new SquareImage(context);
        iv.setLayoutParams(new ViewGroup.LayoutParams(imageWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
        if(data.image != null) {
            cache.setImageBitmap(iv, data.image);
        }

        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(new ViewGroup.LayoutParams(textWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView title = new TextView(context);
        title.setTypeface(null, Typeface.BOLD);
        title.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        String titleText = data.title != null ? data.title : "";
        title.setText(titleText);

        TextView subtitle = new TextView(context);
        subtitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        String subtitleText = data.title != null ? data.subtitle : "";
        subtitle.setText(subtitleText);

        ll.addView(title);
        ll.addView(subtitle);

        setPadding(0, 0, 0, 50);

        addView(iv);
        addView(ll);
    }


}
