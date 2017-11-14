package com.example.alex.weeat;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ReadSelonEtoiles extends AppCompatActivity {

    public static Button del;
    public static EditText id;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_selon_etoiles);

        del = (Button) findViewById(R.id.delBut);
        id = (EditText) findViewById(R.id.idResto);

        context = getApplicationContext();


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(id.getText().toString()) >= 0 && Integer.parseInt(id.getText().toString()) <= 5) {
                    TableLayout tl = (TableLayout) findViewById(R.id.tableResto);
                    int count = tl.getChildCount();
                    for (int i = 0; i < count; i++) {
                        View child = tl.getChildAt(i);
                        if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
                    }
 /* Find Tablelayout defined in main.xml */


                    TableRow tr2 = new TableRow(context);
                    tr2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                /* Create a Button to be the row-content. */
                    TextView coll1 = new TextView(context);
                    coll1.setText("ID");
                    coll1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                    TextView coll2 = new TextView(context);
                    coll2.setText("Nom");
                    coll2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                    TextView coll3 = new TextView(context);
                    coll3.setText("add");
                    coll3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                    TextView coll4 = new TextView(context);
                    coll4.setText("Qbouf");
                    coll4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                    TextView coll5 = new TextView(context);
                    coll5.setText("QServ");
                    coll5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                    TextView coll6 = new TextView(context);
                    coll6.setText("Prix");
                    coll6.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                    TextView coll7 = new TextView(context);
                    coll7.setText("cote");
                    coll7.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

            /* Add Button to row. */
                    tr2.addView(coll1);
                    tr2.addView(coll2);
                    tr2.addView(coll3);
                    tr2.addView(coll4);
                    tr2.addView(coll5);
                    tr2.addView(coll6);
                    tr2.addView(coll7);
            /* Add row to TableLayout. */
                    //tr.setBackgroundResource(R.drawable.sf_gradient_03);
                    tl.addView(tr2, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

                    Cursor c = MainActivity.bd.rawQuery("SELECT * FROM Restaurants where Cote >= '" + id.getText().toString() + "'", null);
                    if (c.moveToFirst()) {
                        do {
                            // Passing values
                            String column1 = c.getString(0);
                            String column2 = c.getString(1);
                            String column3 = c.getString(2);
                            String column4 = c.getString(3);
                            String column5 = c.getString(4);
                            String column6 = c.getString(5);
                            String column7 = c.getString(6);
                            // Do something Here with value
                /* Create a new row to be added. */
                            TableRow tr = new TableRow(context);
                            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                /* Create a Button to be the row-content. */
                            TextView col1 = new TextView(context);
                            col1.setText(column1);
                            col1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                            TextView col2 = new TextView(context);
                            col2.setText(column2);
                            col2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                            TextView col3 = new TextView(context);
                            col3.setText(column3);
                            col3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                            TextView col4 = new TextView(context);
                            col4.setText(column4);
                            col4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                            TextView col5 = new TextView(context);
                            col5.setText(column5);
                            col5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                            TextView col6 = new TextView(context);
                            col6.setText(column6);
                            col6.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                            TextView col7 = new TextView(context);
                            col7.setText(column7);
                            col7.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

            /* Add Button to row. */
                            tr.addView(col1);
                            tr.addView(col2);
                            tr.addView(col3);
                            tr.addView(col4);
                            tr.addView(col5);
                            tr.addView(col6);
                            tr.addView(col7);
            /* Add row to TableLayout. */
                            //tr.setBackgroundResource(R.drawable.sf_gradient_03);
                            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                        } while (c.moveToNext());
                    }
                    c.close();
                }
                else
                {
                    Toast.makeText(context, "Nb Etoiles doit etre entre 0 et 5", Toast.LENGTH_SHORT).show();
                }
            }
        });







    }
}
