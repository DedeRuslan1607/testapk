package model;

public class Ob extends Karyawan {

    private boolean lembur;
    int gaji;

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public boolean isLembur() {
        return lembur;
    }

    public void setLembur(boolean lembur) {
        this.lembur = lembur;
    }

}
