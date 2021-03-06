package com.example.mac.pollcial;

/**
 * Created by mac on 17/11/16.
 */

public class SinglePoll{
    private String pollTitle; // poll's title
    private String pollDecription; // poll's description
    private String pollChoiceA; // user specified choices, at least 2, at most 4
    private String pollChoiceB;
    private String pollChoiceC;
    private String pollChoiceD;
    private String pollPostTime; // the time user submit the poll
    private String userName; // user name, not user account
    private String userEmail; // user email address
    private boolean anonymous; // if true, do not display userName on screen
    private int numVote; // the number of votes that have been submitted
    private int numVoteA;
    private int numVoteB;
    private int numVoteC;
    private int numVoteD;

    private String uid;


    public SinglePoll() {
        this.pollTitle = null;
        this.pollDecription = null;
        this.pollChoiceA = null;
        this.pollChoiceB = null;
        this.pollChoiceC = null;
        this.pollChoiceD = null;
        this.pollPostTime = null;
        this.userName = null;
        this.userEmail = null;
        this.anonymous = false;
        this.numVote = 0;
        this.numVoteA = 0;
        this.numVoteB = 0;
        this.numVoteC = 0;
        this.numVoteD = 0;
        this.uid = null;
    }

    public SinglePoll(String pollTitle, String pollDecription, String pollChoiceA,
                      String pollChoiceB, String pollChoiceC, String pollChoiceD,
                      String pollPostTime, String uid, String userName, String userEmail,
                      boolean anonymous, int numVote, int numVoteA, int numVoteB,
                      int numVoteC, int numVoteD) {

        this.uid = uid;
        this.pollTitle = pollTitle;
        this.pollDecription = pollDecription;
        this.pollChoiceA = pollChoiceA;
        this.pollChoiceB = pollChoiceB;
        this.pollChoiceC = pollChoiceC;
        this.pollChoiceD = pollChoiceD;
        this.pollPostTime = pollPostTime;
        this.userName = userName;
        this.userEmail = userEmail;
        this.anonymous = anonymous;
        this.numVote = numVote;
        this.numVoteA = numVoteA;
        this.numVoteB = numVoteB;
        this.numVoteC = numVoteC;
        this.numVoteD = numVoteD;
    }

    public int getNumVoteA() { return numVoteA; }

    public int getNumVoteB() { return numVoteB; }

    public int getNumVoteC() { return numVoteC; }

    public int getNumVoteD() { return numVoteD; }

    public String getUid() {return uid;}

    public String getPollTitle() {
        return pollTitle;
    }

    public String getPollDecription() {
        return pollDecription;
    }

    public String getPollChoiceA() {
        return pollChoiceA;
    }

    public String getPollChoiceB() {
        return pollChoiceB;
    }

    public String getPollChoiceC() {
        return pollChoiceC;
    }

    public String getPollChoiceD() {
        return pollChoiceD;
    }

    public String getPollPostTime() {
        return pollPostTime;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getNumVote() {
        return numVote;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setUid(String uid) {this.uid = uid;}

    public void setPollTitle(String pollTitle) {
        this.pollTitle = pollTitle;
    }

    public void setPollDecription(String pollDecription) {
        this.pollDecription = pollDecription;
    }

    public void setPollChoiceA(String pollChoiceA) {
        this.pollChoiceA = pollChoiceA;
    }

    public void setPollChoiceB(String pollChoiceB) {
        this.pollChoiceB = pollChoiceB;
    }

    public void setPollChoiceC(String pollChoiceC) {
        this.pollChoiceC = pollChoiceC;
    }

    public void setPollChoiceD(String pollChoiceD) {
        this.pollChoiceD = pollChoiceD;
    }

    public void setPollPostTime(String pollPostTime) {
        this.pollPostTime = pollPostTime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setNumVote(int numVote) {
        this.numVote = numVote;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
}
