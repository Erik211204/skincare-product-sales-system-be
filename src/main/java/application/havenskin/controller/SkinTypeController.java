package application.havenskin.controller;

import application.havenskin.BusinessObject.Models.SkinTypes;
import application.havenskin.DTORequest.SkinTypeDTO;
import application.havenskin.service.SkinTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/haven-skin/skin-types")
public class SkinTypeController {
    @Autowired
    private SkinTypeService skinTypeService;
    @GetMapping
    public List<SkinTypes> getAllSkinTypes() {
        return skinTypeService.getAllSkinTypes();
    }
    @PostMapping
    public SkinTypes addSkinType(@RequestBody SkinTypes skinTypes) {
        return skinTypeService.createSkinType(skinTypes);
    }
    @GetMapping("/{id}")
    public SkinTypes getSkinTypeById(@PathVariable String id) {
       return skinTypeService.getSkinTypeById(id);
    }
    @PutMapping("/{id}")
    public SkinTypes updateSkinType(@PathVariable String id, @RequestBody SkinTypeDTO skinTypes) {
        return skinTypeService.updateSkinType(id, skinTypes);
    }
    @DeleteMapping("/{id}")
    public void deleteSkinType(@PathVariable String id) {
        skinTypeService.deleteSkinType(id);
    }
    @DeleteMapping
    public void deleteAllSkinTypes() {
        skinTypeService.deleteAllSkinTypes();
    }

    @PostMapping("/add-list-skin-types")
    public List<SkinTypes> addSkinTypeList(@RequestBody List<SkinTypes> skinTypes) {
        return skinTypeService.addListOfSkinTypes(skinTypes);
    }
}
