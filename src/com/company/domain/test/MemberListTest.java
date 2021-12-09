package com.company.domain.test;

import com.company.domain.Member;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MemberListTest {

double expected = 3800;



ArrayList<Member> members = new ArrayList<>();
    Member member1 = new Member("John","","dfdf","ffffffff",LocalDate.of(2000,12,12), LocalDate.now(),false,"");

    Member member3 = new Member("John","","dfdf","ffffffff",LocalDate.of(2011,12,12), LocalDate.now(),false,"");

    Member member2 = new Member("John","","dfdf","ffffffff",LocalDate.of(1000,12,12), LocalDate.now(),false,"");



    @org.junit.jupiter.api.Test
    public void Income() {
        double income = 0;
        for (Member member : members) {
            income = income + member.getMembershipFee();
        }
        double actual = income;
        assertEquals(expected,actual);
    }
}