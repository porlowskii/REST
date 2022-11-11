package wsb.rest.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.rest.models.Phone;
import wsb.rest.models.PhoneDto;
import wsb.rest.repositores.PhoneRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public List<Phone> getAll() {return phoneRepository.getAll();}

    public Phone get(Long id) {
        return phoneRepository.get(id)
                .orElseThrow();
    }

    public Phone create(PhoneDto phoneDto) {
        return phoneRepository.create(phoneDto);
    }

    public Phone update (Long id, PhoneDto phoneDto) {
        Phone phone = get(id);
        return phoneRepository.update(phone, phoneDto);
    }

    public void delete (Long id) {
        Phone phone = get(id);
        phoneRepository.delete(phone);
    }
}
