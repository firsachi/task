package informer.controller;

public enum PageAddEdit {
	ADD("add"),
	EDIT("edit"),
	DELETE("delete");
	
	public final String label;

    private PageAddEdit(String label) {
        this.label = label;
    }
}
