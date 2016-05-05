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
    private float VELOCIDAD_X;

    private Sprite sprite;

    private Texture texturaAlbondiga;
    private Sprite spriteAlbondiga;

    private Animation animacion;
    private float timerAnimacion;
    private int tipoA;

    public Ataque(Texture att, float x, float y,float vel,int tipo) {
        VELOCIDAD_X=vel;
      TextureRegion texturaCompleta = new TextureRegion(att);

        this.tipoA=tipo;
        if (tipoA==1) {
            TextureRegion[][] texturaPersonaje = texturaCompleta.split(98, 94);
            Gdx.app.log("kitt","ata");

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

        }
        if (tipoA==0) {
            TextureRegion[][] texturaPersonaje = texturaCompleta.split(125, 64);

            animacion = new Animation(0.25f,

                    texturaPersonaje[0][2],
                    texturaPersonaje[0][1],
                    texturaPersonaje[0][0]);

            sprite = new Sprite(texturaPersonaje[0][0]);

        }
        if (tipoA==2) {
            TextureRegion[][] texturaPersonaje = texturaCompleta.split(94, 64);

            animacion = new Animation(0.25f,
                    texturaPersonaje[0][7],
                    texturaPersonaje[0][6],
                    texturaPersonaje[0][5],
                    texturaPersonaje[0][4],
                    texturaPersonaje[0][3],
                    texturaPersonaje[0][2],
                    texturaPersonaje[0][1],
                    texturaPersonaje[0][0]);

            sprite = new Sprite(texturaPersonaje[0][0]);

        }
        if (tipoA==3) {
            TextureRegion[][] texturaPersonaje = texturaCompleta.split(120, 128);

            animacion = new Animation(0.25f,

                    texturaPersonaje[0][2],
                    texturaPersonaje[0][1],
                    texturaPersonaje[0][0]);

            sprite = new Sprite(texturaPersonaje[0][0]);

        }
        animacion.setPlayMode(Animation.PlayMode.LOOP);

        timerAnimacion = 0;

        sprite.setPosition(x,y);



    }
    public void render (SpriteBatch batch) {

        timerAnimacion += Gdx.graphics.getDeltaTime();

        TextureRegion region = animacion.getKeyFrame(timerAnimacion);
        batch.draw(region, sprite.getX(), sprite.getY());






    }
    public void actualizar() {

        float nuevaX = sprite.getX();
        nuevaX += VELOCIDAD_X;
        sprite.setX(nuevaX);

        

    }
    public Sprite getSprite() {
        return sprite;
    }


    public float getX() {
        return sprite.getX();
    }


    public float getY() {
        return sprite.getY();
    }

}
