import java.util.LinkedList;
public class Post {
    /** Id of post */
    private int postId;
    /** Account who post this post */
    private Account account;
    /** Likes for this post */
    private LinkedList<Like> likes;
    /** Comments for this post */
    private LinkedList<Comment> comments;
    /** content of post */
    private String content;


    /**
     * Constructor method for Post class
     * @param postId Id of post
     * @param account The account post this post
     * @param likes Array of Likes for this post
     * @param comments Array of Comments on this post
     * @param content Content of the post
     */
    public Post(int postId, Account account, LinkedList<Like> likes, LinkedList<Comment> comments, String content) {
        this.postId = postId;
        this.account = account;

        
        this.likes = new LinkedList<>();
        if (likes != null){
            for (int i = 0; i < likes.size(); i++) {
                this.likes.add(likes.get(i));
            }
        }

        this.comments = new LinkedList<>();
        if (comments != null) {
            for (int i = 0; i < comments.size(); i++) {
                this.comments.add(comments.get(i));
            }
        }
        this.content = content;
    }


    /**
     * Gives information of post id, name of account who 
     * posted, and content of post
     */
    public void viewPost() {
        System.out.println("(Post ID: " + postId + ") " + account.getFullName() + ": " + content);
    }

    /**
     * Gives detailed information of post's interactions.
     */
    public void viewInteractions() {
        viewPost();
        
        if (likes.size() != 0) {
            System.out.print("The post was liked by the following account(s): ");
            for (int i = 0; i < likes.size(); i++) {
                System.out.print(likes.get(i).getAccount().getFullName() + ", ");
            }
            System.out.println("");
        }

        System.out.println("The post has " + comments.size() + " comment(s)...");
        for (int i = 0; i < comments.size(); i++) {
            comments.get(i).viewComment();
        }
    }

    /**
     * Add like to post
     * @param theLike the like to post
     */
    public void addLike(Like theLike) {
        for (int i = 0; i < likes.size(); i++) {
            if (likes.get(i).getAccount() == theLike.getAccount()) {
                System.out.println("You can't like anymore! You already liked!!!");
                return;
            }
        }

        likes.add(theLike);
        theLike.getAccount().addActivity(theLike.getAccount().getFullName() + " liked the post '" + this.content + "'");
    }

    /**
     * Unlike a like that liked to this post if user who liked is logged in.
     * @param theAccount
     */
    public void unlike(Account theAccount){
        for (int i = 0; i < likes.size(); i++){
            if (likes.get(i).getAccount() == theAccount){
                if (theAccount.isUserLoggedIn()){
                    likes.remove(i);
                    theAccount.addActivity(theAccount.getFullName() + " unliked the post '" + this.content + "'");
                } else {
                    System.out.println("Error: You can't unlike a post you like while logged out!!!");
                }
                return ;
            }
        }
        System.out.println("Error: You can't unlike!!! You haven't like this post yet!!!");
    }


    /**
     * Uncomment a comment that commented to this post if user who commented is logged in.
     * @param theComment The comment to delete.
     */
    public void uncomment(Comment theComment){
        int index = comments.indexOf(theComment);
        if (index != -1){
            if (theComment.getAccount().isUserLoggedIn()){
                comments.remove(index);
                theComment.getAccount().addActivity(theComment.getAccount().getFullName() + " uncommented the comment '" + theComment.getContent() + "'");
            } else {
                System.out.println("Error: You can not uncomment while you are not logged in!!!");
            }
        } else {
            System.out.println("Error: There is no such comment exist for this post!!!");
        }
    }




    /**
     * Add comment to post
     * @param theComment the comment to add
     */
    public void addComment(Comment theComment) {
        comments.add(theComment);
        theComment.getAccount().addActivity(theComment.getAccount().getFullName() + " commented the comment '" + theComment.getContent() + "'");
    }


}
