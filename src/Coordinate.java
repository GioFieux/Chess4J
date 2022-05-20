/**
*This class creates the coordinate of a case on a chessboard with the row and column. 
*In this class, there is a conversion of the String information entered by the user to a byte and inversely which is sent in the class Game. 
*
*@author Elias MEHIRA, Florent FRAITOT, Alexis JUST, Giovanni FIEUX
*@version 1.0
*/

public class Coordinate {
    private byte row;
    private byte col;

    // WARNING !!! Coordinate doesn't throw any kind if error ...
    public Coordinate(byte x, byte y) {
        this.row = x;
        this.col = y;
    }
    
    public Coordinate() {
    	this.row=(byte)0;
    	this.col=(byte)0;
    }

    public Coordinate(int x, int y) {
        this.row = (byte) x;
        this.col = (byte) y;
    }

    public Coordinate(String str) {
        
    	byte[] conv = stringConversionToByte(str);

        this.row = conv[0];
        this.col = conv[1];
    }

    public byte getRow() {
        return this.row;
    }

    public byte getCol() {
        return this.col;
    }

    public void setRow(byte r) {
        this.row = r;
    }

    public void setCol(byte c) {
        this.col = c;
    }

    public String toString() {
        return "(Row : " + this.getRow() + " , Col : " + this.getCol() + ") " + this.byteConversionToString()[0] + this.byteConversionToString()[1];
    }

    public boolean equals(Object o) {
        if (o instanceof Coordinate) {
            Coordinate c = (Coordinate) o;
            return (this.getCol() == c.getCol() && this.getRow() == c.getRow());
        }
        return false;
    }
    
    /**
     * This method converts a string composed with a letter (corresponding column) and a number (corresponding row) in two bytes.
     * @param str corresponds to a string we want to convert in string.
     * @return array of byte of length 2 composed with row and column converted in byte.
     */
    public byte[] stringConversionToByte(String str) {
    	
        char col = str.charAt(0);
        char row = str.charAt(1);

        byte x = 0;
        byte y = 0;

        byte[] conv = new byte[2];
        
        switch (row) {
            case '1':
                x = 7;
                break;
            case '2':
                x = 6;
                break;
            case '3':
                x = 5;
                break;
            case '4':
                x = 4;
                break;
            case '5':
                x = 3;
                break;
            case '6':
                x = 2;
                break;
            case '7':
                x = 1;
                break;
            case '8':
                x = 0;
                break;
        }

        switch (col) {
            case 'a':
                y = 0;
                break;
            case 'b':
                y = 1;
                break;
            case 'c':
                y = 2;
                break;
            case 'd':
                y = 3;
                break;
            case 'e':
                y = 4;
                break;
            case 'f':
                y = 5;
                break;
            case 'g':
                y = 6;
                break;
            case 'h':
                y = 7;
                break;
        }
        conv[0]=x;
        conv[1]=y;
        return conv;
    }
    
    /**
     * This method converts a coordinate with its row and column in a byte format to a String.
     * @return array of String of length composed with row and column converted in string.
     */
    public String[] byteConversionToString() {
    	byte x=this.getRow();
    	byte y=this.getCol();
    	
    	String[] conv = new String[2];
    	
    	String row = new String();
    	String col = new String();
    	
    	switch (x) {
        case 0:
            row = "8";
            break;
        case 1:
            row = "7";
            break;
        case 2:
            row = "6";
            break;
        case 3:
            row = "5";
            break;
        case 4:
            row = "4";
            break;
        case 5:
            row = "3";
            break;
        case 6:
            row = "2";
            break;
        case 7:
            row = "1";
            break;
    	}
    	
    	switch(y) {
    	case 0:
            col = "a";
            break;
        case 1:
            col = "b";
            break;
        case 2:
            col = "c";
            break;
        case 3:
            col = "d";
            break;
        case 4:
            col = "e";
            break;
        case 5:
            col = "f";
            break;
        case 6:
            col = "g";
            break;
        case 7:
            col = "h";
            break;
    	}
    	conv[1]=row;
    	conv[0]=col;
    	return conv;
    }
}
