package lab2;

public class GiaiPhuongTrinhBacHai {
	private int soA, soB, soC;
	public GiaiPhuongTrinhBacHai(int a, int b, int c) {
		this.soA = a;
		this.soB = b;
		this.soC = c;
	}
	public String giaiPhuongTrinhBacHai() {
		String s ="";
		if (this.soA == 0) {
            if (this.soB == 0) {
                return s+ "PT vô nghiệm!";
            } else {
                return s + "PT có một nghiệm:" + (-this.soC / this.soB);
            }
        }
        // tính delta
        float delta = this.soB*this.soB - 4*this.soA*this.soC;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-this.soB + Math.sqrt(delta)) / (2*this.soA));
            x2 = (float) ((-this.soB - Math.sqrt(delta)) / (2*this.soA));
            return s + "PT có 2 nghiệm là: " + x1 + " và " + x2;
        } else if (delta == 0) {
            x1 = (-this.soB / (2 * this.soA));
            return s + "PT có nghiệm kép: "+ x1;
        } else {
            return s + "PT vô nghiệm!";
        }
	}
}
