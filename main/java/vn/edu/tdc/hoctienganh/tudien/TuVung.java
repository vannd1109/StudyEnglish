package vn.edu.tdc.hoctienganh.tudien;

public class TuVung {
    private int _id;
    private String tu;
    private String nghia;
    private String phatam;
    private String hinhanh;


    public TuVung() {
        this._id = _id;
        this.tu = tu;
        this.nghia = nghia;
        this.phatam = phatam;
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getPhatam() {
        return phatam;
    }

    public void setPhatam(String phatam) {
        this.phatam = phatam;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
