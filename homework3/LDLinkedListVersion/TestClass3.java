/** Test program for third scenario */
public class TestClass3 {
    public static void main(String[] args) {
        // Step 1: Create 3 accounts with usernames “gizemsungu”, “sibelgulmez”, and “gokhankaya”.
        Account gizemsungu = new Account(0, "gizemsungu", "Gebze", "01 01 2023", null, null);
        Account sibelgulmez = new Account(1, "sibelgulmez", "Gebze", "01 01 2023", null, null);
        Account gokhankaya = new Account(2, "gokhankaya", "Gebze", "01 01 2023", null, null);

        // Step 2: Login to the account with username “sibelgulmez”.
        sibelgulmez.LogIn();

        // Step 3: Share two posts.
        Post p1 = new Post(0, sibelgulmez, null, null, "First post");
        Post p2 = new Post(1, sibelgulmez, null, null, "Second post");
        sibelgulmez.addPost(p1);
        sibelgulmez.addPost(p2);

        // Step 4: Follow “gizemsungu” and “gokhankaya”.
        sibelgulmez.follow(gizemsungu);
        sibelgulmez.follow(gokhankaya);

        // Step 5:Log out from the account.
        sibelgulmez.logOut();

        // Step 6: Login to the account with username “gokhankaya”.
        gokhankaya.LogIn();

        // Step 7: View “sibelgulmez”s profile.
        gokhankaya.viewProfile(sibelgulmez);

        // Step 8: View “sibelgulmez”s posts.
        gokhankaya.viewPost(sibelgulmez);

        // Step 9: Like a post of “sibelgulmez”.
        Like like1 = new Like(0, gokhankaya, p2);
        p2.addLike(like1);

        // Step 10: Comment on a post of “sibelgulmez”.
        Comment c1 = new Comment(0, gokhankaya, p2, "First comment to second post of sibelgulmez");
        p2.addComment(c1);

        // Step 11: Follow “sibelgulmez” and “gizemsungu”.
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);

        // Step 12: Send a message to “gizemsungu”.
        Message m1 = new Message(0, gokhankaya, gizemsungu, "First message from gokhankaya to gizemsungu");
        gokhankaya.addOutbox(m1);
        gizemsungu.addMessageToInbox(m1);

        // Step 13: Log out from the account.
        gokhankaya.logOut();

        // Step 14: Login to the account with username “gizemsungu”.
        gizemsungu.LogIn();

        // Step 15: Check the number of messages in the outbox.
        gizemsungu.checkOutbox();

        // Step 16: Check the number of messages in the inbox.
        gizemsungu.checkInbox();

        // Step 17: View the messages in the inbox.
        gizemsungu.viewInbox();

        // Step 18: View “sibelgulmez”s profile.
        gizemsungu.viewProfile(sibelgulmez);

        // Step 19: View “sibelgulmez”s posts.
        gizemsungu.viewPost(sibelgulmez);

        // Step 20: View “sibelgulmez”s posts’ interactions.
        gizemsungu.viewPostInteractions(sibelgulmez);

        // Step 21: Like “sibelgulmez”s posts.
        Like like2 = new Like(1, gizemsungu, p2);
        p2.addLike(like2);

        // Step 22: View “sibelgulmez”s posts’ interactions.
        gizemsungu.viewPostInteractions(sibelgulmez);


        gizemsungu.logOut();


        // -------------------------------------------------
        // Scenario 2 steps


        // “gizemsungu” logs in.
        gizemsungu.LogIn();

        // shares a post (let’s call it Post1).
        Post post1 = new Post(3, gizemsungu, null, null, "gizemsungu first post");
        gizemsungu.addPost(post1);

        // shares another post (let’s call it Post2).
        Post post2 = new Post(4, gizemsungu, null, null, "gizemsungu second post");
        gizemsungu.addPost(post2);

        // logs out.
        gizemsungu.logOut();

        // “sibelgulmez” logs in.
        sibelgulmez.LogIn();

        // views the profile of “gizemsungu”.
        sibelgulmez.viewProfile(gizemsungu);

        // likes Post1.
        Like like3 = new Like(3, sibelgulmez, post1);
        post1.addLike(like3);

        // logs out.
        sibelgulmez.logOut();

        // “gokhankaya” logs in.
        gokhankaya.LogIn();

        // views the profile of “gizemsungu”.
        gokhankaya.viewProfile(gizemsungu);

        // comments on Post2 (ex: Nice!”).
        Comment comment1 = new Comment(1, gokhankaya, post2, "Nice!");
        post2.addComment(comment1);

        // sends a message to “gizemsungu” (ex: “Hello!”)
        Message message2 = new Message(1, gokhankaya, gizemsungu, "Hello");
        gizemsungu.addMessageToInbox(message2);
        gokhankaya.addOutbox(message2);

        // logs out.
        gokhankaya.logOut();

        // “gizemsungu” logs in.
        gizemsungu.LogIn();
        
        // views her own profile.
        gizemsungu.viewProfile(gizemsungu);

        // reads the message from “gokhankaya”.
        gizemsungu.viewInbox();

        gizemsungu.logOut();


        // -------------------------------------------------
        // Scenario 3 steps


        // “gizemsungu” logs in.
        gizemsungu.LogIn();

        // blocks “sibelgulmez”.
        gizemsungu.blockAccount(sibelgulmez);

        // logs out.
        gizemsungu.logOut();

        // “sibelgulmez” logs in.
        sibelgulmez.LogIn();

        // tries to view the profile of “gizemsungu”.
        sibelgulmez.viewProfile(gizemsungu);

        // tries to send a message to “gizemsungu”.
        Message message3 = new Message(2, sibelgulmez, gizemsungu, "a message from sibelgulmez to gizemsungu");
        sibelgulmez.addOutbox(message3);
        gizemsungu.addMessageToInbox(message3);


        sibelgulmez.logOut();
    }
}
