package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects;

public class SanPham {
   String masp;
    String tensp,mota;
    int size;

    public SanPham(String masp, String tensp, String mota, int size) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.size = size;
    }

    public SanPham() {
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
