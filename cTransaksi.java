package UTS_BP2;
import javax.swing.JOptionPane;
public class cTransaksi {
    private String kode;
    private cPembeli pbl;
    private cProduk prd[];
    private int idxprd; //indeks array
    private int maksprd; //maksimal kapasitas array
    private int total;
    private int jumlah;
    private int jumprd[];
    private int totprd[];
    cTransaksi(){
        prd=new cProduk[5];
        jumprd=new int [5];
        totprd=new int [5];
        idxprd=0; 
        maksprd=5;
        kode=new String();
        System.out.println("Default constructor transaksi..");
    }
    public void setPembeli(String kd, String n, String a){
        pbl = new cPembeli(kd,n,a);
    }
    public void setPembeli(cPembeli pb){
        pbl = new cPembeli();
        pbl = pb;
    }
    public void setProduk(cProduk p){
        prd[idxprd] = new cProduk();
        prd[idxprd] = p;
    }
    public void setKode(String kd){ kode=kd; }
    public void setJumlah(int j){ jumlah=j; }
    public void setTotal(int t){ total=t; }
    public cPembeli getPembeli(){ return pbl; }
    public cProduk[] getProduk(){ return prd; }
    public String getKode(){ return kode; }
    public int getJumlah(){ return jumlah; }
    public int getTotal(){ return total; }
    public int getIdxprd(){ return idxprd; }
    public void tambahProduk(cProduk p, int j){
        prd[idxprd]=p;
        jumprd[idxprd]=j;
        totprd[idxprd]=j*p.getHarga();
        idxprd++;
        if(idxprd<maksprd){
            JOptionPane.showMessageDialog(null,"Tambah sukses..");
        }else{
            JOptionPane.showMessageDialog(null,"Keranjang penuh!");
        }
    }
    public StringBuilder lihatTransaksi(){
        StringBuilder struk = new StringBuilder();
        struk.append("\n=== Daftar Belanja ===");
        struk.append("\nKode: ").append(kode).append(" Nama: ").append(pbl.getNama());
        for (int i = 0; i < idxprd; i++) {
            struk.append("\n").append((i+1)).append(". ").append(prd[i].getKode()).append(" ")
            .append(prd[i].getNama()).append(" [").append(jumprd[i]).append("]")
            .append(" Rp").append(prd[i].getHarga());
        }
        struk.append("\nTotal: Rp").append(totalHarga());
        return struk;
    }
    public StringBuilder lihatTransaksi(int bayar, int kembalian, boolean pelanggan){
        StringBuilder struk = new StringBuilder();
        struk.append("\n=== Daftar Belanja ===");
        struk.append("\nKode: ").append(kode).append(" Nama: ").append(pbl.getNama());
        for (int i = 0; i < idxprd; i++) {
            struk.append("\n").append((i+1)).append(". ").append(prd[i].getKode()).append(" ")
            .append(prd[i].getNama()).append(" [").append(jumprd[i]).append("]")
            .append(" Rp").append(prd[i].getHarga());
        }
        if (pelanggan) {
            double diskon = 0.1 * totalHarga();
            struk.append("\nDiskon: Rp").append(diskon);
        }else{
            struk.append("\nDiskon: 0");
        }
        struk.append("\nTotal: Rp").append(totalHarga());
        struk.append("\nBayar: Rp").append(bayar);
        struk.append("\nKembalian: Rp").append(kembalian);
        return struk;
    }
    public void hapusproduk(String np){
        boolean ketemu=false;
        for (int i = 0; i < idxprd; i++) {
            if(np.equalsIgnoreCase(prd[i].getKode()+" ["+jumprd[i]+"]")){
                ketemu=true;
            }
            int jwb = Integer.parseInt(JOptionPane.showInputDialog
                      ("\nYakin hapus?\n1.Ya\n2.Tidak\nJawab = "));
            if(jwb==1){
                for (int j = i; j < idxprd - 1; j++) {
                    prd[j] = prd[j + 1];
                    jumprd[j] = jumprd[j + 1];
                    totprd[j] = totprd[j + 1];
                }
                prd[idxprd - 1] = null;
                jumprd[idxprd - 1] = 0;
                totprd[idxprd - 1] = 0;
                idxprd--;
                JOptionPane.showMessageDialog(null,"Hapus sukses..");
            }else{
                JOptionPane.showMessageDialog(null,"Batal Hapus!");
            }
            break;
        }
    }
    public int totalHarga(){
        int totalHarga=0;
        for (int i = 0; i < idxprd; i++) {
            totalHarga += totprd[i];
        }
        return totalHarga;
    }
}
