package com.ltins.javaspringbootchampion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.ltins.javaspringbootchampion.repository.*;
import com.ltins.javaspringbootchampion.entity.*;
import java.sql.Timestamp;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class BuildingRepositoryTest {

    private BuildingRepository repo;

    @Autowired
    BuildingRepositoryTest(BuildingRepository repo){
        this.repo = repo;
    }

    @Test
    void testAddNew(){
            Building building = new Building();
            building.setAddress("Krasivsk 305");
            building.setArea(69);
            building.setRentDate(new Timestamp(1164648983));

            Building savedBuilding = repo.save(building);

            Assertions.assertThat(savedBuilding).isNotNull();
            Assertions.assertThat(savedBuilding.getId()).isPositive();

    }
    @Test
    void testListAll(){
      Iterable<Building> buildings = repo.findAll();
      Assertions.assertThat(buildings).hasSizeGreaterThan(0);

      for (Building building : buildings){
          System.out.println(building);
         }
     }
    @Test
    void testUpdate(){
        Integer buildingId = 6;
        Optional<Building> optionalBuilding = repo.findById(buildingId);
        Building building = optionalBuilding.get();
        building.setAddress("Changed");
        repo.save(building);

        Building updatedBuilding = repo.findById(buildingId).get();
        Assertions.assertThat(updatedBuilding.getAddress()).isEqualTo("Changed");
     }
    @Test
    void deleteByID(){
        Integer buildingId = 4;
        repo.deleteById(buildingId);

        Optional<Building> optionalBuilding = repo.findById(buildingId);
        Assertions.assertThat(optionalBuilding).isNotPresent();
    }

}
