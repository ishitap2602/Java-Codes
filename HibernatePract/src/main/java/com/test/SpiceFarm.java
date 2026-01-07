
package com.test;
import jakarta.persistence.*;

@Entity
@Table(name = "spice_farms")
public class SpiceFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String farmName;

    private String region;
    private String certification;


    public SpiceFarm(String farmName, String region, String certification) {
        this.farmName = farmName;
        this.region = region;
        this.certification = certification;
    }

    public int getId() { 
    	return id; 
    	}
    public String getFarmName() { 
    	return farmName; 
    	}
    public String getRegion() { 
    	return region; 
    	}
    public String getCertification() { 
    	return certification; 
    	}
}
