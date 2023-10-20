/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author Steven
 */
public class Feed extends Post{
    private String caption;
    private int likes;

    public Feed(String caption, int likes, String postId, ContentState status, Timestamp timeUpload, ContentType postType, ArrayList<Comment> comments) {
        super(postId, status, timeUpload, postType, comments);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    
}
