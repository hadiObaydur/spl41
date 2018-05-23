package com.example.iit.androidnewsappspl2.Model;

/**
 * Created by reale on 10/4/2017.
 */

public class Article {
    private SourceOfArticle source;
    private String author,title,description,url,urlToImage,publishedAt;


    public Article(SourceOfArticle source,String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;

    }

    /* public String getId() {
            return id;
        }
        public void setId(String id) {
             this.id=id ;
        }
        public String getName() {
           return name ;
        }
        public void setName(String name) {
            this.name=name ;
        }
        public void setStatus(String status) {
            this.status=status;
        }
        public String getStatus(){return status;}

        */
    public SourceOfArticle getSourceOfArticle() {
        return source;
    }

    public void setSourceOfrArticleArticle(SourceOfArticle source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
