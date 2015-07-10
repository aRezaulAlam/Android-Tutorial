package com.agroho.rezaul.androidjsonparsing;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ProgressDialog pDialog;

    private static String JsonUrl = "http://api.agroho.com/book/json.php";

    ArrayList<Book> arraylistBooks = new ArrayList<Book>();
    ListView listViewBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetDataSync().execute();

    }


    private class GetDataSync extends AsyncTask<Void,Void,Void>{


        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }


        @Override
        protected Void doInBackground(Void... params) {

            HttpHandler httpObj = new HttpHandler();
            String JsonString = httpObj.getServiceData(JsonUrl);

            if (JsonString != null) {
                JSONObject Jobj = new JSONObject();
                try {
                    JSONArray jArray = new JSONArray(JsonString);
                    for (int i = 0; i < jArray.length(); i++) {
                        Jobj = jArray.getJSONObject(i);
                        Book bookObj = new Book();
                        bookObj.setBookName(Jobj.getString("name"));
                        bookObj.setBookPrice(Jobj.getDouble("price"));
                        arraylistBooks.add(bookObj);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else{
                Log.e("ServiceHandler", "Couldn't get any data from the url");

            }

            return null;

        }



        protected void onPostExecute(Void result) {
            if (pDialog.isShowing())
                pDialog.dismiss();
            listViewBooks = (ListView)findViewById(R.id.listView_book);
            ListBookAdapter adapter = new ListBookAdapter(MainActivity.this,arraylistBooks);
            listViewBooks.setAdapter(adapter);

        }
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
