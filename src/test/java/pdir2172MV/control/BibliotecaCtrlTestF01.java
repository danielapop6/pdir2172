package pdir2172MV.control;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pdir2172MV.model.Carte;
import pdir2172MV.repository.repoInterfaces.CartiRepoInterface;
import pdir2172MV.repository.repoMock.CartiRepoMock;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaCtrlTestF01 {

    BibliotecaCtrl bibliotecaCtrl;


    @Before
    public void setUp() throws Exception {
        CartiRepoInterface cr = new CartiRepoMock();
        bibliotecaCtrl = new BibliotecaCtrl(cr);
    }

    @Test

    public void testAdd_TitleAndYearOk() {
        List<String> referenti = new ArrayList<>();
        referenti.add("George Calinescu");
        List<String> cuvinteCheie = new ArrayList<>();
        referenti.add("otilia");
        referenti.add("enigma");
        Carte carte = new Carte("Enigma Otiliei", referenti, "1987", cuvinteCheie);

        try {
            bibliotecaCtrl.adaugaCarte(carte);
            Assert.assertNotEquals(0, bibliotecaCtrl.getCarti().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd_TitleLengthNotOk() {
        List<String> referenti = new ArrayList<>();
        referenti.add("George Malinescu");
        List<String> cuvinteCheie = new ArrayList<>();
        referenti.add("otilia");
        referenti.add("enigma");
        Carte carte = new Carte("", referenti, "1987", cuvinteCheie);

        try {
            bibliotecaCtrl.adaugaCarte(carte);
        } catch (Exception e) {
            Assert.assertEquals("Titlu invalid!", e.getMessage());
        }
    }


    @Test
    public void testAdd_TitleNotOk() {
        List<String> referenti = new ArrayList<>();
        referenti.add("George Falinescu");
        List<String> cuvinteCheie = new ArrayList<>();
        referenti.add("otilia");
        Carte carte = new Carte("7584372544", referenti, "1987", cuvinteCheie);

        try {
            bibliotecaCtrl.adaugaCarte(carte);
        } catch (Exception e) {
            Assert.assertEquals("Titlu invalid!", e.getMessage());
        }
    }

    @Test
    public void testAdd_YearLengthNotOk() {
        List<String> referenti = new ArrayList<>();
        referenti.add("George Falinescu");
        List<String> cuvinteCheie = new ArrayList<>();
        referenti.add("otilia");
        Carte carte = new Carte("Enigma Otiliei", referenti, "", cuvinteCheie);

        try {
            bibliotecaCtrl.adaugaCarte(carte);
        } catch (Exception e) {
            Assert.assertEquals("An aparitie invalid!", e.getMessage());
        }
    }
    @Test
    public void testAdd_YearNotOk() {
        List<String> referenti = new ArrayList<>();
        referenti.add("George Kalinescu");
        List<String> cuvinteCheie = new ArrayList<>();
        referenti.add("otilia");
        Carte carte = new Carte("Enigma Otiliei", referenti, "degt23", cuvinteCheie);

        try {
            bibliotecaCtrl.adaugaCarte(carte);
        } catch (Exception e) {
            Assert.assertEquals("An aparitie invalid!", e.getMessage());
        }
    }
}