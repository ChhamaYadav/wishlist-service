package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface wishlistRepository extends JpaRepository<Wishlist,Long> {
    Optional<Wishlist> findByUserId(Long userId);
}
