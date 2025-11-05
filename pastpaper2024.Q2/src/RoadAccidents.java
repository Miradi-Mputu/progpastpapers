public abstract class RoadAccidents implements IRoadAccidents  {
public String VehicleType;
public String City;
public int AccidentTotal;

public RoadAccidents(String VehicleType, String City,int AccidentTotal){
    this.VehicleType=VehicleType;
this.City=City;
this.AccidentTotal=AccidentTotal;
}

    public String getVehicleType() {
        return VehicleType;
    }

    public String getCity() {
        return City;
    }

    @Override
    public int getAccidentTotal() {
        return AccidentTotal;
    }
}
