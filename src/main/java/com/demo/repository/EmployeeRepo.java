/**
 * 
 */
package com.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

/**
 * @author Mehul
**/

@Repository
public interface EmployeeRepo  extends MongoRepository<Employee, Integer>{
	
}
