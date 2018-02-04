import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private FormDataObject formDataObject;

	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, FormDataObject form) {
		super(source);
		
		setFormDataObject(form);
	}

	public FormDataObject getFormDataObject() {
		return formDataObject;
	}

	public void setFormDataObject(FormDataObject formDataObject) {
		this.formDataObject = formDataObject;
	}
	
	
}
