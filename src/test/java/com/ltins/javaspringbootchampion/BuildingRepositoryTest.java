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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BuildingRepositoryTest {
    @Autowired
    private BuildingRepository repo;

    @Test
    public void testAddNew(){
            Building building = new Building();
            building.setAddress("Krasivsk 305");
            building.setArea(69);
            building.setRent_date(new Timestamp(1164648983));

            Building savedBuilding = repo.save(building);

            Assertions.assertThat(savedBuilding).isNotNull();
            Assertions.assertThat(savedBuilding.getBuilding_id()).isGreaterThan(0);

    }
}
