package com.example.admin.instanteyecheck_upsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class detection extends AppCompatActivity {

    private static final int
            RQS_LOADIMAGE = 1;
    private Button btnLoad, btnDetFace, next;
    private ImageView imgView;
    private Bitmap myBitmap;
    double max=0;
    int res;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnDetFace = (Button) findViewById(R.id.btnDetectFace);
        imgView = (ImageView) findViewById(R.id.imgview);
        next = (Button) findViewById(R.id.next);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(R.drawable.keratisis1);
            }
        });

        btnDetFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(R.drawable.keratisis1);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compare();
            }
        });
    }
    void compare() {
        progressDialog = new ProgressDialog(detection.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        //progressDialog.setTitle("Progress Dialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    int[] Pics = {R.drawable.acute1, R.drawable.allergicconjunctivitis1, R.drawable.anaphylaxis1, R.drawable.blepharitis1, R.drawable.stye1, R.drawable.keratisis1};
                    for (int i = 0; i < Pics.length; i++) {
                        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.crop);
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
                            if (percentagesim > max) {
                                max = percentagesim;
                                res = i;

                            }
                        }
                    }
                    show(max, res);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }


        }).start();
    }
    private void show(double max, int res) {
        // TODO Auto-generated method stub
        if (max > 75) {
            switch (res) {
                case 0:
                    Intent intent = new Intent(detection.this, acuteglaucomaresult.class);
                    intent.putExtra("probability", max);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(detection.this, allergicconjunctivitisresult.class);
                    intent1.putExtra("probability", max);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(detection.this, allergyanaphylaxisresult.class);
                    intent2.putExtra("probability", max);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(detection.this, blepharitisresult.class);
                    intent3.putExtra("probability", max);
                    startActivity(intent3);
                    break;
                case 4:
                    Intent intent4 = new Intent(detection.this, styeresult.class);
                    intent4.putExtra("probability", max);
                    startActivity(intent4);
                    break;
                case 5:
                    Intent intent5 = new Intent(detection.this, keratitisresult.class);
                    intent5.putExtra("probability", max);
                    startActivity(intent5);
                    break;

            }
        } else {
            Intent intent = new Intent(detection.this, question2.class);
            startActivity(intent);
        }

    }



/*

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RQS_LOADIMAGE
                && resultCode == RESULT_OK) {

            if (myBitmap != null) {
                myBitmap.recycle();
            }

             try {
                 InputStream inputStream =getContentResolver().openInputStream(data.getData());
                 myBitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                imgView.setImageBitmap(myBitmap);
            }
             catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    reference:
    https://search-codelabs.appspot.com/codelabs/face-detection
     */
    /* public void detectFace() {

        Paint landmarksPaint = new Paint();
        landmarksPaint.setStrokeWidth(10);
        landmarksPaint.setColor(Color.RED);
        landmarksPaint.setStyle(Paint.Style.STROKE);
        Bitmap tempBitmap = Bitmap.createBitmap(myBitmap.getWidth(), myBitmap.getHeight(), Bitmap.Config.RGB_565);

        FaceDetector faceDetector =
                new FaceDetector.Builder(getApplicationContext())
                        .setTrackingEnabled(false)
                        .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                        .setProminentFaceOnly(true)
                        .build();
        Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);
        for (int i = 0; i < faces.size(); i++) {
            Face face = faces.get(i);

            Canvas tempCanvas = new Canvas(tempBitmap);
            //    float bottom=face.getPosition().y+face.getHeight();
            // tempCanvas.drawBitmap(myBitmap, 0, 0, null);
//            List<Landmark> landmarks = face.getLandmarks();
float top=0, bottom=0,right=0,left = 0;
            for (Landmark landmark : face.getLandmarks()) {
                switch (landmark.getType()) {
                    case Landmark.LEFT_EYE:

                    case Landmark.RIGHT_EYE:
                        left = landmark.getPosition().x - 50;
                        top = landmark.getPosition().y - 10;
                        right = landmark.getPosition().x + 50;
                        bottom = landmark.getPosition().x + 10;
                        Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
                        Rect dst = new Rect(0, 0, (int) myBitmap.getWidth(), 90);
                        tempCanvas.drawBitmap(myBitmap, src, dst, null);

                        }

            }
             Face thisFace = faces.valueAt(i);
            for (int l = 0; l < landmarks.size(); l++) {

                PointF pos = landmarks.get(l).getPosition();
                tempCanvas.drawPoint(pos.x, pos.y, landmarksPaint);
            }

        }

imgView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
    }
*/
}


    /* private void drawPoint(Canvas canvas, PointF point) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(25);
        paint.setStyle(Paint.Style.STROKE);
        float x = point.x;
        float y = point.y;
        canvas.drawCircle(x, y, 1, paint);
        }
*/