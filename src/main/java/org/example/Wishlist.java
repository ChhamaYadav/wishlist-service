package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wishlist {

    @Id
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<WishlistItems> item=new ArrayList<>();

}
