package com.drools.OrderLocation.AppInsightsLogger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import com.microsoft.applicationinsights.telemetry.ExceptionTelemetry;
import com.microsoft.applicationinsights.telemetry.Telemetry;

@PropertySource("application.properties")
public class AppInsightsLogger {
	
	private static String INSTRUMENTATION_KEY;
	
	 @Value("${INSTRUMENTATION_KEY}")
	  public void setInstrumentationKey(String instrumentationKey) {
	        INSTRUMENTATION_KEY = instrumentationKey;
	  }
   
    private static TelemetryClient telemetryClient;

    public static void InfoLogger(String loggerMessage) {
        
        try {
        	TelemetryConfiguration.getActive().setInstrumentationKey(INSTRUMENTATION_KEY);
            telemetryClient = new TelemetryClient();
            telemetryClient.trackTrace(loggerMessage);
            
        } catch (Exception e) {           
        	trackException(e);
        }
    }
    
 public static void ExceptionLogger(Exception error) {
        
        try {
        	TelemetryConfiguration.getActive().setInstrumentationKey(INSTRUMENTATION_KEY);
            telemetryClient = new TelemetryClient();
            trackException(error);
            
        } catch (Exception e) {           
        	trackException(e);
        }
    }
 
 private static void trackException(Exception exception) {
     if (telemetryClient != null) {
         Telemetry telemetry = new ExceptionTelemetry(exception);
         telemetryClient.track(telemetry);
         telemetryClient.flush();
     }
 }
 
}
