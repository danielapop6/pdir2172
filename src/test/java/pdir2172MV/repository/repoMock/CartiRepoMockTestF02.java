package pdir2172MV.repository.repoMock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pdir2172MV.model.Carte;
import pdir2172MV.repository.repoInterfaces.CartiRepoInterface;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartiRepoMockTestF02 {
    CartiRepoMock cartiRepoMock;


    @Before
    public void setUp() throws Exception {


    }
    @Test
    public void cautaCarteInListaGoala() {
        List<Carte> carti = new ArrayList<>();
        cartiRepoMock = new CartiRepoMock(carti); // lista goala

            List<Carte> cartiCautate = cartiRepoMock.cautaCarte("Enigma");
            Assert.assertEquals(0,cartiCautate.size());
    }

    @Test
    public void cautaCarteListaCuUnSingurElement() {
        List<Carte> carti = new ArrayList<>();
        carti.add(Carte.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
        cartiRepoMock = new CartiRepoMock(carti);

            List<Carte> cartiCautate = cartiRepoMock.cautaCarte("P");
            Assert.assertEquals(1,cartiCautate.size());
    }

    @Test
    public void cautaCarteListaCuMaiMulteElemente() {
        cartiRepoMock = new CartiRepoMock();

        List<Carte> cartiCautate = cartiRepoMock.cautaCarte("enigma");
        Assert.assertEquals(1,cartiCautate.size());
    }
}