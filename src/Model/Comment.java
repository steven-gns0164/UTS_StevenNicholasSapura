/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class Comment {
    private String commentId;
    private String text;
    private ContentState status;

    public Comment(String commentId, String text, ContentState status) {
        this.commentId = commentId;
        this.text = text;
        this.status = status;
    }
}
