import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShowLogger {

    public void log() {
        log.debug(null);
        log.info(null);
        log.error(null);
    }

    public static void main(String[] args) {
        ShowLogger showLogger = new ShowLogger();
        showLogger.log();

    }
}
