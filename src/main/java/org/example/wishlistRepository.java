package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface wishlistRepository extends JpaRepository<Wishlist,Long> {
}
