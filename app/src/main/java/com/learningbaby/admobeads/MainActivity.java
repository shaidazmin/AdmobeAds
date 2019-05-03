package com.learningbaby.admobeads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity {

    private AdView mAdview;
    private Button button, button2,button3;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-3001684762479545~3216098507");

        mAdview = findViewById(R.id.adView);
        button = findViewById(R.id.button);
       button2 = findViewById(R.id.butto2);




        mInterstitialAd = new InterstitialAd(getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3001684762479545/1576370311");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (mInterstitialAd.isLoaded()) {
                   mInterstitialAd.show();
               } else {
                   Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
               }


               mInterstitialAd.setAdListener(new AdListener() {
                   @Override
                   public void onAdLoaded() {
                       // Code to be executed when an ad finishes loading.
                       Toast.makeText(MainActivity.this, "onLoaded", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onAdFailedToLoad(int errorCode) {
                       // Code to be executed when an ad request fails.
                       Toast.makeText(MainActivity.this, "onFailed", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onAdOpened() {
                       // Code to be executed when the ad is displayed.
                       Toast.makeText(MainActivity.this, "onAdOpen", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onAdClicked() {
                       // Code to be executed when the user clicks on an ad.
                       Toast.makeText(MainActivity.this, "onAdClicked", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onAdLeftApplication() {
                       // Code to be executed when the user has left the app.
                       Toast.makeText(MainActivity.this, "onAdLeft", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onAdClosed() {
                       // Code to be executed when the interstitial ad is closed.
                       Toast.makeText(MainActivity.this, "onAdClosed", Toast.LENGTH_SHORT).show();
                   }
               });
           }
       });


       // another button .....

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdRequest adRequest = new AdRequest.Builder().build();

                mAdview.loadAd(adRequest);

                mAdview.setAdListener(new AdListener(){

                    @Override
                    public void onAdLoaded() {
                        // Code to be executed when an ad finishes loading.
                        Toast.makeText(MainActivity.this, "Onloaded", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // Code to be executed when an ad request fails.

                        Toast.makeText(MainActivity.this, "onFailed   "+ errorCode, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdOpened() {
                        // Code to be executed when an ad opens an overlay that
                        // covers the screen.
                        Toast.makeText(MainActivity.this, "onAdOnpened", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdClicked() {
                        // Code to be executed when the user clicks on an ad.
                        Toast.makeText(MainActivity.this, "onAdClicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdLeftApplication() {
                        // Code to be executed when the user has left the app.
                        Toast.makeText(MainActivity.this, "onAdLeftApplication", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the user is about to return
                        // to the app after tapping on an ad.
                        Toast.makeText(MainActivity.this, "onAdClosed", Toast.LENGTH_SHORT).show();
                    }


                });

            }
        });


    }



}
