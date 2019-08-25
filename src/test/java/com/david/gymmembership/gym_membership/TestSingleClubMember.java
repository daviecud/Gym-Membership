package com.david.gymmembership.gym_membership;

import com.david.gymmembership.gym_membership.Model.SingleClubMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSingleClubMember {

    private SingleClubMember singleClubMember;

    @Before
    public void before() {
        singleClubMember = new SingleClubMember("Single", 003, "Jack Jones", 220.00, 1);
    }

    @Test
    public void getMemberType() {
        assertEquals("Single", singleClubMember.getMemberType());
    }

    @Test
    public void getMemberID() {
        assertEquals(003, singleClubMember.getMemberID());
    }

    @Test
    public void getMemberName() {
        assertEquals("Jack Jones", singleClubMember.getName());
    }

    @Test
    public void getFees() {
        assertEquals(220.00, singleClubMember.getFees(), 0);
    }

    @Test
    public void getClub() {
        assertEquals(1, singleClubMember.getClub());
    }

}
