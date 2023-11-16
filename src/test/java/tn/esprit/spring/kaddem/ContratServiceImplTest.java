package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ContratServiceImplTest {

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private ContratServiceImpl contratService;

    @Test
    public void testRetrieveAllContrats() {
        List<Contrat> mockContrats = new ArrayList<>(); 
        when(contratRepository.findAll()).thenReturn(mockContrats);
        List<Contrat> result = contratService.retrieveAllContrats();
        assertEquals(mockContrats, result);
    }

    @Test
    public void testUpdateContrat() {
        Contrat mockContrat = new Contrat(); 
        when(contratRepository.save(any(Contrat.class))).thenReturn(mockContrat);

        Contrat updatedContrat = contratService.updateContrat(mockContrat);

        assertEquals(mockContrat, updatedContrat); 
    }

    @Test
    public void testAddContrat() {
        Contrat mockContrat = new Contrat(); 
        when(contratRepository.save(any(Contrat.class))).thenReturn(mockContrat);

        Contrat addedContrat = contratService.addContrat(mockContrat);

        assertEquals(mockContrat, addedContrat); 
    }

    @Test
    public void testRetrieveContrat() {
        Contrat mockContrat = new Contrat(); 
        when(contratRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockContrat));

        Contrat retrievedContrat = contratService.retrieveContrat(1);

        assertEquals(mockContrat, retrievedContrat); 
    }

    @Test
    public void testRemoveContrat() {
        Contrat mockContrat = new Contrat(); 
        when(contratRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockContrat));

        contratService.removeContrat(1);

        verify(contratRepository).delete(mockContrat); 
    }

    
}
