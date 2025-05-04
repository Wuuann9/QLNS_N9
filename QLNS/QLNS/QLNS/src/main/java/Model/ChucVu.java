
package Model;

public class ChucVu {
	private String maCV;
	private String chucVu;
	
	public ChucVu() {
		super();
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	@Override
	public String toString() {
		return this.chucVu;
	}	
}
