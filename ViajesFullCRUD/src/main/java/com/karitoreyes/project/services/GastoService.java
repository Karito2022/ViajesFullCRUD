package com.karitoreyes.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karitoreyes.project.models.Gasto;
import com.karitoreyes.project.repositories.GastoRepository;

@Service
public class GastoService {
	private final GastoRepository gastoRepository;
    
    public GastoService(GastoRepository gastoRepository){
        this.gastoRepository = gastoRepository;
    }
    
    public List<Gasto> allGastos(){
    	return gastoRepository.findAll();
    }
    
    public Gasto createGasto(Gasto gasto) {
        return gastoRepository.save(gasto);
    }
    
    public Gasto findGasto(Long id) {
        Optional<Gasto> optionalGasto = gastoRepository.findById(id);
        if(optionalGasto.isPresent()) {
            return optionalGasto.get();
        } else {
            return null;
        }
    }
    
    public Gasto updateGasto(Long id, String name, String vendor, Double amountCast, String description) {
     Gasto gastoToUpdate = this.findGasto(id);
     gastoToUpdate.setExpenseName(name);
     gastoToUpdate.setDescription(description);
     gastoToUpdate.setAmount(amountCast);
     gastoToUpdate.setVendor(vendor);
   	 return gastoRepository.save(gastoToUpdate);
    }
    
    public void deleteGasto(Long id) {
    	gastoRepository.deleteById(id);
    } 
 
}