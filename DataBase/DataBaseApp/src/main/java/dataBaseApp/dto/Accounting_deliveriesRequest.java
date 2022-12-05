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
public class Accounting_deliveriesRequest {

    private Long idStorage;
    private Long idContract;
    private Long idProduct;

    private String unit;

    private Integer countProducts;

    private LocalDate dateOfAdmission;


}
