import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;

public class ObjectDescription {
	public static void main (String[] args) {
		ObjectStreamClass osc = ObjectStreamClass.lookupAny(chapter7.User.class);
		ObjectStreamField[] userStreamFields = osc.getFields();
		char[] text = System.console().readPassword();
		System.out.println(text);
		ObjectStreamField obj2 = osc.getField("age");
		System.out.println(osc.getSerialVersionUID());
		
		for (ObjectStreamField obj : userStreamFields) {
			System.out.println(obj.getName() + " " + obj.getType());
		}
	}
}
