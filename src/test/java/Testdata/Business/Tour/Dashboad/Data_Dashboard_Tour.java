package Testdata.Business.Tour.Dashboad;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Data_Dashboard_Tour
{
    public static Data_Dashboard_Tour getDashboardTourData(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(fileName), Data_Dashboard_Tour.class);
    }

    public String getNameTour_Null() {
        return nameTour_Null;
    }

    public String getNameTour_Valid() {
        return nameTour_Valid;
    }

    public String getNameTour_4_char() {
        return nameTour_4_char;
    }

    public String getNameTour_5_char() {
        return nameTour_5_char;
    }

    public String getNameTour_255_char() {
        return nameTour_255_char;
    }

    public String getNameTour_256_char() {
        return nameTour_256_char;
    }

    public String getNameTour_5_space() {
        return nameTour_5_space;
    }

    public String getNameTour_Start_Space() {
        return nameTour_Start_Space;
    }

    public String getNameTour_End_Space() {
        return nameTour_End_Space;
    }

    public String getAlert_NameTour_Is_Required() {
        return alert_NameTour_Is_Required;
    }

    public String getAlert_NameTour_Min() {
        return alert_NameTour_Min;
    }

    public String getAlert_NameTour_Max() {
        return alert_NameTour_Max;
    }

    public String getAlert_Topic_Is_Required() {
        return alert_Topic_Is_Required;
    }

    @JsonProperty("nameTour_Null")
    String nameTour_Null;

    @JsonProperty("nameTour_Valid")
    String nameTour_Valid;

    @JsonProperty("nameTour_4_char")
    String nameTour_4_char;

    @JsonProperty("nameTour_5_char")
    String nameTour_5_char;

    @JsonProperty("nameTour_255_char")
    String nameTour_255_char;

    @JsonProperty("nameTour_256_char")
    String nameTour_256_char;

    @JsonProperty("nameTour_5_space")
    String nameTour_5_space;

    @JsonProperty("nameTour_Start_Space")
    String nameTour_Start_Space;

    @JsonProperty("nameTour_End_Space")
    String nameTour_End_Space;

    @JsonProperty("alert_NameTour_Is_Required")
    String alert_NameTour_Is_Required;

    @JsonProperty("alert_NameTour_Min")
    String alert_NameTour_Min;

    @JsonProperty("alert_NameTour_Max")
    String alert_NameTour_Max;

    @JsonProperty("alert_Topic_Is_Required")
    String alert_Topic_Is_Required;
}
