/**
 * Account class
 */
public class Account {
    /** Id of user */
    private int userId;
    /** Full name of user */
    private String fullName;
    /** Location of user */
    private String location;
    /** Birthday of user */
    private String birthday;
    /** Posts user has posted */
    private Post[] posts;
    /** post array size */
    private int postsSize;
    /** Inbox messages */
    private Message[] inboxMessages;
    /** Inbox messages array size */
    private int inboxMessagesSize;
    /** Outbox messages */
    private Message[] outboxMessages;
    /** Outbox messages array size */
    private int outboxMessagesSize;
    /** Accounts that user follows */
    private Account[] following;
    /** following array size */
    private int followingSize;
    /** Accounts that follow the user */
    private Account[] followers; 
    /** followers array size */
    private int followersSize;

    /** ID of current logged in user */
    private static int currentLoggedInUserId = -1;

    /** Information that whether user is logged in or not */
    private boolean isUserLoggedIn;

    /** account that user viewed his proffile last. */
    private Account lastViewedAccount;

    /** account that blocked by the user */
    private Account[] blockedAccounts;
    /** blockedAccounts array size */
    private int blockedAccountsSize;

    /**
     * Constructor method
     * @param userId id of user
     * @param fullName name of user
     * @param location location of user
     * @param birthday birthday of user
     * @param posts posts user has posted
     * @param messages messages user has eighter sent or recieved.
     */
    public Account(int userId, String fullName,String location, String birthday, Post[] posts, Message[] messages) {
        this.userId = userId;
        this.fullName = fullName;
        this.location = location;
        this.birthday = birthday;

        this.posts = new Post[100];
        this.postsSize = 0;
        if (posts != null){
            for (int i = 0; i < 100 && posts[i] != null; i++) {
                this.posts[this.postsSize++] = posts[i];
            }
        }

        this.inboxMessages = new Message[100];
        this.inboxMessagesSize = 0;
        this.outboxMessages = new Message[100];
        this.outboxMessagesSize = 0;
        if (messages != null) {
            for (int i = 0; i < 100 && messages[i] != null; i++){
                if (messages[i].getSenderId() == userId){
                    this.inboxMessages[this.inboxMessagesSize++] = messages[i];
                } else {
                    this.outboxMessages[this.outboxMessagesSize++] = messages[i];
                }
            }
        }


        this.followers = new Account[100];
        this.followersSize = 0;
        this.following = new Account[100];
        this.followersSize = 0;

        this.isUserLoggedIn = false;

        this.lastViewedAccount = null;

        this.blockedAccounts = new Account[100];
        this.blockedAccountsSize = 0;
    }


    /**
     * Makes user log in if there isn't other account has logged in
     */
    public void LogIn(){
        if (currentLoggedInUserId != -1){
            // an account has already logged in.
            // Print an error message then exit the method.
            System.out.println("You can't log in while another user has already logged in!!!");
            return;
        }
        currentLoggedInUserId = userId;
        isUserLoggedIn = true;
    }


    /**
     * Makes the login account logout.
     */
    public void logOut(){
        // Check whether user is login or not
        if (!isUserLoggedIn){
            System.out.println("Error! Can not logout! User is not login!!!");
            return;
        }
        isUserLoggedIn = false;
        currentLoggedInUserId = -1;
    }



    /**
     * Getter method for userId
     * @return id of user
     */
    int getUserId(){
        return userId;
    }

    /**
     * Getter method for fullname of user
     * @return full name of user
     */
    public String getFullName(){
        return fullName;
    }


    /**
     * Getter method for posts
     * @return user's posts
     */
    public Post[] getPosts() {
        return posts;
    }


    /**
     * Getter method for postSize
     * @return size of posts array
     */
    public int getPostSize() {
        return postsSize;
    }


    /**
     * Add a new post
     * @param newPost new post to add
     */
    void addPost(Post newPost){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        posts[postsSize++] = newPost;
    }


    /**
     * Add new message to inbox
     * @param newMessage new message to add
     */
    void addMessageToInbox(Message newMessage){
        if (isBlocked(newMessage.getSender())) {
            // Sender is blocked by user. Exit without adding message to inbox
            return ;
        }
        inboxMessages[inboxMessagesSize++] = newMessage;
    }

    /**
     * Add new message to outbox
     * @param newMessage new message to add
     */
    void addOutbox(Message newMessage){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        if (newMessage.getReceiver().isBlocked(this)) {
            // receiver is blocked the user.
            System.out.println("You are blocked by him/her!!! You cant send message to him/her");
            return ;
        }
        outboxMessages[outboxMessagesSize++] = newMessage;
    }


    /**
     * Follow theAccount 
     * @param theAccount The account to follow
     */
    public void follow(Account theAccount){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }

        // Check that whether user is already following account or not.
        // If user already following account then dont add theAccout to 
        // the following array again.
        for (int i = 0; i < followingSize; i++){
            if (following[i] == theAccount){
                // theAccout is already followed by user.
                // exit from function.
                return ;
            }
        }

        // If we reach this line then theAccount isn't following by user.
        // Add following array to follow theAccount.
        following[followingSize++] = theAccount;
    }


    /**
     * View an accounts profile
     * @param theAccount The account to view its profile
     */
    public void viewProfile(Account theAccount){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        if (theAccount.isBlocked(this)) {
            System.out.println("You are blocked by this user!!!");
            return ;
        }
        theAccount.profileInformation();
        lastViewedAccount = theAccount;
    }



    /**
     * Gives information of posts of theAccount
     * @param theAccount The account to check hims/hers posts
     */
    public void viewPost(Account theAccount) {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        if (lastViewedAccount != theAccount){
            System.out.println("You must view his/her account to see its posts!!!");
            return ;
        }

        // Print each post from theAccount.getPosts()
        Post[] tmpPosts = theAccount.getPosts();
        for (int i = 0; i < theAccount.getPostSize(); i++) {
            tmpPosts[i].viewPost();
        }
    }

    /**
     * Gives detailed information about posts of theAccount
     * @param theAccount The account to look at hims/hers posts
     */
    public void viewPostInteractions(Account theAccount) {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        if (lastViewedAccount != theAccount){
            System.out.println("You must view his/her account to see its posts!!!");
            return ;
        }

        // Print each post from theAccount.getPosts()
        Post[] tmpPosts = theAccount.getPosts();
        for (int i = 0; i < theAccount.getPostSize(); i++){
            System.out.println("---------------------");
            tmpPosts[i].viewInteractions();
            System.out.println("---------------------");
        }
    }




    /**
     * Gives detailed information of users profile
     */
    public void profileInformation() {
        System.out.println("User ID: " + userId
            + "\nUsername: " + fullName
            + "\nLocation: " + location
            + "\nBirth Date: " + birthday
            + "\n" + fullName + " is following " + followingSize + " account(s) "
            + "and has " + followersSize + " follower(s).");

        if (followersSize != 0) {
            System.out.print("The followers of " + fullName + " are: ");
            for (int i = 0; i < followersSize; i++){
                System.out.print(followers[i].getFullName() + ", ");
            }
        }


        if (followingSize != 0) {
            System.out.print("\n" + fullName + " is following: ");
            for (int i = 0; i < followingSize; i++){
                System.out.print(following[i].getFullName() + ", ");
            }
        }


        System.out.println("\n" + fullName + " has " + postsSize + " post(s).");
    }



    /**
     * Check that how many messages exist in inbox
     */
    public void checkInbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        System.out.println("There is/are " + inboxMessagesSize 
        + " message(s) in the inbox.");
    }


    /**
     * Check that how many messages exist in outbox
     */
    public void checkOutbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        System.out.println("There is/are " + outboxMessagesSize 
        + " message(s) in the outbox.");
    }


    /**
     * View inbox of user
     */
    public void viewInbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        for (int i = 0; i < inboxMessagesSize; i++) {
            inboxMessages[i].viewMessage();
        }
    }


    /**
     * View outbox of user
     */
    public void viewOutbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        for (int i = 0; i < outboxMessagesSize; i++) {
            outboxMessages[i].viewMessage();
        }
    }


    /**
     * Blocks account
     * @param theAccount account to block
     */
    public void blockAccount(Account theAccount) {
        blockedAccounts[blockedAccountsSize++] = theAccount;
    }

    public boolean isBlocked(Account theAccount) {
        for (int i = 0; i < blockedAccountsSize; i++) {
            if (blockedAccounts[i] == theAccount){
                return true;
            }
        }
        return false;
    }

}
