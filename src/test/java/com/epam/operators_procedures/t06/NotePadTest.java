package com.epam.operators_procedures.t06;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotePadTest {

    @Test()
    public void addAndGetNote() throws Exception {
        NotePad notePad = new NotePad();
        notePad.addNote("Note",0);
        Assert.assertEquals(new Note("Note"), notePad.getNode(0));
    }

    @Test
    public void removeNote() throws Exception {
        NotePad notePad = new NotePad();
        notePad.addNote("Note",0);
        notePad.removeNote(0);
        Assert.assertEquals(null, notePad.getNode(0));
    }

    @Test
    public void editNote() throws Exception {
        NotePad notePad = new NotePad();
        notePad.addNote("NotEdited",0);
        notePad.editNote("Edited", 0);
        notePad.editNote("PreviouslyNull",1);
        Assert.assertEquals(new Note("Edited"), notePad.getNode(0));
        Assert.assertEquals(new Note("PreviouslyNull"), notePad.getNode(1));

    }

}