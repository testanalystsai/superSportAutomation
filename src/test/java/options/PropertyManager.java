package options;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
//**********************************************************************************************************
//Author: Sai
//Description: PropertyManager class reads global configurations and use them during test execution.
//**********************************************************************************************************
public class PropertyManager {
 
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\test\\resources\\config.properties";
    private static String currentSeasonEventEndpoint;
    private static String golfEventLeaderBoardEndpoint;
    private static String golfEventScheduleEndpoint;
    private static String golfEventScoreCardEndpoint;
    private static String golfOrderofMeritEndpoint;
    private static String playerScoreCardEndpoint;
    private static String latestGolfEventLeaderBoardEndpoint;
    private static String roundScoreCardEndpoint;
    private static String subscriptionKey;
    private static String subscriptionKeyValue;
  
 
    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }
 
    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        currentSeasonEventEndpoint = prop.getProperty("currentSeasonEventEndpoint");
       golfEventLeaderBoardEndpoint = prop.getProperty("golfEventLeaderBoardEndpoint");
        golfEventScheduleEndpoint = prop.getProperty("golfEventScheduleEndpoint");
       golfEventScoreCardEndpoint = prop.getProperty("golfEventScoreCardEndpoint");
        golfOrderofMeritEndpoint = prop.getProperty("golfOrderofMeritEndpoint");
        playerScoreCardEndpoint = prop.getProperty("playerScoreCardEndpoint");
      latestGolfEventLeaderBoardEndpoint = prop.getProperty("latestGolfEventLeaderBoardEndpoint");
        roundScoreCardEndpoint = prop.getProperty("roundScoreCardEndpoint");
       subscriptionKey = prop.getProperty("subscriptionKey");
        subscriptionKeyValue = prop.getProperty("subscriptionKeyValue");
   
    }
 
    public String getCurrentSeasonEventEndpoint() {
      return currentSeasonEventEndpoint;
    }
    
    public String getGolfEventLeaderBoardEndpoint() {
        return golfEventLeaderBoardEndpoint;
      }
    public String getgolfEventScheduleEndpoint() {
        return golfEventScheduleEndpoint;
      }
    public String getGolfEventScoreCardEndpoint() {
        return golfEventScoreCardEndpoint;
      }
    public String getgolfOrderofMeritEndpoint() {
        return golfOrderofMeritEndpoint;
      }
    public String getplayerScoreCardEndpoint() {
        return playerScoreCardEndpoint;
      }
    public String getlatestGolfEventLeaderBoardEndpoint() {
        return latestGolfEventLeaderBoardEndpoint;
      }
    public String getroundScoreCardEndpoint() {
        return roundScoreCardEndpoint;
      }
   
    
    public String getSubscriptionKey() {
        return subscriptionKey;
    }
 
    public String getSubscriptionKeyValue() {
        return subscriptionKeyValue;
    }
}