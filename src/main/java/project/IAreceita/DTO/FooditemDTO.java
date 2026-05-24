package project.IAreceita.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FooditemDTO {
    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private LocalDateTime validade;
}
