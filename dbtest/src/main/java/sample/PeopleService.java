package sample;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.PeopleRepository;
import sample.People;

@Service
public class PeopleService {
	@Autowired
	private PeopleRepository peopleRepository;
	
	public List<People> findAll() {
		return peopleRepository.findAll();
	}
	
	public People findOne(Integer id) {
		return peopleRepository.findById(id).orElse(null);
	}
	
	public People save(People name) {
		return peopleRepository.save(name);
	}
	
	public void delete(Integer id) {
		peopleRepository.deleteById(id);
	}
}
