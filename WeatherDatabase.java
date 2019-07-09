package comp1406a2;
/** A very simple database storing weather data */
public class WeatherDatabase{

	/* ----------------------------------- */
	/* do NOT change this constructor      */
	/* ----------------------------------- */

	/** Creates an empty weather database  */
	public WeatherDatabase(){}

	/* ----------------------------------- */







	//
	// You need to complete these methods.
	//
	// Unless stated, you will need to change the return
	// value of each of these methods as well as add the actual
	// body of the methods.
	//



	/** Returns all weather stations in the database
	* in no particular order
	*
	* @return an array containing all weather stations that are in
	*         this database. Note that the size of the array should be equal to
	*         the result of <code>this.numberOfWeatherStations()</code>.
	*/

	//returns the array created in the the addWeatherStation method
	public WeatherStation[] getWeatherStations(){
		return oldArray;
	}

	/** Returns the number of weather stations in the database
	*
	* @return the number of weather stations in this database
	*/
	//returns the variable in which the number of weatherstations was stored
	public int numberOfWeatherStations(){
		//returns the integer value (amountOfStations) that is in addWeatherStation method
		return this.amountOfStations;
	}


	/** adds a weather station to this database
		* @param station is the weather station to add. It will always be non-null.
		* @return this weather station.
		*/
		//creates attribute that stores number of weather stations
		int amountOfStations = 0;
		//creates empty array of weatherstations
		WeatherStation[] oldArray = {};
	public WeatherDatabase addWeatherStation(WeatherStation station){
		//every time a station is added, the counter increases by 1
		//thus recording the number of stations in total
		this.amountOfStations += 1;
		//creates a new array of length of old array + 1 and copies the old array onto it
		// adds the parameter to the end of new array
		WeatherStation[] newArray = new WeatherStation[amountOfStations];
		for (int i = 0; i < oldArray.length; i++){
			newArray[i] = oldArray[i];
		}
		newArray[amountOfStations-1] = station;
		//sets oldArray equal to newArray
		oldArray = newArray;
		return this;    // do NOT change the return statement
	}


	/** removes weather station with given id from this database
		* @param id is the ID number of the weather station to remove.
		* @return true if the specified weather station is successfully removed,
		*         returns false otherwise (i.e., if there was no weather station
		*         with the specified ID number in this database to begin with).
		*/
	public boolean removeWeatherStation(int id){
		//creates boolean that is false until a weather station is removed
		boolean removed = false;
		int index = 0;
		for (int i = 0; i < oldArray.length; i++){
			//if weatherstation with id is found, removes it by creating a new Array
			//copies old array objects except removes values
			//sets old array equal to new array
			if (id == oldArray[i].getID()){
				index = i;
				WeatherStation[] newArray2 = new WeatherStation[oldArray.length -1];
				for (int x = 0; x < index; x++){
					newArray2[x] = oldArray[x];
				}
				for (int y = index + 1; y < oldArray.length; y++){
					newArray2[y - 1] = oldArray[y];
				}
				oldArray = newArray2;
				removed = true;
				this.amountOfStations -= 1;
			}
			else{
				continue;
			}
			break;
		}
		return removed;
	}


	/** returns the highest temperature ever recorded by any weather station
	  * in the data base.
	  */
		//creates attributes to store highest temo in database and the index (in oldArray)
		int index1 ;
		Temperature highestDatabaseTemp ;
		Double highestDatabaseTempD = -300.0;
	public Temperature getMaxTemperature(){
		//iterates throgh database (oldArray) and stores Temperature object if it has highest temp
		for (int i = 0; i < oldArray.length; i++){
			double tempd = oldArray[i].getReportWithMaxTemp().getTemperature().getTemp();
			if (tempd >= this.highestDatabaseTempD){
				this.highestDatabaseTempD = tempd;
				index1 = i;
			}
		}
		if (oldArray.length > 0){
			return oldArray[index1].getReportWithMaxTemp().getTemperature();
		}
		return null;
	}


	/** returns the highest temperature on a specified day
		* that is recorded in a report in the weather stations in this database.
		*
		* @param day is the day to find the max temperature on. Note that this
		*            might be the special max temperature day that a
		*            weather station records.
		* @return  the temperature object with the highest recorded Temperature
		*          in the data base on the specified day.
		*/
		//creates attributes to get day of report and store report if needed
		Temperature specialDayMax;
		double specialDayMaxD = -300.0;
		double specialDayTemp;
		int specialday;
	public Temperature getMaxTemperature(int day){
		//iterates through database and stores report if it is on specified days
		//and if it is the highest reported temp
		for (int i = 0; i < oldArray.length; i++){
			WeatherReport[] wrArray1 = oldArray[i].getReports();
			for (int x = 0; x < wrArray1.length; x++){
				specialday = wrArray1[x].getTime().getDay();
				if (specialday == day){
					specialDayTemp = wrArray1[x].getTemperature().getTemp();
					if (specialDayTemp >= specialDayMaxD){
						specialDayMaxD = specialDayTemp;
						specialDayMax = wrArray1[x].getTemperature();
					}
				}
			}
		}
		return specialDayMax;
	}

	/** Computes the average temperature (over all weather stations) for the
	*  time period starting at startDay and ending at endDay (inclusive)
	*
	* @param startDay is the starting day
	* @param endDay is the ending endDay
	* @return the average temperature of all temperature reports for the time
	*         period startDay to endDay (inclusive) taken from all weather
	*         stations in this weather database.
	*/
	//creates attribute to get all combined temps, the number of temps
	double totaltemp = 0.0;
	double averagetemp ;
	int numOfTemps = 0;
	int day ;
	public double averageTemperature(int startDay, int endDay){
		//iterates through database and checks if that date is between startDay and endDay
		//if it is, stores it in totaltemp and gets averagetemp by dividing totaltemp by numOfTemps
		for (int i = 0; i < oldArray.length; i++){
			WeatherReport[] wrArray = oldArray[i].getReports();
			for (int x = 0; x < wrArray.length; x++){
				day = wrArray[x].getTime().getDay();
				if (day >= startDay && day <= endDay){
					totaltemp += wrArray[x].getTemperature().getTemp();
					numOfTemps += 1;
				}
			}
		}
		averagetemp = totaltemp/numOfTemps;
		return averagetemp;
		}






}
