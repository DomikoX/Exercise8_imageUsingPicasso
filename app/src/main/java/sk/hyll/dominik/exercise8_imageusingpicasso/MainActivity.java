package sk.hyll.dominik.exercise8_imageusingpicasso;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    public static String[] eatFoodyImages = {
            "http://i.imgur.com/F1cvFVX.jpg",

            "http://i.imgur.com/lR0O3Wm.jpg",
            "http://i.imgur.com/A6P5bIu.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/ogZCqD1.jpg",
            "http://i.imgur.com/Ppgz7MH.jpg",
            "http://i.imgur.com/NcR7Zy9.jpg",
            "http://i.imgur.com/oqwDAdc.jpg",
            "http://i.imgur.com/KHTVGC1.jpg",
            "http://i.imgur.com/t2vYQbA.jpg",
            "http://i.imgur.com/rNe3fxj.jpg",
            "http://i.imgur.com/CrfaDMf.jpg",
            "http://i.imgur.com/boTVS7b.jpg",
            "http://i.imgur.com/O7rKp0t.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageListAdapter(this, eatFoodyImages));

    }


    public class ImageListAdapter extends ArrayAdapter {
        private Context context;
        private LayoutInflater inflater;

        private String[] imageUrls;

        public ImageListAdapter(Context context, String[] imageUrls) {
            super(context, R.layout.single_image, imageUrls);

            this.context = context;
            this.imageUrls = imageUrls;

            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = inflater.inflate(R.layout.single_image, parent, false);
            }

            Picasso
                    .with(context)
                    .load(imageUrls[position])
                    .resize(200,222).centerCrop()
                    .into((ImageView) convertView);

            return convertView;
        }
    }

}
