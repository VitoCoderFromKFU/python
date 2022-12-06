package dataBaseApp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ForTask1 {
    private Long idDocumentOnAdmission;
    private Long idStorage;
    private Long idProduct;
    private LocalDate dateOfAdmission;
    private Integer countProducts;
    private Long idContract;

    private Integer planDelivery;
    private LocalDate endDate;
}
