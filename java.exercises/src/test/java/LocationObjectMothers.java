
public class LocationObjectMothers {

	public static LocationObjectMother NewOrleans() {
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}
	
	public static LocationObjectMother Houston() {
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
	
	public static LocationObjectMother LosAngeles() {
		return new LocationBuilder()
				.withState(States.California)
				.withCity(Cities.LosAngeles)
				.build();
	}
}