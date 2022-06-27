package pl.coderslab;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book"),
            inverseJoinColumns = @JoinColumn(name = "author"))
    private List<Author> author = new ArrayList<>();
}