package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class wishlistService {

    @Autowired
    private final wishlistRepository wishlistRepository;


    public wishlistService(org.example.wishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<WishlistItems> getWishlist(Long userId) {
        return (List<WishlistItems>) wishlistRepository.findById(userId).map(Wishlist::getItems).orElse(Collections.emptyList());
    }

    public void addtoWishlist(WishlistItems wishlistItems){
        wishlistRepository.save(wishlistItems);
    }
}
