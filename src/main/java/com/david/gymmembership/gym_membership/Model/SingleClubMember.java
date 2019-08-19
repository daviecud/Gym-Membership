package com.david.gymmembership.gym_membership.Model;

public class SingleClubMember extends Member {

    //Create Fields
    private int club;

    //Create Constructor
    SingleClubMember(String pMemberType, int pMemberID, String pName, double pFees, int pClub) {
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
