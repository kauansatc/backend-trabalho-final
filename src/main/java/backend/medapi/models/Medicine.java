package backend.medapi.models;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    private String name;
    private boolean needsPrescription;
    private ArrayList<String> treatsFor;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNeedsPrescription(boolean needsPrescription) {
        this.needsPrescription = needsPrescription;
    }

    public boolean getNeedsPrescription() {
        return needsPrescription;
    }

    public ArrayList<String> getTreatsFor() {
        return treatsFor;
    }

    public void setTreatsFor(ArrayList<String> treatsFor) {
        this.treatsFor = treatsFor;
    }
}
