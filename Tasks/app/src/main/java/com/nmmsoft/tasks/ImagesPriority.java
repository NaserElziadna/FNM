package com.nmmsoft.tasks;

public enum ImagesPriority {
    EASY(R.drawable.ic_done_all),
    MEDIUM(R.drawable.ic_note),
    HARD(R.drawable.ic_note_add),
    ;
    private int action;

    // getter method
    public int getAction()
    {
        return this.action;
    }


    ImagesPriority(int action) {
        this.action = action;
    }
}
