package com.example.itsukiichiyuu.intent;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class jeu_video implements Parcelable {

    private String nom;
    private String descriptif;
    private Bitmap img;

    public jeu_video(String nom, String descriptif, Bitmap img){//mutateur
        super();
        this.nom=nom;
        this.descriptif=descriptif;
        this.img=img;
    }

    public jeu_video(Parcel source){
        this.nom=source.readString();
        this.descriptif=source.readString();
        this.img=source.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(descriptif);
        dest.writeValue(img);
    }

    public static final Parcelable.Creator<jeu_video> CREATOR = new Parcelable.Creator<jeu_video>(){
        @Override
        public jeu_video createFromParcel(Parcel source) {
            return new jeu_video(source);
        }

        @Override
        public jeu_video[] newArray(int size) {
            return new jeu_video[size];
        }
    };

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getDescriptif(){
        return descriptif;
    }

    public void setDescriptif(String descriptif){
        this.descriptif=descriptif;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}