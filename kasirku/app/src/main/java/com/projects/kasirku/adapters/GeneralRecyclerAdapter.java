package com.projects.kasirku.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GeneralRecyclerAdapter<T> extends RecyclerView.Adapter<GeneralRecyclerAdapter.GeneralViewHolder> {

    protected List<T> mainData;
    private GeneralRecyclerAdapter.OnViewHolder<T> listener;
    private @LayoutRes int layoutRes;

    public interface OnViewHolder<T>{
        void onBindView(GeneralViewHolder holder, T item);
    }

    public static class GeneralViewHolder extends RecyclerView.ViewHolder{

        private GeneralRecyclerAdapter.OnViewHolder listener;
        private ViewDataBinding layoutBinding;

        public GeneralViewHolder(@NonNull View itemView, GeneralRecyclerAdapter.OnViewHolder listener) {
            super(itemView);

            try {
                this.listener = listener;
                layoutBinding = DataBindingUtil.bind(itemView);
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }

        public ViewDataBinding getLayoutBinding() {
            return layoutBinding;
        }
    }

    public GeneralRecyclerAdapter(List<T> mainData, int layoutRes, GeneralRecyclerAdapter.OnViewHolder<T> listener){
        this.mainData = mainData;
        this.listener = listener;
        this.layoutRes = layoutRes;
    }

    @NonNull
    @Override
    public GeneralViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return new GeneralViewHolder(view, getListener());
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralViewHolder holder, int position) {
        T t = mainData.get(position);
        getListener().onBindView(holder, t);
    }

    @Override
    public int getItemCount() {
        return getMainData() == null ? 0 : getMainData().size();
    }

    public void setMainData(List<T> mainData) {
        this.mainData = mainData;
    }

    public List<T> getMainData() {
        return mainData;
    }

    public void setListener(OnViewHolder<T> listener) {
        this.listener = listener;
    }

    public OnViewHolder<T> getListener() {
        return listener;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public void changeItemAt(int position, final T data){
        getMainData().set(position, data);
        notifyItemChanged(position);
    }

    public T getItemAt(int position){
        return this.mainData.get(position);
    }

    public void addItem(final T data){
        addItemAt(data, mainData.size());
        notifyItemInserted(mainData.size());
    }

    public void addItemAt(final T data, final int position){
        this.mainData.add(position, data);
        notifyItemInserted(position);
    }

    public void removeAll(){
        getMainData().clear();
        notifyDataSetChanged();
    }
}
