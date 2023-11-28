package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EquipeServiceImplTest {

    @Mock
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Test
    public void testRetrieveAllEquipes() {
        List<Equipe> mockEquipes = new ArrayList<>();
        when(equipeRepository.findAll()).thenReturn(mockEquipes);
        List<Equipe> result = equipeService.retrieveAllEquipes();
        assertEquals(mockEquipes, result);
    }

    @Test
    public void testUpdateEquipe() {
        Equipe mockEquipe = new Equipe();
        when(equipeRepository.save(any(Equipe.class))).thenReturn(mockEquipe);
        Equipe updatedEquipe = equipeService.updateEquipe(mockEquipe);
        assertEquals(mockEquipe, updatedEquipe);
    }

    @Test
    public void testAddEquipe() {
        Equipe mockEquipe = new Equipe();
        when(equipeRepository.save(any(Equipe.class))).thenReturn(mockEquipe);
        Equipe addedEquipe = equipeService.addEquipe(mockEquipe);
        assertEquals(mockEquipe, addedEquipe);
    }

    @Test
    public void testRetrieveEquipe() {
        Equipe mockEquipe = new Equipe();
        when(equipeRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockEquipe));
        Equipe retrievedEquipe = equipeService.retrieveEquipe(1);
        assertEquals(mockEquipe, retrievedEquipe);
    }

    @Test
    public void testDeleteEquipe() {
        Equipe mockEquipe = new Equipe();
        when(equipeRepository.findById(any(Integer.class))).thenReturn(Optional.of(mockEquipe));
        equipeService.deleteEquipe(1);
        verify(equipeRepository).delete(mockEquipe);
    }

}
