public class Like extends Interaction {

    /**
     * Constructor method for Like class
     * @param interactionId interaction id
     * @param account Account who make interaction
     * @param post post that interaction is happened
     */
    public Like(int interactionId, Account account, Post post){
        super(interactionId, account, post);
    }

    /**
     * Getter method for account who liked post
     * @return account who liked post
     */
    public Account getAccount() {
        return super.getAccount();
    }

}
