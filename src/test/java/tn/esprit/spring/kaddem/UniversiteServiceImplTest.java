package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UniversiteServiceImplTest {

    @Mock
    private UniversiteRepository universiteRepository;

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Test
    public void testRetrieveAllUniversites() {
        List<Universite> mockUniversites = new ArrayList<>();
        when(universiteRepository.findAll()).thenReturn(mockUniversites);
        List<Universite> result = universiteService.retrieveAllUniversites();
        assertEquals(mockUniversites, result);
    }

    @Test
    public void testUpdateUniversite() {
        Universite mockUniversite = new Universite();
        when(universiteRepository.save(any(Universite.class))).thenReturn(mockUniversite);
        Universite updatedUniversite = universiteService.updateUniversite(mockUniversite);
        assertEquals(mockUniversite, updatedUniversite);
    }

    @Test
    public void testAddUniversite() {
        Universite mockUniversite = new Universite();
        when(universiteRepository.save(any(Universite.class))).thenReturn(mockUniversite);
        Universite addedUniversite = universiteService.addUniversite(mockUniversite);
        assertEquals(mockUniversite, addedUniversite);
    }

    @Test
    public void testRetrieveUniversite() {
        Universite mockUniversite = new Universite();
        when(universiteRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockUniversite));
        Universite retrievedUniversite = universiteService.retrieveUniversite(1);
        assertEquals(mockUniversite, retrievedUniversite);
    }

    @Test
    public void testDeleteUniversite() {
        Universite mockUniversite = new Universite();
        when(universiteRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockUniversite));
        universiteService.deleteUniversite(1);
        verify(universiteRepository).delete(mockUniversite);
    }

}
