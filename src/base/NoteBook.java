package base;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<Folder> folders;

	public NoteBook() {
		this.folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}
	private boolean insertNote(String folderName, Note note) {
		Folder f = null;
		for (Folder f1 : folders) {
			if (f1.equals(new Folder(folderName))){
				f = f1;
			}
		}
		if (f == null) {
			f  = new Folder(folderName);
			folders.add(f);
		}
		for (Note n : f.getNotes()) {
			if (n.equals(note)) {
				System.out.println("Creating note " + n.getTitle() + " under folder " + folderName + " failed");
				return false;
			}
		}
				f.getNotes().add(note);
		return true;
	}

	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
	}
	
	public ArrayList<Folder> getFolders() {
		return folders;
	}
}