public class EstateAgent implements IEstateAgent {

    public String location;
    public String name;
    public double propertyPrice;
    public double commissionPercent;

    public EstateAgent(String location, String name, String propertyPrice, String commissionPercent) {
        this.location = location;
        this.name = name;
        this.propertyPrice = Double.parseDouble(propertyPrice);
        this.commissionPercent = Double.parseDouble(commissionPercent);


    }

    @Override
    public double CalculateCommission() {
        return propertyPrice * (commissionPercent / 100);
    }

    @Override
    public boolean ValidateData() {
        return !location.equals("") && !name.equals("") && propertyPrice > 0 && commissionPercent > 0;
    }
}
