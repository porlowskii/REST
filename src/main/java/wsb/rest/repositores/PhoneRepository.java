package wsb.rest.repositores;

import org.springframework.stereotype.Repository;
import wsb.rest.exceptions.ResourceNotFoundException;
import wsb.rest.models.Phone;
import wsb.rest.models.PhoneDto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class PhoneRepository {

    static Long currentId = 5L;

    private final List<Phone> phones = new LinkedList<>(Arrays.asList(
            new Phone(1L, "Iphone", "X", 2015),
            new Phone(2L, "Samsung", "S19", 2017),
            new Phone(3L, "Xiaomi", "China1000", 2023),
            new Phone(4L, "LG", "Cookies", 2002)
    ));


    public List<Phone> getAll () {return phones;}

    public Optional<Phone> get(Long id) {
        return phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst();
    }

    public Phone create(PhoneDto phoneDto) {
        Phone newPhone = new Phone(currentId++, phoneDto);
        phones.add(newPhone);
        return newPhone;
    }

    public Phone update (Phone phone, PhoneDto phoneDto) {
        phone.setProducer(phoneDto.getProducer());
        phone.setModel(phoneDto.getModel());
        phone.setYear(phoneDto.getYear());
        return phone;
    }

    public void delete (Phone phone) {phones.remove(phone);}
}
