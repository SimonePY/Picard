package link.locutus.discord.apiv1.enums.city.building.imp;

import link.locutus.discord.apiv1.enums.MilitaryUnit;
import link.locutus.discord.apiv1.enums.ResourceType;
import link.locutus.discord.apiv1.enums.city.building.CommerceBuilding;
import link.locutus.discord.apiv1.enums.city.building.MilitaryBuilding;
import link.locutus.discord.apiv1.enums.city.building.PowerBuilding;
import link.locutus.discord.apiv1.enums.city.building.ResourceBuilding;

public class BuildingBuilder {
    private final String name;
    private final double[] cost = ResourceType.getBuffer();
    private final double[] upkeep = ResourceType.getBuffer();
    private int cap = Integer.MAX_VALUE;
    private int pollution;

    public BuildingBuilder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCap() {
        return cap;
    }

    public int getPollution() {
        return pollution;
    }

    public double[] getCost() {
        return cost;
    }

    public double[] getUpkeep() {
        return upkeep;
    }

    public BuildingBuilder cap(int cap) {
        this.cap = cap;
        return this;
    }

    public BuildingBuilder pollution(int pollution) {
        this.pollution = pollution;
        return this;
    }

    public BuildingBuilder cost(ResourceType resource, double amount) {
        this.cost[resource.ordinal()] += amount;
        return this;
    }

    public BuildingBuilder upkeep(ResourceType resource, double amount) {
        this.upkeep[resource.ordinal()] += amount;
        return this;
    }

    public MilitaryBuilding unit(MilitaryUnit unit, int max, int perDay, double requiredCitizens) {
        return new AMilitaryBuilding(this, unit, max, perDay, requiredCitizens);
    }

    public PowerBuilding power(ResourceType input, double inputAmt, int infraBase, int infraMax) {
        return new APowerBuilding(this, input, inputAmt, infraBase, infraMax);
    }

    public ResourceBuilding resource(ResourceType output) {
        return resource(output.getBaseInput(), output.getBoostFactor(), output, output.getInputs());
    }

    public ResourceBuilding resource(int baseInput, double boostFactor, ResourceType output, ResourceType... inputs) {
        return new AResourceBuilding(this, baseInput, boostFactor, output, inputs);
    }

    public CommerceBuilding commerce(int commerce) {
        return new ACommerceBuilding(this, commerce);
    }

    public AServiceBuilding buildService() {
        return new AServiceBuilding(this);
    }
}
