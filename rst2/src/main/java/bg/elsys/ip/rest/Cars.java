package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Cars {

	@ApiModelProperty(required = true)
	String make;
	String model;
	String engine_cap;
	String hp;
	String transmission;

	
	public Cars(String make, String model, String engine_cap, String hp, String transmission) {
		super();
		this.make = make;
		this.model = model;
		this.engine_cap = engine_cap;
		this.hp = hp;
		this.transmission = transmission;
	}

	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getEngine_cap() {
		return engine_cap;
	}


	public void setEngine_cap(String engine_cap) {
		this.engine_cap = engine_cap;
	}


	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public String getTransmission() {
		return transmission;
	}


	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}


	public Cars() {
	}

}
