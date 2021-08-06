package com.example.markocupic2017200815;

public class PcPart {
    private String name, description, whereToBuy, image, urlSite;

    public PcPart () {}

    public PcPart(String name, String description, String whereToBuy, String image, String urlSite) {
        this.name = name;
        this.description = description;
        this.whereToBuy = whereToBuy;
        this.image = image;
        this.urlSite = urlSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhereToBuy() {
        return whereToBuy;
    }

    public void setWhereToBuy(String whereToBuy) {
        this.whereToBuy = whereToBuy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrlSite() {
        return urlSite;
    }

    public void setUrlSite(String url) {
        this.urlSite = urlSite;
    }
}
