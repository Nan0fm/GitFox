package com.foxmount.gitfox.utils;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import com.foxmount.gitfox.R;


/**
 * Created by A on 01.09.2017.
 */

public class BitmapWorker {
    private LruCache<String, Bitmap> memCache;

    public BitmapWorker( ) {

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        memCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            memCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return memCache.get(key);
    }


    public void loadBitmap(int resId, ImageView imageView) {
        final String imageKey = String.valueOf(resId);

        final Bitmap bitmap = getBitmapFromMemCache(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.c);
//            BitmapWorkerTask task = new BitmapWorkerTask();
//            task.execute(resId);
        }
    }

//    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
//
//        // Decode image in background.
//        @Override
//        protected Bitmap doInBackground(Integer... params) {
////            final Bitmap bitmap = decodeSampledBitmapFromResource(
////                    getResources(), params[0], 100, 100));
//            addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
//            return bitmap;
//        }
//
//    }

}
