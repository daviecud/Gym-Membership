package com.david.gymmembership.gym_membership.Interface;

public interface Calculator <T extends Number> {

    double calculateFees(T clubID);

}
