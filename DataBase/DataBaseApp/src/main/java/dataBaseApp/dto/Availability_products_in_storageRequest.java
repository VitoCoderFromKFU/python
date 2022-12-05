package dataBaseApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Availability_products_in_storageRequest {
    private Long idStorage;

    private Long idProduct;

    private String unit;

    private Integer countInStorage;

    private LocalDate dateLastOperation;

}
