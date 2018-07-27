import enetities.Author;
import enetities.Book;
import enetities.PublishingHouse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("book_db");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();
        /**
        for(int i=0; i<15;i++){
            People p = new People();
            p.setFirstName("First name"+i);
            p.setLastName("Last name"+i);
            p.setAge(22+i);
            em.persist(p);

        }

        Author liviu = new Author();
        liviu.setName("Liviu Rebreanu");
        liviu.setUniversity("UBB");
        em.persist(liviu);

        Author george = new Author();
        george.setName("George Calinescu");
        george.setUniversity("UBB");
        em.persist(george);

        PublishingHouse p1 = new PublishingHouse();
        p1.setLocation("Cluj");
        p1.setName("adevarul");
        p1.setPhoneNumber(35762537);
        em.persist(p1);

        PublishingHouse p2 = new PublishingHouse();
        p2.setLocation("Oradea");
        p2.setName("rao");
        p2.setPhoneNumber(35762537);
        em.persist(p2);


        Book b = new Book();
        b.setName("ion");
        b.setPublishingHouse(p1);
        b.setYear(1941);
        List<Author> authorList1= new ArrayList<>();
        authorList1.add(george);
        b.setAuthorList(authorList1);
        em.persist(b);


        Book b2 = new Book();
        b2.setName("enigma otiliei");
        b2.setPublishingHouse(p2);
        b.setYear(1956);
        List<Author> authorList2=new ArrayList<>();
        authorList2.add(george);
        b2.setAuthorList(authorList2);
        em.persist(b2);


        Book b3 = new Book();
        b3.setName("munca in echipa");
        b3.setPublishingHouse(p1);
        b3.setYear(2000);
        List<Author> authorList3 = new ArrayList<>();
        authorList3.add(liviu);
        authorList3.add(george);
        b3.setAuthorList(authorList3);
        em.persist(b3);

*/

        Query query =em.createQuery("FROM Book b WHERE b.name=?1");
        query.setParameter(1,"enigma otiliei");
        Book result = (Book) query.getSingleResult();
        System.out.println(result.toString());

        Query namedQuery= em.createNamedQuery("Book.findAllBooks");
        List<Book> books=namedQuery.getResultList();
        for(Book p:books){
            System.out.println(p.toString());
        }

        PublishingHouse pub = new PublishingHouse();
        pub.setLocation("Cluj");
        pub.setName("adevarul");
        pub.setPhoneNumber(35762537);

        Query query2 =em.createQuery("SELECT b FROM Book b WHERE b.publishingHouse=?1 and b.year>=?2");
        query2.setParameter(1,pub);
        query2.setParameter(2,1900);
        List<Book> bookList=namedQuery.getResultList();
        for(Book p:bookList){
            System.out.println(p.toString());
        }


        Query query3 =em.createQuery("FROM Book b WHERE b.year=:first");
        query3.setParameter("first",1941);
        Book result3 = (Book) query.getSingleResult();
        System.out.println(result3.toString());












        transaction.commit();
        factory.close();

    }
}
