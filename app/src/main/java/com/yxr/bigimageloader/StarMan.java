package com.yxr.bigimageloader;

/**
 * Created by icer on 16/5/10.
 */
public class StarMan {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StarMan(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
