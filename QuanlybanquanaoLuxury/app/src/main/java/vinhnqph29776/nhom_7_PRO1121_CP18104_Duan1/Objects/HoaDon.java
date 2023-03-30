package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects;

public class HoaDon {
 String mahoadon;
String masp;
String tensp;
String mota;
int size;
String tenkhachhang;
int sdt_khachhang;
String diachi_nguoimua;
int sdt_nguoiban;

 public HoaDon(String mahoadon, String masp, String tensp, String mota, int size, String tenkhachhang, int sdt_khachhang, String diachi_nguoimua, int sdt_nguoiban) {
  this.mahoadon = mahoadon;
  this.masp = masp;
  this.tensp = tensp;
  this.mota = mota;
  this.size = size;
  this.tenkhachhang = tenkhachhang;
  this.sdt_khachhang = sdt_khachhang;
  this.diachi_nguoimua = diachi_nguoimua;
  this.sdt_nguoiban = sdt_nguoiban;
 }

 public HoaDon() {
 }

 public String getMahoadon() {
  return mahoadon;
 }

 public void setMahoadon(String mahoadon) {
  this.mahoadon = mahoadon;
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

 public String getTenkhachhang() {
  return tenkhachhang;
 }

 public void setTenkhachhang(String tenkhachhang) {
  this.tenkhachhang = tenkhachhang;
 }

 public int getSdt_khachhang() {
  return sdt_khachhang;
 }

 public void setSdt_khachhang(int sdt_khachhang) {
  this.sdt_khachhang = sdt_khachhang;
 }

 public String getDiachi_nguoimua() {
  return diachi_nguoimua;
 }

 public void setDiachi_nguoimua(String diachi_nguoimua) {
  this.diachi_nguoimua = diachi_nguoimua;
 }

 public int getSdt_nguoiban() {
  return sdt_nguoiban;
 }

 public void setSdt_nguoiban(int sdt_nguoiban) {
  this.sdt_nguoiban = sdt_nguoiban;
 }
}
