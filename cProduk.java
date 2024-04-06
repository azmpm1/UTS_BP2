package UTS_BP2;
public class cProduk {
    private String nama, kode;
    private int harga, stok;
    cProduk(){
        System.out.println("Constructor default..");
    }
    cProduk(String kd, String n, int h, int s){
        kode=kd; nama=n; harga=h; stok=s;
        System.out.println("Object "+nama+" dibuat..");
    }
    public void setKode(String kd){ kode=kd; }
    public void setNama(String n){ nama=n; }
    public void setHarga(int h){ harga=h; }
    public void setStok(int s){ stok=s; }
    public String getKode(){ return kode; }
    public String getNama(){ return nama; }
    public int getHarga(){ return harga; }
    public int getStok(){ return stok; }
    public String ToString(){
        return kode+" "+nama+" Harga: Rp"+harga+" Stok: "+stok;
    }
}
