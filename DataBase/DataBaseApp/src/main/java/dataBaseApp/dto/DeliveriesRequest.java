package dataBaseApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveriesRequest {

    private Long idProduct;

    private String unit;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer planDelivery;

    private Double priceUnit;
}
