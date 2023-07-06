public class Comment extends Interaction {
    /** Content of comment */
    private String content;

    /**
     * Constructor method for Comment class
     * @param interactionId interaction id
     * @param account Account who make interaction
     * @param post post that interaction is happened
     * @param content content of comment
     */
    public Comment(int interactionId, Account account, Post post, String content){
        super(interactionId, account, post);
        this.content = content;
    }

    /**
     * Gives information about comment
     */
    public void viewComment(){
        System.out.println("Comment " + super.getInteractionId() + ": '" 
            + super.getAccount().getFullName() + "' said '" + content + "'");
    }

    /**
     * Getter method for content of comment.
     * @return The content of comment.
     */
    public String getContent(){
        return content;
    }
}
