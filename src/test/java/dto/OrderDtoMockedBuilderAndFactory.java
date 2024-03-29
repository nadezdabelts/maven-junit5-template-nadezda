package dto;

import lombok.Builder;
import utils.RandomDataGenerator;

@Builder

public class OrderDtoMockedBuilderAndFactory {
    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    int id;

    public String getStatus() {
        return status;
    }

    public int getCourierId() {
        return courierId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getComment() {
        return comment;
    }

    public int getId() {
        return id;
    }
    // static method to use factory

    public static OrderDtoMockedBuilderAndFactory createRandomOrder(){
        //builder
        return OrderDtoMockedBuilderAndFactory.builder()
                .status("OPEN")
                .courierId(8)
                .customerName(RandomDataGenerator.generateName())
                .customerPhone("123456456")
                .comment("comment")
                .id(1)
                .build();
    }


}
