package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedback extends AppCompatActivity {

    EditText toText,sub,msg;
    String to,subj,msgs;
    Button Bsend;
    DatabaseHelper helper = new DatabaseHelper(this);

    private void shareIt() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        Intent.createChooser(sendIntent,"Share via");
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Instant Eye Check-Up System shared!!!");
        sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Instant Eye Check-Up System is now available on playstore. Download it from playstore.");
        startActivity(sendIntent);
    /*
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("*/ /**");

         File originalApk = new File(filePath);

         try {
         //Make new directory in new location
         File tempFile = new File(getExternalCacheDir() + "/ExtractedApk");
         //If directory doesn't exists create new
         if (!tempFile.isDirectory())
         if (!tempFile.mkdirs())
         return;
         //Get application's name and convert to lowercase
         tempFile = new File(tempFile.getPath() + "/" + getString(app.labelRes).replace(" ","").toLowerCase() + ".apk");
         //If file doesn't exists create new
         if (!tempFile.exists()) {
         if (!tempFile.createNewFile()) {
         return;
         }
         }
         //Copy file to new location
         InputStream in = new FileInputStream(originalApk);
         OutputStream out = new FileOutputStream(tempFile);

         byte[] buf = new byte[1024];
         int len;
         while ((len = in.read(buf)) > 0) {
         out.write(buf, 0, len);
         }
         in.close();
         out.close();
         System.out.println("File copied.");
         //Open share dialog
         intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
         startActivity(Intent.createChooser(intent, "Share app via"));

         } catch (IOException e) {
         e.printStackTrace();
         } */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Button btn_share=(Button)findViewById(R.id.button);
        btn_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareIt();
            }

        });


        Button Bsend = (Button) findViewById(R.id.Sbutton);
        Button Bsend1 = (Button) findViewById(R.id.Sbutton1);

        Bsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                to="instanteyecheckup@gmail.com";
                Intent ei = new Intent(Intent.ACTION_SEND);
                ei.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                ei.putExtra(Intent.EXTRA_SUBJECT,"FEEDBACK FROM USER");
                ei.putExtra(Intent.EXTRA_TEXT,"");
                ei.setType("message/rfc822");
                startActivity(Intent.createChooser(ei,"Choose Email app"));
            }
        });
        Bsend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (view.getId()) {

                    case R.id.Sbutton1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=vesitlibrary.pavankumar.camp.VESITLibrary")));
                        break;

                }
            }
        });
     /* public void onSendClick(View v)
    {
        Intent ei = new Intent(Intent.ACTION_SEND);
       // ei.setData(Uri.parse("mailto:"));
        //ei.setType("text/plain");
        ei.putExtra(Intent.EXTRA_EMAIL,to);
        ei.putExtra(Intent.EXTRA_SUBJECT,subj);
        ei.putExtra(Intent.EXTRA_TEXT,msgs);


       /* try {
            startActivity(Intent.createChooser(ei, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FeedbackPage.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
        ei.setType("message/rfc822");
        startActivity(Intent.createChooser(ei,"Choose Email app"));


    }*/

    }
}

