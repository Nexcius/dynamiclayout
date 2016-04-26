package schibsted.com.dynamiclayout.components;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import schibsted.com.dynamiclayout.models.ComponentData;
import schibsted.com.dynamiclayout.util.CachedImageHandler;
import schibsted.com.dynamiclayout.util.ComponentResolver;


public class GridComponent extends GridLayout {
    public GridComponent(Context ctx, ViewGroup parent, ComponentData data, CachedImageHandler cache) {
        super(ctx);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        int columns = data.span > 0 ? data.span : 1;
        setColumnCount(columns);

        int width = parent.getLayoutParams().width > 0 ? parent.getLayoutParams().width : parent.getWidth();
        int columnWidth = width / columns;

        if(data.items != null) {
            for(ComponentData d: data.items) {
                LinearLayout ll = new LinearLayout(ctx);
                ll.setLayoutParams(new ViewGroup.LayoutParams(columnWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

                ComponentResolver.addComponent(ctx, ll, d, cache);
                addView(ll);
            }
        }
    }
}
