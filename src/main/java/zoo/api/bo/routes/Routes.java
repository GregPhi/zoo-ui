package zoo.api.bo.routes;

import zoo.api.bo.Visible;

import java.util.ArrayList;
import java.util.List;
public class Routes {
    private int id;
    private String name;
    private float distance;
    private List<Visible> visibles;
    private boolean make;

    public Routes() {
        this.visibles = new ArrayList<>();
        this.make = false;
    }

    public Routes(String name) {
        this.name = name;
        this.visibles = new ArrayList<>();
        this.make = false;
    }

    public Routes(String name, float distance, List<Visible> visibles, boolean make) {
        this.name = name;
        this.distance = distance;
        this.visibles = visibles;
        this.make = make;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public List<Visible> getVisibles() {
        return visibles;
    }

    public void setVisibles(List<Visible> visibles) {
        this.visibles = visibles;
    }

    public boolean isMake() {
        return make;
    }

    public void setMake(boolean make) {
        this.make = make;
    }

    public void addVisible(Visible visible){
        this.visibles.add(visible);
    }

    public void removeVisible(Visible visible){
        this.visibles.remove(visible);
    }
}
