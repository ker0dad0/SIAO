package Model;

public class Bed {
    private int idb;
    private int idr;
    private Boolean state;

    public Bed(int idb, int idr){
        this.idb = idb;
        this.idr = idr;
        state = false;  //car on vient de créer un nouveau lit
    }


    public int getIdb() {
        return idb;
    }

    public int getIdr() {
        return idr;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }


}
