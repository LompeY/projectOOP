package ex01;

import java.io.*;

/**
 * ???????? ?????????? ??????? ??? ?????????? ? ??????????? ???????????.
 *
 * @author Vitaliy
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class Calc {
    /**
     * ??? ?????, ???????????? ??? ????????????.
     */
    private static final String FNAME = "Item2d.bin";
    /**
     * ????????? ????????? ??????????. ?????? ?????? {@linkplain Item2d}
     */
    private Item2d result;

    /**
     * ?????????????? {@linkplain Calc#result}
     */
    public Calc() {
        result = new Item2d();
    }

    /**
     * ?????????? ???????? {@linkplain Calc#result}
     *
     * @param result - ????? ???????? ?????? ?? ?????? {@linkplain Item2d}
     */
    public void setResult(Item2d result) {
        this.result = result;
    }

    /**
     * ???????? ???????? {@linkplain Calc#result}
     *
     * @return ??????? ???????? ?????? ?? ?????? {@linkplain Item2d}
     */
    public Item2d getResult() {
        return result;
    }

    /**
     * ????????? ???????? ???????.
     *
     * @param decimalNumber - ???????? ??????????? ???????.
     * @return ????????? ?????????? ???????.
     */
    private DigitsNumberDTO calc(int decimalNumber) {
        return new DigitsNumberDTO(Integer.toOctalString(decimalNumber).length(), Integer.toHexString(decimalNumber).length());
    }

    /**
     * ????????? ???????? ??????? ? ?????????
     * ????????? ? ??????? {@linkplain Calc#result}
     *
     * @param decimalNumber - ???????? ??????????? ???????.
     */
    public DigitsNumberDTO init(int decimalNumber) {
        result.setDecimalNumber(decimalNumber);
        DigitsNumberDTO numbers = calc(decimalNumber);
        result.setDigitsNumberOct(numbers.digitsNumberOct);
        result.setDigitsNumberHex(numbers.digitsNumberHex);

        return numbers;
    }

    /**
     * ??????? ????????? ??????????.
     */
    public void show() {
        System.out.println(result);
    }

    /**
     * ????????? {@linkplain Calc#result} ? ????? {@linkplain Calc#FNAME}
     *
     * @throws IOException Exception
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * ??????????????? {@linkplain Calc#result} ?? ????? {@linkplain Calc#FNAME}
     *
     * @throws Exception Exception
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }
}