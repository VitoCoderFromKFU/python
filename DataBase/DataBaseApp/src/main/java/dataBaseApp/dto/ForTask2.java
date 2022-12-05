package dataBaseApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class ForTask2 {
    private Long idContract;
    private Long idProduct;
    private Integer planDelivery;
    private LocalDate endDate;
    private Long sum;

}
