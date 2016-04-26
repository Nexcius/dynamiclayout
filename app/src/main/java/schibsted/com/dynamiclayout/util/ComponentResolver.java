package schibsted.com.dynamiclayout.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import schibsted.com.dynamiclayout.components.GridComponent;
import schibsted.com.dynamiclayout.components.HCardComponent;
import schibsted.com.dynamiclayout.components.ImageComponent;
import schibsted.com.dynamiclayout.components.ListComponent;
import schibsted.com.dynamiclayout.components.TextComponent;
import schibsted.com.dynamiclayout.components.VCardComponent;
import schibsted.com.dynamiclayout.models.ComponentData;

public class ComponentResolver {
    private static final Gson GSON = new Gson();

    public static void addComponent(Context ctx, ViewGroup layout, ComponentData componentData, CachedImageHandler cache) {
        View v = resolve(ctx, layout, componentData, cache);
        if(v != null) {
            layout.addView(v);
        }

    }

    public static View resolve(Context ctx, ViewGroup layout, ComponentData componentData, CachedImageHandler cache) {
        if(componentData != null && componentData.type != null) {
            switch (componentData.type) {
                case Text:
                    return new TextComponent(ctx, componentData);

                case Image:
                    return new ImageComponent(ctx, layout, componentData, cache);

                case List:
                    return new ListComponent(ctx, componentData, cache);

                case Horizontal:
                    componentData.span = 2;
                case Grid:
                    return new GridComponent(ctx, layout, componentData, cache);

                case HCard:
                    return new HCardComponent(ctx, layout, componentData, cache);

                case VCard:
                    return new VCardComponent(ctx, componentData, cache);

                default:
                    Log.w(ComponentResolver.class.getSimpleName(), "Trying to add non supported component: " + GSON.toJson(componentData));
            }

        } else {
            Log.d(ComponentResolver.class.getSimpleName(), "Tried to add invalid component: " + componentData.type + " : " + GSON.toJson(componentData));
        }

        return null;
    }
}
