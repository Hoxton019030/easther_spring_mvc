package ch02._01_setter._00.oldfashion;

import java.util.Collection;
// 傳統上Java使用物件的方法
public class MainAppLottery_Old {

	public static void main(String[] args) {
		ILottery lottery = new LotteryBeanNumberUnique();
		lottery.setLowerBound(1); // setter，性質名稱為lowerBound
		lottery.setUpperBound(10); // setter，性質名稱為upperBound
		lottery.setBallNumber(6); // setter，性質名稱為ballNumber

		Collection<Integer> coll = lottery.getLuckyNumbers();
		System.out.println(coll);
	}
}
