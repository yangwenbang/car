package com.car.common.utils.File;

public class HtmlVo {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return String.format("title:%s,content:%s",this.getTitle(),this.getContent());
    }
}
