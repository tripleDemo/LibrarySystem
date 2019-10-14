package com.hclz.pojo;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthorMsg {
    private Integer authorId;

    private String authorName;

    private String authorPhoto;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date authorBirth;

    public AuthorMsg() {
	}

	public AuthorMsg(String authorName, String authorPhoto, Date authorBirth) {
		this.authorName = authorName;
		this.authorPhoto = authorPhoto;
		this.authorBirth = authorBirth;
	}

	public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    public Date getAuthorBirth() {
        return authorBirth;
    }

    public void setAuthorBirth(Date authorBirth) {
        this.authorBirth = authorBirth;
    }

	@Override
	public String toString() {
		return "AuthorMsg [authorId=" + authorId + ", authorName=" + authorName + ", authorPhoto=" + authorPhoto
				+ ", authorBirth=" + authorBirth + "]";
	}
    
}