package ex05;
import ex04.Command;

/** ????????????
 * ?????? ??? ?????????
 * ? ?????????? ?????
 * ???????????? ??????;
 * ?????? Worker Thread
 * @author Vitaliy
 * @version 1.0
 * @see Command
 */
@SuppressWarnings("SpellCheckingInspection")
public interface Queue {
    /** ????????? ????? ?????? ? ???????;
     * ?????? Worker Thread
     * @param cmd ??????
     */
    void put(Command cmd);
    /** ??????? ?????? ?? ???????;
     * ?????? Worker Thread
     * @return ????????? ??????
     */
    Command take();
}
