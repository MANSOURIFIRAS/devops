package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImplTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Test
    public void testRetrieveAllEtudiants() {
        List<Etudiant> mockEtudiants = new ArrayList<>();
        when(etudiantRepository.findAll()).thenReturn(mockEtudiants);
        List<Etudiant> result = etudiantService.retrieveAllEtudiants();
        assertEquals(mockEtudiants, result);
    }

    @Test
    public void testUpdateEtudiant() {
        Etudiant mockEtudiant = new Etudiant();
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(mockEtudiant);
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(mockEtudiant);
        assertEquals(mockEtudiant, updatedEtudiant);
    }

    @Test
    public void testAddEtudiant() {
        Etudiant mockEtudiant = new Etudiant();
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(mockEtudiant);
        Etudiant addedEtudiant = etudiantService.addEtudiant(mockEtudiant);
        assertEquals(mockEtudiant, addedEtudiant);
    }

    @Test
    public void testRetrieveEtudiant() {
        Etudiant mockEtudiant = new Etudiant();
        when(etudiantRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockEtudiant));
        Etudiant retrievedEtudiant = etudiantService.retrieveEtudiant(1);
        assertEquals(mockEtudiant, retrievedEtudiant);
    }

    @Test
    public void testRemoveEtudiant() {
        Etudiant mockEtudiant = new Etudiant();
        when(etudiantRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockEtudiant));
        etudiantService.removeEtudiant(1);
        verify(etudiantRepository).delete(mockEtudiant);
    }

}
