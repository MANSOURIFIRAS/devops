package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartementServiceImplTest {

    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private DepartementServiceImpl departementService;

    @Test
    public void testRetrieveAllDepartements() {
        List<Departement> mockDepartements = new ArrayList<>();
        Mockito.when(departementRepository.findAll()).thenReturn(mockDepartements);
        List<Departement> result = departementService.retrieveAllDepartements();
        assertEquals(mockDepartements, result);
    }

    @Test
    public void testAddDepartement() {
        Departement mockedDepartement = new Departement();
        Mockito.when(departementRepository.save(Mockito.any(Departement.class))).thenReturn(mockedDepartement);
        Departement result = departementService.addDepartement(mockedDepartement);
        assertEquals(mockedDepartement, result);
    }

    @Test
    public void testUpdateDepartement() {
        Departement mockDepartement = new Departement();
        when(departementRepository.save(any(Departement.class))).thenReturn(mockDepartement);
        Departement updatedDepartement = departementService.updateDepartement(mockDepartement);
        assertEquals(mockDepartement, updatedDepartement);
    }

    @Test
    public void testRetrieveDepartement() {
        Departement mockDepartement = new Departement();
        when(departementRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockDepartement));
        Departement retrievedDepartement = departementService.retrieveDepartement(1);
        assertEquals(mockDepartement, retrievedDepartement);
    }

    @Test
    public void testDeleteDepartement() {
        Departement mockDepartement = new Departement();
        when(departementRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockDepartement));
        departementService.deleteDepartement(1);
        verify(departementRepository).delete(mockDepartement);
    }

}
