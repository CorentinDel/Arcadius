package com.cd.Arcadius.UserCard;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, UserCardKey> {
    List<UserCard> findByUserId(Long userId);

    Optional<UserCard> findById(UserCardKey id);
}
