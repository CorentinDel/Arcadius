package com.cd.Arcadius.Pack;

import org.springframework.stereotype.Service;

@Service
public class PackMapper {
    public PackDto toDto(Pack pack) {
        return new PackDto(pack.getId(), pack.getAmount(), pack.getNextAt());
    }
}
