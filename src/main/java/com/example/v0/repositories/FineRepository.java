package com.example.v0.repositories;

import com.example.v0.models.Fine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FineRepository {
    private Map<Long, Fine> fineMap;
    private static long counter;

    public FineRepository() {
        this.fineMap = new HashMap<>();
    }

    public Fine save(Fine fine){
        if (fine.getId() == null){
            fine.setId(++counter);
        }
        fineMap.put(fine.getId(), fine);
        return fine;
    }

    public Optional<Fine> findById(long fineId){
        if (fineMap.containsKey(fineId)){
            return Optional.of(fineMap.get(fineId));
        }
        return Optional.empty();
    }
}
