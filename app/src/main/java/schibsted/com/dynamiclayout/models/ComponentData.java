package schibsted.com.dynamiclayout.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class ComponentData {
    private static final Gson GSON = new Gson();

    public ComponentType type;
    public int span;
    public ComponentData[] items;
    //public HashMap<String, Object> meta;
    public String action;
    public String title;
    public String subtitle;
    public String image;

    public static ComponentData fromJSON(String json) {
        return GSON.fromJson(json, ComponentData.class);
    }
}
