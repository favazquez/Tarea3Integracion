/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewPackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author Felipe
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String[] hello(@WebParam(name = "name") String txt) {
        
        GlobalWeather globalWeather = new GlobalWeather();
        Airport a  = new Airport();
        GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();
        AirportSoap as = a.getAirportSoap();
        
        String cities= globalWeatherSoap.getCitiesByCountry(txt);
        String airports= as.getAirportInformationByCountry(txt);
        String[] result = new String[2];
        result[0]=cities;
        result[1]=airports;
        return result;
    }
}
