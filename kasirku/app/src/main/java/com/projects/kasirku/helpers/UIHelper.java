package com.projects.kasirku.helpers;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.projects.kasirku.R;
import com.projects.kasirku.databinding.CustomToastBinding;

public class UIHelper {

    private Context context;

    private UIHelper(){}

    public static UIHelper newInstance(Context context){
        UIHelper uiHelper = new UIHelper();
        uiHelper.setContext(context);
        return uiHelper;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Integer calculateColumnNumber(){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / 125); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

    public void showToast(String message, int icon, int color){
        CustomToastBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.custom_toast,
                null,
                false
        );

        binding.setIcon(icon);
        binding.setInfo(message);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.layout.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), color));
        }

        Toast toast = new Toast(getContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(binding.getRoot());
        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.BOTTOM, 0,0);

        toast.show();
    }

    public void showErrorToast(String message){
        showToast(message, R.drawable.ic_cancel_white, R.color.red);
    }
}
