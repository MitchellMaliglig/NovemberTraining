
public class Bass {
	private String make;
	private String model;
	private int stringCount;

	public Bass(String make, String model, int stringCount) {
		this.make = make;
		this.model = model;
		this.stringCount = stringCount;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStringCount() {
		return this.stringCount;
	}

	public void setStringCount(int stringCount) {
		this.stringCount = stringCount;
	}

	@Override
	public String toString() {
		return getMake() + " " + getModel() + " " + getStringCount();
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}


		if (!(object instanceof Bass)) {
			return false;
		}

		Bass bass = (Bass) object;

		return this.getMake() == bass.getMake() && 
				this.getModel() == bass.getModel() &&
				this.getStringCount() == bass.getStringCount();
	}
}
