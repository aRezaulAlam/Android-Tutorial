package com.agroho.rezaul.listviewsqlitedb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<Book> arrayListBook;
    ListView listViewBooks;
    EditText EditName,EditPrice;
    Button UpdateButton;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditName = (EditText)findViewById(R.id.edit_bookname);
        EditPrice = (EditText)findViewById(R.id.edit_bookprice);
        UpdateButton = (Button)findViewById(R.id.button_update);


        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = EditName.getText().toString();
                String strPrice = EditPrice.getText().toString();

                double price = Double.parseDouble(strPrice);

                long inserted = db.insertBookInfo(new Book(name, price));

                if (inserted >= 0) {
                    Toast.makeText(getApplicationContext(), "Data inserted",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data insertion failed",
                            Toast.LENGTH_LONG).show();
                }

                refreshlist();
            }
        });

        refreshlist();

    }

    private void refreshlist(){
        arrayListBook = new ArrayList<Book>();
        arrayListBook = db.getAllBooksInfo();

        listViewBooks = (ListView)findViewById(R.id.listView_book);
        ListBookAdapter adapter = new ListBookAdapter(this,arrayListBook);
        listViewBooks.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
