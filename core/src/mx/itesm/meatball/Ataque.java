package mx.itesm.meatball;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 * Created by Roberto on 21/04/2016.
 */
public class Ataque {
    private float VELOCIDAD_X;     // Velocidad horizontal

    private Sprite sprite;  // Sprite cuando no se mueve
    private Texture texturaAlbondiga;
    private Sprite spriteAlbondiga;
    // Animación
    private Animation animacion;    // Caminando
    private float timerAnimacion;   // tiempo para calcular el frame
    private int tipoA;

    public Ataque(Texture att, float x, float y,float vel,int tipo) {
        VELOCIDAD_X=vel;
      TextureRegion texturaCompleta = new TextureRegion(att);
        // La divide en frames de 16x32 (ver marioSprite.png)
        this.tipoA=tipo;
        if (tipoA==1) {
            TextureRegion[][] texturaPersonaje = texturaCompleta.split(98, 94);
            Gdx.app.log("kitt","ata");
            // Crea la animación con tiempo de 0.25 segundos entre frames.
            animacion = new Animation(0.25f,

                    texturaPersonaje[0][15],
                    texturaPersonaje[0][14],
                    texturaPersonaje[0][13],
                    texturaPersonaje[0][12],
                    texturaPersonaje[0][11],
                    texturaPersonaje[0][10],
                    texturaPersonaje[0][9],
                    texturaPersonaje[0][8],
                    texturaPersonaje[0][7],
                    texturaPersonaje[0][6],
                    texturaPersonaje[0][5],
                    texturaPersonaje[0][4],
                    texturaPersonaje[0][3],
                    texturaPersonaje[0][2],
                    texturaPersonaje[0][1]);

            sprite = new Sprite(texturaPersonaje[0][0]);
            // Animación infinita
        }
        if (tipoA==0) {
            TextureRegion[][] texturaPersonaje = texturaCompleta.split(94, 64);
            // Crea la animación con tiempo de 0.25 segundos entre frames.
            animacion = new Animation(0.25f,


                    texturaPersonaje[0][7],
                    texturaPersonaje[0][6],
                    texturaPersonaje[0][5],
                    texturaPersonaje[0][4],
                    texturaPersonaje[0][3],
                    texturaPersonaje[0][2],
                    texturaPersonaje[0][1]);

            sprite = new Sprite(texturaPersonaje[0][0]);
            // Animación infinita
        }
        animacion.setPlayMode(Animation.PlayMode.LOOP);
        // Inicia el timer que contará tiempo para saber qué frame se dibuja
        timerAnimacion = 0;
        // Crea el sprite cuando para el personaje quieto (idle)
            // quieto
        sprite.setPosition(x,y);



    }
    public void render (SpriteBatch batch) {
        // Dibuja el personaje dependiendo del estadoMovimiento
        timerAnimacion += Gdx.graphics.getDeltaTime();
        // Obtiene el frame que se debe mostrar (de acuerdo al timer)
        TextureRegion region = animacion.getKeyFrame(timerAnimacion);
        batch.draw(region, sprite.getX(), sprite.getY());


        //spriteAlbondiga.setSize(5, 5);

        // Gdx.app.log("render","x="+getX()+" vidas = "+vidas);



    }
    public void actualizar() {
        // Ejecutar movimiento horizontal
        float nuevaX = sprite.getX();
        nuevaX += VELOCIDAD_X;
        sprite.setX(nuevaX);

        
       /* if (nuevaX<=PantallaJuego.ANCHO_MAPA-sprite.getWidth()) {
            sprite.setX(nuevaX);
        }*/
    }
    public Sprite getSprite() {
        return sprite;
    }

    // Accesores para la posición
    public float getX() {
        return sprite.getX();
    }


    public float getY() {
        return sprite.getY();
    }

}
