package com.codeclan.example.PirateService.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "raids")
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "location")
    private String location;
    @Column(name = "loot")
    private int loot;


    @JsonIgnoreProperties("raid")
    @ManyToMany
    @JoinTable(name="pirate_raids", joinColumns = {@JoinColumn (name="raid_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name ="pirate_id", nullable = false, updatable = false)})
    private List<Pirate> pirates;

    public Raid(String location, int loot){
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<Pirate>();
    }

    public Raid(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void addPirate(Pirate pirate){
        pirates.add(pirate);
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }
}
