package com.projects.kasirku.viewmodels;

import android.content.Context;

import com.projects.kasirku.data.HomeMenuEnum;

public class HomeMenuViewModel {

    private HomeMenuEnum menuEnum;
    private String menuCode;
    private String menuName;
    private int menuIcon;
    private HomeMenuListener listener;

    public interface HomeMenuListener{
        void onMenuClick(HomeMenuEnum menuEnum);
    }

    public HomeMenuViewModel(HomeMenuEnum menuEnum, HomeMenuListener listener){
        this.menuEnum = menuEnum;
        this.menuCode = menuEnum.getCode();
        this.menuName = menuEnum.getName();
        this.menuIcon = menuEnum.getIcon();
        this.listener = listener;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public void onMenuClicked(){
        listener.onMenuClick(menuEnum);
    }
}
