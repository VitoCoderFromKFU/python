package dataBaseApp.dto;


import jakarta.persistence.Entity;
import lombok.*;

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
    //ForTask1(Long idDocumentOnAdmission,Long idStorage,Long idProduct,)
}
