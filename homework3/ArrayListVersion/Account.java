import java.util.ArrayList;

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
    private ArrayList<Post> posts;
    /** Inbox messages */
    private ArrayList<Message> inboxMessages;
    /** Outbox messages */
    private ArrayList<Message> outboxMessages;
    /** Accounts that user follows */
    private ArrayList<Account> following;
    /** Accounts that follow the user */
    private ArrayList<Account> followers;
    private ArrayList<String> actionHistory;

    /** ID of current logged in user */
    private static int currentLoggedInUserId = -1;

    /** Information that whether user is logged in or not */
    private boolean isUserLoggedIn;

    /** account that user viewed his proffile last. */
    private Account lastViewedAccount;

    /** account that blocked by the user */
    private ArrayList<Account> blockedAccounts;

    /**
     * Constructor method
     * @param userId id of user
     * @param fullName name of user
     * @param location location of user
     * @param birthday birthday of user
     * @param posts posts user has posted
     * @param messages messages user has eighter sent or recieved.
     */
    public Account(int userId, String fullName,String location, String birthday, ArrayList<Post> posts, ArrayList<Message> messages) {
        this.userId = userId;
        this.fullName = fullName;
        this.location = location;
        this.birthday = birthday;

        this.posts = new ArrayList<>();
        if (posts != null){
            for (int i = 0; i < posts.size(); i++) {
                this.posts.add(posts.get(i));
            }
        }

        this.inboxMessages = new ArrayList<>();
        this.outboxMessages = new ArrayList<>();
        if (messages != null) {
            for (int i = 0; i < messages.size(); i++){
                if (messages.get(i).getSenderId() == userId){
                    this.inboxMessages.add(messages.get(i));
                } else {
                    this.outboxMessages.add(messages.get(i));
                }
            }
        }


        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.actionHistory = new ArrayList<>();

        this.isUserLoggedIn = false;

        this.lastViewedAccount = null;

        this.blockedAccounts = new ArrayList<>();
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
        actionHistory.add(fullName + " is logged in.");
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
        actionHistory.add(fullName + " is logged out.");
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
    public ArrayList<Post> getPosts() {
        return posts;
    }


    /**
     * Getter method for postSize
     * @return size of posts array
     */
    public int getPostSize() {
        return posts.size();
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
        posts.add(newPost);
        actionHistory.add(fullName + " added a new post.");
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
        inboxMessages.add(newMessage);
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
        outboxMessages.add(newMessage);
        actionHistory.add(fullName + " sent a new message.");
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
        if (following.indexOf(theAccount) != -1){
            // The user already has been following this account.
            return ;
        }

        // If we reach this line then theAccount isn't following by user.
        // Add following array to follow theAccount.
        following.add(theAccount);
        actionHistory.add(fullName + " has started to follow account " + theAccount.getFullName());
    }

    /**
     * Unfollow an account you've already followed.
     * @param theAccount The account to unfollow.
     */
    public void unfollow(Account theAccount){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        int index = following.indexOf(theAccount);
        if (index != -1){
            following.remove(index);
            actionHistory.add(fullName + " unfollowed the account " + theAccount.getFullName());
        } else {
            System.out.println("Error: You are not following the the account!!!");
        }

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
        actionHistory.add(fullName + " viewed the profile of the account " + theAccount.getFullName());
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
        ArrayList<Post> tmpPosts = theAccount.getPosts();
        for (int i = 0; i < theAccount.getPostSize(); i++) {
            tmpPosts.get(i).viewPost();
        }
        actionHistory.add(fullName + " viewed the posts of the account " + theAccount.getFullName());
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
        ArrayList<Post> tmpPosts = theAccount.getPosts();
        for (int i = 0; i < theAccount.getPostSize(); i++){
            System.out.println("---------------------");
            tmpPosts.get(i).viewInteractions();
            System.out.println("---------------------");
        }
        actionHistory.add(fullName + " viewed the posts interactions of the account " + theAccount.getFullName());
    }




    /**
     * Gives detailed information of users profile
     */
    public void profileInformation() {
        System.out.println("User ID: " + userId
            + "\nUsername: " + fullName
            + "\nLocation: " + location
            + "\nBirth Date: " + birthday
            + "\n" + fullName + " is following " + following.size() + " account(s) "
            + "and has " + followers.size() + " follower(s).");

        if (followers.size() != 0) {
            System.out.print("The followers of " + fullName + " are: ");
            for (int i = 0; i < followers.size(); i++){
                System.out.print(followers.get(i).getFullName() + ", ");
            }
        }


        if (following.size() != 0) {
            System.out.print("\n" + fullName + " is following: ");
            for (int i = 0; i < following.size(); i++){
                System.out.print(following.get(i).getFullName() + ", ");
            }
        }


        System.out.println("\n" + fullName + " has " + posts.size() + " post(s).");
    }



    /**
     * Check that how many messages exist in inbox
     */
    public void checkInbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        System.out.println("There is/are " + inboxMessages.size() 
        + " message(s) in the inbox.");
        actionHistory.add(fullName + " checked the inbox.");
    }


    /**
     * Check that how many messages exist in outbox
     */
    public void checkOutbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        System.out.println("There is/are " + outboxMessages.size() 
        + " message(s) in the outbox.");
        actionHistory.add(fullName + " checked the outbox.");
    }


    /**
     * View inbox of user
     */
    public void viewInbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        for (int i = 0; i < inboxMessages.size(); i++) {
            inboxMessages.get(i).viewMessage();
        }
        actionHistory.add(fullName + " viewed the inbox.");
    }


    /**
     * View outbox of user
     */
    public void viewOutbox() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        for (int i = 0; i < outboxMessages.size(); i++) {
            outboxMessages.get(i).viewMessage();
        }
        actionHistory.add(fullName + " checked the outbox.");
    }


    /**
     * Blocks account
     * @param theAccount account to block
     */
    public void blockAccount(Account theAccount) {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        int index = blockedAccounts.indexOf(theAccount);
        if (index == -1){
            blockedAccounts.add(theAccount);
            actionHistory.add(fullName + " has blocked the account " + theAccount.getFullName());
        } else {
            System.out.println("Error: Account has already been blocked!!!");
        }
    }

    /**
     * Unblock a blocked account.
     * @param theAccount The account to unblock.
     */
    public void unblockAccount(Account theAccount){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        int index = blockedAccounts.indexOf(theAccount);
        if (index != -1){
            blockedAccounts.remove(index);
            actionHistory.add(fullName + " has unblocked the account " + theAccount.getFullName());
        } else {
            System.out.println("Error: Account hasn't been blocked yet!!!");
        }
    }


    /**
     * Check that whether an account is blocked or not.
     * @param theAccount The account to check it.
     * @return true if the account is blocked. Else false.
     */
    public boolean isBlocked(Account theAccount) {
        for (int i = 0; i < blockedAccounts.size(); i++) {
            if (blockedAccounts.get(i) == theAccount){
                return true;
            }
        }
        return false;
    }

    /**
     * Getter method for information that whether user is login or not.
     * @return true if user logged in, else false.
     */
    public boolean isUserLoggedIn(){
        return isUserLoggedIn;
    }

    /**
     * Adds a new activity to activity history.
     * @param newActivity The new activity to add activity history.
     */
    public void addActivity(String newActivity){
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        actionHistory.add(newActivity);
    }


    /**
     * Shows the action history of the user if user is logged in.
     */
    public void showActionHistory() {
        if (!isUserLoggedIn){
            System.out.println("Error: You are not logged in!!!");
            return ;
        }
        System.out.println("----------------------------------------");
        System.out.println("Action History:");
        for (int i = 0; i < actionHistory.size(); i++){
            System.out.println(i + ".\t" + actionHistory.get(i));
        }
        System.out.println("----------------------------------------");
    }
}
