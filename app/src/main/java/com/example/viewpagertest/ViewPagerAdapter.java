package com.example.viewpagertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.viewpagertest.models.Item;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private List<Item> mItems;

    ViewPagerAdapter(List<Item> items) {
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewGroup vgItem;
        final Context context = container.getContext();

        vgItem = (ViewGroup) LayoutInflater.from(context)
                .inflate(R.layout.page_item, container, false);

        final Item item = mItems.get(position);

        TextView title = vgItem.findViewById(R.id.title);
        TextView description = vgItem.findViewById(R.id.description);

        if (item.getName() != null && item.getDescription() != null) {
            title.setText(item.getName());
            description.setText(item.getDescription());
        }
        container.addView(vgItem);
        return vgItem;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
