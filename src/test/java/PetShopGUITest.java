import br.ufpb.dcx.felipe.Animal;
import br.ufpb.dcx.felipe.PetShopGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetShopGUITest {
    private PetShopGUI petShopGUI;

    @BeforeEach
    public void setUp() {
        petShopGUI = new PetShopGUI();
    }

    @Test
    public void testCadastrarAnimal() {
        // Simula a entrada do usuário nos campos de texto
        petShopGUI.nomeField.setText("Rex");
        petShopGUI.especieField.setText("Cachorro");
        petShopGUI.racaField.setText("Labrador");


        // Verifica se o animal foi cadastrado corretamente
        assertEquals(1, petShopGUI.animais.size());
        Animal animalCadastrado = petShopGUI.animais.get(0);
        assertEquals("Rex", animalCadastrado.getNome());
        assertEquals("Cachorro", animalCadastrado.getEspecie());
        assertEquals("Labrador", animalCadastrado.getRaca());
    }
}