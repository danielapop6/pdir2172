import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pdir2172MV.control.BibliotecaCtrl;
import pdir2172MV.model.Carte;
import pdir2172MV.repository.repoInterfaces.CartiRepoInterface;
import pdir2172MV.repository.repoMock.CartiRepoMock;

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