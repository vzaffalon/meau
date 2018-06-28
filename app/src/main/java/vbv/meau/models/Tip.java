package vbv.meau.models;

import java.util.ArrayList;

/**
 * Created by vzaffalon on 01/06/2018.
 */

public class Tip {
    private String categoria;
    private ArrayList<TipInfo> tipInfo;

    public Tip(String categoria, ArrayList<TipInfo> tipInfo) {
        this.categoria = categoria;
        this.tipInfo = tipInfo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<TipInfo> getTipInfo() {
        return tipInfo;
    }

    public void setTipInfo(ArrayList<TipInfo> tipInfo) {
        this.tipInfo = tipInfo;
    }
}
