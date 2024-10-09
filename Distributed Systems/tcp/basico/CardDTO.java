package tcp.basico;

import java.io.Serializable;
import java.util.UUID;

public class CardDTO implements Serializable {
    private static final UUID serialVersionUID = UUID.randomUUID(); // Add a serialVersionUID for version control

    private String transactionId;
    private String cardName;
    private String cardNumber;
    private String expirationDate;
    private Double transactionValue;

    public static UUID getSerialversionuid() {
        return serialVersionUID;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Double getTransactionValue() {
        return transactionValue;
    }
    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }

    

}
