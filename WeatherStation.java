package comp1406a2;
/** A weather station keeps a collection of weather reports.
  * The actual weather station it models will make temperature
  * observations which provides the data for the reports.
  *
  * A weather station only needs to remember the last 10
  * reports added to it (in the order that they are added),
  * in addition to the report with the highest temperature that
  * has ever been and recorded/added to this weather station.
  * That is, it only needs to store 11 weather reports in total.
  *
  * Notes: The highest ever temperature record might be one of the
  *        last 10 added reports but it also might not.
  *        You must store the last 10 reports in an array.
  *        The higherst ever temperature report does not need to be
  *        sotred in this array (unless it was one of the last 10).
  */
public class WeatherStation{
/* --------------------------------------------------------------------------/
/* --------------------------------------------------------------------------/
/* ----------------------------------------------------- */
/*                                                       */
/* BEGIN  --  do NOT change anything until the end of    */
/*            this block of attributes, constructor and  */
/*            and methods                                */
/*                                                       */
/* ----------------------------------------------------- */

  /** The name of this weather station */
  protected final String name;

  /** The id number of this weather station. Should be unique. */
  protected final int    id;

  /** Initializes this weather station's name and id  */
  public WeatherStation(String nameOfStation, int idOfStation){
    this.name = nameOfStation;
    this.id   = idOfStation;
  }

  /** Getter for this weather station's name
   * @return the name of this weather station
   */
  public String getName(){ return this.name;  }

  /** Getter for this weather station's id number
   * @return the ID of this weather station
   */
  public int    getID(){ return this.id; }

  /** Creates a weather report
   * @param temperature is a valid temperature object correspinding to
   *                    an obervation at this weather station.
   * @param time is the time that the temoerature was recorded.
   * @return a weather report for this weather station recording
   *         the temperature and time of when the obervation was made.
   */
  public WeatherReport makeReport(Temperature temperature, TimeStamp time){
    return new WeatherReport(temperature, time, this);
  }

	/** A nice String representation of a weather station object */
  @Override
  public String toString(){
    return this.name + " [id:" + this.id + "]";
  }
/* ----------------------------------------------------- */
/*                                                       */
/* END - complete the methods below these comments       */
/*                                                       */
/* ----------------------------------------------------- */
/* --------------------------------------------------------------------------/*
/* --------------------------------------------------------------------------/*

  /** Adds a report to the station.
   *
   * @param report is a WeatherReport to be added to this WeatherStation
   * @return this WeatherStation. (Do NOT alter the return statement of this
   *         method.)
   *
   */
   //creates a database of size 10 and records how many spots are filled
   WeatherReport[] storage = new WeatherReport[10];
   int amountOfReports = 0;
   //records the highest WeatherReport that ever goes through the base
   WeatherReport highestDatabaseTemp;
   double highestDatabaseTempD = -300.0;
  public WeatherStation addReport(WeatherReport report){
    //if amount of reports is 10, moves each report down one index
    //stores latest report at index 9
    if (amountOfReports == 10){
      for(int x = 1; x < this.storage.length; x++){
        this.storage[x-1] = storage[x];
      }
      this.storage[9] = report;
    }
    //if amount of reports is less than 10, adds report to highest empty index
    else{
      storage[amountOfReports] = report;
      amountOfReports += 1;
    }
    //stores the highest temp and WeatherReport
    if (report.getTemperature().getTemp() > this.highestDatabaseTempD){
      highestDatabaseTempD = report.getTemperature().getTemp();
      highestDatabaseTemp = report;
    }
    return this;  // do NOT alter the return statement
  }


    /** Returns the most recently added report.
      *
      *
      * @return the most recently added WeatherReport to this weatherstation.
      *         If no reports have ever been added then returns null.
      */

    public WeatherReport getMostRecentReport(){
      //if database holds reports, returns latest one which is at index 0
      if (getReports().length > 0){
        return getReports()[0];
      }
      //if database is empty, returns null
      else {
        return null;
      }
    }


  /** Returns the last 10 weather getReports added to this weather station.
	 * <p>
	 * If there haven't been 10 reports added then return as many as has been added.
   *
   * @return an array of the last 10 added WeatherReports (in the order
   *         that they were added). The most recently added report is the
   *         first element in the array.
   *         If there has been less than 10 reports added to this
   *         weatherstation, then returns as many reports as there is.
   *         The returned array must be the same size as the number of
   *         reports returned.
   */
  public WeatherReport[] getReports(){
    //using a loop, counts the number of reports in the storage
    int size = 0;
    for(int i = 0; i < this.storage.length; i++){
      if (this.storage[i] != null){
        size += 1;
      }
    }
    //creates new database with amount of reports
    //stores latest report at index 0 and oldest at last index
    WeatherReport[] returnArray = new WeatherReport[size];
    int storeindex = this.storage.length - 1;
    for (int z = 0; z < returnArray.length; z++){
      for (int x = storeindex; x > -1; x--)
      if (this.storage[x] != null){
        returnArray[z] = storage[x];
        storeindex = x-1;
        break;
      }
    }
    return returnArray;
  }


  /** Returns a weather report with highest recorded temperature
   * of any report ever added to this WeatherStation.  If there have been
   * multiple reports with the same highest temperature, the most recently
   * added report is returned,.
   *
   * @return a WeatherReport that has the highest recorded temperature
   *         of any report ever added to this WeatherStation. Returns
   *         null if no report has ever been added to this weatherstation.
   */

  public WeatherReport getReportWithMaxTemp(){
    //if database is not empty, returns the highest temp ever recorded
    if (getReports().length > 0){
      return highestDatabaseTemp;
    }
    //if database is empty, returns null
    return null;
  }






}
