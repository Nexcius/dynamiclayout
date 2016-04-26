package schibsted.com.dynamiclayout.components;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import schibsted.com.dynamiclayout.models.ComponentData;

public class TextComponent extends LinearLayout {
    public TextComponent(Context ctx, ComponentData data) {
        super(ctx);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        setPadding(0, 25, 0, 50);

        TextView title = new TextView(ctx);
        title.setTypeface(null, Typeface.BOLD);
        if(data.title != null) {
            title.setText(data.title);
        }

        TextView subtitle = new TextView(ctx);
        if(data.subtitle != null) {
            subtitle.setText(data.subtitle);
        }

        addView(title);
        addView(subtitle);
    }
}
