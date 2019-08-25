package com.david.gymmembership.gym_membership;

import com.david.gymmembership.gym_membership.Model.MultiClubMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMultiClubMember {

    private MultiClubMember multiClubMember;

    @Before
    public void before() {multiClubMember = new MultiClubMember("Multi", 0002, "Joe Rogan", 1200.00, 150);}

    @Test
    public void getMemberType() {
        assertEquals("Multi", multiClubMember.getMemberType());
    }

    @Test
    public void getMemberID() {
        assertEquals(0002, multiClubMember.getMemberID());
    }

    @Test
    public void getMemberName() {
        assertEquals("Joe Rogan", multiClubMember.getName());
    }

    @Test
    public void getFees() {
        assertEquals(1200.00, multiClubMember.getFees(), 0);
    }

    @Test
    public void getMembershipPoints() {
        assertEquals(150, multiClubMember.getMembershipPoints());
    }
}
