package com.example.admin.instanteyecheck_upsystem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class compare extends AppCompatActivity {
    double max=0;
    int res;
    //  Disease d= new Disease(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    d.InsertDisease();
        setContentView(R.layout.activity_compare);
        int[] Pics = {R.drawable.acute1, R.drawable.allergicconjunctivitis1, R.drawable.anaphylaxis1,R.drawable.blepharitis1,R.drawable.stye1,R.drawable.keratisis1};
        for (int i = 1; i < Pics.length; i++) {
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ag);
            Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), Pics[i]);
            int width1 = bitmap1.getWidth();
            int width2 = bitmap2.getWidth();
            int height1 = bitmap1.getHeight();
            int height2 = bitmap2.getHeight();
            if ((width1 != width2) || (height1 != height2)) {
                TextView tv1 = (TextView) findViewById(R.id.textview1);
                tv1.setText("Error: Images dimensions mismatch");
            } else {
                long difference = 0;
                for (int y = 0; y < height1; y++) {
                    for (int x = 0; x < width1; x++) {
                        int rgbA = bitmap1.getPixel(x, y);
                        int rgbB = bitmap2.getPixel(x, y);
                        int redA = (rgbA >> 16) & 0xff;
                        int greenA = (rgbA >> 8) & 0xff;
                        int blueA = (rgbA) & 0xff;
                        int redB = (rgbB >> 16) & 0xff;
                        int greenB = (rgbB >> 8) & 0xff;
                        int blueB = (rgbB) & 0xff;
                        difference += Math.abs(redA - redB);
                        difference += Math.abs(greenA - greenB);
                        difference += Math.abs(blueA - blueB);
                    }
                }
                // Total number of red pixels = width * height
                // Total number of blue pixels = width * height
                // Total number of green pixels = width * height
                // So total number of pixels = width * height * 3
                double total_pixels = width1 * height1 * 3;

                // Normalizing the value of different pixels
                // for accuracy(average pixels per color
                // component)
                double avg_different_pixels = difference /
                        total_pixels;

                // There are 255 values of pixels in total
                double percentagediff = (avg_different_pixels /
                        255) * 100;

                double percentagesim = (100 - percentagediff);
                if(percentagesim>max) {
                    max = percentagesim;
                    res=i;
                }

            }

        }
        TextView tv2 = (TextView) findViewById(R.id.textview1);
        tv2.setText("Similarity Percentage=" + max+"image id" +res);
    }
}




