package Mutuelle.controller;


import Mutuelle.model.Plafond;
import Mutuelle.payload.ApiResponse;
import Mutuelle.payload.PlafondRequest;
import Mutuelle.payload.PlafondResponse;
import Mutuelle.repository.PlafondRepository;
import Mutuelle.service.PlafondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plafonds")
public class PlafondController {

    @Autowired
    private PlafondRepository plafondRepository;

    @Autowired
    private PlafondService plafondService;

    @GetMapping("/{Id}")
    public PlafondResponse getPlafondById(
            @PathVariable(value = "Id") Integer Id) {
        return plafondService.getById(Id);
    }

    @GetMapping("")
    public List<PlafondResponse> getPlafonds() {
        List<PlafondResponse> plafondx = plafondService.getAll();
        return plafondx;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createPlafond(@Valid @RequestBody PlafondRequest plafondRequest) {
        PlafondResponse plafond = plafondService.addPlafond(plafondRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{plafondId}")
                .buildAndExpand(plafond.getCodePlafond()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Plafond Created Successfully"));
    }

    @PutMapping("/{plafondId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updatePlafond(@Valid @RequestBody PlafondRequest plafondRequest, @PathVariable Integer plafondId) {


        Optional<Plafond> monPlafond = plafondRepository.findById(plafondId);
        if (!monPlafond.isPresent()) return ResponseEntity.badRequest()
                .body(new ApiResponse(false, "Code plafond n'est pas trouvé"));
        Plafond plafond = new Plafond(plafondRequest);
        if (plafondId != plafondRequest.getCodePlafond()) {
            plafondRepository.deleteById(plafondId);
            plafondRepository.save(plafond);

        } else plafondRepository.save(plafond);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{plafondId}")
                .buildAndExpand(plafond.getCode_pl()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Plafond updated Successfully"));
    }
    @RequestMapping(value = "/delete/{Id}",method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> DeletePlafond(@PathVariable Integer Id) {

        Optional<Plafond> monPlafond = plafondRepository.findById(Id);
        if (!monPlafond.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, "Code plafond n'est pas trouvé"));
        }
        System.out.println(monPlafond);
        Plafond plafond=monPlafond.get();
        plafondRepository.delete(plafond);

        return ResponseEntity.ok(
                new ApiResponse(true, "Plafond deleted Successfully"));
    }
}
