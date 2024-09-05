package com.example.v0.repositories;

import com.example.v0.models.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemberRepository {
    private Map<Long, Member> memberMap;
    private static long counter;

    public MemberRepository() {
        this.memberMap = new HashMap<>();
    }

    public Member save(Member member){
        if (member.getId() == null){
            member.setId(++counter);
        }
        memberMap.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(long memberId){
        if (memberMap.containsKey(memberId)){
            return Optional.of(memberMap.get(memberId));
        }
        return Optional.empty();
    }
}
