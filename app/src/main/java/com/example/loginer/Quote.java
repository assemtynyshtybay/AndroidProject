package com.example.loginer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Quote {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("quoteText")
    private String quoteText;
    @Expose
    @SerializedName("quoteAuthor")
    private String quoteAuthor;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

}
