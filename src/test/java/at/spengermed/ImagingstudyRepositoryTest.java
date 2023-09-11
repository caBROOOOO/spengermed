package at.spengermed;

import at.spengermed.models.*;
import at.spengermed.repositories.ImagingstudyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ImagingstudyRepositoryTest {

    @Autowired
    private ImagingstudyRepository imagingstudyRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOneImagingstudy() {
        Imagingstudy is = returnOneImagingstudy();
        Imagingstudy savedIS = imagingstudyRepository.save(is);
        Imagingstudy loadedIS = imagingstudyRepository.findById(savedIS.getId()).get();
        assertNotNull(loadedIS);


        assertEquals(is.getIdentifier(), loadedIS.getIdentifier());
        assertEquals(is.getSeries(), loadedIS.getSeries());

        assertTrue(is.getStarted() == loadedIS.getStarted());
        assertTrue(is.getSubject() == loadedIS.getSubject());
        assertTrue(is.getNumberOfSeries() == loadedIS.getNumberOfSeries());
        assertTrue(is.getDescription() == loadedIS.getDescription());


    }

    @Test
    @Transactional
    public void testDeleteOneImagingstudy(){
        Imagingstudy is = returnOneImagingstudy();
        Imagingstudy savedIS = imagingstudyRepository.save(is);
        imagingstudyRepository.deleteById(savedIS.getId());
        assertFalse(imagingstudyRepository.findById(savedIS.getId()).isPresent());

    }

    @Test
    @Transactional
    public void testUpdateOneImagingstudy(){
        Imagingstudy savedIS = imagingstudyRepository.save(new Imagingstudy());
        Imagingstudy is = returnOneImagingstudy();
        is.setId(savedIS.getId());
        imagingstudyRepository.save(is);
        Imagingstudy updatedIS = imagingstudyRepository.findById(savedIS.getId()).get();


        assertNotNull(updatedIS.getIdentifier());
        assertNotNull(updatedIS.getSeries());
        assertEquals(is.getStatus(),updatedIS.getStatus());
        assertEquals(is.getSubject(), updatedIS.getSubject());
        assertEquals(is.getNumberOfSeries(), updatedIS.getNumberOfSeries());
        assertEquals(is.getDescription(), updatedIS.getDescription());


    }

    public static Imagingstudy returnOneImagingstudy() {

        Period period = new Period(LocalDateTime.of(2000, 01, 01, 1, 1),
                LocalDateTime.of(2001, 01, 01, 1, 1));

        List<Coding> svnrcodings = new ArrayList<>();
        svnrcodings.add(new Coding("System", "0.1.1", "Code", "<div>...<div>",false));


        CodeableConcept ccType = CodeableConcept.builder()
                .coding(svnrcodings)
                .text("<div></div>")
                .build();// new CodeableConcept(codings, "Text");

        List<Identifier> identifiers = new ArrayList<>();
        identifiers.add(
                Identifier.builder()
                        .code(Identifier.UseCode.temp)
                        .period(period)
                        .system("System")
                        .type(ccType)
                        .value("value")
                        .build());


        List<Coding> coding = new ArrayList<>();
        coding.add(
                Coding.builder()
                        .system("System")
                        .version("0-0.01")
                        .code("123456")
                        .display("divdiv")
                        .userSelected(false)
                        .build());

        List<Series> series = new ArrayList<>();
        series.add(
                Series.builder()
                        .uid("uid")
                        .number(1245678)
                        //.modality(coding)
                        .build());


        return Imagingstudy.builder()
                .identifier(identifiers)
                .status(Imagingstudy.StatusCode.registered)
                //.started()
                .numberOfSeries(1234)
                .description("Andjela")
                .series(series)
                .build();
    }
}