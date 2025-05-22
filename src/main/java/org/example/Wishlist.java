package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wishlist {

    @Id
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<WishlistItems> item=new ArrayList<>();

    public static Object getItems(WishlistItems wishlistItems) {
    }
}
