package com.david.gymmembership.gym_membership.Model;

//create subclass of parent class Member
public class SingleClubMember extends Member { //SingleClubMember uses Inheritance to inherit the methods/fields of parent class Member (depending on access modifiers in Member class)

    //Create Fields
    private int club;

    //Create Constructor
    public SingleClubMember(String pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberID, pName, pFees);
        club = pClub;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + club;
    }
}
