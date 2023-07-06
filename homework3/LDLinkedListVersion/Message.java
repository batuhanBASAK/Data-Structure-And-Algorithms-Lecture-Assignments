/**
 * Message class
 */
public class Message {

    /** Id of message */
    private int messageId;
    /** Id of sender */
    private Account sender;
    /** Id of receiver */
    private Account receiver;
    /** message Content */
    private String content;

    /**
     * Constructor method for Message class
     * @param messageId Id of message
     * @param sender sender accout
     * @param receiver receiver account
     * @param content message Content
     */
    public Message(int messageId, Account sender, Account receiver, String content){
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    /**
     * Getter method for messageId
     * @return message id
     */
    public int getMessageId(){
        return messageId;
    }

    /**
     * Getter method for senderId
     * @return id of sender
     */
    public int getSenderId(){
        return sender.getUserId();
    }

    /**
     * Getter method for receiver id
     * @return receiver id
     */
    public int getReceiverId(){
        return receiver.getUserId();
    }

    /**
     * Getter method for content
     * @return message content
     */
    public String getContent(){
        return content;
    }


    /**
     * Getter method for sender
     * @return sender account
     */
    public Account getSender() {
        return sender;
    }

    /**
     * Getter method for receiver
     * @return receiver account
     */
    public Account getReceiver() {
        return receiver;
    }

    /**
     * Prints Message id, sender account, receiver account, and message 
     * content.
     */
    public void viewMessage() {
        System.out.println("Message ID: " + messageId
            + "\nFrom: " + sender.getFullName()
            + "\nTo: " + receiver.getFullName()
            + "\nMessage: " + content);
    }
}
