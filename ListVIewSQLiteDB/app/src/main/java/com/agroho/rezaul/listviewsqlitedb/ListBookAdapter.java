package com.agroho.rezaul.listviewsqlitedb;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AKM Rezaul Alam on 7/8/2015.
 * This class is used for creating custom list view
 */
public class ListBookAdapter extends BaseAdapter {

    Context context;
    protected List<Book> listBooks;
    LayoutInflater inflater;

    public ListBookAdapter(Context context, List<Book> listBooks) {
        this.context = context;
        this.listBooks = listBooks;
        this.inflater = LayoutInflater.from(context);

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
        return listBooks.get(position).getBook_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView==null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.list_item,parent,false);

            holder.TextBookName = (TextView)convertView.findViewById(R.id.textview_bookname);
            holder.TextBookPrice = (TextView)convertView.findViewById(R.id.textView_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        Book book = listBooks.get(position);
        holder.TextBookName.setText(book.getBook_name());
        holder.TextBookPrice.setText(book.getBook_price() + " $");

        return convertView;
    }

    private class ViewHolder{
        TextView TextBookName;
        TextView TextBookPrice;
    }
}
