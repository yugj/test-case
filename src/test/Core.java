package test;

public class Core {

	private double expressionResult = 24;
	// private int maxLine=10;
	private boolean error = true;
	private double numbers[] = new double[4];
	public Object resultReturn;

	/**
	 * �ö���ӵ��3��˽�б��� expressionResult,������ maxLine,������ÿҳ���� error,�Ƿ����
	 * numbers[4],��¼���������4����
	 * 
	 * ���,�ö���ӵ�����·������ⲿ���� setNumbers(double[] <�������>) ���������������,4��ʱ���ܼ���,�޷���
	 * setMaxLine(int <����>) ����ÿҳ������,�޷��� getMaxLine() ����ÿҳ������,����Ϊint
	 * setExpressionResult(double <������>) ����������,�޷��� getExpressionResult()
	 * ����������,����Ϊdouble getExpression() ���ؿɵó��������ı��ʽ,����Ϊ�ַ�������
	 * 
	 * ���,˽�з�����Ϊ��������ʽת������
	 */

	// ����ʹ��
	public static void main(String[] args) {
		Core s = new Core();
		s.setNumbers(new int[] { 3, 3, 8, 8 });
		String[] output = s.getExpression();
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	/** �趨��������ĸ��������������飬���Ծ����ݴ���(��Ϊ4����) */
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

	/** �趨ÿҳ��ʾ������ */
	// public void setMaxLine(int n) {
	// if (n>0) {
	// maxLine=n;
	// }
	// }
	// /** ����ÿҳ��ʾ������ */
	// public int getMaxLine() {
	// return maxLine;
	// }
	/** �趨��Ҫ�õ��Ľ�� */
	public void setExpressionResult(double n) {
		expressionResult = n;
	}

	/** ���������� */
	public double expressionResult() {
		return expressionResult;
	}

	/** ���ط��������ı��ʽ */
	public String[] getExpression() {
		if (!error) {
			String[] expression = calculate(numbers);
			return expression;
		} else
			return new String[] { "������,��������" };
	}

	/** cal24()��������Ϊ24�ı��ʽ */
	private String[] calculate(double[] n) {
		if (n.length != 4)
			return new String[] { "Error" };
		double[] n1 = new double[3];
		double[] n2 = new double[2];
		String[] resultString = new String[1024]; // ���1000���,��ʱδ���
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
								// ȥ�����������Ľ�,��Ϊx/(y/z)=x*z/y
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
											.equals(resultString[count])) { // ȥ����ȫ�ظ��Ľ�
										isRepeat = true;
										break; // ��ǰ�˳�ѭ��
									}
								}
								if (c1 == c2 && c2 == c3 && c1 % 3 == 0
										&& t1 + t2 != 0) { // ��������
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
			return new String[] { "�������޽�" };
		String[] resultReturn = new String[count];
		System.arraycopy(resultString, 0, resultReturn, 0, count);
		return resultReturn;
	}

	/** cal1()����4��������һ�κ󷵻�3���� */
	private double[] cal1(double[] n, int t, int c) { // tΪԭ����t1��cΪԭ����c1
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

	/** cal2()����3��������һ�κ󷵻�2���� */
	private double[] cal2(double[] n, int t, int c) { // tΪԭ����t2��cΪԭ����c2
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

	/** cal()����2��������󷵻ؽ�� */
	private double cal(double n1, double n2, int c) { // n1,n2Ϊ��������cΪ��������
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
				return 9999; // ʹ�������ز�Ϊ24
			else
				return n1 / n2;
		default:
			if (n1 == 0)
				return 9999; // ͬ��
			else
				return n2 / n1;
		}
	}

	/** calString()��������ʽ */
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
				|| (c3 == 1 && c1 / 3 == 0)) // �ض�����¼���һ������*****************************
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
		if (c3 / 3 > c2 / 3 || (c3 == 2 && nString[0].indexOf('+') >= 0)) // �ض�����¼���һ������*****************************
			nString[0] = '(' + nString[0] + ')';
		return calString2(nString[0], nString[1], c3);
	}

	/** calString()�����ݷ������һ��������ʽ */
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