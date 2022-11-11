package wsb.rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private Long id;
    private String producer;
    private String model;
    private Integer year;

    public Phone (Long id, PhoneDto phonedto) {
        this.id= id;
        this.producer = phonedto.getProducer();
        this.model = phonedto.getModel();
        this.year = phonedto.getYear();
    }
}
