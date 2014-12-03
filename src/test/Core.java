package test;

public class Core {

	private double expressionResult = 24;
	// private int maxLine=10;
	private boolean error = true;
	private double numbers[] = new double[4];
	public Object resultReturn;

	/**
	 * 该对象拥有3个私有变量 expressionResult,所需结果 maxLine,输出结果每页行数 error,是否出错
	 * numbers[4],记录用来运算的4个数
	 * 
	 * 其次,该对象拥有以下方法供外部调用 setNumbers(double[] <运算的数>) 输入用来运算的数,4个时才能计算,无返回
	 * setMaxLine(int <行数>) 输入每页的行数,无返回 getMaxLine() 返回每页的行数,类型为int
	 * setExpressionResult(double <所需结果>) 输入所需结果,无返回 getExpressionResult()
	 * 返回所需结果,类型为double getExpression() 返回可得出所需结果的表达式,类型为字符串数组
	 * 
	 * 最后,私有方法均为计算与表达式转换部分
	 */

	// 测试使用
	public static void main(String[] args) {
		Core s = new Core();
		s.setNumbers(new int[] { 3, 3, 8, 8 });
		String[] output = s.getExpression();
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	/** 设定被计算的四个数，由于是数组，所以具有容错功能(不为4个数) */
	public void setNumbers(double[] n) {
		if (n.length == 4) {
			error = false;
			numbers = n;
		} else
			error = true;
	}

	public void setNumbers(int[] n) {
		if (n.length == 4) {
			error = false;
			for (int i = 0; i < 4; i++) {
				numbers[i] = n[i];
			}
		} else
			error = true;
	}

	/** 设定每页显示的行数 */
	// public void setMaxLine(int n) {
	// if (n>0) {
	// maxLine=n;
	// }
	// }
	// /** 返回每页显示的行数 */
	// public int getMaxLine() {
	// return maxLine;
	// }
	/** 设定需要得到的结果 */
	public void setExpressionResult(double n) {
		expressionResult = n;
	}

	/** 返回所需结果 */
	public double expressionResult() {
		return expressionResult;
	}

	/** 返回符合条件的表达式 */
	public String[] getExpression() {
		if (!error) {
			String[] expression = calculate(numbers);
			return expression;
		} else
			return new String[] { "出错了,输入有误" };
	}

	/** cal24()，输出结果为24的表达式 */
	private String[] calculate(double[] n) {
		if (n.length != 4)
			return new String[] { "Error" };
		double[] n1 = new double[3];
		double[] n2 = new double[2];
		String[] resultString = new String[1024]; // 最多1000组解,暂时未溢出
		int count = 0;
		boolean isRepeat = false;
		for (int t1 = 0; t1 < 6; t1++) {
			for (int c1 = 0; c1 < 6; c1++) {
				for (int t2 = 0; t2 < 3; t2++) {
					for (int c2 = 0; c2 < 6; c2++) {
						for (int c3 = 0; c3 < 6; c3++) {
							if ((c1 / 3 == c2 / 3 && (c1 % 3) * (c2 % 3) != 0)
									|| (c2 / 3 == c3 / 3 && (c2 % 3) * (c3 % 3) != 0)
									|| (c1 / 3 == c3 / 3
											&& (c1 % 3) * (c3 % 3) != 0 && t2 == 2)) {
								// 去除连减连除的解,因为x/(y/z)=x*z/y
								continue;
							}
							n1 = cal1(n, t1, c1);
							n2 = cal2(n1, t2, c2);
							double result = cal(n2[0], n2[1], c3);
							if ((result - expressionResult) < 0.00000001
									&& (expressionResult - result) < 0.00000001) {
								resultString[count] = calString(n, t1, c1, t2,
										c2, c3) + "=" + (int) expressionResult;
								for (int i = 0; i < count; i++) {
									isRepeat = false;
									if (resultString[i]
											.equals(resultString[count])) { // 去除完全重复的解
										isRepeat = true;
										break; // 提前退出循环
									}
								}
								if (c1 == c2 && c2 == c3 && c1 % 3 == 0
										&& t1 + t2 != 0) { // 连加连乘
									isRepeat = true;
								}
								if (!isRepeat) {
									count++;
								}
							}
						}
					}
				}
			}
		}
		if (count == 0)
			return new String[] { "该组数无解" };
		String[] resultReturn = new String[count];
		System.arraycopy(resultString, 0, resultReturn, 0, count);
		return resultReturn;
	}

	/** cal1()，将4个数计算一次后返回3个数 */
	private double[] cal1(double[] n, int t, int c) { // t为原来的t1，c为原来的c1
		double[] m = new double[3];
		switch (t) {
		case 0:
			m[1] = n[2];
			m[2] = n[3];
			m[0] = cal(n[0], n[1], c);
			break;
		case 1:
			m[1] = n[1];
			m[2] = n[3];
			m[0] = cal(n[0], n[2], c);
			break;
		case 2:
			m[1] = n[1];
			m[2] = n[2];
			m[0] = cal(n[0], n[3], c);
			break;
		case 3:
			m[1] = n[0];
			m[2] = n[3];
			m[0] = cal(n[1], n[2], c);
			break;
		case 4:
			m[1] = n[0];
			m[2] = n[2];
			m[0] = cal(n[1], n[3], c);
			break;
		default:
			m[1] = n[0];
			m[2] = n[1];
			m[0] = cal(n[2], n[3], c);
		}
		return m;
	}

	/** cal2()，将3个数计算一次后返回2个数 */
	private double[] cal2(double[] n, int t, int c) { // t为原来的t2，c为原来的c2
		double[] m = new double[2];
		switch (t) {
		case 0:
			m[1] = n[2];
			m[0] = cal(n[0], n[1], c);
			break;
		case 1:
			m[1] = n[1];
			m[0] = cal(n[0], n[2], c);
			break;
		default:
			m[1] = n[0];
			m[0] = cal(n[1], n[2], c);
		}
		return m;
	}

	/** cal()，将2个数计算后返回结果 */
	private double cal(double n1, double n2, int c) { // n1,n2为运算数，c为运算类型
		switch (c) {
		case 0:
			return n1 + n2;
		case 1:
			return n1 - n2;
		case 2:
			return n2 - n1;
		case 3:
			return n1 * n2;
		case 4:
			if (n2 == 0)
				return 9999; // 使计算结果必不为24
			else
				return n1 / n2;
		default:
			if (n1 == 0)
				return 9999; // 同上
			else
				return n2 / n1;
		}
	}

	/** calString()，输出表达式 */
	private String calString(double[] n, int t1, int c1, int t2, int c2, int c3) {
		String[] nString = new String[4];
		switch (t1) {
		case 0:
			nString[0] = calString2("" + (int) n[0], "" + (int) n[1], c1);
			nString[1] = "" + (int) n[2];
			nString[2] = "" + (int) n[3];
			break;
		case 1:
			nString[0] = calString2("" + (int) n[0], "" + (int) n[2], c1);
			nString[1] = "" + (int) n[1];
			nString[2] = "" + (int) n[3];
			break;
		case 2:
			nString[0] = calString2("" + (int) n[0], "" + (int) n[3], c1);
			nString[1] = "" + (int) n[1];
			nString[2] = "" + (int) n[2];
			break;
		case 3:
			nString[0] = calString2("" + (int) n[1], "" + (int) n[2], c1);
			nString[1] = "" + (int) n[0];
			nString[2] = "" + (int) n[3];
			break;
		case 4:
			nString[0] = calString2("" + (int) n[1], "" + (int) n[3], c1);
			nString[1] = "" + (int) n[0];
			nString[2] = "" + (int) n[2];
			break;
		default:
			nString[0] = calString2("" + (int) n[2], "" + (int) n[3], c1);
			nString[1] = "" + (int) n[0];
			nString[2] = "" + (int) n[1];
		}
		if ((c2 / 3 > c1 / 3 && (t2 != 2 || c2 / 3 == c3 / 3))
				|| ((c3 / 3 > c1 / 3 + c2 / 3) && t2 == 2)
				|| (c3 == 1 && c1 / 3 == 0)) // 特定情况下加上一个括号*****************************
			nString[0] = '(' + nString[0] + ')';
		switch (t2) {
		case 0:
			nString[0] = calString2(nString[0], "" + nString[1], c2);
			nString[1] = nString[2];
			break;
		case 1:
			nString[0] = calString2(nString[0], nString[2], c2);
			break;
		default:
			nString[3] = nString[0];
			nString[0] = calString2(nString[1], nString[2], c2);
			nString[1] = nString[3];
		}
		if (c3 / 3 > c2 / 3 || (c3 == 2 && nString[0].indexOf('+') >= 0)) // 特定情况下加上一个括号*****************************
			nString[0] = '(' + nString[0] + ')';
		return calString2(nString[0], nString[1], c3);
	}

	/** calString()，根据符号输出一部运算表达式 */
	private String calString2(String n1, String n2, int c) {
		switch (c) {
		case 0:
			return n1 + '+' + n2;
		case 1:
			return n1 + '-' + n2;
		case 2:
			return n2 + '-' + n1;
		case 3:
			return n1 + '*' + n2;
		case 4:
			return n1 + '/' + n2;
		default:
			return n2 + '/' + n1;
		}
	}

}