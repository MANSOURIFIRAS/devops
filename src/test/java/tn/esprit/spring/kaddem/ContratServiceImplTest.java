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


        @Test
    public void testAffectContratToEtudiant() {
        // Mocking data
        Etudiant mockEtudiant = new Etudiant(); 
        Contrat mockContrat = new Contrat(); 
        when(etudiantRepository.findByNomEAndPrenomE(anyString(), anyString())).thenReturn(mockEtudiant);
        when(contratRepository.findByIdContrat(anyInt())).thenReturn(mockContrat);
        when(mockEtudiant.getContrats()).thenReturn(new HashSet<>());

        Contrat affectedContrat = contratService.affectContratToEtudiant(1, "John", "Doe");

        assertEquals(mockContrat, affectedContrat); 
        verify(contratRepository).save(mockContrat);
    }

    @Test
    public void testNbContratsValides() {
        Date startDate = new Date();
        Date endDate = new Date();
        when(contratRepository.getnbContratsValides(startDate, endDate)).thenReturn(5); 

        int validContractsCount = contratService.nbContratsValides(startDate, endDate);

        assertEquals(5, validContractsCount);
    }

    @Test
    public void testRetrieveAndUpdateStatusContrat() {
        Contrat mockContrat = new Contrat(); 
        mockContrat.setDateFinContrat(new Date());
        mockContrat.setArchive(false); 
        List<Contrat> contratList = Collections.singletonList(mockContrat);
        when(contratRepository.findAll()).thenReturn(contratList);

        contratService.retrieveAndUpdateStatusContrat();

        verify(contratRepository).save(Mockito.any(Contrat.class));
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDates() {
        Date startDate = new Date();
        Date endDate = new Date(); 
        Contrat mockContrat = new Contrat(); 
        mockContrat.setSpecialite(Specialite.IA); 
        when(contratRepository.findAll()).thenReturn(Collections.singletonList(mockContrat));

        float chiffreAffaire = contratService.getChiffreAffaireEntreDeuxDates(startDate, endDate);

        float expectedChiffreAffaire = 0;
        assertEquals(expectedChiffreAffaire, chiffreAffaire);
    }

    
}
