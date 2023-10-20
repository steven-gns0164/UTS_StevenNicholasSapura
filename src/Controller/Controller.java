package Controller;

import Model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;

public class Controller {

    // Create some dummy data for User
    User user1 = new User("Vincent", "Pingcen", "passw0", "Oni-Chan", new ArrayList<>());
    User user2 = new User("Aqil", "NEAR", "passw1", "Agar Silaturahmi tak terputus, bolelah pinjam 100", new ArrayList<>());

    // Create some dummy data for Comment
    Comment comment1 = new Comment("Keren banget lu bang", "1 Person has leave a comment", ContentState.SHOWED);
    Comment comment2 = new Comment("Sehat bang?", "2 Persons has leave a comment", ContentState.SHOWED);

    // Create some dummy data for Feed
    Feed feed1 = new Feed("Caption for feed1", 10, "feed1", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE, new ArrayList<>(Arrays.asList(comment1)));
    Feed feed2 = new Feed("Caption for feed2", 15, "feed2", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE, new ArrayList<>(Arrays.asList(comment1, comment2)));

    // Create some dummy data for Reel
    Reel reel1 = new Reel(2000, 12, "reel1", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.VIDEO, new ArrayList<>(Arrays.asList(comment2)));
    Reel reel2 = new Reel(4000, 9, "reel2", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.VIDEO, new ArrayList<>(Arrays.asList(comment2)));

    // Create some dummy data for Story
    Story story1 = new Story(12, 456, "story1", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE, new ArrayList<>(Arrays.asList(comment1, comment2)));
    Story story2 = new Story(11, 321, "story2", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE, new ArrayList<>(Arrays.asList(comment1)));

    public String showUserPosts(ArrayList<User> listUser) {
        String pinned = "";
        String showed = "";
        String archived = "";
        int jumlahDelete = 0;

        for (int i = 0; i < listUser.size(); i++) {
            ArrayList<Post> listpost = listUser.get(i).getPost();
            for (int j = 0; j < listpost.size(); j++) {
                switch (listpost.get(j).getStatus()) {
                    case PINNED:
                        pinned += printData(listpost, j);
                        break;
                    case SHOWED:
                        showed += printData(listpost, j);
                        break;
                    case ARCHIVED:
                        archived += printData(listpost, j);
                        break;
                    case DELETED:
                        jumlahDelete++;
                    default:
                        break;
                }
            }
        }
        String hasil = pinned + showed + archived + "Jumlah post deleted : " + jumlahDelete;
        return hasil;
    }

    public String printData(ArrayList<Post> listpost, int j) {
        String hasil;
        if (listpost.get(j) instanceof Story) {
            Story story = (Story) listpost.get(j);
            return hasil = "\nViews: " + story.getViews() + listpost.get(j).getStatus();
        } else if (listpost.get(j) instanceof Feed) {
            Feed feed = (Feed) listpost.get(j);
            return hasil = "\nUsername Teman: " + feed.getLikes() + listpost.get(j).getStatus();
        } else if (listpost.get(j) instanceof Reel) {
            Reel reel = (Reel) listpost.get(j);
            return hasil = "\nUsername Teman: " + reel.getPlayedCount() + listpost.get(j).getStatus();
        } else {
            return "";
        }
    }

    public String changePostState(int indexUser, int indexPost, ArrayList<User> listUser) {
        ArrayList<Post> tempPost = listUser.get(indexUser).getPost();
        Post foundPost = (Post) tempPost.get(indexPost);

        if (foundPost.getStatus().equals(ContentState.ARCHIVED)) {
            String tanya = "Mau diubah jadi apa?";
            String jawab = DialogView.showInputDialog(tanya);
            if (jawab.equals("1")) {
                foundPost.setStatus(ContentState.DELETED);
                return "Post Deleted";
            } else if (jawab.equals("2")) {
                foundPost.setStatus(ContentState.SHOWED);
                return "Post Showed";
            } else {
                return "Cancelled";
            }
        } else if (foundPost.getStatus().equals(ContentState.SHOWED)) {
            String tanya = "Post showed mau diuabah kemana?";
            String jawab = DialogView.showInputDialog(tanya);
            if (jawab.equals("1")) {
                foundPost.setStatus(ContentState.PINNED);
                return "Post Pinned";
            } else if (jawab.equals("2")) {
                foundPost.setStatus(ContentState.ARCHIVED);
                return "Post Archived";
            } else {
                return "Cancelled";
            }
        } else if (foundPost.getStatus().equals(ContentState.PINNED)) {
            String tanya = "Post Archived mau diubah kemana?";
            String jawab = DialogView.showInputDialog(tanya);
            if (jawab.equals("1")) {
                foundPost.setStatus(ContentState.SHOWED);
                return "Post Showed";
            } else {
                return "Cancelled";
            }
        } else {
            return "No Return";
        }
    

        }
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.user1.showUserPosts();
        controller.user1.getPost().get(0).showPost("reel1", controller.user1);
        controller.user1.changePostState(controller.user1.getPost().get(0), ContentState.ARCHIVED);
    }
}
