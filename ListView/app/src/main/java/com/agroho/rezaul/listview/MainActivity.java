package com.agroho.rezaul.listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ArrayList<Book> arraylistBooks;
    ListView listViewBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arraylistBooks = new ArrayList<Book>();

        Book ardiuno = new Book(R.drawable.audrino, "Arduino User Guide",35);
        Book html = new Book(R.drawable.html, "HTML Document",27);
        Book JavaFX8 = new Book(R.drawable.java_fx,"Introducong JavaFX 8 Progrmamming",45);
        Book swift = new Book(R.drawable.java_swift,"Swift Programming Guide",33);
        Book JavascriptAndJquery = new Book(R.drawable.javascript,"JAVASCRIPT & JQUERY",53);
        Book Perl = new Book(R.drawable.perl,"PERL Black Book",29);

        arraylistBooks.add(ardiuno);
        arraylistBooks.add(html);
        arraylistBooks.add(JavaFX8);
        arraylistBooks.add(swift);
        arraylistBooks.add(JavascriptAndJquery);
        arraylistBooks.add(Perl);

        listViewBooks = (ListView)findViewById(R.id.listView_book);
        ListBookAdapter adapter = new ListBookAdapter(this,arraylistBooks);
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
