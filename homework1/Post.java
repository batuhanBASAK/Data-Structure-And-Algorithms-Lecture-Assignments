public class Post {
    /** Id of post */
    private int postId;
    /** Account who post this post */
    private Account account;
    /** Likes for this post */
    private Like[] likes;
    /** Size of array likes */
    private int likesSize;
    /** Comments for this post */
    private Comment[] comments;
    /** size of array comments */
    private int commentsSize;
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
    public Post(int postId, Account account, Like[] likes, Comment[] comments, String content) {
        this.postId = postId;
        this.account = account;

        
        this.likes = new Like[100];
        this.likesSize = 0;
        if (likes != null) {
            for (Like l : likes) {
                this.likes[this.likesSize++] = l;
            }
        }

        this.comments = new Comment[100];
        this.commentsSize = 0;
        if (comments != null) {
            for (Comment l : comments) {
                this.comments[this.commentsSize++] = l;
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
        
        if (likesSize != 0) {
            System.out.print("The post was liked by the following account(s): ");
            for (int i = 0; i < likesSize; i++) {
                System.out.print(likes[i].getAccount().getFullName() + ", ");
            }
            System.out.println("");
        }

        System.out.println("The post has " + commentsSize + " comment(s)...");
        for (int i = 0; i < commentsSize; i++) {
            comments[i].viewComment();
        }
    }

    /**
     * Add like to post
     * @param theLike the like to post
     */
    public void addLike(Like theLike) {
        for (int i = 0; i < likesSize; i++) {
            if (likes[i].getAccount() == theLike.getAccount()) {
                System.out.println("You can't like anymore! You already liked!!!");
                return;
            }
        }

        likes[likesSize++] = theLike;
    }

    /**
     * Add comment to post
     * @param theComment the comment to add
     */
    public void addComment(Comment theComment) {
        comments[commentsSize++] = theComment;
    }


}
