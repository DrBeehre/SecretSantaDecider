import java.util.Date;

public class Log {

    private String Message;
    private Date CreateDt;

    public Log(String Message, Date CreateDt){
        this.Message = Message;
        this.CreateDt = CreateDt;
    }

    public String getMessage() {
        return Message;
    }

    public Date getCreateDt() {
        return CreateDt;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setCreateDt(Date createDt) {
        CreateDt = createDt;
    }
}
