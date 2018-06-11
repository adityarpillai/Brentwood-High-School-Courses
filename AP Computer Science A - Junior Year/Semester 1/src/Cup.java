class Cup {
    //global variable in Cup class
    private String material, color; //material and color of cup
    private boolean empty; //indicates if the cup is empty = true

    //constructor methods
    //default constructor method
    Cup() {
        material = "none";
        color = "none";
        empty = true;
    }
    //parametrized constructor method

    Cup(String material, String color, boolean empty) {
        this.material = material; //this is global
        this.color = color;
        this.empty = empty; //this.empty on left is the global empty
    }

//----------------------------------------------------------------------------

    //Accessor-get method
    String getMaterial() {
        return material;
    }

    //----------------------------------------------------------------------------
    //Modifier Methods - set methods
    void setMaterial(String material) {
        this.material = material;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    boolean isEmpty() {
        return empty;
    }

    void setEmpty(boolean empty) {
        this.empty = empty;
    }

//----------------------------------------------------------------------------


}//end of class cup
