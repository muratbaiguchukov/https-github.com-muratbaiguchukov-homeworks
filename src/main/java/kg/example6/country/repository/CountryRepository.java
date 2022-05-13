package kg.example6.country.repository;

import kg.example6.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
    List<Country> findAllByCountryName(String countryName);

    //@Modifying
    //@Query(nativeQuery = true,value = "update countries s set is_active = false where s.id =:id")
    //Country isActive(Long countryId);


}