package enetities;

import javax.persistence.*;
import java.util.List;
@Entity
@NamedQuery(name="Book.findAllBooks",query = "SELECT b FROM Book b")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

  @ManyToMany(mappedBy = "bookList")
    private List<Author> authorList;

  @ManyToOne(cascade = CascadeType.PERSIST)
    private PublishingHouse publishingHouse;
    private int year;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorList=" + authorList +
                ", publishingHouse=" + publishingHouse +
                ", year=" + year +
                '}';
    }
}
