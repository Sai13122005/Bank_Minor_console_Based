import java.time.*;
public class Transaction
{
    private final String type;
    private final double amount;
    private final java.time.LocalDateTime timestamp;
    
    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        timestamp = LocalDateTime.now();
    }
    public String getTransactionDetails()
    {
        return "Timestamp: "+timestamp+" | Type: "+type+" | Amount:$"+amount;
    }
}