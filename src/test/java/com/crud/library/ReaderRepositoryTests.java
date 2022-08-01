package com.crud.library;

import com.crud.library.domains.Reader;
import com.crud.library.repositories.ReaderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KodillaLibraryApplication.class)
public class ReaderRepositoryTests {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    void saveReaderTest() {
        //Given
        Reader reader = new Reader();
        reader.setName("Pawel");
        reader.setSurname("Kowalski");
        reader.setBirth(LocalDate.of(1993, 4, 12));

        //When
        readerRepository.save(reader);

        //Then
        Assertions.assertNotEquals(reader.getReaderId(), null);

        //CleanUp
        readerRepository.deleteById(reader.getReaderId());
    }

    @Test
    void deleteReaderTest() {
        //Given
        Reader reader = new Reader();
        reader.setName("Pawel");
        reader.setSurname("Kowalski");
        reader.setBirth(LocalDate.of(1993, 4, 12));

        readerRepository.save(reader);

        //When
        readerRepository.delete(reader);

        //Then
        Assertions.assertEquals(Optional.empty(), readerRepository.findById(reader.getReaderId()));
    }
}
