package com.projects.kasirku.helpers;

import java.text.DecimalFormat;

public class TextHelper {

    private TextHelper(){}

    public static TextHelper newInstance(){
        TextHelper textHelper = new TextHelper();

        return textHelper;
    }

    public String rupiahValue(int originalValue) {
        String pattern = "###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        return "Rp " + decimalFormat.format(originalValue);
    }

    public String initialString(String originalString){
        String initials = "";

        for (String s : originalString.split(" ")) {
            if (initials.length() < 2)
                initials+=s.charAt(0);
        }

        return initials;
    }
}
