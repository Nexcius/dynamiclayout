package schibsted.com.dynamiclayout.components;

import android.content.Context;
import android.view.ViewGroup;

import schibsted.com.dynamiclayout.models.ComponentData;
import schibsted.com.dynamiclayout.models.SquareImage;
import schibsted.com.dynamiclayout.util.CachedImageHandler;


public class ImageComponent extends SquareImage {
    public ImageComponent(Context ctx, ViewGroup parent, ComponentData data, CachedImageHandler cache) {
        super(ctx);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if(data.image != null) {
            cache.setImageBitmap(this, data.image);
        }
    }
}
