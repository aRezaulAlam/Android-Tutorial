package com.agroho.rezaul.androidjsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 7/8/2015.
 */
public class ListBookAdapter extends BaseAdapter {

    Context context;
    protected List<Book> listBooks;
    LayoutInflater inflater;

    public ListBookAdapter(Context context, List<Book> listBooks) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listBooks = listBooks;
    }

    @Override
    public int getCount() {
        return listBooks.size();
    }

    @Override
    public Book getItem(int position) {
        return listBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.list_item,parent,false);

            holder.TextBookName = (TextView)convertView.findViewById(R.id.book_name);
            holder.TextBookPrice = (TextView)convertView.findViewById(R.id.book_price);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        Book book = listBooks.get(position);
        holder.TextBookName.setText(book.getBookName());
        holder.TextBookPrice.setText(book.getBookPrice() + " $");

        return convertView;
    }

    private class ViewHolder {
        TextView TextBookName;
        TextView TextBookPrice;
    }
}

