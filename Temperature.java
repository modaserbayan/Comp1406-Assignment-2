package comp1406a2;

/**
 * A class to represent temperature (with a value and scale).
 *
 * COMP 1406
 * Winter 2019
 * Assignment 2
 */

public class Temperature{
  //attributes initialized
  double temp ;
  Scale scale ;
  //the char representation of the scale
  char scalechar;
	/** Initializes a temperature object with given value in Celsius
	 *  <p>
	 *  If the initial temperature is less than -273.15C then the temperature
	 *  object will be initialized with -273.15C.
   *
	 * @param temp is the initial temperature in Celsius.
	 */
  public Temperature(double temp){
    //if temp is blow absolute 0, sets it to absolute 0 value
    //else sets it to given value
    if(temp < -273.15){
      this.temp = -273.15;
    }
    else{
      this.temp = temp;
    }
    this.scale = Scale.CELSIUS;
  }


	/** Initializes a temperature object with given value using the specified scale
   * <p>
	 * If the temperature is lower than absolute zero, in the given scale,
	 * then set the temperature to absolute zero (in that scale).
   * <p>
 	 * Usage: new Temperature(12.3, Scale.KELVIN)
	 *
	 * @param temp is the initial temperature in the scale provided in
   *        the second argument.
	 * @param scale is the scale of initial temperature and must be a constant
	 *        defined in the Scale enum type.
	 */
  public Temperature(double temp, Scale scale){
    this.temp = temp;
    this.scale = scale;

    //using switch cases, makes sure temp is not below absolute 0
    //switch cases for each possible scale
    switch (this.scale){

      case CELSIUS:
      if (this.temp < -273.15){
        this.temp = -273.15;
      }
      else{
        this.temp = temp;
      }
      break;

      case FAHRENHEIT:
      if (this.temp < -459.67){
        this.temp = -459.67;
      }
      else{
        this.temp = temp;
      }
      break;

      case KELVIN:
      if (this.temp < 0){
        this.temp = 0;
      }
      else{
        this.temp = temp;
      }
      break;

    }
  }

	/** Initializes a new temperature object that is a copy of the
   *  temperature object parameter.
   *
   * That is, it makes a new object that is a copy of the input object.
   *
	 * @param temp is a non-null temperature object
	 */
  public Temperature(Temperature temp){
    this.temp = temp.temp;
    this.scale = temp.scale;
  }



	/** getter for the scale
	 * <p>
	 * The output of this getter method must always be the first letter of one
	 * of the names in the Scales enum class. It must be the upper case letter.
	 * <p>
	 * Example: t = new Temperature(12.3, Scale.KELVIN);
	 *          t.getScale() will then output 'K'
	 *
	 * @return the first letter (in upper case) of the string representation of the
	 *         current scale of this object.
	 */
  public char getScale(){
    //the three different possibilities for scale
    //all being converted to a char representation
    switch (scale){
      case CELSIUS:
      scalechar = 'C';
      break;

      case FAHRENHEIT:
      scalechar = 'F';
      break;

      case KELVIN:
      scalechar = 'K';
      break;
    }
    return scalechar;
  }

	/** getter for the temperature
	 *
	 * @return the temperature of the object using the current scale
	 */
  public double getTemp(){
    //return -Double.MAX_VALUE;
    this.temp = temp;
    return temp;
  }


  /** setter for scale
	 *
	 * @param scale is the new scale of the temperature and must be
	 *        a constant from the Scale enum type. The next time you
	 *        call getTemp(), the temperature will be output in this scale.
   * @return a reference to this object.
	 */
  public Temperature setScale(Scale scale){
    //checks the input scale, if it matches the current scale, nothing changes
    //if the input scale differs, converts to that input scale
    switch (scale){
      //converting to CELSIUS
      case CELSIUS:
      if (this.scale == Scale.FAHRENHEIT){
        this.temp = (this.temp - 32) * (5.0/9);
        break;
      }
      else if (this.scale == Scale.KELVIN){
        this.temp = (this.temp - 273.15);
        break;
      }
      else if (this.scale == Scale.CELSIUS){
        break;
      }

      //converting to FAHRENHEIT
      case FAHRENHEIT:
      if (this.scale == Scale.FAHRENHEIT){
        break;
      }
      else if (this.scale == Scale.KELVIN){
        this.temp = ((this.temp - 273.15) * (9.0/5)) + 32;
        break;
      }
      else if (this.scale == Scale.CELSIUS){
        this.temp = (this.temp * (9.0/5))+32;
        break;
      }

      case KELVIN:
      if (this.scale == Scale.FAHRENHEIT){
        this.temp = ((this.temp - 32) * (5.0/9)) + 273.15;
        break;
      }
      else if (this.scale == Scale.KELVIN){
        break;
      }
      else if (this.scale == Scale.CELSIUS){
        this.temp = (this.temp + 273.15);
        break;
      }
    }

    //uses switch case to make sure temp is not below absolute 0
    switch (scale){

      case CELSIUS:
      if (this.temp < -273.15){
        this.temp = -273.15;
      }
      else{
        this.temp = temp;
      }
      break;

      case FAHRENHEIT:
      if (this.temp < -459.67){
        this.temp = -459.67;
      }
      else{
        this.temp = temp;
      }
      break;

      case KELVIN:
      if (this.temp < 0){
        this.temp = 0;
      }
      else{
        this.temp = temp;
      }
      break;

    }
    this.scale = scale;
    return this;  // do NOT change this return statement.
	}


	/** setter for temperature
	 *
	 * @param temp is the new temperature (in the object's current scale)
   * @return a reference to this object.
	 */
  public Temperature setTemp(double temp){
    this.temp = temp;

    //uses switch case to make sure temp is not below absolute 0
    switch (this.scale){

      case CELSIUS:
      if (this.temp < -273.15){
        this.temp = -273.15;
      }
      break;

      case FAHRENHEIT:
      if (this.temp < -459.67){
        this.temp = -459.67;
      }
      break;

      case KELVIN:
      if (this.temp < 0){
        this.temp = 0;
      }
      break;

    }

    return this;  // do NOT change this return statement.
	}

	/** setter for temperature
	 *
	 * @param temp is the new temperature
	 * @param scale is the scale of the new temperature. It must be
	 *        a constant from the Scale enum type.
   * @return a reference to this object.
   */
  public Temperature setTemp(double temp, Scale scale){
    this.temp = temp;
    this.scale = scale;
    //uses switch case to make sure temp is not below absolute 0
    switch (scale){

      case CELSIUS:
      if (this.temp < -273.15){
        this.temp = -273.15;
      }
      break;

      case FAHRENHEIT:
      if (this.temp < -459.67){
        this.temp = -459.67;
      }
      break;

      case KELVIN:
      if (this.temp < 0){
        this.temp = 0;
      }
      break;

    }
    return this;  // do NOT change this return statement.
	}

	/** setter for temperature
	 *
	 * @param temp is the new temperature.
	 * @param scale is a string representing one of the three scales.
   * @return a reference to this object.
   */
  public Temperature setTemp(double temp, String scale){
    String firstletter = scale.substring(0,1).toLowerCase();
    if (firstletter.equals("c")){
      this.scale = Scale.CELSIUS;
    }
    else if(firstletter.equals("k")){
      this.scale = Scale.KELVIN;
    }
    else if (firstletter.equals("f")){
      this.scale = Scale.FAHRENHEIT;
    }
    this.temp = temp;

    //uses switch case to make sure temp is not below absolute 0
    switch (this.scale){

      case CELSIUS:
      if (this.temp < -273.15){
        this.temp = -273.15;
      }
      break;

      case FAHRENHEIT:
      if (this.temp < -459.67){
        this.temp = -459.67;
      }
      break;

      case KELVIN:
      if (this.temp < 0){
        this.temp = 0;
      }
      break;

    }
		return this;  // do NOT change this return statement.
  }













	/* ------------------------------------------------- */
	/* ------------------------------------------------- */
  /* do not change anything below this                 */
  /* ------------------------------------------------- */
	/* ------------------------------------------------- */

  /** String representation of a temperature object    */
	@Override
  public String toString(){
    return "" + this.getTemp() + this.getScale();
  }

}
