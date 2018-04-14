package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class diseasedetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseasedetails);


        Button but1=(Button)findViewById(R.id.b1);
        Button but2=(Button)findViewById(R.id.b2);
        Button but3=(Button)findViewById(R.id.b3);
        Button but4=(Button)findViewById(R.id.b4);
        Button but5=(Button)findViewById(R.id.b5);
        Button but6=(Button)findViewById(R.id.b6);
        Button but7=(Button)findViewById(R.id.b7);
        Button but8=(Button)findViewById(R.id.b8);
        Button but9=(Button)findViewById(R.id.b9);
        Button but10=(Button)findViewById(R.id.b10);
        Button but11=(Button)findViewById(R.id.b11);
        Button but12=(Button)findViewById(R.id.b12);
        Button but13=(Button)findViewById(R.id.b13);
        Button but14=(Button)findViewById(R.id.b14);

        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent int1=new Intent(diseasedetails.this, a1.class);
                startActivity(int1);
            }
        });
                but2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        Intent int2=new Intent(diseasedetails.this,a2.class);
                        startActivity(int2);
                    }
                });
                        but3.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){

                                Intent int3=new Intent(diseasedetails.this,a3.class);
                                startActivity(int3);
                            }
                        });
                                but4.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){

                                        Intent int4=new Intent(diseasedetails.this,a4.class);
                                        startActivity(int4);
                                    }
                                });
                                        but5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v){

                                                Intent int5=new Intent(diseasedetails.this,a5.class);
                                                startActivity(int5);
                                            }
                                        });
                                                but6.setOnClickListener(new View.OnClickListener(){
                                                    @Override
                                                    public void onClick(View v){

                                                        Intent int6=new Intent(diseasedetails.this,a6.class);
                                                        startActivity(int6);
                                                    }
                                                });
                                                        but7.setOnClickListener(new View.OnClickListener(){
                                                            @Override
                                                            public void onClick(View v){

                                                                Intent int7=new Intent(diseasedetails.this,a7.class);
                                                                startActivity(int7);
                                                            }
                                                        });
                                                                but8.setOnClickListener(new View.OnClickListener(){
                                                                    @Override
                                                                    public void onClick(View v){

                                                                        Intent int8=new Intent(diseasedetails.this,a8.class);
                                                                        startActivity(int8);
                                                                    }
                                                                });
                                                                        but9.setOnClickListener(new View.OnClickListener(){
                                                                            @Override
                                                                            public void onClick(View v){

                                                                                Intent int9=new Intent(diseasedetails.this,a9.class);
                                                                                startActivity(int9);
                                                                            }
                                                                        });
                                                                                but10.setOnClickListener(new View.OnClickListener(){
                                                                                    @Override
                                                                                    public void onClick(View v){

                                                                                        Intent int10=new Intent(diseasedetails.this,a10.class);
                                                                                        startActivity(int10);
                                                                                    }
                                                                                });
                                                                                        but11.setOnClickListener(new View.OnClickListener(){
                                                                                            @Override
                                                                                            public void onClick(View v){

                                                                                                Intent int11=new Intent(diseasedetails.this,a11.class);
                                                                                                startActivity(int11);
                                                                                            }
                                                                                        });
                                                                                                but12.setOnClickListener(new View.OnClickListener(){
                                                                                                    @Override
                                                                                                    public void onClick(View v){

                                                                                                        Intent int12=new Intent(diseasedetails.this,a12.class);
                                                                                                        startActivity(int12);
                                                                                                    }
                                                                                                });
                                                                                                        but13.setOnClickListener(new View.OnClickListener(){
                                                                                                            @Override
                                                                                                            public void onClick(View v){

                                                                                                                Intent int13=new Intent(diseasedetails.this,a13.class);
                                                                                                                startActivity(int13);
                                                                                                            }
                                                                                                        });
                                                                                                                but14.setOnClickListener(new View.OnClickListener(){
                                                                                                                    @Override
                                                                                                                    public void onClick(View v){

                                                                                                                        Intent int14=new Intent(diseasedetails.this,a14.class);
                                                                                                                        startActivity(int14);
                                                                                                                    }
                                                                                                                });

    }
}