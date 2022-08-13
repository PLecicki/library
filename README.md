[comment]: <> (```diff)
[comment]: <> (@@ English version below @@)
[comment]: <> (```)
```diff
@@ Polish version: In progress @@
@@ English version: To do @@
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
  - book_id - identyfikator danego typu książki
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
### Książka
