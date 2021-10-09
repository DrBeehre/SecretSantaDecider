import java.util.List;

public class LogList {

    private List<Log> logs;

    public LogList(List<Log> logs){
        this.logs = logs;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
