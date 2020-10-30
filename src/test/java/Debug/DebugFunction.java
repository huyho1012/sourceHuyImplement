package Debug;

import static Common.HelperFunction.ConfigResourceBundle.CONFIG_RESOURCE;

public class DebugFunction {
    public static void main (String [] args) {


    }

    protected static String replaceMoreWhitespaceToOne(String content) {
        return  content.replaceAll("^ +| +$|( )+", "$1");
    }

    public static String convertString(String content){
        if(content.length()>200){
            return content.substring(0,200)+"...";
        }
        else
            return content;
    }

    public static String getLinkOnAvatarlink(){
        String url = "url('https://test-media.hahalolo.com/2020/09/29/09/13/5f72983fbc502609c2256036200929091357aF_240-xauto_high.jpg')";
        String[] a = url.split("/");
        return a[a.length-1].replaceAll("[^\\w\\.\\-]", "");
    }
}