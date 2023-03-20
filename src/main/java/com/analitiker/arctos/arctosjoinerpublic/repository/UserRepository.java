package com.analitiker.arctos.arctosjoinerpublic.repository;

import com.analitiker.arctos.arctosjoinerpublic.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByEmail(String email);
    @Override
    Optional<UserEntity> findById(UUID uuid);
}
