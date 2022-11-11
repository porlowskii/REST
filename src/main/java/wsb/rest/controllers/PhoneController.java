package wsb.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wsb.rest.models.Phone;
import wsb.rest.models.PhoneDto;
import wsb.rest.services.PhoneService;

import java.util.List;

@RestController
@RequestMapping("phones")
@AllArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    List<Phone> getAll() {return phoneService.getAll();}

    @GetMapping("{id}")
    ResponseEntity<Phone> get(@PathVariable Long id) {
        return ResponseEntity.ok(phoneService.get(id));
    }

    @PostMapping
    ResponseEntity<Phone> create (@RequestBody PhoneDto phoneDto){
        Phone phone = phoneService.create(phoneDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(phone);
    }

    @PutMapping("{id}")
    ResponseEntity<Phone> update (@PathVariable Long id, @RequestBody PhoneDto phoneDto){
        return ResponseEntity.ok(phoneService.update(id, phoneDto));
    }

    @DeleteMapping ("{id}")
    ResponseEntity<Phone> delete(@PathVariable Long id) {
        phoneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
