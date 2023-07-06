/** Test program for forth scenario */
public class TestClass4 {
    public static void main(String[] args) {
        // 10 new account
        Account account1 = new Account(3, "account1", "gebze", "01.01.2000", null, null);
        Account account2 = new Account(4, "account2", "gebze", "01.01.2000", null, null);
        Account account3 = new Account(5, "account3", "gebze", "01.01.2000", null, null);
        Account account4 = new Account(6, "account4", "gebze", "01.01.2000", null, null);
        Account account5 = new Account(7, "account5", "gebze", "01.01.2000", null, null);
        Account account6 = new Account(8, "account6", "gebze", "01.01.2000", null, null);
        Account account7 = new Account(9, "account7", "gebze", "01.01.2000", null, null);
        Account account8 = new Account(10, "account8", "gebze", "01.01.2000", null, null);
        Account account9 = new Account(11, "account9", "gebze", "01.01.2000", null, null);
        Account account10 = new Account(12, "account10", "gebze", "01.01.2000", null, null);


        // account 1 login
        account1.LogIn();

        // follow others
        account1.follow(account2);
        account1.follow(account3);
        account1.follow(account4);
        account1.follow(account5);
        account1.follow(account6);
        account1.follow(account7);
        account1.follow(account8);
        account1.follow(account9);
        account1.follow(account10);


        // block 
        account1.blockAccount(account10);
        account1.blockAccount(account4);

        // account1 posts a new posts.
        Post p1 = new Post(0, account1, null, null, "First post of account1");
        account1.addPost(p1);

        // account1 logs out.
        account1.logOut();

        // account2 logins.
        account2.LogIn();

        // account2 follows account1
        account2.follow(account1);

        // account2 posts a new post
        Post p2 = new Post(1, account2, null, null, "First post of account2");
        account2.addPost(p2);

        System.out.println("\n\n\naccount2 is viewing profile of account1\n");
        account2.viewProfile(account1);

        System.out.println("\n\n\naccount2 is viewing posts of account1\n");
        account2.viewPost(account1);

        System.out.println("\n\n\naccount2 is viewing posts' interactions of account1\n");
        account2.viewPostInteractions(account1);

        // Like first post of account1
        Like l1 = new Like(0, account2, p1);
        p1.addLike(l1);

        // account2 adds a comment to account1's first post.
        Comment c1 = new Comment(0, account2, p1, "first comment from account2");
        p1.addComment(c1);

        System.out.println("\n\n\naccount2 is viewing posts' interactions of account1\n");
        account2.viewPostInteractions(account1);

        // Unlike p1
        p1.unlike(account2);
        // Uncomment p1 
        p1.uncomment(c1);

        System.out.println("\n\n\naccount2 is viewing posts' interactions of account1 after unliking and uncommenting\n");
        account2.viewPostInteractions(account1);

        System.out.println("\n\n\naccount2 is looking his activity history\n");
        account2.showActionHistory();

        // account2 unfollows account1
        account2.unfollow(account1);

        System.out.println("\n\n\naccount2 is viewing his profile\n");
        account2.viewProfile(account2);

        account2.logOut();



        account10.LogIn();
        System.out.println("\n\n\naccount10 is blocked by account1 but he is trying to send  a message to account1\n");
        Message m1 = new Message(0, account10, account1, "Hello");
        account10.addOutbox(m1);
        account1.addMessageToInbox(m1);
        account10.logOut();



        account1.LogIn();

        // account1 unblocks the account account10
        account1.unblockAccount(account10);

        // account10 logins and sends a message to account1
        account1.logOut();
        account10.LogIn();
        System.out.println("\n\n\naccount10 is unblocked by account1. He is trying to send  a message to account1 again.\n");
        //Message m1 = new Message(0, account10, account1, "Hello");
        account10.addOutbox(m1);
        account1.addMessageToInbox(m1);

        account10.logOut();

        account1.LogIn();
        System.out.println("\n\n\naccount1 is checking inbox\n");
        account1.checkInbox();

        System.out.println("\n\n\naccount1 is viewing inbox\n");
        account1.viewInbox();
        account1.logOut();

    }
}
