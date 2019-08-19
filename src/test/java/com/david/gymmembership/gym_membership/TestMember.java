package com.david.gymmembership.gym_membership;

import com.david.gymmembership.gym_membership.Model.Member;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMember {

    Member member;

    @Before
    public void before() {
        member = new Member("Single", 0001, "Mexican Bob", 149.99);
    }

    @Test
    public void getMemberType() {
        assertEquals("Single", member.getMemberType());
    }

    @Test
    public void getMemberID() {
        assertEquals(0001, member.getMemberID());
    }

    @Test
    public void getMemberName() {
        assertEquals("Mexican Bob", member.getName());
    }

    @Test
    public void getFee() {
        assertEquals(149.99, member.getFees(), 0);
    }
}
