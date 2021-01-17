package zoo.api.bo.interest;

import zoo.api.bo.Visible;
import zoo.api.bo.ZooPosition;

public class Interest extends Visible {
    private TypeOfInterest typeOfInterest;

    public Interest() {
    }

    public Interest(String name, TypeOfInterest typeOfInterest) {
        super(name);
        this.typeOfInterest = typeOfInterest;
    }

    public Interest(String name, ZooPosition zooPosition, TypeOfInterest typeOfInterest) {
        super(name, zooPosition);
        this.typeOfInterest = typeOfInterest;
    }

    public TypeOfInterest getTypeOfInterest() {
        return typeOfInterest;
    }

    public void setTypeOfInterest(TypeOfInterest typeOfInterest) {
        this.typeOfInterest = typeOfInterest;
    }
}
