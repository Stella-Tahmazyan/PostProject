package com.webPage.am.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "auther")
public class Auther {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private  String name;
    @Column
    private String surname;
    @ManyToMany
    @JoinTable(name = "auther_book",
        joinColumns = @JoinColumn(name = "auther_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    List<Book> books;

}
