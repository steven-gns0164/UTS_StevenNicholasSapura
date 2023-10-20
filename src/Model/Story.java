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
public class Story extends Post{
    private int duration;
    private int views;

    public Story(int duration, int views, String postId, ContentState status, Timestamp timeUpload, ContentType postType, ArrayList<Comment> comments) {
        super(postId, status, timeUpload, postType, comments);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
