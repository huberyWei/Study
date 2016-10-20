/**
 * 饮料的抽象类
 * @author David
 *
 */
public class Beverage {
	public String description;
	public Boolean milk;
	public Boolean soy;
	public Boolean mocha;
	public Boolean whilp;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getMilk() {
		return milk;
	}
	public void setMilk(Boolean milk) {
		this.milk = milk;
	}
	public Boolean getSoy() {
		return soy;
	}
	public void setSoy(Boolean soy) {
		this.soy = soy;
	}
	public Boolean getMocha() {
		return mocha;
	}
	public void setMocha(Boolean mocha) {
		this.mocha = mocha;
	}
	public Boolean getWhilp() {
		return whilp;
	}
	public void setWhilp(Boolean whilp) {
		this.whilp = whilp;
	}
	public double cost(){
		return 0;
	};
}
