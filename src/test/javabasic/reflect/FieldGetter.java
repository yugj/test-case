package test.javabasic.reflect;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FieldGetter {
	private static Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args){
		Demo d = new Demo();
		d.setAge(10);
		d.setName("name");
		d.setCal(Calendar.getInstance());
		d.setDate(new Date());
		d.setD(new BigDecimal(100));
		printObj(d);
	}
	
	@SuppressWarnings("rawtypes")
	public static String printObj(Object o){
		StringBuffer sb = new StringBuffer();
		try {
			Class c = (Class) o.getClass();
			sb.append(c.getSimpleName() + "[");
			Field[] fields = c.getDeclaredFields();
			
			for (Field f : fields) {
				f.setAccessible(true);
				Object obj = f.get(o);
				if(obj instanceof Calendar) { 
					Calendar cal = (Calendar)obj;
					sb.append(f.getName() + "=" + format.format(cal.getTime()) + " " );
					System.out.println(f.getType());
				} else if(obj instanceof Date) { 
					Date date = (Date)obj;
					sb.append(f.getName() +  "=" +  format.format(date.getTime()) + " ");
				} else  {
					sb.append(f.getName() + "=" + obj + " ");
				}
			}
			sb.append("]");
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}

}

class Demo implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id = 2;
	private String name;
	private int age;
	private Calendar cal;
	private Date date;
	private BigDecimal d;
	
	
	@SuppressWarnings("unused")
	private String test;
	
	public BigDecimal getD() {
		return d;
	}

	public void setD(BigDecimal d) {
		this.d = d;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", age=" + age + ", cal="
				+ cal + ", date=" + date + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
