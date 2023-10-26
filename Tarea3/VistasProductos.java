package Tarea3;

import java.awt.*;

public class VistasProductos {
    private VistaSnicker snicker;
    private VistaSuper8 super8;
    private VistaCoca coca;
    private VistaFanta fanta;
    private VistaSprite sprite;

    public VistasProductos(){
        snicker = new VistaSnicker();
        super8 = new VistaSuper8();
        coca = new VistaCoca();
        fanta = new VistaFanta();
        sprite = new VistaSprite();
    }


    public void paint(Graphics g) {


    }
}
