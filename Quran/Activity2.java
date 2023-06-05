package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class Activity2 extends AppCompatActivity {

    ListView listView1;
    Button button;
    EditText search;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> single;
    ArrayList<String> adp;
    Verses v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        listView1=findViewById(R.id.listView);
        button=findViewById(R.id.button1);
        search=findViewById(R.id.search);

        Intent i = getIntent();

        int index = i.getIntExtra("index", -1);
        int start = i.getIntExtra("start", -1);
        int end = i.getIntExtra("end", -1);
        int count = i.getIntExtra("count", -1);
        System.out.println("\tindex is\t" + index);
        System.out.println("\tstart is\t" + start);
        System.out.println("\tend is\t" + end);

         v = new Verses();

        ArrayList<String> verse;

        verse = v.GetData(start, end);

        if (verse == null || verse.isEmpty()) {
            System.out.println("list is empty\t");
        } else
        {
            //The ArrayList is not null and has elements
            System.out.println("verse list not empty\t" + verse.size());
        }


        if(verse!=null)
        {

            adp=new ArrayList<>(verse);
            arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, adp);

            listView1.setAdapter(arrayAdapter);
        }
        else{
            System.out.println("verse is null so not set");
           // return;
        }
        single=new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val=Integer.parseInt(search.getText().toString());
                if(val<0 || val>count)
                {
                    System.out.println("enter valid verse no");
                    Toast.makeText(Activity2.this, "enter valid verse no", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    // verse = v.GetData(start, end);
                    //  System.out.println("inside button size of verse\t"+verse.size()+"\t"+verse.get(0));
                    String s=verse.get(val);
                    single.add(s);
//
                    //  System.out.println("inside button the ayat is\t"+s);
                    //  System.out.println("inside button size of single\t"+single.size());

                    // Clear the old data and add the new data to the ArrayAdapter
                    arrayAdapter.clear();
                    arrayAdapter.addAll(single);

                    // Notify the adapter that the data has changed
                    arrayAdapter.notifyDataSetChanged();
                    single.clear();


                }

//                else {
//                  try{
//                      verse1 = v.GetData(start, end);
//                      System.out.println("inside button size of verse before adaptor\t"+verse1.size()+"\t"+verse1.get(0));
//                      if(val<=verse1.size())
//                      {
//                         // verse=
//                          String s=verse1.get(val);
//                          single.add(s);
////
//                          //  System.out.println("inside button the ayat is\t"+s);
//                          //  System.out.println("inside button size of single\t"+single.size());
//
//                          // Clear the old data and add the new data to the ArrayAdapter
//                          arrayAdapter.clear();
//                          System.out.println(" size of verse1 after adapter cleared\t"+verse1.size()+"\t");
//                          System.out.println(" size of verse after adapter cleared\t"+verse.size()+"\t");
//                          arrayAdapter.addAll(single);
//
//                          // Notify the adapter that the data has changed
//                          arrayAdapter.notifyDataSetChanged();
//                          single.clear();
//                      }
//                      else {
//                          System.out.println(" size of verse after else\t"+verse1.size()+"\t");
//                      }
//
//
//                  }
//                  catch (Exception e)
//                  {
//                      System.out.println("error occured"+e);
//                      System.out.println(" size of verse after exception\t"+verse1.size()+"\t");
//
//
//                  }
//
//                }



            }
        });

        }
    }

