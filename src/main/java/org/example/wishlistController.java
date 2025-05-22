package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class wishlistController {

    @Autowired
    private final wishlistService wishlistService;

    public wishlistController(org.example.wishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/add")
    public ResponseEntity<Wishlist> addToWishlist(@RequestBody WishlistItems wishlistItems,@RequestParam Long userId){
        System.out.println("Adding the wishlist product to the db");
            return ResponseEntity.ok(wishlistService.addToWishlist(userId,wishlistItems));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getWishListCount(@RequestParam Long userId){
        System.out.println("Getting count of the items");
        return ResponseEntity.ok(wishlistService.getWishlistCount(userId));
    }


}
