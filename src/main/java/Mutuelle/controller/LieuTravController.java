package Mutuelle.controller;

import Mutuelle.model.LieuTrav;
import Mutuelle.model.Poll;
import Mutuelle.payload.*;
import Mutuelle.repository.LieuTravRepository;
import Mutuelle.security.CurrentUser;
import Mutuelle.security.UserPrincipal;
import Mutuelle.service.LieuTravService;
import org.hibernate.ObjectNotFoundException;
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
@RequestMapping("/api/worklocations")
public class LieuTravController {


    @Autowired
    private LieuTravRepository lieuTravRepository;

    @Autowired
    private LieuTravService lieuTravService;

    @GetMapping("/{Id}")
    public LieuTravResponse getLieuTravById(
            @PathVariable(value = "Id") Integer Id) {
        return lieuTravService.getById(Id);
    }

    @GetMapping("")
    public List<LieuTravResponse> getLieuTravs() {
        List<LieuTravResponse> lieux = lieuTravService.getAll();
        return lieux;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createLieuTrav(@Valid @RequestBody LieuTravRequest lieuTravRequest) {
        LieuTravResponse lieuTrav = lieuTravService.addLieuTrav(lieuTravRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{lieutravId}")
                .buildAndExpand(lieuTrav.getCodeLieu()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Lieu de travail Created Successfully"));
    }

    @PutMapping("/{lieuTravId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateLieuTrav(@Valid @RequestBody LieuTravRequest lieuTravRequest, @PathVariable Integer lieuTravId) {


        Optional<LieuTrav> monLieu = lieuTravRepository.findById(lieuTravId);
        if (!monLieu.isPresent()) return ResponseEntity.badRequest()
                .body(new ApiResponse(false, "Code lieu n'est pas trouvé"));
        LieuTrav lieu = new LieuTrav(lieuTravRequest);
        if (lieuTravId != lieuTravRequest.getCodeLieu()) {
            lieuTravRepository.deleteById(lieuTravId);
            lieuTravRepository.save(lieu);

        } else lieuTravRepository.save(lieu);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{lieuId}")
                .buildAndExpand(lieu.getCode_li()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Lieu updated Successfully"));
    }
    @RequestMapping(value = "/delete/{Id}",method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> DeleteLieuTrav(@PathVariable Integer Id) {

        Optional<LieuTrav> monLieu = lieuTravRepository.findById(Id);
        if (!monLieu.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, "Code lieu n'est pas trouvé"));
        }
        System.out.println(monLieu);
        LieuTrav lieu=monLieu.get();
        lieuTravRepository.delete(lieu);

        return ResponseEntity.ok(
                new ApiResponse(true, "Lieu deleted Successfully"));
    }




}
