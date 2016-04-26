package schibsted.com.dynamiclayout.models;

import com.google.gson.Gson;

public class LayoutData {
    private static final Gson GSON = new Gson();

    public String title;
    public ComponentData[] components;

    public static LayoutData fromJSON(String json) {
        return GSON.fromJson(json, LayoutData.class);
    }
}
