package sample.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.People;
import sample.Repository.PeopleRepository;

@Service
public class PeopleService {
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Transactional(readOnly=false)
	public List<People> findAll() {
		return peopleRepository.findAll();
	}
	
	@Transactional(readOnly=false)
	public List<People> findOne(Integer id) {
		return peopleRepository.findAll();
	}
	
	@Transactional(readOnly=false)
	public People save(People people) {
		return peopleRepository.saveAndFlush(people);
	}
	
	@Transactional(readOnly=false)
	public void delete(People people) {
		peopleRepository.delete(people);
	}
}
