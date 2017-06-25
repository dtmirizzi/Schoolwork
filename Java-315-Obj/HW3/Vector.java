package HW;


import HW.VectorInterface;


public class Vector implements VectorInterface {
	private double u;
	private double v;
	private double w;
	public Vector(double u, double v, double w ) {
		this.u= u;
		this.v= v;
		this.w= w;
	}
	public Vector( ) {
		this.u= 0;
		this.v= 0;
		this.w= 0;
	}
	public Vector(VectorInterface r ) {
		this.u= r.Get(XCOMPONENT);
		this.v= r.Get(YCOMPONENT);
		this.w= r.Get(ZCOMPONENT);
	}

	@Override
	public double Get(int _component) {
		if(_component==this.XCOMPONENT){
			return this.u;
		}else if(_component==this.YCOMPONENT){
			return this.v;
		}else if(_component==this.ZCOMPONENT){
			return this.w;
		}
		System.out.println("not a Component");
		return 0;
	}

	@Override
	public void Set(int _component, double _value) {
		if(_component==this.XCOMPONENT){
			this.u= _value;
		}else if(_component==this.YCOMPONENT){
			this.v= _value;
		}else if(_component==this.ZCOMPONENT){
			this.w= _value;
		}
		System.out.println("not a Component");
	}

	@Override
	public VectorInterface Add(VectorInterface _rhs) {
		double u = this.u;
		double v= this.v;
		double w= this.w;
		double x = _rhs.Get(0);
		double y= _rhs.Get(1);
		double z= _rhs.Get(2);
		return new Vector(u+x,v+y,w+z);
		
	}

	@Override
	public VectorInterface Subtract(VectorInterface _rhs) {
		double x = _rhs.Get(0);
		double y= _rhs.Get(1);
		double z= _rhs.Get(2);
		return new Vector(this.u-x,this.v-y,this.w-z);
	}

	@Override
	public VectorInterface Multiply(double _value) {
		double u = this.u;
		double v= this.v;
		double w= this.w;
		return new Vector(u*_value,v*_value,w*_value);
	}

	@Override
	public double Dot(VectorInterface _rhs) {
		double u = this.u;
		double v= this.v;
		double w= this.w;
		double x = _rhs.Get(0);
		double y= _rhs.Get(1);
		double z= _rhs.Get(2);
		return u*x+v*y+w*z;
	}

	@Override
	public VectorInterface Cross(VectorInterface _rhs) {
		double u = this.u;
		double v= this.v;
		double w= this.w;
		double x = _rhs.Get(0);
		double y= _rhs.Get(1);
		double z= _rhs.Get(2);
		return new Vector((v*z)-(w*y),(u*z)-(x*w), (u*y)-(v*x));
	}

	@Override
	public double Norm() {
		double u = this.u;
		double v= this.v;
		double w= this.w;
		return Math.sqrt(u*u+ v*v+w*w);
	}

	@Override
	public VectorInterface Unit() {
		
		return new Vector(this.u/this.Norm(), this.v/this.Norm(), this.w/this.Norm());
	}

	@Override
	public double AngleBetween(VectorInterface _rhs) {
		return Math.acos(this.Dot(_rhs)/(this.Norm()*_rhs.Norm()));
	}

	@Override
	public double DirectionAngle(int _component) {
		if(_component==this.XCOMPONENT){
			return this.u/ this.Norm();
		}else if(_component==this.YCOMPONENT){
			return this.v/ this.Norm();
		}else if(_component==this.ZCOMPONENT){
			return this.w/this.Norm();
		}
		System.out.println("not a Component");
		return 0;

	}

	@Override
	public boolean Parallel(VectorInterface _rhs) {
		return Math.abs((this.Cross(_rhs)).Norm())<0.001;
	}

	@Override
	public boolean AntiParallel(VectorInterface _rhs) {
		return Math.abs((this.AngleBetween(_rhs))- Math.PI)<0.001;
	}

	@Override
	public VectorInterface Projection(VectorInterface _rhs) {
		double u = this.u;
		double v= this.v;
		double w= this.w;
		double x = _rhs.Get(0);
		double y= _rhs.Get(1);
		double z= _rhs.Get(2);
		double k= this.Dot(_rhs.Unit());
		return new Vector(_rhs.Unit().Multiply(k));
	}

	@Override
	public boolean equals(VectorInterface _rhs) {
		return this.u==_rhs.Get(XCOMPONENT)&&this.v==_rhs.Get(YCOMPONENT)&&this.w==_rhs.Get(ZCOMPONENT);
	}
	
	public String toString(){
		return "<"+this.u+", "+this.v+", "+this.w+">.";
	}

	
}
