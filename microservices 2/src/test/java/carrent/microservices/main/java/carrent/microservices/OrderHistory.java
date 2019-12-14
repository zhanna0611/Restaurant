package carrent.microservices;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class OrderHistory {
    public OrderHistory() {
    }

    public OrderHistory(String fullname, Date createdAt, String carType) {
        this.fullname = fullname;
        this.createdAt = createdAt;
        this.carType = carType;
    }

    private String fullname;
    private Date createdAt;
    private String carType;

}
