package com.webPage.am.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column
    private Date date;
    @Column
    private String art;
    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;
}
