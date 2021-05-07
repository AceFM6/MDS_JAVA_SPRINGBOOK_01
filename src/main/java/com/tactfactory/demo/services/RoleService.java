package com.tactfactory.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.demo.entities.Role;
import com.tactfactory.demo.repositories.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;
    
    public List<Role> findAll() {
		return this.repository.findAll();
	}

    public Map<Long, String> getTemplateList(){
        Map<Long, String> result = new HashMap<>();

        for (Role item : this.repository.findAll()) {
            result.put(item.getId(), item.getName());
        }

        return result;
    }
    
    public void generateRoles() {
    	Role seller = new Role();
    	Role customer = new Role();
    	
    	seller.setName("seller");
    	customer.setName("customer");
    	
    	this.repository.save(seller);
    	this.repository.save(customer);
    }

    public Role findRole(final Long roleId) {
        return this.repository.findById(roleId).orElse(null);
    }

	public Role getRandomRole() {
		Role role = new Role();
		if(this.repository.findAll().isEmpty()) {
			role = null;
		} else {
			List<Role> givenList = this.repository.findAll();
			Random rand = new Random();
			role = givenList.get(rand.nextInt(givenList.size()));
		}
		
		return role;
	}

}
