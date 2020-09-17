package sample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

}

