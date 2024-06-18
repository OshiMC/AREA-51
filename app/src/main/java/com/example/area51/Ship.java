package com.example.area51;


import static com.example.area51.GameView.screenRatioX;
import static com.example.area51.GameView.screenRatioY;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;



public class Ship {

    public int speed = 10;
    public boolean wasShot = true;
    int x = 0, y, width, height, shipCounter = 1;
    Bitmap ship1, ship2, ship3, ship4;

    Ship (Resources res) {

        ship1 = BitmapFactory.decodeResource(res, R.drawable.ship1);
        ship2 = BitmapFactory.decodeResource(res, R.drawable.ship2);
        ship3 = BitmapFactory.decodeResource(res, R.drawable.ship3);
        ship4 = BitmapFactory.decodeResource(res, R.drawable.ship4);

        width = ship1.getWidth();
        height = ship1.getHeight();

        width /= 8;
        height /= 8;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        ship1 = Bitmap.createScaledBitmap(ship1, width, height, false);
        ship2 = Bitmap.createScaledBitmap(ship2, width, height, false);
        ship3 = Bitmap.createScaledBitmap(ship3, width, height, false);
        ship4 = Bitmap.createScaledBitmap(ship4, width, height, false);

        y = -height;
    }

    Bitmap getShip () {

        if (shipCounter == 1) {
            shipCounter++;
            return ship1;
        }

        if (shipCounter == 2) {
            shipCounter++;
            return ship2;
        }

        if (shipCounter == 3) {
            shipCounter++;
            return ship3;
        }

        shipCounter = 1;

        return ship4;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}



