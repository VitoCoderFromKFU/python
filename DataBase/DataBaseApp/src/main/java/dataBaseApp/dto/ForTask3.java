package dataBaseApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ForTask3 {
    private Long idStorage;
    private Long idProduct;
    private String unit;
    private Integer countInStorage;
    private LocalDate dateLastOperation;
}
