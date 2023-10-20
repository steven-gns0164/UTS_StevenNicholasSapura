/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author Steven
 */
public abstract class Post {

    private String postId;
    private ContentState status;
    private Timestamp timeUpload;
    private ContentType postType;
    private ArrayList<Comment> comments;

    public Post(String postId, ContentState status, Timestamp timeUpload, ContentType postType, ArrayList<Comment> comments) {
        this.postId = postId;
        this.status = status;
        this.timeUpload = timeUpload;
        this.postType = postType;
        this.comments = comments;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public Timestamp getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Timestamp timeUpload) {
        this.timeUpload = timeUpload;
    }

    public ContentType getPostType() {
        return postType;
    }

    public void setPostType(ContentType postType) {
        this.postType = postType;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
