package HW;
//@author dtmirizzi
public class HW8_4Eclipse {
        private double minor;
	private double major;
	
	public HW8_4Eclipse(double _minor, double _major)
	{
		this.minor = _minor; // never do minor=minor in a constructor! use this!
		this.major = _major;
	}

	public double getMajor()
	{
		return this.major;
	}

	public double getMinor()
	{
		return this.minor;
	}	
	
	public double getArea()
	{
		return Math.PI * this.minor * this.major;
	}


    }
