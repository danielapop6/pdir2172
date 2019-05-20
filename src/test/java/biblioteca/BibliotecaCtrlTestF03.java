package biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.repository.repoMock.CartiRepoMock;

import java.util.List;

public class BibliotecaCtrlTestF03 {
    BibliotecaCtrl bibliotecaCtrl;


    @Before
    public void setUp() throws Exception {
        CartiRepoInterface cr = new CartiRepoMock();
        bibliotecaCtrl = new BibliotecaCtrl(cr);
    }

    @Test
    public void getCartiOrdonateDinAnValid() {
        try {
            List<Carte> list = bibliotecaCtrl.getCartiOrdonateDinAnul("1948");
            Assert.assertEquals(3, list.size());
            Assert.assertEquals(list.get(0).getTitlu(),"Dale carnavalului");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getCartiOrdonateDinAnInvalid() {
        try {
            List<Carte> list = bibliotecaCtrl.getCartiOrdonateDinAnul("lalala");
        } catch (Exception e) {
            Assert.assertEquals("Nu e numar!", e.getMessage());
        }
    }
}