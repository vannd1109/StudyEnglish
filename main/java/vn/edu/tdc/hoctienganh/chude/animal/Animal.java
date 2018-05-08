package vn.edu.tdc.hoctienganh.chude.animal;

import java.io.Serializable;

public class Animal implements Serializable {
    private int _id;
    private String name;
    private String pro;
    private String mean;
    private String image;
    private int IDChude;

    public Animal(int _id, String name, String pro, String mean, String image, int IDChude) {
        this._id = _id;
        this.name = name;
        this.pro = pro;
        this.mean = mean;
        this.image = image;
        this.IDChude = IDChude;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIDChude() {
        return IDChude;
    }

    public void setIDChude(int IDChude) {
        this.IDChude = IDChude;
    }
}
