package pdir2172MV;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pdir2172MV.control.BibliotecaCtrl;
import pdir2172MV.model.Carte;
import pdir2172MV.repository.repoInterfaces.CartiRepoInterface;
import pdir2172MV.repository.repoMock.CartiRepoMock;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Unit test for simple App.
 */
public class BigBang {

    BibliotecaCtrl bibliotecaCtrl;

    @Before
    public void setUp() {
        CartiRepoInterface cr = new CartiRepoMock();
        bibliotecaCtrl = new BibliotecaCtrl(cr);
    }

    @Test
    public void test1() {
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
    public void test2() {
        List<Carte> cartiCautate;
        try {
            cartiCautate = bibliotecaCtrl.cautaCarte("enigma");
            Assert.assertEquals(1, cartiCautate.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            List<Carte> list = bibliotecaCtrl.getCartiOrdonateDinAnul("1948");
            Assert.assertEquals(3, list.size());
            Assert.assertEquals(list.get(0).getTitlu(), "Dale carnavalului");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bigBangIntegration() {
        boolean part1 = false, part2 = false, part3 = false;
        //Calendar c = Calendar.getInstance();
        int  n = bibliotecaCtrl.getCarti().size();
        try {
            bibliotecaCtrl.adaugaCarte(Carte.getCarteFromString("Confesiuni;Marin Preda;1970;Corint;confesiuni"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (n + 1 == bibliotecaCtrl.getCarti().size())
            part1 = true;

        List<Carte> cartiCautate = null;
        try {
            cartiCautate = bibliotecaCtrl.cautaCarte("confesiuni");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(cartiCautate.size() == 1){
            part2 = true;
        }

        List<Carte> list = null;
        try {
            list = bibliotecaCtrl.getCartiOrdonateDinAnul("1970");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(list.size() == 1){
            part3 = true;
        }

        Assert.assertTrue(part1 && part2 && part3);
    }
}
