public interface VectorInterface {
    /**
     * These constants are used whenever a method requires
     * the specification of a component
     */
    static final int XCOMPONENT = 0;
    static final int YCOMPONENT = 1;
    static final int ZCOMPONENT = 2;

	/**
	 * Accessor retrieves individual components 
	 * 
	 * @param _component 	Specifies which component to retrieve
	 * @return 				The double value of requested component
	 */
	public abstract double Get(int _component);

	/**
	 * Mutator sets individual components
	 * 
	 * @param _component	Specifies which component to set
	 * @param _value		Value to set
	 */
	public abstract void Set(int _component, double _value);

	/**
	 * Add the parameter (addend) to this (augend) and
	 * return a new (sum) Vector
	 *     this.X = this.X + parameter.X
	 *     this.Y = this.Y + parameter.Y
	 *     this.Z = this.Z + parameter.Z
	 * @param _rhs	Addend of the operation
	 */
	public abstract VectorInterface Add(VectorInterface _rhs);

	/**
	 * Subtract the parameter (subtrahend) from this (minuend) and
	 * return a new (difference) Vector
	 *     this.X = this.X - parameter.X
	 *     this.Y = this.Y - parameter.Y
	 *     this.Z = this.Z - parameter.Z
	 * @param _rhs	Subtrahend of the operation
	 */
    	public abstract VectorInterface Subtract(VectorInterface _rhs);

	/**
	 * Multiply this by a scalar value and return a new Vector
	 *     this.X = parameter * X
	 *     this.Y = parameter * Y
	 *     this.Z = parameter * Z
	 * @param _value	Scalar for multiplication
	 */
	public abstract VectorInterface Multiply(double _value);

	/**
	 * Compute the dot product between this and the parameter. Dot product of
	 * two vectors is defined as 
	 *   (this.X * parameter.X) + (this.Y * parameter.Y) + (this.Z * parameter.Z)
	 * @param _rhs	Second operand 
	 * @return		A double representing the dot product of this and the parameter
	 */
	public abstract double Dot(VectorInterface _rhs);

	/**
	 * Compute the cross product between this and the parameter as a new vector.
	 * Cross product of two vectors is defined as 
	 *   this.X = (this.Y * parameter.Z) - (this.Z * parameter.Y)
	 *   this.Y = (this.Z * parameter.X) - (this.X * parameter.Z)
	 *   this.Z = (this.X * parameter.Y) - (this.Y * parameter.X)
	 * @param _rhs	Second operand 
	 */
	public abstract VectorInterface Cross(VectorInterface _rhs);

	/**
	 * Retrieves the length (norm) of this.
	 * norm = sqrt(this.X * this.X + this.Y * this.Y + this.Z * this.Z)
	 * @return	A double representing the length (norm) of the vector
	 */
	public abstract double Norm();

	/**
	 * Return a unit vector representation of this. Unit vector is defined as
	 *     this.X = this.X / this.Norm()
	 *     this.Y = this.Y / this.Norm()
	 *     this.Z = this.Z / this.Norm()
	 * @return	A Vector representing the unit vector of this
	 */
	public abstract VectorInterface Unit();

	/**
	 * Return the angle between this and the parameter vector
	 * @param _rhs
	 * @return	The angle between the this and the parameter in radians
	 */
	public abstract double AngleBetween(VectorInterface _rhs);

	/**
	 * Return the direction angle of this
	 * @param _comp specifies which of the 3 direction angles to compute
	 * @return	The requested direction angle in radians
	 */
	public abstract double DirectionAngle(int _comp);

	/**
	 * Determine if this and the parameter vector are parallel
	 * @param _rhs
	 * @return	true if this and the parameter are parallel, false otherwise
	 */
	public abstract boolean Parallel(VectorInterface _rhs);

	/**
	 * Determine if this and the parameter vector are anti-parallel
	 * @param _rhs
	 * @return		true if this and the parameter  are anti-parallel, false otherwise
	 */
	public abstract boolean AntiParallel(VectorInterface _rhs);

	/**
	 * Project this onto the parameter vector and return the resulting vector
	 * @param _rhs
	 * @return	The projection length of this onto the parameter
	 */
	public abstract VectorInterface Projection(VectorInterface _rhs);

	/**
	 * Compare this and the parameter vector for equality of components
	 * @param _rhs	Comparison vector
	 * @return		true if components of this and the parameter are all equal, false otherwise
	 */
	public abstract boolean equals(VectorInterface _rhs);

	/**
	 * Convert this to a String suitable from printing.
	 * 
	 */
	public abstract String toString();
}
