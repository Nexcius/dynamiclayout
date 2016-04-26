package schibsted.com.dynamiclayout.components;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import schibsted.com.dynamiclayout.models.ComponentData;
import schibsted.com.dynamiclayout.util.CachedImageHandler;
import schibsted.com.dynamiclayout.util.ComponentResolver;

public class ListComponent extends LinearLayout {

    public ListComponent(Context ctx, ComponentData data, CachedImageHandler cache) {
        super(ctx);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

        if(data.items != null) {
            for(ComponentData d: data.items) {
                ComponentResolver.addComponent(ctx, this, d, cache);
            }
        }
    }
}
