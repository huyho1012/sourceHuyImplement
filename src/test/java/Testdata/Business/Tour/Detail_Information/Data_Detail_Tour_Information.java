package Testdata.Business.Tour.Detail_Information;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Data_Detail_Tour_Information
{
    public static Data_Detail_Tour_Information getDataDetailTourInformation(String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(fileName), Data_Detail_Tour_Information.class);
    }

    @JsonProperty("value_Is_Null")
    String value_Is_Null;
    @JsonProperty("value_Is_Number")
    String value_Is_Number;
    @JsonProperty("value_Is_Decimal")
    String value_Is_Decimal;
    @JsonProperty("value_Is_Negative")
    String value_Is_Negative;
    @JsonProperty("value_Is_Special_Char")
    String value_Is_Special_Char;
    @JsonProperty("value_Is_Script")
    String value_Is_Script;
    @JsonProperty("value_Is_Char")
    String value_Is_Char;

    @JsonProperty("nameTour_Is_Valid")
    String nameTour_Is_Valid;
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

    @JsonProperty("SKU_Is_Char")
    String SKU_Is_Char;
    @JsonProperty("SKU_2_Char")
    String SKU_2_Char;
    @JsonProperty("SKU_3_Char")
    String SKU_3_Char;
    @JsonProperty("SKU_Is_Valid")
    String SKU_Is_Valid;
    @JsonProperty("SKU_255_Char")
    String SKU_255_Char;
    @JsonProperty("SKU_256_Char")
    String SKU_256_Char;
    @JsonProperty("SKU_5_Space")
    String SKU_5_Space;
    @JsonProperty("SKU_Start_Space")
    String SKU_Start_Space;
    @JsonProperty("SKU_End_Space")
    String SKU_End_Space;

    @JsonProperty("totalDay_Is_Valid")
    String totalDay_Is_Valid;
    @JsonProperty("totalDay_Equal_Max")
    String totalDay_Equal_Max;
    @JsonProperty("totalDay_More_Max")
    String totalDay_More_Max;

    @JsonProperty("priceBasic_Is_Valid")
    String priceBasic_Is_Valid;
    @JsonProperty("priceBasic_More_Max")
    String priceBasic_More_Max;
    @JsonProperty("priceBasic_Equal_Max")
    String priceBasic_Equal_Max;

    @JsonProperty("closingDays_More_Max")
    String closingDays_More_Max;
    @JsonProperty("closingDays_Equal_Max")
    String closingDays_Equal_Max;
    @JsonProperty("closingDays_Is_Valid")
    String closingDays_Is_Valid;

    @JsonProperty("address_Is_Valid_And_Only")
    String address_Is_Valid_And_Only;
    @JsonProperty("address_Has_Many_Location")
    String address_Has_Many_Location;
    @JsonProperty("address_Is_Invalid")
    String address_Is_Invalid;

    @JsonProperty("country_Is_Invalid")
    String country_Is_Invalid;
    @JsonProperty("country_Is_Valid_1")
    String country_Is_Valid_1;
    @JsonProperty("country_Is_Valid_2")
    String country_Is_Valid_2;

    @JsonProperty("city_Is_Invalid")
    String city_Is_Invalid;
    @JsonProperty("city_Is_Valid_1")
    String city_Is_Valid_1;
    @JsonProperty("city_Is_Valid_2")
    String city_Is_Valid_2;

    @JsonProperty("county_Is_Invalid")
    String county_Is_Invalid;
    @JsonProperty("county_Is_Valid_1")
    String county_Is_Valid_1;
    @JsonProperty("county_Is_Valid_2")
    String county_Is_Valid_2;

    @JsonProperty("shortDes_Less_Min")
    String shortDes_Less_Min;
    @JsonProperty("shortDes_More_Max")
    String shortDes_More_Max;
    @JsonProperty("shortDes_Is_Valid")
    String shortDes_Is_Valid;
    @JsonProperty("shortDes_Start_Space")
    String shortDes_Start_Space;
    @JsonProperty("shortDes_End_Space")
    String shortDes_End_Space;

    @JsonProperty("priRegulations_Less_Min")
    String priRegulations_Less_Min;
    @JsonProperty("priRegulations_Is_Valid")
    String priRegulations_Is_Valid;
    @JsonProperty("priRegulations_Start_Space")
    String priRegulations_Start_Space;
    @JsonProperty("priRegulations_End_Space")
    String priRegulations_End_Space;

    @JsonProperty("policy_Less_Min")
    String policy_Less_Min;
    @JsonProperty("policy_Is_Valid")
    String policy_Is_Valid;
    @JsonProperty("policy_Start_Space")
    String policy_Start_Space;
    @JsonProperty("policy_End_Space")
    String policy_End_Space;

    @JsonProperty("policy_Installment_Is_Valid")
    String policy_Installment_Is_Valid;

    @JsonProperty("image_Format_PNG")
    String image_Format_PNG;
    @JsonProperty("image_Format_JPG")
    String image_Format_JPG;
    @JsonProperty("image_Format_JPEG")
    String image_Format_JPEG;
    @JsonProperty("image_Format_WEBP")
    String image_Format_WEBP;
    @JsonProperty("image_Format_BMP")
    String image_Format_BMP;
    @JsonProperty("image_Format_ICO")
    String image_Format_ICO;
    @JsonProperty("image_Format_TIF")
    String image_Format_TIF;
    @JsonProperty("image_Format_TIFF")
    String image_Format_TIFF;
    @JsonProperty("image_Format_GIF")
    String image_Format_GIF;
    @JsonProperty("image_Format_HEIC")
    String image_Format_HEIC;

    @JsonProperty("alert_NameTour_Is_Required")
    String alert_NameTour_Is_Required;
    @JsonProperty("alert_NameTour_Less_Min")
    String alert_NameTour_Less_Min;
    @JsonProperty("alert_NameTour_More_Max")
    String alert_NameTour_More_Max;

    @JsonProperty("alert_SKU_Is_Required")
    String alert_SKU_Is_Required;
    @JsonProperty("alert_SKU_Less_Min")
    String alert_SKU_Less_Min;
    @JsonProperty("alert_SKU_More_Max")
    String alert_SKU_More_Max;

    @JsonProperty("alert_TotalDay_Is_Required")
    String alert_TotalDay_Is_Required;
    @JsonProperty("alert_TotalDay_More_Max")
    String alert_TotalDay_More_Max;

    @JsonProperty("alert_BasicPrice_Is_Required")
    String alert_BasicPrice_Is_Required;
    @JsonProperty("alert_BasicPrice_More_Max")
    String alert_BasicPrice_More_Max;

    @JsonProperty("alert_ClosingDay_Is_Required")
    String alert_ClosingDay_Is_Required;
    @JsonProperty("alert_ClosingDay_More_Max")
    String alert_ClosingDay_More_Max;

    @JsonProperty("alert_Address_Is_Required")
    String alert_Address_Is_Required;
    @JsonProperty("alert_Country_Is_Required")
    String alert_Country_Is_Required;
    @JsonProperty("alert_City_Is_Required")
    String alert_City_Is_Required;

    @JsonProperty("alert_ShortDes_Is_Required")
    String alert_ShortDes_Is_Required;
    @JsonProperty("alert_ShortDes_Less_Min")
    String alert_ShortDes_Less_Min;

    @JsonProperty("alert_PriRegulations_Is_Required")
    String alert_PriRegulations_Is_Required;
    @JsonProperty("alert_PriRegulations_Less_Min")
    String alert_PriRegulations_Less_Min;

    @JsonProperty("alert_Policy_Is_Required")
    String alert_Policy_Is_Required;
    @JsonProperty("alert_Policy_Less_Min")
    String alert_Policy_Less_Min;

    @JsonProperty("alert_Logo_Is_Required")
    String alert_Logo_Is_Required;
    @JsonProperty("alert_Cover_Is_Required")
    String alert_Cover_Is_Required;
    @JsonProperty("alert_Album_Atleast_1_Image")
    String alert_Album_Atleast_1_Image;

    @JsonProperty("messageToast_Address_Is_Invalid")
    String messageToast_Address_Is_Invalid;
    @JsonProperty("messageToast_Album_More_Max")
    String messageToast_Album_More_Max;
    @JsonProperty("messageToast_Missing_Information")
    String messageToast_Missing_Information;
    @JsonProperty("messageToast_Update_Failed")
    String messageToast_Update_Failed;
    @JsonProperty("messageToast_Incorect_Format_File")
    String messageToast_Incorect_Format_File;

    public String getValue_Is_Null() {
        return value_Is_Null;
    }

    public String getValue_Is_Number() {
        return value_Is_Number;
    }

    public String getValue_Is_Decimal() {
        return value_Is_Decimal;
    }

    public String getValue_Is_Negative() {
        return value_Is_Negative;
    }

    public String getValue_Is_Special_Char() {
        return value_Is_Special_Char;
    }

    public String getValue_Is_Script() {
        return value_Is_Script;
    }

    public String getValue_Is_Char() {
        return value_Is_Char;
    }

    public String getNameTour_Is_Valid() {
        return nameTour_Is_Valid;
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

    public String getSKU_Is_Char() {
        return SKU_Is_Char;
    }

    public String getSKU_2_Char() {
        return SKU_2_Char;
    }

    public String getSKU_3_Char() {
        return SKU_3_Char;
    }

    public String getSKU_Is_Valid() {
        return SKU_Is_Valid;
    }

    public String getSKU_255_Char() {
        return SKU_255_Char;
    }

    public String getSKU_256_Char() {
        return SKU_256_Char;
    }

    public String getSKU_5_Space() {
        return SKU_5_Space;
    }

    public String getSKU_Start_Space() {
        return SKU_Start_Space;
    }

    public String getSKU_End_Space() {
        return SKU_End_Space;
    }

    public String getTotalDay_Is_Valid() {
        return totalDay_Is_Valid;
    }

    public String getTotalDay_Equal_Max() {
        return totalDay_Equal_Max;
    }

    public String getTotalDay_More_Max() {
        return totalDay_More_Max;
    }

    public String getAlert_BasicPrice_Is_Required() {
        return alert_BasicPrice_Is_Required;
    }

    public String getAlert_BasicPrice_More_Max() {
        return alert_BasicPrice_More_Max;
    }

    public String getAlert_ClosingDay_Is_Required() {
        return alert_ClosingDay_Is_Required;
    }

    public String getAlert_ClosingDay_More_Max() {
        return alert_ClosingDay_More_Max;
    }

    public String getPriceBasic_Is_Valid() {
        return priceBasic_Is_Valid;
    }

    public String getPriceBasic_More_Max() {
        return priceBasic_More_Max;
    }

    public String getPriceBasic_Equal_Max() {
        return priceBasic_Equal_Max;
    }

    public String getClosingDays_More_Max() {
        return closingDays_More_Max;
    }

    public String getClosingDays_Equal_Max() {
        return closingDays_Equal_Max;
    }

    public String getClosingDays_Is_Valid() {
        return closingDays_Is_Valid;
    }

    public String getAddress_Is_Valid_And_Only() {
        return address_Is_Valid_And_Only;
    }

    public String getAddress_Has_Many_Location() {
        return address_Has_Many_Location;
    }

    public String getAddress_Is_Invalid() {
        return address_Is_Invalid;
    }

    public String getCountry_Is_Invalid() {
        return country_Is_Invalid;
    }

    public String getCountry_Is_Valid_1() {
        return country_Is_Valid_1;
    }

    public String getCountry_Is_Valid_2() {
        return country_Is_Valid_2;
    }

    public String getCity_Is_Invalid() {
        return city_Is_Invalid;
    }

    public String getCity_Is_Valid_1() {
        return city_Is_Valid_1;
    }

    public String getCity_Is_Valid_2() {
        return city_Is_Valid_2;
    }

    public String getCounty_Is_Invalid() {
        return county_Is_Invalid;
    }

    public String getCounty_Is_Valid_1() {
        return county_Is_Valid_1;
    }

    public String getCounty_Is_Valid_2() {
        return county_Is_Valid_2;
    }

    public String getShortDes_Less_Min() {
        return shortDes_Less_Min;
    }

    public String getShortDes_More_Max() {
        return shortDes_More_Max;
    }

    public String getShortDes_Is_Valid() {
        return shortDes_Is_Valid;
    }

    public String getShortDes_Start_Space() {
        return shortDes_Start_Space;
    }

    public String getShortDes_End_Space() {
        return shortDes_End_Space;
    }

    public String getPriRegulations_Less_Min() {
        return priRegulations_Less_Min;
    }

    public String getPriRegulations_Is_Valid() {
        return priRegulations_Is_Valid;
    }

    public String getPriRegulations_Start_Space() {
        return priRegulations_Start_Space;
    }

    public String getPriRegulations_End_Space() {
        return priRegulations_End_Space;
    }

    public String getPolicy_Less_Min() {
        return policy_Less_Min;
    }

    public String getPolicy_Is_Valid() {
        return policy_Is_Valid;
    }

    public String getPolicy_Start_Space() {
        return policy_Start_Space;
    }

    public String getPolicy_End_Space() {
        return policy_End_Space;
    }

    public String getPolicy_Installment_Is_Valid() {
        return policy_Installment_Is_Valid;
    }

    public String getImage_Format_PNG() {
        return image_Format_PNG;
    }

    public String getImage_Format_JPG() {
        return image_Format_JPG;
    }

    public String getImage_Format_JPEG() {
        return image_Format_JPEG;
    }

    public String getImage_Format_WEBP() {
        return image_Format_WEBP;
    }

    public String getImage_Format_BMP() {
        return image_Format_BMP;
    }

    public String getImage_Format_ICO() {
        return image_Format_ICO;
    }

    public String getImage_Format_TIF() {
        return image_Format_TIF;
    }

    public String getImage_Format_TIFF() {
        return image_Format_TIFF;
    }

    public String getImage_Format_GIF() {
        return image_Format_GIF;
    }

    public String getImage_Format_HEIC() {
        return image_Format_HEIC;
    }

    public String getAlert_NameTour_Is_Required() {
        return alert_NameTour_Is_Required;
    }

    public String getAlert_NameTour_Less_Min() {
        return alert_NameTour_Less_Min;
    }

    public String getAlert_NameTour_More_Max() {
        return alert_NameTour_More_Max;
    }

    public String getAlert_SKU_Is_Required() {
        return alert_SKU_Is_Required;
    }

    public String getAlert_SKU_Less_Min() {
        return alert_SKU_Less_Min;
    }

    public String getAlert_SKU_More_Max() {
        return alert_SKU_More_Max;
    }

    public String getAlert_TotalDay_Is_Required() {
        return alert_TotalDay_Is_Required;
    }

    public String getAlert_TotalDay_More_Max() {
        return alert_TotalDay_More_Max;
    }

    public String getAlert_Address_Is_Required() {
        return alert_Address_Is_Required;
    }

    public String getAlert_Country_Is_Required() {
        return alert_Country_Is_Required;
    }

    public String getAlert_City_Is_Required() {
        return alert_City_Is_Required;
    }

    public String getAlert_ShortDes_Is_Required() {
        return alert_ShortDes_Is_Required;
    }

    public String getAlert_ShortDes_Less_Min() {
        return alert_ShortDes_Less_Min;
    }

    public String getAlert_PriRegulations_Is_Required() {
        return alert_PriRegulations_Is_Required;
    }

    public String getAlert_PriRegulations_Less_Min() {
        return alert_PriRegulations_Less_Min;
    }

    public String getAlert_Policy_Is_Required() {
        return alert_Policy_Is_Required;
    }

    public String getAlert_Policy_Less_Min() {
        return alert_Policy_Less_Min;
    }

    public String getAlert_Logo_Is_Required() {
        return alert_Logo_Is_Required;
    }

    public String getAlert_Cover_Is_Required() {
        return alert_Cover_Is_Required;
    }

    public String getAlert_Album_Atleast_1_Image() {
        return alert_Album_Atleast_1_Image;
    }

    public String getMessageToast_Address_Is_Invalid() {
        return messageToast_Address_Is_Invalid;
    }

    public String getMessageToast_Album_More_Max() {
        return messageToast_Album_More_Max;
    }

    public String getMessageToast_Missing_Information() {
        return messageToast_Missing_Information;
    }

    public String getMessageToast_Update_Failed() {
        return messageToast_Update_Failed;
    }

    public String getMessageToast_Incorect_Format_File() {
        return messageToast_Incorect_Format_File;
    }

}
