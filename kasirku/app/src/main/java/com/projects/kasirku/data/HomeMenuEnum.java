package com.projects.kasirku.data;

import com.projects.kasirku.R;

public enum HomeMenuEnum {
    MENU_PRODUCT_MANAGEMENT(GlobalVariable.CODE_PRODUCT_MANAGEMENT, GlobalVariable.NAME_PRODUCT_MANAGEMENT, R.drawable.ic_box),
    MENU_EMPLOYEE(GlobalVariable.CODE_EMPLOYEE, GlobalVariable.NAME_EMPLOYEE, R.drawable.ic_employee),
    MENU_OUTLET(GlobalVariable.CODE_OUTLET, GlobalVariable.NAME_OUTLET, R.drawable.ic_outlet),
    MENU_ORDER(GlobalVariable.CODE_ORDER, GlobalVariable.NAME_ORDER, R.drawable.ic_delivery),
    MENU_FINANCING(GlobalVariable.CODE_FINANCING, GlobalVariable.NAME_FINANCING, R.drawable.ic_financing),
    MENU_BILL(GlobalVariable.CODE_BILL, GlobalVariable.NAME_BILL, R.drawable.ic_bill)
    ;

    private final String code;
    private final String name;
    private final int icon;

    HomeMenuEnum(String code, String name, int icon){
        this.code = code;
        this.name = name;
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
