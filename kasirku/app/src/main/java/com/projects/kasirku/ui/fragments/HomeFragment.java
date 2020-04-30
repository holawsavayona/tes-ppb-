package com.projects.kasirku.ui.fragments;

import androidx.lifecycle.ViewModelProviders;

import com.projects.kasirku.R;
import com.projects.kasirku.adapters.GeneralRecyclerAdapter;
import com.projects.kasirku.data.HomeMenuEnum;
import com.projects.kasirku.databinding.FragmentHomeBinding;
import com.projects.kasirku.databinding.ItemHomeMenuBinding;
import com.projects.kasirku.helpers.UIHelper;
import com.projects.kasirku.ui.fragments.BaseFragment;
import com.projects.kasirku.viewmodels.HomeMenuViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements HomeMenuViewModel.HomeMenuListener{

    private List<HomeMenuViewModel> menuViewModelList;
    private GeneralRecyclerAdapter<HomeMenuViewModel> adapterMenu;

    @Override
    protected int attachLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        super.initData();

        menuViewModelList = new ArrayList<>();
        menuViewModelList.add(new HomeMenuViewModel(HomeMenuEnum.MENU_PRODUCT_MANAGEMENT, this));
        menuViewModelList.add(new HomeMenuViewModel(HomeMenuEnum.MENU_EMPLOYEE, this));
        menuViewModelList.add(new HomeMenuViewModel(HomeMenuEnum.MENU_OUTLET, this));
        menuViewModelList.add(new HomeMenuViewModel(HomeMenuEnum.MENU_ORDER, this));
        menuViewModelList.add(new HomeMenuViewModel(HomeMenuEnum.MENU_FINANCING, this));
        menuViewModelList.add(new HomeMenuViewModel(HomeMenuEnum.MENU_BILL, this));

        adapterMenu = new GeneralRecyclerAdapter<>(
                menuViewModelList,
                R.layout.item_home_menu,
                ((holder, item) -> {
                    ItemHomeMenuBinding binding = (ItemHomeMenuBinding) holder.getLayoutBinding();
                    binding.setMenuViewModel(item);
                })
        );
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        binding.setMenuAdapter(adapterMenu);
        binding.shopNow.setOnClickListener(v ->
                UIHelper.newInstance(getContext()).showErrorToast("Fitur ini belum tersedia")
        );
    }

    @Override
    public void onMenuClick(HomeMenuEnum menuEnum) {
        UIHelper.newInstance(getContext()).showErrorToast("Fitur ini belum tersedia");
    }
}