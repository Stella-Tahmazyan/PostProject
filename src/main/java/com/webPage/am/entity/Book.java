package com.webPage.am.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private int page;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column
    private Date date;
    @ManyToMany
     @JoinTable(name = "book")
    List<Auther> authers;
}
