package com.epam.operators_procedures.t06;


public class NotePad {
    private Note[] allNotes;

    public NotePad() {
        this.allNotes = new Note[10];
    }

    public NotePad(int size) {
        if(size < 1)
            throw new RuntimeException("Incorrect note array size");
        this.allNotes = new Note[size];
    }

    public NotePad(Note[] notes) {
        this.allNotes = notes;
    }


    public void addNote(String noteText, int index) throws RuntimeException {
        if (index >= allNotes.length || index < 0)
            throw new RuntimeException("Incorrect array index");
        allNotes[index] = new Note(noteText);
    }

    public Note getNode(int index){
        if (index >= allNotes.length || index < 0)
            throw new RuntimeException("Incorrect array index");
        return allNotes[index];
    }

    public void removeNote(int index) throws RuntimeException {
        if (index >= allNotes.length || index < 0)
            throw new RuntimeException("Incorrect array index");
        allNotes[index] = null;
    }

    public void editNote(String noteText, int index) {
        if (index >= allNotes.length || index < 0)
            throw new RuntimeException("Incorrect array index");
        if (allNotes[index] == null)
            addNote(noteText, index);
        else
            allNotes[index].setNoteText(noteText);
    }

    public void displayAllNotes() {
        for (Note note : allNotes) {
            if(note != null)
                System.out.println(note.getNoteText());
        }
    }


}
