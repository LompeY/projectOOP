package ex04;

/**
 * ????????? ???????
 * ??? ??????;
 * ???????: Command,
 * Worker Thread
 *
 * @author Vitaliy
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public interface Command {
    /**
     * ?????????? ???????; ???????: Command, Worker Thread
     */
    public void execute();
}
