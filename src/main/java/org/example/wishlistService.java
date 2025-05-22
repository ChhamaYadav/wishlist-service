package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class wishlistService {

    @Autowired
    private final wishlistRepository wishlistRepository;


    public wishlistService(org.example.wishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist addToWishlist(Long userId, WishlistItems items) {
        Wishlist wishlist = wishlistRepository.findById(userId).orElse(new Wishlist());
        wishlist.setUserId(userId);

        // Ensure item list is initialized
        if (wishlist.getItem() == null) {
            wishlist.setItem(new ArrayList<>());
        }

        boolean alreadyExists = wishlist.getItem().stream()
                .anyMatch(i -> i.getProductId().equals(items.getProductId()));

        if (!alreadyExists) {
            wishlist.getItem().add(items);
        }

        return wishlistRepository.save(wishlist);
    }


    public List<WishlistItems> getWishlist(Long userId) {
        return wishlistRepository.findById(userId)
                .map(Wishlist::getItem)
                .orElse(Collections.emptyList());
    }

    public void removeFromWishList(Long userId,Long productId){
        wishlistRepository.findById(userId).ifPresent(wishlist -> {
            wishlist.getItem().removeIf(item->item.getProductId().equals(productId));
            wishlistRepository.save(wishlist);
        });
    }

    public int getWishlistCount(Long userId){
        return wishlistRepository.findById(userId)
                .map(wishlist -> wishlist.getItem().size())
                .orElse(0);
    }
}
