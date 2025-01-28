package application.havenskin.service;

import application.havenskin.BusinessObject.Models.Brands;

import application.havenskin.DTORequest.BrandDTO;
import application.havenskin.mapper.Mapper;
import application.havenskin.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandsRepository brandsRepository;
    @Autowired
    private Mapper mapper;
    public List<Brands> getAllBrands(){
        return brandsRepository.findAll();
    }

    public Brands getBrandById(String id){
        Brands brand = brandsRepository.findById(id).get();
        return brand;
    }
    public Brands createBrand(BrandDTO brands){
        Brands x = mapper.toBrands(brands);
        return brandsRepository.save(x);
    }
//    public Brands updateBrand(String id,Brands brand) {
//        //  Brands brands = brandsRepository.findById(id).get();
//        //    Brands x = mapper.toBrands(brand);
//        if (!brandsRepository.existsById(id)) {
//            throw new RuntimeException("Brand not found");
//        }
//        return brandsRepository.save(brand);
//    }
    public Brands updateBrand(String id, BrandDTO brandDTO){
        Brands brand = brandsRepository.findById(id).orElseThrow(()-> new RuntimeException("Brand not found"));

        mapper.updateBrands(brand, brandDTO);

        return brandsRepository.save(brand);
    }
//        Brands x = brandsRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
//        Brands a = mapper.toBrands(brand);
//        a.setBrandId(x.getBrandId());
//        return brandsRepository.save(a);
    public void deleteBrand(String id){
//        Brands brand = brandsRepository.findById(id).get();
        if(!brandsRepository.existsById(id)){
            throw new RuntimeException("Brand not found");
        }
        brandsRepository.deleteById(id);
    }

    public void deleteAllBrands(){
        brandsRepository.deleteAll();
    }
    public String getBrandsByName(String name){
        if(brandsRepository.findBybrandName(name) == null){
            throw new RuntimeException("Brand not found");
        }
        return brandsRepository.findBybrandName(name).getBrandId();
    }

    public List<Brands> addBrands(List<Brands> x){
        return brandsRepository.saveAll(x);
    }

}
