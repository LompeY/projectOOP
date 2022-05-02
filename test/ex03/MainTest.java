package ex03;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;

/** ????????? ????????????
 * ????????????? ???????.
 * @author Vitaliy
 * @version 3.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class MainTest {
    /** ???????? ???????? ???????????????? ?????? {@linkplain ViewTable} */
    @Test
    public void testCalc() {
        ViewTable tbl = new ViewTable(10, 5);
        assertEquals(10, tbl.getWidth());
        assertEquals(5, tbl.getItems().size());
        tbl.init(100);
        Item2d item = new Item2d();
        int ctr = 0;
        item.setAll(0, 1, 1);
        assertEquals("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">", tbl.getItems().get(ctr), item);
        ctr++;
        item.setAll(100, 3, 2);
        assertEquals("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">", tbl.getItems().get(ctr), item);
        ctr++;
        item.setAll(200, 3, 2);
        assertEquals("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">", tbl.getItems().get(ctr), item);
        ctr++;
        item.setAll(300, 3, 3);
        assertEquals("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">", tbl.getItems().get(ctr), item);
        ctr++;
        item.setAll(400, 3, 3);
        assertEquals("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">", tbl.getItems().get(ctr), item);
    }
    /** ???????? ????????????. ???????????? ?????????????? ??????. */
    @Test
    public void testRestore() {
        ViewTable tbl1 = new ViewTable(10, 1000);
        ViewTable tbl2 = new ViewTable();

        tbl1.init(30, (int)(Math.random() * 1000));

        try {
            tbl1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
        assertTrue("containsAll()", tbl1.getItems().containsAll(tbl2.getItems()));
    }
}
