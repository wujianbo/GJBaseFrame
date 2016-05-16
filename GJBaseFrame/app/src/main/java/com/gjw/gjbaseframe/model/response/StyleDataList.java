package com.gjw.gjbaseframe.model.response;

/**
 * 首页获取系列列表-TabLayout
 * Created by Hank on 2016/4/23.
 */
public class StyleDataList {

    /**
     * id : 1030407
     * orderTag : 7
     * text : 构家新古典
     * parentId : 10304
     * imagePath : imagePath
     */

    private int id;
    private int orderTag;
    private String text;
    private int parentId;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(int orderTag) {
        this.orderTag = orderTag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
