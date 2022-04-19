package com.news.zybertime.Model;

public class DetailNewsModel {
    private int detailNewsImage;
    private String detailNewsTitle;
    private String detailDateTime;
    private String detailNewsText;
    private boolean bookmarked;

    public DetailNewsModel(int detailNewsImage, String detailNewsTitle, String detailDateTime, String detailNewsText) {
        this.detailNewsImage = detailNewsImage;
        this.detailNewsTitle = detailNewsTitle;
        this.detailDateTime = detailDateTime;
        this.detailNewsText = detailNewsText;
    }

    public int getDetailNewsImage() {
        return detailNewsImage;
    }

    public void setDetailNewsImage(int detailNewsImage) {
        this.detailNewsImage = detailNewsImage;
    }

    public String getDetailNewsTitle() {
        return detailNewsTitle;
    }

    public void setDetailNewsTitle(String detailNewsTitle) {
        this.detailNewsTitle = detailNewsTitle;
    }

    public String getDetailDateTime() {
        return detailDateTime;
    }

    public void setDetailDateTime(String detailDateTime) {
        this.detailDateTime = detailDateTime;
    }

    public String getDetailNewsText() {
        return detailNewsText;
    }

    public void setDetailNewsText(String detailNewsText) {
        this.detailNewsText = detailNewsText;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
