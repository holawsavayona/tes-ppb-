package com.projects.kasirku.ui.fragments;

import com.projects.kasirku.R;
import com.projects.kasirku.adapters.GeneralRecyclerAdapter;
import com.projects.kasirku.databinding.FragmentTransactionBinding;
import com.projects.kasirku.databinding.ItemProductBinding;
import com.projects.kasirku.databinding.ItemTransactionBinding;
import com.projects.kasirku.models.ProductModel;
import com.projects.kasirku.models.TransactionItemModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionFragment extends BaseFragment<FragmentTransactionBinding> {

    private List<ProductModel> productModelList;
    private GeneralRecyclerAdapter<ProductModel> productAdapter;

    private List<TransactionItemModel> transactionItemModelList;
    private GeneralRecyclerAdapter<TransactionItemModel> transactionItemAdapter;

    private int total;
    private int totalQty;

    @Override
    protected int attachLayout() {
        return R.layout.fragment_transaction;
    }

    @Override
    protected void initData() {
        super.initData();

        total = 0;
        totalQty = 0;

        productModelList = new ArrayList<>();
        productModelList.add(
                new ProductModel(1, "Kecap ABCD", 5000)
        );
        productModelList.add(
                new ProductModel(2, "Saos Bebek", 10000)
        );
        productModelList.add(
                new ProductModel(3, "Beras Mantan", 25000)
        );
        productModelList.add(
                new ProductModel(4, "Saori Asam Kecut", 10000)
        );
        productModelList.add(
                new ProductModel(5, "Teh Poco Poco", 7500)
        );
        productModelList.add(
                new ProductModel(6, "Kopi Kapal Laut", 2500)
        );
        productModelList.add(
                new ProductModel(7, "Top Es Asam Manis", 5000)
        );
        productModelList.add(
                new ProductModel(8, "Kopi Tubruk", 10000)
        );
        productModelList.add(
                new ProductModel(9, "Saoro Saus Manis", 15000)
        );
        productModelList.add(
                new ProductModel(10, "Mayones Kuning", 10000)
        );

        productAdapter = new GeneralRecyclerAdapter<>(
                productModelList,
                R.layout.item_product,
                ((holder, item) -> {
                    ItemProductBinding binding = (ItemProductBinding) holder.getLayoutBinding();
                    binding.setProductModel(item);
                    binding.item.setOnClickListener(v -> addItemToCart(item));
                })
        );

        transactionItemModelList = new ArrayList<>();
        transactionItemAdapter = new GeneralRecyclerAdapter<>(
                transactionItemModelList,
                R.layout.item_transaction,
                ((holder, item) -> {
                    ItemTransactionBinding binding = (ItemTransactionBinding) holder.getLayoutBinding();
                    binding.setItemModel(item);
                })
        );
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        binding.setItemAdapter(productAdapter);
        binding.setTransactionItemAdapter(transactionItemAdapter);
        refreshLayout();
    }

    private void addItemToCart(ProductModel productModel){
        boolean itemExist = false;

        for (TransactionItemModel itemModel : transactionItemAdapter.getMainData()){
            int index = transactionItemAdapter.getMainData().indexOf(itemModel);
            if (itemModel.getName().equals(productModel.getName())){
                itemModel.setQuantity(itemModel.getQuantity() + 1);
                itemModel.setItemTotalPrice(itemModel.getItemPrice() * itemModel.getQuantity());
                transactionItemAdapter.changeItemAt(index, itemModel);

                itemExist = true;
            }
        }

        if (!itemExist){
            transactionItemAdapter.addItem(
                    new TransactionItemModel(productModel.getName(), productModel.getPrice(), 1, productModel.getPrice() * 1)
            );
        }

        refreshLayout();
    }

    private void refreshLayout(){
        total = 0;
        totalQty = 0;

        for (TransactionItemModel itemModel : transactionItemAdapter.getMainData()){
            total += itemModel.getItemTotalPrice();
            totalQty += itemModel.getQuantity();
        }

        binding.setTotalQty(totalQty);
        binding.setTotal(total);
    }
}