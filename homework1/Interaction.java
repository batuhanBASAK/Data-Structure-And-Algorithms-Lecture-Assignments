public class Interaction {

    /** Interaction id */
    private int interactionId;
    /** Account who make interaction */
    private Account account;
    /** post that interaction is happened */
    private Post post;

    /**
     * Constructor method for Interaction class
     * @param interactionId interaction id
     * @param account Account who make interaction
     * @param post post that interaction is happened
     */
    public Interaction(int interactionId, Account account, Post post){
        this.interactionId = interactionId;
        this.account = account;
        this.post = post;
    }

    /**
     * Getter method for interaction id
     * @return interaction id
     */
    protected int getInteractionId() {
        return interactionId;
    }

    /**
     * Getter method for account
     * @return Account who make interaction
     */
    protected Account getAccount() {
        return account;
    }

    /**
     * Getter method for post
     * @return post that interaction is happened
     */
    protected Post getPost() {
        return post;
    }

}
