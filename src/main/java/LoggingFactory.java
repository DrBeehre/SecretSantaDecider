import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoggingFactory {

    private List<Log> pastLogs;

    public LoggingFactory(List<Log> pastLogs) {
        this.pastLogs = pastLogs;
    }

    public int appendLog(Log Log){
        pastLogs.add(Log);
        return 1;
    }

    public int appendLogs(List<Log> Logs){
        pastLogs = Stream.concat(pastLogs.stream(), Logs.stream())
                .collect(Collectors.toList());
        return 1;
    }


    public List<Log> getPastLogs() {
        return pastLogs;
    }
}
