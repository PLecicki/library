```diff
@@ English version below @@
```
# Back-end aplikacji "Biblioteka książek"
Java, Hibernate, REST API, Spring Boot, JUnit, Lombok
Autor - Piotr Łęcicki
## O aplikacji
&nbsp;&nbsp;&nbsp;&nbsp;Aplikacja służy do obsługi biblioteki z książkami zapewniając połączenie z bazą danych zawierającą informacje o książkach i ich egzemplarzach,
czytelnikach oraz wypożyczeniach. Każda tabela w bazie danych zawiera encję w kodzie, na podstawie której została ta tabela stworzona i jest uzupełniana.
## Encje
Baza danych zawiera cztery tabele o polach:
- BOOKS - przechowuje informacje odnośnie książek dostępnych w bibliotece
  - book_id - identyfikator książki
  - title - tytuł książki
  - author - autor książki
  - year - rok publikacji książki
- COPIES - zawiera informacje dotyczące konkretnych egzemplarzy danych książek
  - book_copy_id - identyfikator egzemplarza
  - book_id (klucz obcy) - identyfikator książki z tabeli BOOKS
  - status - stan egzemplarza zawierający jeden z czterech możliwych stanów (ENUM: dostępny, wypożyczony, zniszczony, zgubiony)
- READERS - przechowuje informacje dotyczące czytelników
  - reader_id - numer identyfikacyjny czytelnika
  - name - imię czytelnika
  - surname - nazwisko czytelnika
  - date_of_birth - data urodzenia czytelnika
- BORROWED_BOOKS - zawiera dane porządkujące wypożyczenia książek
  - borrow_id - identyfikator wypożyczenia
  - book_copy_id (klucz obcy) - identyfikator wypożyczonego egzemplarza
  - reader_id (klucz obcy) - identyfikator czytelnika który wypożyczył
  - date_of_borrowing - data wypożyczenia
  - date_of_returning - data planowanego zwrotu książki
## Repozytoria
&nbsp;&nbsp;&nbsp;&nbsp;Interfejsy będące repozytoriami dziedziczą CrudRepository<T, ID>, które przyjmuje klasę reprezentującą encję oraz typ pola zawierającego
numer ID. Repozytoria udostępniają metody służące między innymi do zapisu informacji w bazie danych, usuwania ich lub modyfikacji. <br>
&nbsp;&nbsp;&nbsp;&nbsp;Repozytoria można dostosowywać do własnych potrzeb dopisując lub nadpisując metody trzymając się odpowiednich reguł.<br>
&nbsp;&nbsp;&nbsp;&nbsp;Każda encja zawiera oddzielne repozytorium pozwalające na wykonywanie operacji z udziałem bazy danych<br><br>
![image](https://user-images.githubusercontent.com/84147482/184505183-263339af-8561-435a-b1aa-685e03b6434b.png)
![image](https://user-images.githubusercontent.com/84147482/184505188-584da9b1-cf3c-4706-8d0c-bef32e6f4459.png) <br>
## Serwis bazy danych
&nbsp;&nbsp;&nbsp;&nbsp;Klasa reprezentująca serwis bazy danych zawiera zbiór metod służących do obsługi bazy danych za pośrednictwem repozytoriów. Serwis obsługuje wszystkie repozytoria zawarte w projekcie oraz umożliwia operacje takie jak np. pobranie listy z obiektami, pobranie jednego obiektu za pomocą numeru ID, zapis obiektu lub usunięcie wiersza z tabeli bazy danych.<br><br>
![image](https://user-images.githubusercontent.com/84147482/184506188-4ee184bf-2ccf-4d56-a393-992b6eeb3b14.png) <br>
## Mappery
&nbsp;&nbsp;&nbsp;&nbsp;Są to klasy transformujące podane jako argument dane na obiekt innego typu, który może zostać użyty do innych celów takich jak
np. zamieszczenie jego pól w bazie danych.<br><br>
![image](https://user-images.githubusercontent.com/84147482/184506402-f6973159-1187-4219-adfb-ea8c3e519132.png) <br>
## Kontrolery
&nbsp;&nbsp;&nbsp;&nbsp;Kontrolery obsługują żądania HTTP takie jak np. GET, POST, PUT, DELETE, gdzie niektóre z metod przyjmują jako argument zawarty w adresie URL numer ID danego wiersza w tabeli w bazie danych.<br><br>
![image](https://user-images.githubusercontent.com/84147482/184506439-74811f42-51ee-420a-a822-810fffd9360c.png) <br>
## Obsługa błędów
&nbsp;&nbsp;&nbsp;&nbsp;Projekt zawiera klasę, której metody zawierają obsługę wyjątków możliwych do wystąpienia w programie takich jak np. nieistniejący zapis
w tabeli o podanym Id. <br><br>
![image](https://user-images.githubusercontent.com/84147482/184506533-28633b4b-8330-4f0c-bd11-2fdab06aa91d.png) <br>
## Zobrazowanie obsługi żądań wysłanych za pomocą oprogramowania "Postman"
### Dodanie książki
![image](https://user-images.githubusercontent.com/84147482/184506764-09cb222d-166b-44e0-8e38-1be713fa6606.png)
![image](https://user-images.githubusercontent.com/84147482/184506797-ceed5a64-144e-4638-826c-b35bd615e773.png)
### Dodanie egzemplarza
![image](https://user-images.githubusercontent.com/84147482/184506829-38613d23-6c0b-4271-ae3a-7121aaafb6c5.png)
![image](https://user-images.githubusercontent.com/84147482/184506843-5fc57d5c-14d3-4522-9c29-3547c75d7d53.png)
### Edycja statusu egzemplarza
#### Przed:
![image](https://user-images.githubusercontent.com/84147482/184506843-5fc57d5c-14d3-4522-9c29-3547c75d7d53.png)
![image](https://user-images.githubusercontent.com/84147482/184506896-2ba208f2-305d-43a5-bd76-a131e6482d03.png)
#### Po:
![image](https://user-images.githubusercontent.com/84147482/184506914-9626ce13-60db-4e7b-8c71-b2dfc24aa681.png)
### Dodanie nowego czytelnika
![image](https://user-images.githubusercontent.com/84147482/184506960-5f64c4e4-342d-42c8-89aa-5cce833044fc.png)
![image](https://user-images.githubusercontent.com/84147482/184506968-a51c81ee-abf1-4578-8d71-43dbd1818aa0.png)
### Sprawdzenie liczby dostępnych egzemplarzy książki o podanym numerze ID
![image](https://user-images.githubusercontent.com/84147482/184507051-b4a49d73-d7d1-433c-bbc5-9fd03f3515c0.png)
![image](https://user-images.githubusercontent.com/84147482/184507070-a7ff56ad-e145-4c2c-b4b2-54dc966756f8.png)
### Dodanie wypożyczenia książki
![image](https://user-images.githubusercontent.com/84147482/184507115-f7dfe607-a73a-4b3a-8d9a-09a7209f45b7.png)
![image](https://user-images.githubusercontent.com/84147482/184507133-b6767c73-1ead-4db5-a009-4b6285e607d0.png)
### Usunięcie pozycji z listy wypożyczonych egzemplarzy po numerze ID wypożyczenia
![image](https://user-images.githubusercontent.com/84147482/184507160-8a0d3b52-7469-40c4-8151-6dd9d815df76.png)
![image](https://user-images.githubusercontent.com/84147482/184507166-e5b14611-8e5b-4d6f-9dba-e11daae97447.png)
## Testy jednostkowe
![image](https://user-images.githubusercontent.com/84147482/184507294-b14bcdcd-7a94-49e1-a229-006501604f97.png) <br>
&nbsp;&nbsp;&nbsp;&nbsp;Sprawdzają poprawność działania niektórych operacji na danych udostępnianych przez repozytoria.
### Przykładowy test jednostkowy sprawdzający poprawność wykonywania operacji dodawania wypożyczenia do tabeli
```java
@Test
    void saveBorrowTest() {
        //Given
        Reader reader = new Reader();
        reader.setName("Pawel");
        reader.setSurname("Kowalski");
        reader.setBirth(LocalDate.of(1993, 4, 12));

        Book book = new Book();
        book.setTitle("AAAAAA");
        book.setAuthor("BBBBBB");
        book.setYear((short)1999);

        BookCopies bookCopy = new BookCopies();
        bookCopy.setBook(book);
        bookCopy.setStatus(CopyStatus.BORROWED);

        Borrows borrows = new Borrows();
        borrows.setBookCopies(bookCopy);
        borrows.setReader(reader);
        borrows.setBorrowing(LocalDate.of(2022, 6, 12));
        borrows.setBorrowing(LocalDate.of(2023, 1, 23));

        //When
        bookRepository.save(book);
        bookCopiesRepository.save(bookCopy);
        readerRepository.save(reader);
        borrowsRepository.save(borrows);

        //Then
        Assertions.assertNotEquals(borrows.getBorrowId(), null);

        //CleanUp
        borrowsRepository.delete(borrows);
        readerRepository.delete(reader);
        bookCopiesRepository.delete(bookCopy);
        bookRepository.delete(book);
    }
```
<br><br>
# Back-end "Library" application
Java, Hibernate, REST API, Spring Boot, JUnit, Lombok
Author - Piotr Łęcicki
## About application
&nbsp;&nbsp;&nbsp;&nbsp;The application is used to operate the library with books ensuring connection with the database containing information about books, their copies, readers and borrows. Each table in the database contains the code entity from which the table was created and is completed.
## Entities
The database contains four tables with the fields:
- BOOKS - stores informations about books available in the library
  - book_id - book identifier
  - title - title of the book
  - author - author of the book
  - year - the year of book publication
- COPIES - contains information on specific copies of the given books
  - book_copy_id - book copy identifier
  - book_id (foreign key) - book identifier from the BOOKS table
  - status - the condition of the item containing one of the four possible states (ENUM: available, borrowed, broken, lost)
- READERS - stores information about readers
  - reader_id - reader identification number
  - name - the name of the reader
  - surname - reader surname
  - date_of_birth - reader's date of birth
- BORROWED_BOOKS - contains data about book borrowings
  - borrow_id - borrowing identifier
  - book_copy_id (foreign key) - identifier of the borrowed item
  - reader_id (foreign key) - ID of the reader who borrowed
  - date_of_borrowing - borrowing date
  - date_of_returning - date of the planned return of the book
## Repositories
&nbsp;&nbsp;&nbsp;&nbsp;Repository interfaces extends from CrudRepository <T, ID>, which takes the class representing the entity and the type of the field containing
ID number. Repositories provide methods for, among other things, saving, deleting or modifying information in a database. <br>
&nbsp;&nbsp;&nbsp;&nbsp;The repositories can be adapted to your needs by adding or overwriting methods, keeping to the appropriate rules.<br>
&nbsp;&nbsp;&nbsp;&nbsp;Each entity contains a separate repository for performing database operations<br><br>
![image](https://user-images.githubusercontent.com/84147482/184505183-263339af-8561-435a-b1aa-685e03b6434b.png)
![image](https://user-images.githubusercontent.com/84147482/184505188-584da9b1-cf3c-4706-8d0c-bef32e6f4459.png) <br>
## Database service
&nbsp;&nbsp;&nbsp;&nbsp;The class representing the database service contains a set of methods for setting the database through repositories. The website supports all repositories included in the project and enables operations such as e.g. retrieving a list with objects, retrieving one object using an ID number, saving an object or deleting a row from a database table.<br><br>
![image](https://user-images.githubusercontent.com/84147482/184506188-4ee184bf-2ccf-4d56-a393-992b6eeb3b14.png) <br>
## Mappers
&nbsp;&nbsp;&nbsp;&nbsp;These are transforming classes given as an argument to an object of a different type that can be used for other purposes such as
eg adding its fields in the database.<br><br>
![image](https://user-images.githubusercontent.com/84147482/184506402-f6973159-1187-4219-adfb-ea8c3e519132.png) <br>
## Controllers
&nbsp;&nbsp;&nbsp;&nbsp;Controllers handle HTTP requests such as GET, POST, PUT, DELETE, where some of the methods take as an argument contained in the URL the ID number of a given row in a table in the database.<br><br>
![image](https://user-images.githubusercontent.com/84147482/184506439-74811f42-51ee-420a-a822-810fffd9360c.png) <br>
## Error handling
&nbsp;&nbsp;&nbsp;&nbsp;The project contains a class whose methods contain the handling of exceptions that can occur in the program, such as a non-existent record
in the table with given Id. <br><br>
![image](https://user-images.githubusercontent.com/84147482/184506533-28633b4b-8330-4f0c-bd11-2fdab06aa91d.png) <br>
## Display of handling requests sent with the "Postman" application
### Adding book
![image](https://user-images.githubusercontent.com/84147482/184506764-09cb222d-166b-44e0-8e38-1be713fa6606.png)
![image](https://user-images.githubusercontent.com/84147482/184506797-ceed5a64-144e-4638-826c-b35bd615e773.png)
### Adding book copy
![image](https://user-images.githubusercontent.com/84147482/184506829-38613d23-6c0b-4271-ae3a-7121aaafb6c5.png)
![image](https://user-images.githubusercontent.com/84147482/184506843-5fc57d5c-14d3-4522-9c29-3547c75d7d53.png)
### Editing status of copy
#### Before:
![image](https://user-images.githubusercontent.com/84147482/184506843-5fc57d5c-14d3-4522-9c29-3547c75d7d53.png)
![image](https://user-images.githubusercontent.com/84147482/184506896-2ba208f2-305d-43a5-bd76-a131e6482d03.png)
#### After:
![image](https://user-images.githubusercontent.com/84147482/184506914-9626ce13-60db-4e7b-8c71-b2dfc24aa681.png)
### Adding new reader
![image](https://user-images.githubusercontent.com/84147482/184506960-5f64c4e4-342d-42c8-89aa-5cce833044fc.png)
![image](https://user-images.githubusercontent.com/84147482/184506968-a51c81ee-abf1-4578-8d71-43dbd1818aa0.png)
### Checking the number of available copies of the book with given ID number
![image](https://user-images.githubusercontent.com/84147482/184507051-b4a49d73-d7d1-433c-bbc5-9fd03f3515c0.png)
![image](https://user-images.githubusercontent.com/84147482/184507070-a7ff56ad-e145-4c2c-b4b2-54dc966756f8.png)
### Adding borrow of book
![image](https://user-images.githubusercontent.com/84147482/184507115-f7dfe607-a73a-4b3a-8d9a-09a7209f45b7.png)
![image](https://user-images.githubusercontent.com/84147482/184507133-b6767c73-1ead-4db5-a009-4b6285e607d0.png)
### Deletion of an item from the list of borrowed copies by borrow ID number
![image](https://user-images.githubusercontent.com/84147482/184507160-8a0d3b52-7469-40c4-8151-6dd9d815df76.png)
![image](https://user-images.githubusercontent.com/84147482/184507166-e5b14611-8e5b-4d6f-9dba-e11daae97447.png)
## Unit tests
![image](https://user-images.githubusercontent.com/84147482/184507294-b14bcdcd-7a94-49e1-a229-006501604f97.png) <br>
&nbsp;&nbsp;&nbsp;&nbsp;They check the correctness of operation of some operations on the data provided by the repositories.
### Sample unit test to validate the operation of adding a borrow to the table
```java
@Test
    void saveBorrowTest() {
        //Given
        Reader reader = new Reader();
        reader.setName("Pawel");
        reader.setSurname("Kowalski");
        reader.setBirth(LocalDate.of(1993, 4, 12));

        Book book = new Book();
        book.setTitle("AAAAAA");
        book.setAuthor("BBBBBB");
        book.setYear((short)1999);

        BookCopies bookCopy = new BookCopies();
        bookCopy.setBook(book);
        bookCopy.setStatus(CopyStatus.BORROWED);

        Borrows borrows = new Borrows();
        borrows.setBookCopies(bookCopy);
        borrows.setReader(reader);
        borrows.setBorrowing(LocalDate.of(2022, 6, 12));
        borrows.setBorrowing(LocalDate.of(2023, 1, 23));

        //When
        bookRepository.save(book);
        bookCopiesRepository.save(bookCopy);
        readerRepository.save(reader);
        borrowsRepository.save(borrows);

        //Then
        Assertions.assertNotEquals(borrows.getBorrowId(), null);

        //CleanUp
        borrowsRepository.delete(borrows);
        readerRepository.delete(reader);
        bookCopiesRepository.delete(bookCopy);
        bookRepository.delete(book);
    }
```

